package modelo;

public class Erabiltzailea extends Pertsona{
	
	private String Erabiltzaile_izena;
	private String Pasahitza;
	private String gmail;
	private String mota;
	//Konstruktorea
	public Erabiltzailea(String izena, int adina, String erabiltzaile_izena, String pasahitza,
			String gmail, String mota) {
		super(izena, adina);
		this.Erabiltzaile_izena = erabiltzaile_izena;
		Pasahitza = pasahitza;
		this.gmail = gmail;
		this.mota = mota;
	}
		

	public Erabiltzailea() {
		this.Erabiltzaile_izena = "";
		this.Pasahitza = "";
		this.gmail = "";
	}


	public String getErabiltzaile_izena() {
		return Erabiltzaile_izena;
	}


	public void setErabiltzaile_izena(String erabiltzaile_izena) {
		Erabiltzaile_izena = erabiltzaile_izena;
	}


	public String getPasahitza() {
		return Pasahitza;
	}


	public void setPasahitza(String pasahitza) {
		Pasahitza = pasahitza;
	}


	public String getGmail() {
		return gmail;
	}


	public void setGmail(String gmail) {
		this.gmail = gmail;
	}


	public String getMota() {
		return mota;
	}


	public void setMota(String mota) {
		this.mota = mota;
	}


	@Override
	public String toString() {
		return "Erabiltzailea [Erabiltzaile_izena=" + Erabiltzaile_izena + ", Pasahitza=" + Pasahitza + ", gmail="
				+ gmail + ", mota=" + mota + ", izena=" + izena + ", adina=" + adina + "]";
	}


	
	
}
