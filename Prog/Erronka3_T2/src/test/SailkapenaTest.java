package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Sailkapena;

class SailkapenaTest {

	Sailkapena s1;
	Sailkapena s2;
	
	@BeforeEach
	void setUp() throws Exception {
		s1 = new Sailkapena();
		s2 = new Sailkapena(1, "Athletic", 10, 5, 3, 30, 35);
	}

	@Test
	void testGetTaldeID() {
		assertEquals(1, s2.getTaldeID());
	}

	@Test
	void testSetTaldeID() {
		s1.setTaldeID(5);
		assertEquals(5, s1.getTaldeID());
	}

	@Test
	void testGetIzenat() {
		assertEquals("Athletic", s2.getIzenat());
	}

	@Test
	void testSetIzenat() {
		s1.setIzenat("Real Sociedad");
		assertEquals("Real Sociedad", s1.getIzenat());
	}

	@Test
	void testGetTPG() {
		assertEquals(10, s2.getTPG());
	}

	@Test
	void testSetTPG() {
		s1.setTPG(12);
		assertEquals(12, s1.getTPG());
	}

	@Test
	void testGetTPE() {
		assertEquals(5, s2.getTPE());
	}

	@Test
	void testSetTPE() {
		s1.setTPE(2);
		assertEquals(2, s1.getTPE());
	}

	@Test
	void testGetTPP() {
		assertEquals(3, s2.getTPP());
	}

	@Test
	void testSetTPP() {
		s1.setTPP(1);
		assertEquals(1, s1.getTPP());
	}

	@Test
	void testGetTGOL() {
		assertEquals(30, s2.getTGOL());
	}

	@Test
	void testSetTGOL() {
		s1.setTGOL(45);
		assertEquals(45, s1.getTGOL());
	}

	@Test
	void testGetTPTS() {
		assertEquals(35, s2.getTPTS());
	}

	@Test
	void testSetTPTS() {
		s1.setTPTS(40);
		assertEquals(40, s1.getTPTS());
	}

	@Test
	void testToString() {
		assertNotNull(s2.toString());
		assertTrue(s2.toString().contains("Athletic"));
		assertTrue(s2.toString().contains("TPTS=35"));
	}
}