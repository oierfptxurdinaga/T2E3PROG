package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Pertsona;

class PertsonaTest {
	Pertsona p1;
	Pertsona p2;
	@BeforeEach
	void setUp() throws Exception {
		p1=new Pertsona();
		p2=new Pertsona("Iñigo", 19);
	}

	@Test
	void testGetIzena() {
		assertEquals("Iñigo",p2.getIzena() );
	}

	@Test
	void testSetIzena() {
		p1.setIzena("Markel");
		assertEquals("Markel", p1.getIzena());
	}

	@Test
	void testGetAdina() {
		assertEquals(19 ,p2.getAdina());
	}

	@Test
	void testSetAdina() {
		p1.setAdina(20);
		assertEquals(20, p1.getAdina());
	}

}
