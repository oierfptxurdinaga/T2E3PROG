package modelo;

public class Pertsona {

	protected String izena;
	protected int adina;
	
	public Pertsona(String izena, int adina) {
		super();
		this.izena = izena;
		this.adina = adina;
	}

	public Pertsona(Pertsona p) {
		super();
		p.izena = izena;
		p.adina = adina;
	}
	
	public Pertsona() {
		super();
		this.izena = "";
		this.adina = 0;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}


	public int getAdina() {
		return adina;
	}

	public void setAdina(int adina) {
		this.adina = adina;
	}

	@Override
	public String toString() {
		return "Pertsona [izena=" + izena + ", adina=" + adina + "]";
	}
	
	
	
	

}
