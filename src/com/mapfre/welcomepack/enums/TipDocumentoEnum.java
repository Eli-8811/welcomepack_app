package com.mapfre.welcomepack.enums;

public enum TipDocumentoEnum {

	FACTURA_PADRE("F", "FACTURA_PADRE"),
	FACTURA_COMPLEMENTO("C", "FACTURA_COMPLEMENTO"),
	RECIBO_DE_PAGO("R", "RECIBO_DE_PAGO");

	private final String acronimo;
    private final String descripcion;

    TipDocumentoEnum(String acronimo ,String descripcion) {
    	this.acronimo = acronimo;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getAcronimo() {
		return acronimo;
	}

	public static TipDocumentoEnum fromValue(String valor) {
        for (TipDocumentoEnum enumerable : TipDocumentoEnum.values()) {
            if (enumerable.name().equals(valor)) {
                return enumerable;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + valor);
    }
        
}
