package modelo;

/**
 * Sistemako erabiltzaile bat ordezkatzen duen klasea, Pertsona klasearen herentzia jasoz.
 * Erabiltzailearen logina, pasahitza eta mota kudeatzeko erabiltzen da.
 */
public class Erabiltzailea extends Pertsona{
	
	private String Erabiltzaile_izena;
	private String Pasahitza;
	private String gmail;
	private String mota;
	
	/**
	 * Erabiltzaile baten datu guztiak hasieratzeko eraikitzailea.
	 * @param izena Pertsonaren izena (Pertsona klasetik).
	 * @param adina Pertsonaren adina (Pertsona klasetik).
	 * @param erabiltzaile_izena Sisteman sartzeko erabiltzaile-izena.
	 * @param pasahitza Sisteman sartzeko pasahitza.
	 * @param gmail Erabiltzailearen posta elektronikoa.
	 * @param mota Erabiltzailearen rola edo mota.
	 */
	//Konstruktorea
	public Erabiltzailea(String izena, int adina, String erabiltzaile_izena, String pasahitza,
			String gmail, String mota) {
		super(izena, adina);
		this.Erabiltzaile_izena = erabiltzaile_izena;
		Pasahitza = pasahitza;
		this.gmail = gmail;
		this.mota = mota;
	}
		
	/**
	 * Eraikitzaile hutsa, erabiltzaile bat hasierako balioekin (hutsik) sortzeko.
	 */
	public Erabiltzailea() {
		this.Erabiltzaile_izena = "";
		this.Pasahitza = "";
		this.gmail = "";
	}

	/**
	 * Erabiltzaile-izena lortzen du.
	 * @return Erabiltzailearen izena.
	 */
	public String getErabiltzaile_izena() {
		return Erabiltzaile_izena;
	}

	/**
	 * Erabiltzaile-izena ezartzen du.
	 * @param erabiltzaile_izena Ezari nahi den erabiltzaile-izena.
	 */
	public void setErabiltzaile_izena(String erabiltzaile_izena) {
		Erabiltzaile_izena = erabiltzaile_izena;
	}

	/**
	 * Pasahitza lortzen du.
	 * @return Erabiltzailearen pasahitza.
	 */
	public String getPasahitza() {
		return Pasahitza;
	}

	/**
	 * Pasahitza ezartzen du.
	 * @param pasahitza Ezari nahi den pasahitza.
	 */
	public void setPasahitza(String pasahitza) {
		Pasahitza = pasahitza;
	}

	/**
	 * Posta elektronikoa lortzen du.
	 * @return Erabiltzailearen posta elektronikoa.
	 */
	public String getGmail() {
		return gmail;
	}

	/**
	 * Posta elektronikoa ezartzen du.
	 * @param gmail Ezari nahi den posta elektronikoa.
	 */
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	/**
	 * Erabiltzaile mota lortzen du.
	 * @return Erabiltzailearen mota edo rola.
	 */
	public String getMota() {
		return mota;
	}

	/**
	 * Erabiltzaile mota ezartzen du.
	 * @param mota Ezari nahi den erabiltzaile mota.
	 */
	public void setMota(String mota) {
		this.mota = mota;
	}

	/**
	 * Erabiltzailearen informazio guztia testu formatuan itzultzen du.
	 * @return Objektuaren datuak dauzkan String-a.
	 */
	@Override
	public String toString() {
		return "Erabiltzailea [Erabiltzaile_izena=" + Erabiltzaile_izena + ", Pasahitza=" + Pasahitza + ", gmail="
				+ gmail + ", mota=" + mota + ", izena=" + izena + ", adina=" + adina + "]";
	}


	
	
}