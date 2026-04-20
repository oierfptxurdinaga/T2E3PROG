package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Jokalaria;
import modelo.JokalariLista;

class JokalariListaTest {

	JokalariLista jl1;
	JokalariLista jl2;
	List<Jokalaria> listaPrueba;
	
	@BeforeEach
	void setUp() throws Exception {
		jl1 = new JokalariLista();
		
		// Creamos una lista con un jugador para el constructor con parámetros
		listaPrueba = new ArrayList<>();
		listaPrueba.add(new Jokalaria("Markel", 19, 10, 1, 8, 5));
		
		jl2 = new JokalariLista(listaPrueba);
	}

	@Test
	void testGetJokalariak() {
		// Verificamos que la lista no sea nula y que tenga el tamaño esperado
		assertNotNull(jl2.getJokalariak());
		assertEquals(1, jl2.getJokalariak().size());
		assertEquals("Markel", jl2.getJokalariak().get(0).getIzena());
	}

	@Test
	void testSetJokalariak() {
		List<Jokalaria> nuevaLista = new ArrayList<>();
		nuevaLista.add(new Jokalaria("Iñigo", 20, 11, 1, 9, 3));
		
		jl1.setJokalariak(nuevaLista);
		
		assertEquals(1, jl1.getJokalariak().size());
		assertEquals("Iñigo", jl1.getJokalariak().get(0).getIzena());
	}
	
	@Test
	void testConstructorVacio() {
		// Es importante asegurar que el constructor vacío inicializa la lista (no es null)
		assertNotNull(jl1.getJokalariak());
		assertEquals(0, jl1.getJokalariak().size());
	}
}