package modelo;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Taldea")
public class JokalariLista {
	private List<Jokalaria> jokalariak;
	
	public JokalariLista() {
        this.jokalariak = new ArrayList<>();
    }
	
	public JokalariLista(List<Jokalaria> jokalariak) {
		this.jokalariak = jokalariak;
	}
	@XmlElement(name = "Jokalariak")
	public List<Jokalaria>getJokalariak(){
		return jokalariak;
	}
	public void setJokalariak(List<Jokalaria>jokalariak) {
		this.jokalariak = jokalariak;
	}
}