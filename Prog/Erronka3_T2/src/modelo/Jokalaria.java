package modelo;

public class Jokalaria extends Pertsona {

	private int jokalariId;
	private int taldeID;
	private int zbkJo;
	private int golak;
	
	public Jokalaria(String izena, int adina, int jokalariId, int taldeID, int zbkJo, int golak ) {
		super(izena, adina);
		this.jokalariId = jokalariId;
		this.taldeID = taldeID;
		this.zbkJo = zbkJo;
	}
	
	public Jokalaria(Jokalaria j) {
		j.jokalariId = jokalariId;
		j.taldeID = taldeID;
		j.zbkJo = zbkJo;
		j.golak = golak;
	}
	
	public Jokalaria() {
		this.jokalariId = 1;
		this.taldeID = 1;
		this.zbkJo = 7;
		this.golak = 0;
	}

	public int getJokalariId() {
		return jokalariId;
	}

	public void setJokalariId(int jokalariId) {
		this.jokalariId = jokalariId;
	}

	public int getTaldeID() {
		return taldeID;
	}

	public void setTaldeID(int taldeID) {
		this.taldeID = taldeID;
	}

	public int getZbkJo() {
		return zbkJo;
	}

	public void setZbkJo(int zbkJo) {
		this.zbkJo = zbkJo;
	}

	public int getGolak() {
		return golak;
	}

	public void setGolak(int golak) {
		this.golak = golak;
	}

	@Override
	public String toString() {
		return "Jokalaria [jokalariId=" + jokalariId + ", taldeID=" + taldeID + ", zbkJo=" + zbkJo + ", golak=" + golak
				+ ", izena=" + izena + ", adina=" + adina + "]";
	}

	
	
	
	
}
