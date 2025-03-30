package com.mapfre.welcomepack.utils;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Constants {

	public Constants() {
		super();
	}
	
	public static final String DUMMY_URL_DOCUMENTUM_POLICY = "https://accesoext.mapfre.com.mx/Citrix/MapfreWeb/CG-AutoPLUS.pdf";
	public static final String DUMMY_URL_DOCUMENTUM_FILE = "http://www.mapfre.com.mx/seguros/automovil/Documents/CG-AutoPLUS.pdf";
	public static final String DUMMY_POLICY = "4102400000123";
	
	public static final String DUMMY_UUID = "44334358-871D-4E78-BE29-882FAAE68705";
	
	public static final String GROUP_ID = "com.mapfre.welcomepack";
	public static final String UTF_8_APP = "UTF-8";
	public static final String COMODIN = "/*";
	public static final String ALL = "*";
	public static final String SLASH = "/";
	public static final Charset UTF_8 = Charset.forName(UTF_8_APP);
	public static final Charset WINDOWS_1252 = Charset.forName("windows-1252");
	public static final String PREFIX_NAME_FILE = "wp_autos_digital";
	public static final String APPLICATION_JSON = "application/json";
	public static final String ACCEPT = "accept";
	public static final String LGN_VAL = "lngVal";
	public static final String USR_VAL = "usrVal";
	public static final String PLY_VAL = "plyVal";
	public static final String CMP_VAL = "cmpVal";
	public static final String RCP_VAL = "rcpVal";
	public static final String POLICY = "poliza";
	public static final String ONE = "1";
	public static final Integer NUMBER_ZERO = 0;
	public static final Integer NUMBER_ONE = 1;
	public static final String ZERO = "0";
	public static final String COUNTRY_CODE_MX = "52";
	public static final Double CONVERSION = 1024.0;
	public static final Integer BATCH = 1000;
	public static final Integer STATUS_OK = 200;
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String AUTHORIZATION = "Authorization";
	public static final String TOKEN = "Basic QVBJTkVHRVg6TTRwZnIzMjAyMQ==";
	public static final String BASIC = "Basic";
	public static final String RANDOM = "aleatorio_";
	public static final String STRICT_HOST_KEY_CHEKING = "StrictHostKeyChecking";
	public static final String NO = "no";
	public static final String SFTP = "sftp";
	public static final String UNCHECKED = "unchecked";
	public static final String FINISHED = "Finished";
	public static final String FORMAT_XML = "XML";
	public static final String FORMAT_PDF = "PDF";
	public static final String FORMAT_TXT = "TXT";
	public static final String SFTP_HOST = "${sftp.host}";
	public static final String SFTP_PORT = "${sftp.port}";
	public static final String SFTP_USERNAME = "${sftp.username}";
	public static final String SFTP_PASSWORD = "${sftp.password}";
	public static final String OUTPUT_SERVER_LOCAL_CSV_INPUT = "${sftp.output.csv.input}";
	public static final String OUTPUT_SERVER_LOCAL_CSV_OUTPUT = "${sftp.output.csv.output}";
	public static final String OUTPUT_SERVER_LOCAL_INVOICE = "${sftp.output.invoice}";
	public static final String OUTPUT_SERVER_LOCAL_DEPOSIT = "${sftp.output.deposit}";
	public static final String OUTPUT_SERVER_REMOTE = "${sftp.output-server-remote}";	
	public static final String TEMP_URI_REACHCORE = "${reachcore.action.consultar.factura}";
	public static final String MS_LNG = "${ms.lng}";
	public static final String MS_USR = "${ms.usr}";
	public static final String MS_TKN = "${ms.tkn}";
	public static final String MS_THREAD = "${ms.thread}";
	
	public static final String MS_ONE = "${ms.one}";
	public static final String MS_TWO = "${ms.two}";
	public static final String MS_TREE = "${ms.three}";
	public static final String MS_FOUR = "${ms.four}";
	public static final String MS_FIVE = "${ms.five}";
	public static final String MS_SIX = "${ms.six}";
	
	public static final String REACHCORE_INVOICE = "${reachcore.action.consultar.factura}";
	public static final String REACHCORE_KEY = "${reachcore.key}";
	
	public static final String AND = "AND";
	public static final String EQUALS = "=";
	public static final String COD_CIA = "cod_cia";
	public static final String NUM_POLIZA = "num_poliza";
	public static final String NUM_SPTO = "num_spto";
	public static final String MMX_POLIZA = "mmx_poliza";
	public static final String ID_DOCUMENTUM = "IdDocumentum";
	public static final String R_OBJECT_ID = "r_object_id";
	
	public static final String ZERO_QUOTATION_MARK = "'0'";
	public static final String ONE_QUOTATION_MARK = "'1'";
	
	public static final String EMPTY = "";
	
	public static final String GATOS = "#############################################################";
	public static final String GATO = "#";
	
	public static final Map<String, String> URL_MAP_CONDITIONS_GENERAL;

	static {
		Map<String, String> documentos = new HashMap<>();
        documentos.put("CNSF-S0041-0297-2019#CONDUSEF-003979-01", "https://www.mapfre.com.mx/media/seguro-auto-plus-04-09-19.pdf");
        documentos.put("CNSF-S0041-0463-2021#CONDUSEF-003979-02", "https://www.mapfre.com.mx/media/cg-autoplus-10-12-2021.pdf");
        documentos.put("CNSF-S0041-0296-2019#CONDUSEF-004049-01", "https://www.mapfre.com.mx/media/seguro-auto-tu-eliges-30-10-19.pdf");
        documentos.put("CNSF-S0041-0557-2016#0", "https://www.mapfre.com.mx/media/seguro-vehiculo-residente-21-06-16.pdf");
        documentos.put("CNSF-S0041-0618-2019#CONDUSEF-004168-01", "https://www.mapfre.com.mx/media/seguro-vehiculo-residentes-18-12-19.pdf");
        documentos.put("CNSF-S0041-0618-2019#CONDUSEF-004487-01", "https://www.mapfre.com.mx/media/seguro-vehiculo-residentes-11-08-20.pdf");
        documentos.put("CNSF-S0041-0618-2019#CONDUSEF-004987-01", "https://www.mapfre.com.mx/media/cg-residentes-16-08-21-4987.pdf");
        documentos.put("CNSF-S0041-0311-2021#CONDUSEF-005086-01", "https://www.mapfre.com.mx/media/condiciones-generales-vehiculos-residentes-16-08-21.pdf");
        documentos.put("CNSF-S0041-0364-2019#CONDUSEF-004020-01", "https://www.mapfre.com.mx/media/cg-santander-14-10-2019.pdf");
        documentos.put("CNSF-S0041-0414-2021#CONDUSEF-005092-01", "https://www.mapfre.com.mx/media/cg-satander-03-11-2021.pdf");
        documentos.put("CNSF-S0041-0508-2015#CONDUSEF-001846-01", "https://www.mapfre.com.mx/media/cg-sbe-autos-05-11-2015.pdf");
        documentos.put("CNSF-S0041-0542-2014#CONDUSEF-001853-02", "https://www.mapfre.com.mx/media/seguro-obligatorio-09-02-15.pdf");
        documentos.put("CNSF-S0041-0376-2017#CONDUSEF-002256-02", "https://www.mapfre.com.mx/media/seguro-moto14-09-17.pdf");
        documentos.put("CNSF-S0041-0377-2017#CONDUSEF-002294-02", "https://www.mapfre.com.mx/media/auto-insurance-14-09-17.pdf");
        documentos.put("CNSF-S0041-0377-2017#CONDUSEF-002294-02", "https://www.mapfre.com.mx/media/auto-insurance-14-09-17.pdf");
        documentos.put("CNSF-S0041-0518-2020#CONDUSEF-005000-01", "https://www.mapfre.com.mx/media/seguro-mapfre-digital-autos-20-11-20.pdf");
        documentos.put("CNSF-S0041-0230-2014#CONDUSEF-001801-02", "https://www.mapfre.com.mx/media/seguro-auto-gap-02-04-14.pdf");
        documentos.put("CNSF-S0041-0390-2022#CONDUSEF-005532-02", "https://www.mapfre.com.mx/media/cg-autoplus-31-10-2022.pdf");
        documentos.put("CNSF-S0041-0005-2023#CONDUSEF-005633-02", "https://www.mapfre.com.mx/media/tu-eliges-01-03-23.pdf");
        documentos.put("CNSF-S0041-0430-2022#CONDUSEF-005575-01", "https://www.mapfre.com.mx/media/cg-santander-multianual.pdf");
        documentos.put("CNSF-S0041-0376-2017#CONDUSEF-002256-03", "https://www.mapfre.com.mx/media/cg-motorizate-fecha-junio-2022.pdf");
        documentos.put("CNSF-S0041-0376-2017#MODI-S0041-0007-2022", "https://www.mapfre.com.mx/media/cg-motorizate-fecha-junio-2022.pdf");
        documentos.put("CNSF-S0041-0390-2022#CONDUSEF-005532-03", "https://www.mapfre.com.mx/media/cg-autoplus-29-03-2023.pdf");
        documentos.put("CNSF-S0041-0044-2023#CONDUSEF-005661-02", "https://www.mapfre.com.mx/media/cg-mexitravel-08-05-23.pdf");
        documentos.put("CNSF-S0041-0043-2023#CONDUSEF-005660-02", "https://www.mapfre.com.mx/media/cg-mexitravel-max-10-05-23.pdf");
        documentos.put("CNSF-S0041-0005-2023#CONDUSEF-005633-02", "https://www.mapfre.com.mx/media/tu-eliges-01-03-23.pdf");
        documentos.put("CNSF-S0041-0390-2022#CONDUSEF-005532-04", "https://www.mapfre.com.mx/media/cg-autplus-modi-08-08-23.pdf");
        documentos.put("CNSF-S0041-0390-2022#CONDUSEF-006112-01", "https://www.mapfre.com.mx/media/cg-auto-plus-5-9-23.pdf");
        documentos.put("CNSF-S0041-0342-2023#CONDUSEF-006167-01", "https://www.mapfre.com.mx/media/cg-auto-plus-15-06-2024.pdf");
        documentos.put("CNSF-S0041-0379-2023#CONDUSEF-005086-03", "https://www.mapfre.com.mx/media/cg-vh-residentes-abril-2024.pdf");
        documentos.put("CNSF-S0041-0379-2023#CONDUSEF-005086-02", "https://www.mapfre.com.mx/media/cg-vehiculos-residentes-17-noviembre-2023.pdf");
        documentos.put("CNSF-S0041-0342-2023#CONDUSEF-006167-03", "https://www.mapfre.com.mx/media/cg-auto-plus-15-06-2024.pdf");
        documentos.put("CNSF-S0041-0342-2023#CONDUSEF-006167-02", "https://www.mapfre.com.mx/media/cg-autoplus-20febrero2024.pdf");
        URL_MAP_CONDITIONS_GENERAL = Collections.unmodifiableMap(documentos);
	}

}