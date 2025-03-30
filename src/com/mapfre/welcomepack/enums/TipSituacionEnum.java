package com.mapfre.welcomepack.enums;

public enum TipSituacionEnum {

	CT("PAGADO"),
    EP("EMITIDO_PENDIENTE"),
    RE("REMESADO");

    private final String descripcion;

    TipSituacionEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

	public static TipSituacionEnum fromValue(String rcpStsTypVal) {
	    for (TipSituacionEnum situacion : TipSituacionEnum.values()) {
	        if (situacion.name().equals(rcpStsTypVal)) {
	            return situacion;
	        }
	    }
	    throw new IllegalArgumentException("Unknown enum value: " + rcpStsTypVal);
	}
	
}
