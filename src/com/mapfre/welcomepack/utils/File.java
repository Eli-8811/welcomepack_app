package com.mapfre.welcomepack.utils;

import java.util.Map;
import com.mapfre.welcomepack.exception.WelcomepackException;

public class File {

	public File() {
		super();
	}
	
	
	/**
	 * Valida email y telefono para que no vengan vacios los dos por cada poliza:
	 *
	 * @param Map<String, String> recordValues.
	 * @return Sin retorno.
	 * @throws WelcomepackException Si ocurre un error durante el procesamiento.
	 */
	@SuppressWarnings("unused")
	private void validateFields(Map<String, String> recordValues) throws WelcomepackException {				
        String[] requiredFields = {
            "numPoliza", 
            "nombreContratante",
            "fecEfecPoliza", 
            "fecVctoPoliza"
        };
        for (String field : requiredFields) {
            if (recordValues.get(field) == null || recordValues.get(field).isEmpty()) {
                throw new WelcomepackException(Messages.FILE_POLICIES_EMPTY + ": " + field + " is missing or empty");
            }
        }
        String email = recordValues.get("email");
        String telefono = recordValues.get("telefono");        
        if ((email == null || email.isEmpty()) && (telefono == null || telefono.isEmpty())) {
            throw new WelcomepackException(Messages.FILE_POLICIES_EMPTY + ": Both email and telefono cannot be null or empty");
        }        
    }
	
}
