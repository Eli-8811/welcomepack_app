package com.mapfre.welcomepack.payload;

import java.util.List;

public class ReqCondicionesGenerales {

    private List<OPlyGniT> oPlyGniT;
    private List<OPlyAtrT> oPlyAtrT;

    public ReqCondicionesGenerales() {

    }

    public ReqCondicionesGenerales(List<OPlyGniT> oPlyGniT, List<OPlyAtrT> oPlyAtrT) {
        this.oPlyGniT = oPlyGniT;
        this.oPlyAtrT = oPlyAtrT;
    }

    public List<OPlyGniT> getOPlyGniT() {
        return oPlyGniT;
    }

    public void setOPlyGniT(List<OPlyGniT> oPlyGniT) {
        this.oPlyGniT = oPlyGniT;
    }

    public List<OPlyAtrT> getOPlyAtrT() {
        return oPlyAtrT;
    }

    public void setOPlyAtrT(List<OPlyAtrT> oPlyAtrT) {
        this.oPlyAtrT = oPlyAtrT;
    }

    public static class OPlyGniT {

    	private int cmpVal;
        private String plyVal;

        public OPlyGniT(int cmpVal, String plyVal) {
            this.cmpVal = cmpVal;
            this.plyVal = plyVal;
        }

        public int getCmpVal() {
            return cmpVal;
        }

        public void setCmpVal(int cmpVal) {
            this.cmpVal = cmpVal;
        }

        public String getPlyVal() {
            return plyVal;
        }

        public void setPlyVal(String plyVal) {
            this.plyVal = plyVal;
        }
        
    }

    public static class OPlyAtrT {
    	
        private String fldNam;
        private int rskVal;

        public OPlyAtrT(String fldNam, int rskVal) {
            this.fldNam = fldNam;
            this.rskVal = rskVal;
        }

        public String getFldNam() {
            return fldNam;
        }

        public void setFldNam(String fldNam) {
            this.fldNam = fldNam;
        }

        public int getRskVal() {
            return rskVal;
        }

        public void setRskVal(int rskVal) {
            this.rskVal = rskVal;
        }
        
    }
    
}