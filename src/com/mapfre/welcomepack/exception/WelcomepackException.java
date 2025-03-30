package com.mapfre.welcomepack.exception;

public class WelcomepackException extends Exception {
    
	private static final long serialVersionUID = 1L;

	public WelcomepackException() {
        super();
    }

    public WelcomepackException(String mensaje) {
        super(mensaje);
    }

    public WelcomepackException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    public WelcomepackException(Throwable causa) {
        super(causa);
    }
    
}