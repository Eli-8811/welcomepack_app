package com.mapfre.welcomepack.enums;

public enum TipGestorEnum {

	TA("DOMICILIADO_PAGO_TARJETA"),
    DB("DOMICILIADO_PAGO_CON_CUENTA_CLABE"),
    AG("NO_DOMICILIADO"),
	GP("GP");

    private final String descripcion;

    TipGestorEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static TipGestorEnum fromValue(String valor) {
        for (TipGestorEnum pago : TipGestorEnum.values()) {
            if (pago.name().equals(valor)) {
                return pago;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + valor);
    }
    
}
