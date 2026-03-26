package modelo;

public class Partidua {
	
	private int denboraldia;
    private int jardunaldia;
    
    private String taldeLokala;
    private String taldeKanpokoa;
    
    private int golLokala;
    private int golKanpokoa;
       
    private int partiduaId;

    // Constructor vacío
    public Partidua() {}

    // Constructor completo
    public Partidua(int jardunaldia, String taldeLokala, String taldeKanpokoa,
                   int golLokala, int golKanpokoa,int partiduaId, int denboraldia) {
        this.jardunaldia = jardunaldia;
        this.taldeLokala = taldeLokala;
        this.taldeKanpokoa = taldeKanpokoa;
        this.golLokala = golLokala;
        this.golKanpokoa = golKanpokoa;
        this.partiduaId = partiduaId;
    }

	public int getJardunaldia() {
		return jardunaldia;
	}

	public void setJardunaldia(int jardunaldia) {
		this.jardunaldia = jardunaldia;
	}

	public String getTaldeLokala() {
		return taldeLokala;
	}

	public void setTaldeLokala(String taldeLokala) {
		this.taldeLokala = taldeLokala;
	}

	public String getTaldeKanpokoa() {
		return taldeKanpokoa;
	}

	public void setTaldeKanpokoa(String taldeKanpokoa) {
		this.taldeKanpokoa = taldeKanpokoa;
	}

	public int getGolLokala() {
		return golLokala;
	}

	public void setGolLokala(int golLokala) {
		this.golLokala = golLokala;
	}

	public int getGolKanpokoa() {
		return golKanpokoa;
	}

	public void setGolKanpokoa(int golKanpokoa) {
		this.golKanpokoa = golKanpokoa;
	}
	
	public int getPartiduaId() {
		return partiduaId;
	}

	public void setPartiduaId(int partiduaId) {
		this.partiduaId = partiduaId;
	}

	public int getDenboraldia() {
		return denboraldia;
	}

	public void setDenboraldia(int denboraldia) {
		this.denboraldia = denboraldia;
	}

	@Override
	public String toString() {
		return "Partidua [denboraldia=" + denboraldia + ", jardunaldia=" + jardunaldia + ", taldeLokala=" + taldeLokala
				+ ", taldeKanpokoa=" + taldeKanpokoa + ", golLokala=" + golLokala + ", golKanpokoa=" + golKanpokoa
				+ ", partiduaId=" + partiduaId + "]";
	}
}