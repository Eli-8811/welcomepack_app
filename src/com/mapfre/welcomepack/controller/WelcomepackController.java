package com.mapfre.welcomepack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mapfre.welcomepack.exception.WelcomepackException;
import com.mapfre.welcomepack.model.DataFile;
import com.mapfre.welcomepack.model.Welcomepack;
import com.mapfre.welcomepack.service.WelcomepackService;
import com.mapfre.welcomepack.utils.Time;

public class WelcomepackController {

	public static final Logger log = LoggerFactory.getLogger(WelcomepackController.class);

	private static WelcomepackController instance;
	private Properties properties;

	private WelcomepackController() {
		log.info("PREPARANDO CONTROLADOR");
	}

	public static synchronized WelcomepackController getInstance() {
		if (instance == null) {
			instance = new WelcomepackController();
		}
		return instance;
	}

	public boolean init(Properties properties) {

		this.properties = properties;
		boolean isSuccess = false;

		Time.start();		

		try {

			Map<String, String> map = new HashMap<>();

	        map.put("sftp_host", getProperty("sftp.host"));
	        map.put("sftp_port", getProperty("sftp.port"));
	        map.put("sftp_username", getProperty("sftp.username"));
	        map.put("sftp_password", getProperty("sftp.password"));
	        map.put("sftp_remote_server", getProperty("sftp.remote.server"));
	        map.put("sftp_csv_output", getProperty("sftp.csv.output"));
	        map.put("sftp_csv_input", getProperty("sftp.csv.input"));
	        map.put("sftp_connect", getProperty("sftp.connect"));
	        map.put("ms_lng", getProperty("ms.lng"));
	        map.put("ms_usr", getProperty("ms.usr"));
	        map.put("ms_tkn", getProperty("ms.tkn"));
	        map.put("ms_one", getProperty("ms.one"));
	        map.put("ms_two", getProperty("ms.two"));
	        map.put("ms_three", getProperty("ms.three"));
	        map.put("ms_four", getProperty("ms.four"));
	        map.put("ms_five", getProperty("ms.five"));
	        map.put("ms_six", getProperty("ms.six"));
	        map.put("ms_thread", getProperty("ms.thread"));

			String nombreFichero = WelcomepackService.getInstance().descargarFichero(map);
			DataFile model = WelcomepackService.getInstance().leerFicheroDescargado(nombreFichero, map);
			List<Welcomepack> list = WelcomepackService.getInstance().generarWelcomepack(model, map);

			log.info("{} ", list.size());
			String duration = Time.stop();
			log.info("FINALIZA LANZAMIENTO WELCOMEPACK EN {} ", duration);

		} catch (WelcomepackException e) {
			log.error(e.getMessage());
		}

		return isSuccess;

	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

}