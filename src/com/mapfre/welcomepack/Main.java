package com.mapfre.welcomepack;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mapfre.welcomepack.controller.WelcomepackController;

public class Main {

    public static final Logger log = LoggerFactory.getLogger(Main.class);
    
    private Properties properties;

    public Main() {
        properties = new Properties();
        try (InputStream input = new FileInputStream("C:\\Users\\Eli\\Documents\\recursos\\properties\\config.properties")) {
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return properties;
    }
    
    public static void main(String[] args) {        
    	try {        	
    		log.info("INICIA WELCOMEPACK");
            Main configLoader = new Main();          
            boolean result = WelcomepackController.getInstance().init(configLoader.getProperties());
            log.info("FINALIZA WELCOMEPACK", result);
            log.info("TIEMPO DE EJECUCION [{}]", result);            
        } catch (Exception e) {
            log.error(e.getMessage());
        }    	
    }
    
}