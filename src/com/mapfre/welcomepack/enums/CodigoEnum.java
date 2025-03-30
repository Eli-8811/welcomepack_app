package com.mapfre.welcomepack.enums;

public enum CodigoEnum {

	COD_PRODUCTO("COD_PRODUCTO"),
	COD_REG_CNSF("COD_REG_CNSF"),
	COD_REG_RECAS("COD_REG_RECAS");
    
    private final String codigo;

    CodigoEnum(String codigo) {
        this.codigo = codigo;
    }

	public String getCodigo() {
		return codigo;
	}
    
	public static CodigoEnum obteneCodigo(String codigo) {
	    for (CodigoEnum codigoEnum : CodigoEnum.values()) {
	        if (codigoEnum.getCodigo().equals(codigo)) {
	            return codigoEnum;
	        }
	    }
	    throw new IllegalArgumentException("No se encontro uel codigo ".concat(codigo));
	}

}