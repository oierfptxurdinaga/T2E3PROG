package modelo;

public class Sailkapena {
	private int TaldeID;
	private String izenat;
	private int TPG;
	private int TPE;
	private int TPP;
	private int TGOL; 
	private int TPTS;
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
	
	public int getTaldeID() {
		return TaldeID;
	}
	public void setTaldeID(int taldeID) {
		TaldeID = taldeID;
	}
	public String getIzenat() {
		return izenat;
	}
	public void setIzenat(String izenat) {
		this.izenat = izenat;
	}
	public int getTPG() {
		return TPG;
	}
	public void setTPG(int tPG) {
		TPG = tPG;
	}
	public int getTPE() {
		return TPE;
	}
	public void setTPE(int tPE) {
		TPE = tPE;
	}
	public int getTPP() {
		return TPP;
	}
	public void setTPP(int tPP) {
		TPP = tPP;
	}
	public int getTGOL() {
		return TGOL;
	}
	public void setTGOL(int tGOL) {
		TGOL = tGOL;
	}
	public int getTPTS() {
		return TPTS;
	}
	public void setTPTS(int tPTS) {
		TPTS = tPTS;
	}
	
	@Override
	public String toString() {
		return "Sailkapena [TaldeID=" + TaldeID + ", izenat=" + izenat + ", TPG=" + TPG + ", TPE=" + TPE + ", TPP="
				+ TPP + ", TGOL=" + TGOL + ", TPTS=" + TPTS + "]";
	}
	
	
	
}
