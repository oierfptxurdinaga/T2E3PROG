package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Partidua;

class PartiduaTest {

	Partidua p1;
	Partidua p2;
	
	@BeforeEach
	void setUp() throws Exception {
		p1 = new Partidua();
		p2 = new Partidua(1, "Athletic", "Real Sociedad", 2, 1, 5, 2024);
	}

	@Test
	void testGetPartiduaId() {
		assertEquals(1, p2.getPartiduaId());
	}

	@Test
	void testSetPartiduaId() {
		p1.setPartiduaId(10);
		assertEquals(10, p1.getPartiduaId());
	}

	@Test
	void testGetTaldeLokala() {
		assertEquals("Athletic", p2.getTaldeLokala());
	}

	@Test
	void testSetTaldeLokala() {
		p1.setTaldeLokala("Alaves");
		assertEquals("Alaves", p1.getTaldeLokala());
	}

	@Test
	void testGetTaldeKanpokoa() {
		assertEquals("Real Sociedad", p2.getTaldeKanpokoa());
	}

	@Test
	void testSetTaldeKanpokoa() {
		p1.setTaldeKanpokoa("Eibar");
		assertEquals("Eibar", p1.getTaldeKanpokoa());
	}

	@Test
	void testGetGolLokala() {
		assertEquals(2, p2.getGolLokala());
	}

	@Test
	void testSetGolLokala() {
		p1.setGolLokala(3);
		assertEquals(3, p1.getGolLokala());
	}

	@Test
	void testGetGolKanpokoa() {
		assertEquals(1, p2.getGolKanpokoa());
	}

	@Test
	void testSetGolKanpokoa() {
		p1.setGolKanpokoa(0);
		assertEquals(0, p1.getGolKanpokoa());
	}

	@Test
	void testGetJardunaldia() {
		assertEquals(5, p2.getJardunaldia());
	}

	@Test
	void testSetJardunaldia() {
		p1.setJardunaldia(12);
		assertEquals(12, p1.getJardunaldia());
	}

	@Test
	void testGetDenboraldia() {
		assertEquals(2024, p2.getDenboraldia());
	}

	@Test
	void testSetDenboraldia() {
		p1.setDenboraldia(2025);
		assertEquals(2025, p1.getDenboraldia());
	}

	@Test
	void testToString() {
		assertNotNull(p2.toString());
		assertTrue(p2.toString().contains("Athletic"));
		assertTrue(p2.toString().contains("Real Sociedad"));
	}
}