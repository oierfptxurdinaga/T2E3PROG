package modelo;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Jokalarien zerrenda bat biltzen duen klasea, XML formatuan (JAXB bidez) 
 * tratatzeko (esportatu eta inportatzeko) erabiltzen dena.
 */
@XmlRootElement(name = "Taldea")
public class JokalariLista {
	private List<Jokalaria> jokalariak;
	
	/**
	 * Eraikitzaile hutsa, jokalarien zerrenda huts bat hasieratzen duena.
	 */
	public JokalariLista() {
		this.jokalariak = new ArrayList<>();
	}	
	/**
	 * Emandako jokalarien zerrenda batekin objektua hasieratzeko eraikitzailea.
	 * @param jokalariak Jokalarien zerrenda bat.
	 */
	public JokalariLista(List<Jokalaria> jokalariak) {
		this.jokalariak = jokalariak;
	}
	
	/**
	 * Jokalarien zerrenda lortzen du.
	 * @return Jokalaria objektuen zerrenda.
	 */
	@XmlElement(name = "Jokalariak")
	public List<Jokalaria>getJokalariak(){
		return jokalariak;
	}
	
	/**
	 * Jokalarien zerrenda ezartzen du.
	 * @param jokalariak Ezari nahi den jokalarien zerrenda.
	 */
	public void setJokalariak(List<Jokalaria>jokalariak) {
		this.jokalariak = jokalariak;
	}
}