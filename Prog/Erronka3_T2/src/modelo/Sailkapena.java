package modelo;

/**
 * Talde baten sailkapeneko datuak (puntuak, irabazitako partiduak, etab.) gordetzen dituen klasea.
 */
public class Sailkapena {
	private int TaldeID;
	private String izenat;
	private int TPG;
	private int TPE;
	private int TPP;
	private int TGOL; 
	private int TPTS;
	
	/**
	 * Taldearen sailkapeneko datu guztiak hasieratzeko eraikitzailea.
	 * @param taldeID Taldearen identifikadorea.
	 * @param izenat Taldearen izena.
	 * @param tPG Irabazitako partiduak (Partidos Ganados).
	 * @param tPE Berdindutako partiduak (Partidos Empatados).
	 * @param tPP Galdutako partiduak (Partidos Perdidos).
	 * @param tGOL Sartutako golak edo gol diferentzia.
	 * @param tPTS Lortutako puntu kopurua.
	 */
	public Sailkapena(int taldeID, String izenat, int tPG, int tPE, int tPP, int tGOL, int tPTS) {
		super();
		TaldeID = taldeID;
		this.izenat = izenat;
		TPG = tPG;
		TPE = tPE;
		TPP = tPP;
		TGOL = tGOL;
		TPTS = tPTS;
	}
	
	/**
	 * Taldearen identifikadorea lortzen du.
	 * @return Taldearen ID-a.
	 */
	public int getTaldeID() {
		return TaldeID;
	}
	
	/**
	 * Taldearen identifikadorea ezartzen du.
	 * @param taldeID Ezari nahi den ID-a.
	 */
	public void setTaldeID(int taldeID) {
		TaldeID = taldeID;
	}
	
	/**
	 * Taldearen izena lortzen du.
	 * @return Taldearen izena.
	 */
	public String getIzenat() {
		return izenat;
	}
	
	/**
	 * Taldearen izena ezartzen du.
	 * @param izenat Ezari nahi den izena.
	 */
	public void setIzenat(String izenat) {
		this.izenat = izenat;
	}
	
	/**
	 * Irabazitako partiduak lortzen ditu.
	 * @return Irabazitako partidu kopurua.
	 */
	public int getTPG() {
		return TPG;
	}
	
	/**
	 * Irabazitako partiduak ezartzen ditu.
	 * @param tPG Ezari nahi den kopurua.
	 */
	public void setTPG(int tPG) {
		TPG = tPG;
	}
	
	/**
	 * Berdindutako partiduak lortzen ditu.
	 * @return Berdindutako partidu kopurua.
	 */
	public int getTPE() {
		return TPE;
	}
	
	/**
	 * Berdindutako partiduak ezartzen ditu.
	 * @param tPE Ezari nahi den kopurua.
	 */
	public void setTPE(int tPE) {
		TPE = tPE;
	}
	
	/**
	 * Galdutako partiduak lortzen ditu.
	 * @return Galdutako partidu kopurua.
	 */
	public int getTPP() {
		return TPP;
	}
	
	/**
	 * Galdutako partiduak ezartzen ditu.
	 * @param tPP Ezari nahi den kopurua.
	 */
	public void setTPP(int tPP) {
		TPP = tPP;
	}
	
	/**
	 * Golak lortzen ditu.
	 * @return Gol kopurua.
	 */
	public int getTGOL() {
		return TGOL;
	}
	
	/**
	 * Golak ezartzen ditu.
	 * @param tGOL Ezari nahi den kopurua.
	 */
	public void setTGOL(int tGOL) {
		TGOL = tGOL;
	}
	
	/**
	 * Puntuak lortzen ditu.
	 * @return Puntu kopurua.
	 */
	public int getTPTS() {
		return TPTS;
	}
	
	/**
	 * Puntuak ezartzen ditu.
	 * @param tPTS Ezari nahi den puntu kopurua.
	 */
	public void setTPTS(int tPTS) {
		TPTS = tPTS;
	}
	
	/**
	 * Sailkapenaren informazio guztia testu formatuan itzultzen du.
	 * @return Objektuaren datuak dauzkan String-a.
	 */
	@Override
	public String toString() {
		return "Sailkapena [TaldeID=" + TaldeID + ", izenat=" + izenat + ", TPG=" + TPG + ", TPE=" + TPE + ", TPP="
				+ TPP + ", TGOL=" + TGOL + ", TPTS=" + TPTS + "]";
	}
	
	
	
}