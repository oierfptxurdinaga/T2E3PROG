package modelo;

/**
 * Pertsona baten oinarrizko datuak (izena eta adina) gordetzen dituen klasea.
 * Beste klase batzuen (adibidez, Erabiltzailea edo Jokalaria) gurasoa edo superklasea izateko pentsatua.
 */
public class Pertsona {

	protected String izena;
	protected int adina;
	
	/**
	 * Pertsona baten datu guztiak hasieratzeko eraikitzailea.
	 * @param izena Pertsonaren izena.
	 * @param adina Pertsonaren adina.
	 */
	public Pertsona(String izena, int adina) {
		super();
		this.izena = izena;
		this.adina = adina;
	}

	/**
	 * Pertsona baten kopia sortzeko eraikitzailea.
	 * @param p Kopiatu nahi den Pertsona objektua.
	 */
	public Pertsona(Pertsona p) {
		super();
		p.izena = izena;
		p.adina = adina;
	}
	
	/**
	 * Eraikitzaile hutsa, pertsona bat hasierako balioekin sortzeko.
	 */
	public Pertsona() {
		super();
		this.izena = "";
		this.adina = 0;
	}

	/**
	 * Pertsonaren izena lortzen du.
	 * @return Pertsonaren izena.
	 */
	public String getIzena() {
		return izena;
	}

	/**
	 * Pertsonaren izena ezartzen du.
	 * @param izena Ezari nahi den izena.
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}


	/**
	 * Pertsonaren adina lortzen du.
	 * @return Pertsonaren adina.
	 */
	public int getAdina() {
		return adina;
	}

	/**
	 * Pertsonaren adina ezartzen du.
	 * @param adina Ezari nahi den adina.
	 */
	public void setAdina(int adina) {
		this.adina = adina;
	}

	/**
	 * Pertsonaren informazio guztia testu formatuan itzultzen du.
	 * @return Objektuaren datuak dauzkan String-a.
	 */
	@Override
	public String toString() {
		return "Pertsona [izena=" + izena + ", adina=" + adina + "]";
	}
	
	
	
	

}