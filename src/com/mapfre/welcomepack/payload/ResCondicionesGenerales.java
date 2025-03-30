package com.mapfre.welcomepack.payload;

import java.util.List;

public class ResCondicionesGenerales {

	private List<OPlyAtrSWrapper> oPlyAtrS;

	public List<OPlyAtrSWrapper> getoPlyAtrS() {
		return oPlyAtrS;
	}

	public void setOPlyAtrS(List<OPlyAtrSWrapper> oPlyAtrS) {
		this.oPlyAtrS = oPlyAtrS;
	}

	public static class OPlyAtrSWrapper {

		private OPlyAtrS oPlyAtrS;

		public OPlyAtrSWrapper(OPlyAtrS oPlyAtrS) {
			this.oPlyAtrS = oPlyAtrS;
		}

		public OPlyAtrS getOPlyAtrS() {
			return oPlyAtrS;
		}

		public void setoPlyAtrS(OPlyAtrS oPlyAtrS) {
			this.oPlyAtrS = oPlyAtrS;
		}

	}

	public static class OPlyAtrS {

		private int cmpVal;
		private String plyVal;
		private int enrSqn;
		private int aplVal;
		private int aplEnrSqn;
		private int rskVal;
		private int pedVal;
		private int lobVal;
		private String lvlTypVal;
		private String fldNam;
		private String fldValVal;
		private String fldShrVal;
		private String fldTxtVal;
		private int sqnVal;
		private String rskRmv;
		private String opvRow;
		private String aplOpvRow;
		
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
		public int getEnrSqn() {
			return enrSqn;
		}
		public void setEnrSqn(int enrSqn) {
			this.enrSqn = enrSqn;
		}
		public int getAplVal() {
			return aplVal;
		}
		public void setAplVal(int aplVal) {
			this.aplVal = aplVal;
		}
		public int getAplEnrSqn() {
			return aplEnrSqn;
		}
		public void setAplEnrSqn(int aplEnrSqn) {
			this.aplEnrSqn = aplEnrSqn;
		}
		public int getRskVal() {
			return rskVal;
		}
		public void setRskVal(int rskVal) {
			this.rskVal = rskVal;
		}
		public int getPedVal() {
			return pedVal;
		}
		public void setPedVal(int pedVal) {
			this.pedVal = pedVal;
		}
		public int getLobVal() {
			return lobVal;
		}
		public void setLobVal(int lobVal) {
			this.lobVal = lobVal;
		}
		public String getLvlTypVal() {
			return lvlTypVal;
		}
		public void setLvlTypVal(String lvlTypVal) {
			this.lvlTypVal = lvlTypVal;
		}
		public String getFldNam() {
			return fldNam;
		}
		public void setFldNam(String fldNam) {
			this.fldNam = fldNam;
		}
		public String getFldValVal() {
			return fldValVal;
		}
		public void setFldValVal(String fldValVal) {
			this.fldValVal = fldValVal;
		}
		public String getFldShrVal() {
			return fldShrVal;
		}
		public void setFldShrVal(String fldShrVal) {
			this.fldShrVal = fldShrVal;
		}
		public String getFldTxtVal() {
			return fldTxtVal;
		}
		public void setFldTxtVal(String fldTxtVal) {
			this.fldTxtVal = fldTxtVal;
		}
		public int getSqnVal() {
			return sqnVal;
		}
		public void setSqnVal(int sqnVal) {
			this.sqnVal = sqnVal;
		}
		public String getRskRmv() {
			return rskRmv;
		}
		public void setRskRmv(String rskRmv) {
			this.rskRmv = rskRmv;
		}
		public String getOpvRow() {
			return opvRow;
		}
		public void setOpvRow(String opvRow) {
			this.opvRow = opvRow;
		}
		public String getAplOpvRow() {
			return aplOpvRow;
		}
		public void setAplOpvRow(String aplOpvRow) {
			this.aplOpvRow = aplOpvRow;
		}

	}

}