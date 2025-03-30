package com.mapfre.welcomepack.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.mapfre.welcomepack.enums.CodigoEnum;
import com.mapfre.welcomepack.enums.ColumnasEnum;
import com.mapfre.welcomepack.enums.TipDocumentoEnum;
import com.mapfre.welcomepack.enums.TipGestorEnum;
import com.mapfre.welcomepack.enums.TipSituacionEnum;
import com.mapfre.welcomepack.exception.WelcomepackException;
import com.mapfre.welcomepack.model.DataFile;
import com.mapfre.welcomepack.model.ExtraData;
import com.mapfre.welcomepack.model.ExtraDataParams;
import com.mapfre.welcomepack.model.Welcomepack;
import com.mapfre.welcomepack.payload.ORcpErcC;
import com.mapfre.welcomepack.payload.ORcpErcPC;
import com.mapfre.welcomepack.payload.ORcpPmiP;
import com.mapfre.welcomepack.payload.ORcpPmiS;
import com.mapfre.welcomepack.payload.ORcpPmrP;
import com.mapfre.welcomepack.payload.ORcpPmrS;
import com.mapfre.welcomepack.payload.ReqReceipt;
import com.mapfre.welcomepack.payload.ResCondicionesGenerales;
import com.mapfre.welcomepack.utils.Constants;
import com.mapfre.welcomepack.utils.Messages;
import com.mapfre.welcomepack.utils.Restful;
import com.mapfre.welcomepack.utils.Utils;

public class WelcomepackService {

	public static final Logger log = LoggerFactory.getLogger(WelcomepackService.class);

	private static WelcomepackService instance;
	
	private WelcomepackService() {
		log.info("PREPARANDO SERVICIOS");
	}

	public static synchronized WelcomepackService getInstance() {
		if (instance == null) {
			instance = new WelcomepackService();
		}
		return instance;
	}

	public String descargarFichero(Map<String, String> map) throws WelcomepackException {
		String nombreFichero = "";
		if (map.get("sftp_connect").equals("OK")) {
			nombreFichero = descargarFicheroFtp(map);
		} else {
			nombreFichero = descargarFicheroLocal();
		}
		return nombreFichero;
	}

	public String descargarFicheroLocal() throws WelcomepackException {
		return "wp_autos_digital_20241211 - UAT.csv";
	}

	public String descargarFicheroFtp(Map<String, String> map) throws WelcomepackException {
		String fileName = null;
		JSch jsch = new JSch();
		Session session = null;
		ChannelSftp channelSftp = null;
		FileOutputStream fos = null;
		try {
			session = createSession(jsch, map);
			channelSftp = openSftpChannel(session);
			if (channelSftp.isConnected()) {
				@SuppressWarnings(Constants.UNCHECKED)
				Vector<ChannelSftp.LsEntry> ficheros = channelSftp.ls(map.get("sftp_remote_server"));
				boolean isFound = false;
				for (ChannelSftp.LsEntry entry : ficheros) {
					if (entry.getFilename().contains(Constants.PREFIX_NAME_FILE)) {
						fileName = entry.getFilename();
						String localFilePath = map.get("sftp_csv_output").concat(entry.getFilename());
						isFound = true;
						try {
							fos = new FileOutputStream(localFilePath);
							channelSftp.get(map.get("sftp_remote_server").concat(Constants.SLASH).concat(entry.getFilename()), fos);
							long fileSizeInBytes = new File(localFilePath).length();
							double fileSizeInKB = fileSizeInBytes / Constants.CONVERSION;							
							log.info("{}", fileSizeInKB);
						} catch (FileNotFoundException e) {
							throw new WelcomepackException(e.getMessage());
						} finally {
							if (fos != null) {
								try {
									fos.close();
								} catch (IOException e) {
									throw new WelcomepackException(e.getMessage());
								}
							}
						}
						break;
					}
				}
				if (!isFound) {
					throw new WelcomepackException(String.format(Messages.NOT_FOUND_FILE, Constants.PREFIX_NAME_FILE));
				}
			} else {
				throw new WelcomepackException(String.format(Messages.SFTP_COULD_NOT_CONNECT, map.get("sftp_username"),
						map.get("sftp_password"), map.get("sftp_host"), map.get("sftp_port")));
			}
		} catch (JSchException e) {
			throw new WelcomepackException(e.getMessage());
		} catch (SftpException e) {
			throw new WelcomepackException(e.getMessage());
		} finally {
			if (channelSftp != null && channelSftp.isConnected()) {
				channelSftp.disconnect();
			}
			if (session != null && session.isConnected()) {
				session.disconnect();
			}
		}
		return fileName;
	}

	public boolean upload(String nombreFichero, Map<String, String> map) throws WelcomepackException {
		String pathFullRemote = map.get("sftp_remote_server").concat(nombreFichero);
		String pathFullLocal = map.get("sftp_csv_output").concat(nombreFichero);
		boolean isUpload = false;
		JSch jsch = new JSch();
		Session session = null;
		ChannelSftp channelSftp = null;
		FileInputStream fis = null;
		try {
			session = createSession(jsch, map);
			channelSftp = openSftpChannel(session);
			if (channelSftp.isConnected()) {
				File localFile = new File(pathFullLocal);
				try {
					fis = new FileInputStream(localFile);
					channelSftp.put(fis, pathFullRemote);
					isUpload = true;
					long fileSizeInBytes = localFile.length();
					double fileSizeInKB = fileSizeInBytes / Constants.CONVERSION;
					log.info("{}", fileSizeInKB);
				} catch (FileNotFoundException e) {
					log.error(e.getMessage());
				} finally {
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
							log.error(e.getMessage());
						}
					}
				}
			} else {
				throw new WelcomepackException(String.format(Messages.SFTP_COULD_NOT_CONNECT, map.get("sftp_username"),
						map.get("sftp_password"), map.get("sftp_host"), map.get("sftp_port")));
			}
		} catch (JSchException e) {
			throw new WelcomepackException(e.getMessage());
		} catch (SftpException e) {
			throw new WelcomepackException(e.getMessage());
		} finally {
			if (channelSftp != null && channelSftp.isConnected()) {
				channelSftp.disconnect();
			}
			if (session != null && session.isConnected()) {
				session.disconnect();
			}
		}
		return isUpload;
	}

	private Session createSession(JSch jsch, Map<String, String> map) throws JSchException {
		Session session = jsch.getSession(map.get("sftp_username"), map.get("sftp_host"), Integer.valueOf(map.get("sftp_port")));
		session.setPassword(map.get("sftp_password"));
		Properties config = new Properties();
		config.put(Constants.STRICT_HOST_KEY_CHEKING, Constants.NO);
		session.setConfig(config);
		session.connect();
		return session;
	}
	
	private ChannelSftp openSftpChannel(Session session) throws JSchException {
		ChannelSftp channelSftp = (ChannelSftp) session.openChannel(Constants.SFTP);
		channelSftp.connect();
		return channelSftp;
	}

	public DataFile leerFicheroDescargado(final String fileName, Map<String, String> map) throws WelcomepackException {						
		
		Reader reader = null;
		CSVParser csvParser = null;
		final DataFile model = new DataFile();
		final String pathFull = map.get("sftp_csv_input").concat(fileName);
		
		try {
			
			reader = new InputStreamReader(new FileInputStream(pathFull), Constants.WINDOWS_1252);
			csvParser = new CSVParser(reader, CSVFormat.DEFAULT.builder().setDelimiter(';').setHeader().setSkipHeaderRecord(true).build());			
			
			final List<String> headers = complementarCabeceras(csvParser);									
			final List<CSVRecord> records = obtenerRegistros(csvParser);				
			
			if (headers.isEmpty()) {
				throw new WelcomepackException(String.format(Messages.HEADERS_EMPTY_FILE, pathFull));
			}
			
			if (records.isEmpty()) {
				throw new WelcomepackException(String.format(Messages.RECORDS_EMPTY_FILE, pathFull));
			}
			
			model.setHeaders(headers);
			model.setRecords(records);
			
		} catch (IOException e) {
			
			throw new WelcomepackException(String.format(Messages.ERROR_READER_CSV, fileName, map.get("sftp_csv_input")));
			
		} finally {
			
			if (csvParser != null) {
				try {
					csvParser.close();
				} catch (IOException e) {
					throw new WelcomepackException(String.format(Messages.ERROR_CLOSE_CSV_PARSER, fileName));
				}
			}			
			
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new WelcomepackException(String.format(Messages.ERROR_CLOSE_READER, fileName));
				}
			}	
			
		}		
		
		return model;
		
	}

	private List<CSVRecord> obtenerRegistros(final CSVParser csvParser) {
		final List<CSVRecord> records = new ArrayList<>();
		for (CSVRecord csvRecord : csvParser) {
			records.add(csvRecord);
		}
		return records;
	}

	private List<String> complementarCabeceras(final CSVParser csvParser) throws WelcomepackException {	
		final List<String> headers = new ArrayList<>();
	    for (ColumnasEnum columna : ColumnasEnum.values()) {
	        if (columna.getIndice() > 0) {
	            headers.add(columna.getCabecera());
	        }
	    }
	    return headers;
	}
	
	public List<Welcomepack> generarWelcomepack(final DataFile list, final Map<String, String> map) throws WelcomepackException {
	    if (map.get("ms_thread").equals("OK")) {
	    	log.info("PREPARANDO MODO MULTI HILO");
	        return procesoParalelo(list, map);
	    } else {
	    	log.info("PREPARANDO MODO SECUENCIAL");
	        return procesoSecuencial(list, map);
	    }
	}
	
	private List<Welcomepack> procesoParalelo(final DataFile list, final Map<String, String> map) throws WelcomepackException {
		validarLista(list);
		log.info("COMENZANDO...");
	    List<CompletableFuture<Welcomepack>> futures = list.getRecords().stream()
	        .map(record -> CompletableFuture.supplyAsync(() -> procesarRegistro(record, list, map).orElse(null))
	            .exceptionally(e -> {
	            	log.error(e.getMessage());
	                return null;
	            }))
	        .collect(Collectors.toList());
	    List<Welcomepack> objects = futures.stream()
	        .map(future -> {
	            try {
	                return future.get();
	            } catch (Exception e) {
	            	log.error(e.getMessage());
	                return null;
	            }
	        })
	        .filter(Objects::nonNull)
	        .collect(Collectors.toList());
	    return objects;
	}
	
	private List<Welcomepack> procesoSecuencial(final DataFile list, final Map<String, String> map) throws WelcomepackException {
		validarLista(list);
	    final List<Welcomepack> welcomepacks = new ArrayList<>();
	    final List<CSVRecord> records = list.getRecords();
	    final int batchSize = Constants.BATCH;
	    final int totalRecords = records.size();
	    int cont = Constants.NUMBER_ONE;
	    log.info("COMENZANDO...");
	    for (int i = Constants.NUMBER_ZERO; i < totalRecords; i += batchSize) {
	        final List<CSVRecord> batch = records.subList(i, Math.min(i + batchSize, totalRecords));
	        for (CSVRecord record : batch) {
	        	log.info("");
	            final String poliza = record.get(Constants.NUMBER_ZERO).trim();
	            log.info("INDEX=[{}] POLIZA=[{}] ", cont++, poliza);
	            final Optional<Welcomepack> model = procesarRegistro(record, list, map);
	            model.ifPresent(welcomepacks::add);
	        }
	    }
	    return welcomepacks;
	}
	
	private static void validarLista(final DataFile list) throws WelcomepackException {
	    if (Objects.isNull(list.getHeaders()) || list.getHeaders().isEmpty() ||
	        Objects.isNull(list.getRecords()) || list.getRecords().isEmpty()) {
	        throw new WelcomepackException(Messages.FILE_POLICIES_EMPTY);
	    }
	}
	
	private Optional<Welcomepack> procesarRegistro(final CSVRecord record, final DataFile list, final Map<String, String> map) {	    
		try {	        
	    	final Welcomepack model = procesarDatosIniciales(record, list);	        
	        if (!validarDatosIniciales(model)) {
	        	return Optional.empty();
	        }	        
	        procesarCondicionesGeneralesPorPoliza(record, list, model, map);	        
	        if (!validarCondicionesGenerales(model)) {
	        	return Optional.empty();
	        }	        
	        procesarReciboFacturaPorPoliza(record, model, map);	        
	        if (!validarReciboFactura(model)) {
	        	return Optional.empty();
	        }	        
	        procesarDocumentumPorPoliza(Constants.DUMMY_POLICY, model, map);     
	        if (!validarDocumentumPoliza(model)) {
	        	return Optional.empty();
	        }	        
	        procesarSectorPorPoliza(record, model);	        
	        if (!validarSectorPorPoliza(model)) {
	        	return Optional.empty();
	        }	       
	        return Optional.of(model);	        
	    } catch (Exception e) {
	        log.error("La poliza {} no pede ser procesada a causa de: {} ", record.get(0).trim(), e.getMessage());
	        return Optional.empty();
	    }		
	}
	
	private Welcomepack procesarDatosIniciales(final CSVRecord record, final DataFile list) {
	    return Optional.ofNullable(complementandoDatosInicialesPorPoliza(record, list.getHeaders(), list.getRecords())).orElse(null);
	}
	
	private Welcomepack complementandoDatosInicialesPorPoliza(
	        final CSVRecord record, 
	        final List<String> headers,
	        final List<CSVRecord> records) {
	    return new Welcomepack(
	        record.get(0).trim(),
	        record.get(1).trim(),
	        record.get(2).trim(),
	        complementaTelefono(record.get(3).trim()),
	        record.get(4).trim(),
	        record.get(5).trim(),
	        record.get(6).trim(),
	        new ExtraData()
	    );
	}
	
	private Welcomepack procesarCondicionesGeneralesPorPoliza(
	        final CSVRecord record,
	        final DataFile originDataModelList,
	        final Welcomepack model,
	        final Map<String, String> map) {
	    final ResponseEntity<String> response = Restful.consumirCondicionesGenerales(
	    		map.get("ms_lng"),
	    		map.get("ms_usr"),
	    		map.get("ms_tkn"),
	    		map.get("ms_one"),
	            record.get(Constants.NUMBER_ZERO).trim()
	    );
	    if (response == null || response.getBody() == null || response.getStatusCodeValue() != Constants.STATUS_OK) {
	        return null;
	    }
	    complementandoCondicionesGeneralesPorPoliza(
	            record,
	            originDataModelList.getHeaders(),
	            originDataModelList.getRecords(),
	            response,
	            model,
	            record.get(Constants.NUMBER_ZERO).trim()
	    );
	    if (model == null) {
	        return null;
	    }
	    return model;
	}
	
	private void complementandoCondicionesGeneralesPorPoliza(
			final CSVRecord record, 			
			final List<String> headers, 
			final List<CSVRecord> records,
			final ResponseEntity<String> response,
			final Welcomepack model,
			final String poliza) {		
		final Gson gson = new Gson();
		final ResCondicionesGenerales responseObject = new ResCondicionesGenerales();			
		final Type responseType = new TypeToken<List<ResCondicionesGenerales.OPlyAtrSWrapper>>() {
		}.getType();		
		final List<ResCondicionesGenerales.OPlyAtrSWrapper> responseList = gson.fromJson(response.getBody(), responseType);
		if (responseList == null || responseList.isEmpty()) {
			return;
		}	
		responseObject.setOPlyAtrS(responseList);
		final ExtraDataParams extraDataParams = obtenerCondicionesGeneralesPorPoliza(responseList, poliza);		
		if (extraDataParams == null) {
			return;
		} else {
			log.info("APLICANDO CONDICIONES GENERALES");
			model.getExtraData().setDocCondicionesGenerales(extraDataParams.getDocCondicionesGenerales());
			model.getExtraData().setProductoComercial(extraDataParams.getProductoComercial());
			model.getExtraData().setExtraDataParams(extraDataParams);
		}
	}
	
	private ExtraDataParams obtenerCondicionesGeneralesPorPoliza(
	        final List<ResCondicionesGenerales.OPlyAtrSWrapper> responseList, 
	        final String noPoliza) {
	    final ExtraDataParams extraDataFull = new ExtraDataParams();
	    for (final ResCondicionesGenerales.OPlyAtrSWrapper wrapper : responseList) {
	        final ResCondicionesGenerales.OPlyAtrS oPlyAtrS = wrapper.getOPlyAtrS();
	        final CodigoEnum codigoEnum = CodigoEnum.obteneCodigo(oPlyAtrS.getFldNam().trim());
	        applyCodigoStrategy(codigoEnum, oPlyAtrS, extraDataFull);
	    }
	    final String cnsf_recas = extraDataFull.getDataCNSF().concat(Constants.GATO).concat(extraDataFull.getDataRECAS());
	    final String urlConditionsGenerals = Constants.URL_MAP_CONDITIONS_GENERAL.get(cnsf_recas);
	    if (urlConditionsGenerals != null) {
	        extraDataFull.setDocCondicionesGenerales(urlConditionsGenerals);
	    } else {
	        return null;
	    }
	    return extraDataFull;
	}
	
	private void applyCodigoStrategy(final CodigoEnum codigoEnum, final ResCondicionesGenerales.OPlyAtrS oPlyAtrS,
			final ExtraDataParams extraDataFull) {
		switch (codigoEnum) {
		case COD_PRODUCTO:
			extraDataFull.setProductoComercial(oPlyAtrS.getFldTxtVal());
			extraDataFull.setIdProductoComercial(oPlyAtrS.getFldValVal());
			break;
		case COD_REG_CNSF:
			extraDataFull.setDataCNSF(oPlyAtrS.getFldValVal());
			break;
		case COD_REG_RECAS:
			extraDataFull.setDataRECAS(oPlyAtrS.getFldValVal());
			break;
		default:
			break;
		}
	}
	
	private void procesarSectorPorPoliza(final CSVRecord record, final Welcomepack model) {
	    Optional.ofNullable(record.get(Constants.NUMBER_ZERO).trim())
	            .filter(Utils::isNotNullOrEmpty)
	            .map(Utils::getFirstCharacter)
	            .ifPresent(sector -> {
	                model.getExtraData().setSector(sector);
	            });
	}
	
	private String complementaTelefono(final String telefono) {
		if(Utils.isNotNullOrEmpty(telefono)) {
			return Constants.COUNTRY_CODE_MX.concat(telefono);
		}
		return telefono;
	}
	
	private void procesarReciboFacturaPorPoliza(final CSVRecord record, final Welcomepack model,final Map<String, String> map) {
	    final String poliza = record.get(Constants.NUMBER_ZERO).trim();
	    final ResponseEntity<List<ORcpErcPC>> response = Restful.consumirRcpParams(
	    		map.get("ms_lng"),
	    		map.get("ms_usr"),
	    		map.get("ms_tkn"),
	    		map.get("ms_two"),
	            poliza, new ReqReceipt(Constants.ZERO, Constants.ZERO, Constants.ZERO));
	    if (response == null || response.getBody() == null || response.getBody().isEmpty()) {
	        return;
	    }
	    final List<ORcpErcPC> bodyList = response.getBody();
	    final ORcpErcPC oRcpErcPCMinimum = obtenerInMValMinimo(bodyList);
	    final ORcpErcC ercC = oRcpErcPCMinimum.getoRcpErcC();
	    final ORcpPmrP pmrP = ercC.getoRcpPmrP();
	    if (pmrP != null) {
	        final ORcpPmrS pmrS = pmrP.getoRcpPmrS();
	        if (pmrS != null) {
	            final String rcpStsTypVal = pmrS.getRcpStsTypVal();
	            final String mnrTypVal = pmrS.getMnrTypVal();
	            if (rcpStsTypVal != null || mnrTypVal != null) {
	                try {
	                    final TipSituacionEnum situacion = TipSituacionEnum.fromValue(rcpStsTypVal);
	                    final TipGestorEnum gestor = TipGestorEnum.fromValue(mnrTypVal);
	                    final TipDocumentoEnum tipoDocumento = obtenerTipoDocumento(gestor, situacion);
	                    if (tipoDocumento == null) {
	                        return;
	                    }
	                    switch (tipoDocumento) {
	                        case FACTURA_COMPLEMENTO:
	                        case FACTURA_PADRE:
	                            generarUrlFactura(ercC, tipoDocumento, poliza, model);
	                            break;
	                        case RECIBO_DE_PAGO:
	                            generarUrlRecibo(tipoDocumento, poliza, model);
	                            break;
	                        default:
	                            break;
	                    }
	                } catch (IllegalArgumentException e) {
	                	log.error(e.getMessage());
	                }
	            } else {
	                log.error(String.format(Messages.ERROR_ENUMS_NULL_SITUACION_OR_GESTOR, rcpStsTypVal, mnrTypVal));
	            }
	        }
	    }
	}
	
	private ORcpErcPC obtenerInMValMinimo(final List<ORcpErcPC> bodyList) {
	    Integer minInmVal = Integer.MAX_VALUE;
	    ORcpErcPC ercPCMinimum = null;
	    for (final ORcpErcPC ercPC : bodyList) {
	        final ORcpErcC ercC = ercPC.getoRcpErcC();
	        if (ercC == null) {
	            break;
	        }
	        final Integer inmVal = obtenerImnVal(ercC);
	        if (inmVal == null) {
	            break;
	        }
	        if (inmVal < minInmVal) {
	            minInmVal = inmVal;
	            ercPCMinimum = ercPC;
	        }
	    }
	    if (ercPCMinimum != null) {
	    	log.info(String.format(Messages.DOCUMENT_MINIMUM, minInmVal));
	    }
	    return ercPCMinimum;
	}
	
	/*
	private String obtenerFolTax(final String tipoDocumento, final String poliza, final String rcpVal) {
	    final ResponseEntity<List<ResReciboFactura>> response = Restful.consumirReciboFacturaB64(
	    		getLng(),
	            getUsr(),
	            getTkn(),
	            getOne(),
	            poliza, 
	            rcpVal);
	    if (response == null || response.getBody() == null || response.getStatusCodeValue() != Constants.STATUS_OK) {
	        return Constants.EMPTY;
	    }
	    
	    final List<ResReciboFactura> bodyList = response.getBody();
	    final String folTax = bodyList.size() == 1 ? bodyList.get(Constants.NUMBER_ZERO).getFolTax() : bodyList.stream()
	            .map(ResReciboFactura::getFolTax)
	            .reduce((first, second) -> second)
	            .orElse(Constants.EMPTY);	    
	    return Constants.DUMMY_UUID;
	}
	
	private String obtenerRcpVal(final ORcpErcC ercC) {
	    if (ercC.getoRcpPmiPT() != null && !ercC.getoRcpPmiPT().isEmpty()) {
	        for (final ORcpPmiP pmiP : ercC.getoRcpPmiPT()) {
	            final ORcpPmiS pmiS = pmiP.getoRcpPmiS();
	            if (pmiS != null) {
	                final String rcpVal = pmiS.getRcpVal().toString();
	                return rcpVal;
	            }
	        }
	    }
	    return null;
	}
	*/
	
	private Integer obtenerImnVal(final ORcpErcC ercC) {
		Integer inmVal = null;
		if (ercC.getoRcpPmiPT() != null && !ercC.getoRcpPmiPT().isEmpty()) {
			for (ORcpPmiP pmiP : ercC.getoRcpPmiPT()) {
				final ORcpPmiS pmiS = pmiP.getoRcpPmiS();
				if (pmiS != null) {
					inmVal = pmiS.getInmVal();
					if (inmVal == 1) {
						return inmVal;
					}
				}
			}
		}
		return inmVal;
	}
	
	private void procesarDocumentumPorPoliza(String poliza, Welcomepack model, final Map<String, String> map) {	
		String urlGenerator = "";
		String idDocumentum = Restful.obtenerIdDocumentum(map.get("ms_five"), map.get("ms_tkn"), Constants.DUMMY_POLICY);		
    	if(!idDocumentum.isEmpty()) { 
    		urlGenerator = Restful.callGenerator(idDocumentum, map.get("ms_six"));    		
    		if(!urlGenerator.isEmpty()) {
    			model.getExtraData().setDocPoliza(urlGenerator);
    		} 		
    	} else {
    		log.error(String.format(Messages.POLICY_NO_CONTAINS_ID_DOCUMENTUM, poliza));
    	}    	
	}
	
	private TipDocumentoEnum obtenerTipoDocumento(final TipGestorEnum gestor, final TipSituacionEnum situacion) {
		if (situacion == TipSituacionEnum.CT) {
			return TipDocumentoEnum.FACTURA_COMPLEMENTO;
		} else if (situacion != TipSituacionEnum.CT && gestor == TipGestorEnum.TA || gestor == TipGestorEnum.DB) {
			return TipDocumentoEnum.FACTURA_PADRE;
		} else if (situacion != TipSituacionEnum.CT && gestor != TipGestorEnum.TA || gestor != TipGestorEnum.DB) {
			return TipDocumentoEnum.RECIBO_DE_PAGO;
		} else {
			return null;
		}
	}
	
	private void generarUrlFactura(final ORcpErcC ercC, final TipDocumentoEnum tipoDocumento, final String poliza, final Welcomepack model) {
		model.getExtraData().setDocRecibo("https://oat.reachcore.com/api/rest/Timbre/Get?uuid=44334358-871D-4E78-BE29-882FAAE68705&format=pdf");
	}
	
	private void generarUrlRecibo(final TipDocumentoEnum tipoDocumento, final String poliza, final Welcomepack model) {
		model.getExtraData().setDocRecibo("https://oat.reachcore.com/api/rest/Timbre/Get?uuid=44334358-871D-4E78-BE29-882FAAE68705&format=pdf");
	}

	private boolean validarDatosIniciales(final Welcomepack model) {
	    return Stream.of(
	            model.getNumPoliza(),
	            model.getNombreContratante(),
	            model.getEmail(),
	            model.getTelefono(),
	            model.getFecEfecPoliza(),
	            model.getFecVctoPoliza(),
	            model.getImpPrima()
	        ).anyMatch(Utils::isNotNullOrEmpty);
	}
	
	private boolean validarCondicionesGenerales(final Welcomepack model) {
	    return Optional.ofNullable(model.getExtraData())
	                   .map(extraData -> Utils.isNotNullOrEmpty(extraData.getDocCondicionesGenerales()))
	                   .orElse(false);
	}

	private boolean validarReciboFactura(final Welcomepack model) {
	    return Optional.ofNullable(model.getExtraData())
	                   .map(extraData -> Utils.isNotNullOrEmpty(extraData.getDocRecibo()))
	                   .orElse(false);
	}

	private boolean validarDocumentumPoliza(final Welcomepack model) {
	    return Optional.ofNullable(model.getExtraData())
	                   .map(extraData -> Utils.isNotNullOrEmpty(extraData.getDocPoliza()))
	                   .orElse(false);
	}

	private boolean validarSectorPorPoliza(final Welcomepack model) {
	    return Optional.ofNullable(model.getExtraData())
	                   .map(extraData -> Utils.isNotNullOrEmpty(extraData.getSector()))
	                   .orElse(false);
	}
	
}