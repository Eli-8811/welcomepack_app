package com.mapfre.welcomepack.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import com.mapfre.welcomepack.enums.CodigoEnum;
import com.mapfre.welcomepack.payload.DocumentumResponse;
import com.mapfre.welcomepack.payload.ORcpErcPC;
import com.mapfre.welcomepack.payload.ReqCondicionesGenerales;
import com.mapfre.welcomepack.payload.ReqReceipt;
import com.mapfre.welcomepack.payload.RequestModel;
import com.mapfre.welcomepack.payload.ResReciboFactura;
import com.mapfre.welcomepack.payload.ResponseModel;

public class Restful {

	public static final Logger log = LoggerFactory.getLogger(Restful.class);
	
	public Restful() {
		super();
	}

	/**
	 * Servicio web para obtener los siguientes datos:
	 * 
	 * COD_PRODUCTO
	 * COD_REG_CNSF
	 * COD_REG_RECAS
	 * http://10.184.60.83/nwt_isu_api_mx_be-web/newtron/api/issue/business_line/policy/attribute/queryatr
	 * 
	 * @param String lng 
	 * @param String usr 
	 * @param String tkn 
	 * @param String ms
	 * @param String poliza
	 * @return ResponseEntity<String>
	 * @throws HttpClientErrorException Si ocurre un error durante el procesamiento
	 * @throws HttpServerErrorException Si ocurre un error durante el procesamiento
	 * @throws UnknownHttpStatusCodeException Si ocurre un error durante el procesamiento
	 */
	public static final ResponseEntity<String> consumirCondicionesGenerales(
			String lng, 
			String usr,
			String tkn,
			String ms, 
			String poliza) {
		Gson gson = new Gson();
		HttpHeaders headers = new HttpHeaders();
		headers.set(Constants.ACCEPT, Constants.APPLICATION_JSON);
		headers.set(Constants.LGN_VAL, lng);
		headers.set(Constants.USR_VAL, usr);
		headers.set(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON);
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(Constants.AUTHORIZATION, Constants.BASIC.concat(" ").concat(tkn));
		ReqCondicionesGenerales requestModel = new ReqCondicionesGenerales();
		requestModel.setOPlyGniT(Arrays.asList(new ReqCondicionesGenerales.OPlyGniT(1, poliza)));
		requestModel
				.setOPlyAtrT(Arrays.asList(new ReqCondicionesGenerales.OPlyAtrT(CodigoEnum.COD_PRODUCTO.getCodigo(), 1),
						new ReqCondicionesGenerales.OPlyAtrT(CodigoEnum.COD_REG_CNSF.getCodigo(), 1),
						new ReqCondicionesGenerales.OPlyAtrT(CodigoEnum.COD_REG_RECAS.getCodigo(), 1)));
		String request = gson.toJson(requestModel);
		HttpEntity<String> entity = new HttpEntity<>(request, headers);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<String> response = restTemplate.exchange(ms, HttpMethod.POST, entity, String.class);
			return response;
		} catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException e) {
			log.error(e.getCause().toString());
			return null;
		}
	}

	/**
	 * Servicio web para obtener los siguientes datos:
	 * 
	 * TIPO DE SITUACION
	 * TIPO GESTOR
	 * 
	 * http://10.184.60.83/nwt_tsy_api_mx_be-web/newtron/api/treasury/receipt/1.0/querybyply
	 * 
	 * @param String lng 
	 * @param String usr 
	 * @param String tkn 
	 * @param String ms
	 * @param String poliza
	 * @param ReqReceipt body
	 * @return ResponseEntity<List<ORcpErcPC>>
     * @throws HttpClientErrorException Si ocurre un error durante el procesamiento
	 * @throws HttpServerErrorException Si ocurre un error durante el procesamiento
	 * @throws UnknownHttpStatusCodeException Si ocurre un error durante el procesamiento
	 */
	public static ResponseEntity<List<ORcpErcPC>> consumirRcpParams(
			String lng, 
			String usr, 
			String tkn, 
			String ms,
			String poliza, 
			ReqReceipt body) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(Constants.ACCEPT, Constants.APPLICATION_JSON);
		headers.set(Constants.LGN_VAL, lng);
		headers.set(Constants.USR_VAL, usr);
		headers.set(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON);
		headers.set(Constants.AUTHORIZATION, Constants.BASIC.concat(" ").concat(tkn));
		headers.set(Constants.CMP_VAL, Constants.ONE);
		headers.set(Constants.PLY_VAL, poliza);
		headers.setContentType(MediaType.APPLICATION_JSON);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(ms);
		HttpEntity<Object> requestEntity = new HttpEntity<>(body, headers);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<List<ORcpErcPC>> responseEntity = restTemplate.exchange(builder.toUriString(),
					HttpMethod.POST, requestEntity, new ParameterizedTypeReference<List<ORcpErcPC>>() {
					});
			return responseEntity;
		} catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException e) {
			log.error(e.getCause().toString());
			return null;
		}
	}

	/**
	 * Servicio web para obtener los siguientes datos:
	 * 
	 * UUID
	 * 
	 * http://10.184.60.83/nwt_tsy_api_mx_be-web/newtron/api/treasury/receipt/list
	 * 
	 * @param String lng 
	 * @param String usr 
	 * @param String tkn 
	 * @param String ms
	 * @param String poliza
	 * @param String plyVal 
	 * @param String rcpVal
	 * @return ResponseEntity<List<ResReciboFactura>>
	 * @throws HttpClientErrorException Si ocurre un error durante el procesamiento
	 * @throws HttpServerErrorException Si ocurre un error durante el procesamiento
	 * @throws UnknownHttpStatusCodeException Si ocurre un error durante el procesamiento
	 */
	public static ResponseEntity<List<ResReciboFactura>> consumirReciboFacturaB64(
			String lng, 
			String usr, 
			String tkn,
			String ms, 
			String plyVal, 
			String rcpVal) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(Constants.ACCEPT, Constants.APPLICATION_JSON);
		headers.set(Constants.LGN_VAL, lng);
		headers.set(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON);
		headers.set(Constants.AUTHORIZATION, Constants.BASIC.concat(" ").concat(tkn));
		headers.set(Constants.CMP_VAL, Constants.ONE);
		Map<String, String> params = new HashMap<>();
		params.put(Constants.PLY_VAL, plyVal);
		params.put(Constants.RCP_VAL, rcpVal);
		params.put(Constants.USR_VAL, usr);
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(ms).queryParam(Constants.PLY_VAL, plyVal)
				.queryParam(Constants.RCP_VAL, rcpVal).queryParam(Constants.USR_VAL, usr).buildAndExpand(params);
		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<List<ResReciboFactura>> responseEntity = restTemplate.exchange(builder.toUriString(),
					HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<ResReciboFactura>>() {
					});
			return responseEntity;
		} catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException e) {
			log.error(e.getCause().toString());
			return null;
		}
	}

	/**
	 * Servicio web para obtener los siguientes datos:
	 * 
	 * ID_DOCUMENTUM
	 * 
	 * http://apidocmx.mapfre.com.mx:8080/API_Docum_UAT/datos/executeQuery
	 * 
	 * @param String ms
	 * @param String poliza
	 * @return String
	 * @throws HttpClientErrorException Si ocurre un error durante el procesamiento
	 * @throws HttpServerErrorException Si ocurre un error durante el procesamiento
	 * @throws UnknownHttpStatusCodeException Si ocurre un error durante el procesamiento
	 */
	/*
	public static String obtenerIdDocumentum(String ms, String poliza) {		
		String idDocumentum = Constants.EMPTY;		
	    try {
	        List<ReqCondition> conditions = new ArrayList<>();
	        conditions.add(new ReqCondition(Constants.COD_CIA, Constants.EQUALS, new ReqValue(Constants.ONE_QUOTATION_MARK, null, false), Constants.AND));
	        conditions.add(new ReqCondition(Constants.NUM_POLIZA, Constants.EQUALS, new ReqValue("'".concat(poliza).concat("'"), null, false), Constants.AND));
	        conditions.add(new ReqCondition(Constants.NUM_SPTO, Constants.EQUALS, new ReqValue(Constants.ZERO_QUOTATION_MARK, null, false), null));
	        ReqDocumentum request = new ReqDocumentum(Constants.ALL, Constants.MMX_POLIZA, conditions);
	        Gson gson = new Gson();
	        HttpHeaders headers = new HttpHeaders();
	        RestTemplate restTemplate = new RestTemplate();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        HttpEntity<String> entity = new HttpEntity<>(gson.toJson(request), headers);
	        String response = restTemplate.exchange(ms, HttpMethod.PUT, entity, String.class).getBody();
	        Type responseType = new TypeToken<List<ResDocumentum>>() {}.getType();
	        List<ResDocumentum> documentumResponses = gson.fromJson(response, responseType);
	        for (ResDocumentum item : documentumResponses) {
	            List<ResDocumentumRow> documentumRows = MapperDocumentum.mapRows(item.getRows());
	            for (ResDocumentumRow row : documentumRows) {
	                idDocumentum = row.getrObjectId();
	            }
	        }	        
	    } catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException e) {
	        log.error(e.getMessage());
	    }
		return idDocumentum;      
    }
	*/
	public static String obtenerIdDocumentum(String ms, String tkn, String poliza) {
	    String idDocumentum = Constants.EMPTY;
	    RequestModel requestModel = new RequestModel();
	    requestModel.setAttributes(Constants.R_OBJECT_ID);
	    requestModel.setDocumentType(Constants.MMX_POLIZA);
	    RequestModel.Condition condition = new RequestModel.Condition();
	    condition.setAttribute(Constants.NUM_POLIZA);
	    condition.setOperator(Constants.EQUALS);
	    RequestModel.Value value = new RequestModel.Value();
	    value.setValue("'".concat(poliza).concat("'"));
	    value.setObjectQuery(null);
	    value.setQuery(false);
	    condition.setValue(value);
	    condition.setConnector(null);
	    List<RequestModel.Condition> conditions = new ArrayList<>();
	    conditions.add(condition);
	    requestModel.setConditions(conditions);
	    try {	    	
	        RestTemplate restTemplate = new RestTemplate();
	        HttpHeaders headers = new HttpHeaders();
	        Gson gson = new Gson();
	        headers.set(Constants.AUTHORIZATION, Constants.TOKEN);
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        String requestBody = gson.toJson(requestModel);
	        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
	        String response = restTemplate.exchange(ms, HttpMethod.PUT, entity, String.class).getBody();
	        Type responseType = new TypeToken<List<ResponseModel>>() {}.getType();
	        List<ResponseModel> responseModels = gson.fromJson(response, responseType);	        
	        for (ResponseModel responseModel : responseModels) {	            
	            for (List<String> row : responseModel.getRows()) {
	                for (String item : row) {
	                	idDocumentum = item;
	                }
	            }
	        }
	    } catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException e) {
	    	log.error(e.getCause().toString());
	    }	    
	    return idDocumentum;	    
	}
	
	/**
	 * Servicio web para obtener los siguientes datos:
	 * 
	 * URL_GENERATOR_POLIZA
	 * 
	 * https://negociosuat.mapfre.com.mx/URLGenerator/api/url/generate
	 * 
	 * @param String idDocumentum 
	 * @param String ms
	 * @return String
	 * @throws HttpClientErrorException Si ocurre un error durante el procesamiento
	 * @throws HttpServerErrorException Si ocurre un error durante el procesamiento
	 * @throws UnknownHttpStatusCodeException Si ocurre un error durante el procesamiento
	 */
	public static String callGenerator(String idDocumentum, String ms) {		
		String url = Constants.EMPTY;
	    HttpHeaders headers = new HttpHeaders();
	    RestTemplate restTemplate = new RestTemplate();
		headers.setContentType(MediaType.APPLICATION_JSON);
		Map<String, Object> body = new HashMap<>();
		body.put(Constants.ID_DOCUMENTUM, idDocumentum);
		HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);		
		try {			
			ResponseEntity<DocumentumResponse> responseEntity = restTemplate.exchange(ms, HttpMethod.POST, request, DocumentumResponse.class);
			int statusCode = responseEntity.getBody().getStatus();
			if (statusCode == 0) {
				url = responseEntity.getBody().getData();
			} else {
				return null;
			}			
	    } catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException e) {
	    	log.error(e.getCause().toString());
	    }
		return url;		
	}
	
	public static String callPaymentReferenceNT(String policyNumber, String lng, String usr, String tkn, String ms) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_PDF, MediaType.APPLICATION_OCTET_STREAM));
		HttpEntity<String> request = new HttpEntity<>(headers);
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(ms).queryParam(Constants.POLICY, policyNumber);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<byte[]> responseByte = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET,
					request, byte[].class);
			byte[] content = responseByte.getBody();
			return new String(Base64.getEncoder().encodeToString(content));
		} catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException e) {
			log.error(e.getCause().toString());
			return null;
		}
		
	}

}
