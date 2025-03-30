package com.mapfre.welcomepack.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Objects;

import com.google.gson.Gson;

public class Utils {

	public Utils() {
		super();
	}

	/**
	 * Converts a given model to its JSON representation and logs the result
	 *
	 * @param <T> The type of the model
	 * @param model The model to be converted to JSON
	 */
	public static <T> void modelAsJson(T model) {
        Gson gson = new Gson();
        String json = gson.toJson(model);
        System.out.println(String.format(Messages.MODEL_TO_JSON, json));
    }

	/**
	 * Checks if a given object is not null and, if it's a string, not empty after trimming.
	 *
	 * @param <T> The type of the object.
	 * @param value The object to check.
	 * @return true if the object is not null and, if it's a string, not empty; false otherwise.
	 */
	public static <T> boolean isNotNullOrEmpty(T value) {
	    if (Objects.nonNull(value)) {
	        if (value instanceof String) {
	            return !((String) value).trim().isEmpty();
	        }
	        return true;
	    }
	    return false;
	}
	
	
	/**
	 * Decodes a Base64 string and writes the resulting bytes to a file
	 *
	 * @param outputFilePath The directory path where the file will be saved
	 * @param nameFile The name of the file
	 * @param extension The file extension
	 * @param base64 The Base64 encoded string
	 * @return true if the file was successfully written, false otherwise
	 */
	public static boolean b64ToFile(String outputFilePath, String nameFile, String extension, String base64) {
	    boolean flag = false;
	    byte[] decodedBytes = Base64.getDecoder().decode(base64);
	    Path path = Paths.get(outputFilePath, nameFile + "." + extension);
	    try {
	        Files.write(path, decodedBytes);
	        flag = true;
	    } catch (IOException e) {
	        System.out.println(e.getMessage());
	    }
	    return flag;
	}
	
	public static char getFirstCharacter(String input) {
	    if (input != null && !input.isEmpty()) {
	        return input.charAt(0);
	    } else {
	        throw new IllegalArgumentException(Messages.CHAIN_NOT_EMPTY);
	    }
	}
	
}
