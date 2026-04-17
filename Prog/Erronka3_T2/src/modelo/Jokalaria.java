package modelo;
import jakarta.xml.bind.annotation.*;

/**
 * Jokalari baten datuak gordetzen dituen klasea, Pertsona klasetik herentzia jasoz.
 * XML formatuan (JAXB bidez) tratatzeko anotazioak ditu.
 */
@XmlRootElement(name = "Taldea")
@XmlAccessorType(XmlAccessType.PROPERTY)

public class Jokalaria extends Pertsona {
	
	private int jokalariId;
	private int taldeID;
	private int zbkJo;
	private int golak;
	
	/**
	 * Jokalari baten datu guztiak hasieratzeko eraikitzailea.
	 * @param izena Pertsonaren izena (Pertsona klasetik).
	 * @param adina Pertsonaren adina (Pertsona klasetik).
	 * @param jokalariId Jokalariaren identifikadorea.
	 * @param taldeID Jokalariaren taldearen identifikadorea.
	 * @param zbkJo Jokalariaren dortsal zenbakia.
	 * @param golak Jokalariak sartu dituen golak.
	 */
	public Jokalaria(String izena, int adina, int jokalariId, int taldeID, int zbkJo, int golak ) {
		super(izena, adina);
		this.jokalariId = jokalariId;
		this.taldeID = taldeID;
		this.zbkJo = zbkJo;
		this.golak = golak;
	}
	
	/**
	 * Jokalari baten kopia sortzeko eraikitzailea.
	 * @param j Kopiatu nahi den Jokalaria objektua.
	 */
	public Jokalaria(Jokalaria j) {
		j.jokalariId = jokalariId;
		j.taldeID = taldeID;
		j.zbkJo = zbkJo;
		j.golak = golak;
	}
	
	/**
	 * Eraikitzaile hutsa, JAXB bezalako liburutegiek XML-tik objektuak sortzeko erabilia.
	 */
	public Jokalaria() {}
	
	/**
	 * Jokalariaren identifikadorea lortzen du.
	 * @return Jokalariaren ID-a.
	 */
	@XmlElement(name ="Jid")
	public int getJokalariId() {
		return jokalariId;
	}
	
	/**
	 * Jokalariaren identifikadorea ezartzen du.
	 * @param jokalariId Ezari nahi den ID-a.
	 */
	public void setJokalariId(int jokalariId) {
		this.jokalariId = jokalariId;
	}
	
	/**
	 * Taldearen identifikadorea lortzen du.
	 * @return Taldearen ID-a.
	 */
	@XmlElement(name ="Tid")
	public int getTaldeID() {
		return taldeID;
	}

	/**
	 * Taldearen identifikadorea ezartzen du.
	 * @param taldeID Ezari nahi den taldearen ID-a.
	 */
	public void setTaldeID(int taldeID) {
		this.taldeID = taldeID;
	}
	
	/**
	 * Jokalariaren dortsal zenbakia lortzen du.
	 * @return Dortsal zenbakia.
	 */
	@XmlElement(name ="Zbk")
	public int getZbkJo() {
		return zbkJo;
	}

	/**
	 * Jokalariaren dortsal zenbakia ezartzen du.
	 * @param zbkJo Ezari nahi den dortsal zenbakia.
	 */
	public void setZbkJo(int zbkJo) {
		this.zbkJo = zbkJo;
	}
	
	/**
	 * Sartutako gol kopurua lortzen du.
	 * @return Jokalariaren golak.
	 */
	@XmlElement(name ="Gol")
	public int getGolak() {
		return golak;
	}

	/**
	 * Sartutako gol kopurua ezartzen du.
	 * @param golak Ezari nahi den gol kopurua.
	 */
	public void setGolak(int golak) {
		this.golak = golak;
	}

	/**
	 * Jokalariaren informazio guztia testu formatuan itzultzen du.
	 * @return Objektuaren datuak dauzkan String-a.
	 */
	@Override
	public String toString() {
		return "Jokalaria [jokalariId=" + jokalariId + ", taldeID=" + taldeID + ", zbkJo=" + zbkJo + ", golak=" + golak
				+ ", izena=" + izena + ", adina=" + adina + "]";
	}

	
	
	
	
}