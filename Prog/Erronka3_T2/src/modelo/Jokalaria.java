package modelo;

public class Jokalaria extends Pertsona {

	private int jokalariId;
	private int taldeID;
	private int zbkJo;
	
	public Jokalaria(String izena, int adina, int jokalariId, int taldeID, int zbkJo) {
		super(izena, adina);
		this.jokalariId = jokalariId;
		this.taldeID = taldeID;
		this.zbkJo = zbkJo;
	}
	
	public Jokalaria(Jokalaria j) {
		j.jokalariId = jokalariId;
		j.taldeID = taldeID;
		j.zbkJo = zbkJo;
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

	@Override
	public String toString() {
		return "Jokalaria [jokalariId=" + jokalariId + ", taldeID=" + taldeID + ", zbkJo=" + zbkJo + ", izena=" + izena
				+ ", adina=" + adina + "]";
	}

	
	
	
}
