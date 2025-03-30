package com.mapfre.welcomepack.enums;

public enum ColumnasEnum {

	COLUMNA_1(1, "A", "NUM_POLIZA"),
	COLUMNA_2(2, "B", "NOMBRE_CONTRATANTE"),
    COLUMNA_3(3, "G", "EMAIL"),
    COLUMNA_4(4, "H", "TELEFONO"),
    COLUMNA_5(5, "I", "FEC_EFEC_POLIZA"),
    COLUMNA_6(6, "J", "FEC_VCTO_POLIZA"),
    COLUMNA_7(7, "K", "IMP_PRIMA"),    
    COLUMNA_8(8, "L", "PRODUCTO_COMERCIAL"),
    COLUMNA_9(9, "M", "DOC_POLIZA"),
    COLUMNA_10(10, "N", "DOC_FACTURA"),
    COLUMNA_11(11, "O", "DOC_CONDICIONES_GENERALES"),
	COLUMNA_12(12, "P", "SECTOR");
    
    private final int indice;
    private final String celda;
    private final String cabecera;

    ColumnasEnum(int indice, String celda, String cabecera) {
        this.indice = indice;
        this.celda = celda;
        this.cabecera = cabecera;
    }

	public int getIndice() {
		return indice;
	}

	public String getCelda() {
		return celda;
	}

	public String getCabecera() {
		return cabecera;
	}
    
	public static ColumnasEnum obtenerColumna(String celda) {
	    for (ColumnasEnum columna : ColumnasEnum.values()) {
	        if (columna.getCelda().equals(celda)) {
	            return columna;
	        }
	    }
	    throw new IllegalArgumentException("No se encontro una columna con la celda: ".concat(celda));
	}
	
	public static ColumnasEnum obtenerColumnaHeader(String header) {
	    for (ColumnasEnum columna : ColumnasEnum.values()) {
	        if (columna.getCabecera().equals(header)) {
	            return columna;
	        }
	    }
	    throw new IllegalArgumentException("No se encontro una columna con la celda: ".concat(header));
	}
	
}