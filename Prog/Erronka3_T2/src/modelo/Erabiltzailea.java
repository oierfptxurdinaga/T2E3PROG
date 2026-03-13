package modelo;

public class Erabiltzailea extends Pertsona{
	
	private String Erabiltzaile_izena;
	private String Pasahitza;
	private String gmail;
	//Konstruktorea
	public Erabiltzailea(String izena, int adina, String erabiltzaile_izena, String pasahitza,
			String gmail) {
		super(izena, adina);
		Erabiltzaile_izena = erabiltzaile_izena;
		Pasahitza = pasahitza;
		this.gmail = gmail;
	}
		

	public Erabiltzailea() {
		Erabiltzaile_izena = "";
		Pasahitza = "";
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
	@Override
	public String toString() {
		return "Erabiltzailea [Erabiltzaile_izena=" + Erabiltzaile_izena + ", Pasahitza=" + Pasahitza + ", gmail="
				+ gmail + ", izena=" + izena + ", adina=" + adina + "]";
	}
	
	
}
