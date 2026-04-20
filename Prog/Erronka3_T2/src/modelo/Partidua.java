package modelo;

/**
 * Futbol partidu baten informazioa eta datuak (taldeak, golak, jardunaldia...) gordetzen dituen klasea.
 */
public class Partidua {
	
	private int denboraldia;
    private int jardunaldia;
    
    private String taldeLokala;
    private String taldeKanpokoa;
    
    private int golLokala;
    private int golKanpokoa;
       
    private int partiduaId;

    /**
     * Eraikitzaile hutsa, partidu bat hasierako balioekin sortzeko.
     */
    // Constructor vacío
    public Partidua() {}

    /**
     * Partidu baten datu guztiak hasieratzeko eraikitzailea.
     * @param partiduaId Partiduaren identifikadorea.
     * @param taldeLokala Etxeko taldearen izena.
     * @param taldeKanpokoa Kanpoko taldearen izena.
     * @param golLokala Etxeko taldeak sartutako golak.
     * @param golKanpokoa Kanpoko taldeak sartutako golak.
     * @param jardunaldia Partidua jokatzen den jardunaldiaren zenbakia.
     * @param denboraldia Partidua jokatzen den denboraldia.
     */
    // Constructor completo
    public Partidua(int partiduaId, String taldeLokala, String taldeKanpokoa,
            int golLokala, int golKanpokoa, int jardunaldia, int denboraldia) {
 this.partiduaId = partiduaId; 
 this.taldeLokala = taldeLokala;
 this.taldeKanpokoa = taldeKanpokoa;
 this.golLokala = golLokala;
 this.golKanpokoa = golKanpokoa;
 this.jardunaldia = jardunaldia;
 this.denboraldia = denboraldia;
}

	/**
	 * Jardunaldiaren zenbakia lortzen du.
	 * @return Jardunaldia.
	 */
	public int getJardunaldia() {
		return jardunaldia;
	}

	/**
	 * Jardunaldiaren zenbakia ezartzen du.
	 * @param jardunaldia Ezari nahi den jardunaldiaren zenbakia.
	 */
	public void setJardunaldia(int jardunaldia) {
		this.jardunaldia = jardunaldia;
	}

	/**
	 * Etxeko taldearen izena lortzen du.
	 * @return Etxeko taldearen izena.
	 */
	public String getTaldeLokala() {
		return taldeLokala;
	}

	/**
	 * Etxeko taldearen izena ezartzen du.
	 * @param taldeLokala Ezari nahi den etxeko taldearen izena.
	 */
	public void setTaldeLokala(String taldeLokala) {
		this.taldeLokala = taldeLokala;
	}

	/**
	 * Kanpoko taldearen izena lortzen du.
	 * @return Kanpoko taldearen izena.
	 */
	public String getTaldeKanpokoa() {
		return taldeKanpokoa;
	}

	/**
	 * Kanpoko taldearen izena ezartzen du.
	 * @param taldeKanpokoa Ezari nahi den kanpoko taldearen izena.
	 */
	public void setTaldeKanpokoa(String taldeKanpokoa) {
		this.taldeKanpokoa = taldeKanpokoa;
	}

	/**
	 * Etxeko taldeak sartutako golak lortzen ditu.
	 * @return Etxeko taldearen golak.
	 */
	public int getGolLokala() {
		return golLokala;
	}

	/**
	 * Etxeko taldeak sartutako golak ezartzen ditu.
	 * @param golLokala Ezari nahi den gol kopurua.
	 */
	public void setGolLokala(int golLokala) {
		this.golLokala = golLokala;
	}

	/**
	 * Kanpoko taldeak sartutako golak lortzen ditu.
	 * @return Kanpoko taldearen golak.
	 */
	public int getGolKanpokoa() {
		return golKanpokoa;
	}

	/**
	 * Kanpoko taldeak sartutako golak ezartzen ditu.
	 * @param golKanpokoa Ezari nahi den gol kopurua.
	 */
	public void setGolKanpokoa(int golKanpokoa) {
		this.golKanpokoa = golKanpokoa;
	}
	
	/**
	 * Partiduaren identifikadorea lortzen du.
	 * @return Partiduaren ID-a.
	 */
	public int getPartiduaId() {
		return partiduaId;
	}

	/**
	 * Partiduaren identifikadorea ezartzen du.
	 * @param partiduaId Ezari nahi den ID-a.
	 */
	public void setPartiduaId(int partiduaId) {
		this.partiduaId = partiduaId;
	}

	/**
	 * Denboraldiaren zenbakia lortzen du.
	 * @return Denboraldia.
	 */
	public int getDenboraldia() {
		return denboraldia;
	}

	/**
	 * Denboraldiaren zenbakia ezartzen du.
	 * @param denboraldia Ezari nahi den denboraldiaren zenbakia.
	 */
	public void setDenboraldia(int denboraldia) {
		this.denboraldia = denboraldia;
	}

	/**
	 * Partiduaren informazio guztia testu formatuan itzultzen du.
	 * @return Objektuaren datuak dauzkan String-a.
	 */
	@Override
	public String toString() {
		return "Partidua [denboraldia=" + denboraldia + ", jardunaldia=" + jardunaldia + ", taldeLokala=" + taldeLokala
				+ ", taldeKanpokoa=" + taldeKanpokoa + ", golLokala=" + golLokala + ", golKanpokoa=" + golKanpokoa
				+ ", partiduaId=" + partiduaId + "]";
	}
}