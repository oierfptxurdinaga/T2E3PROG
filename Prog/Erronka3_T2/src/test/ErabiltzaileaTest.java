package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Erabiltzailea;

class ErabiltzaileaTest {
	Erabiltzailea e1;
	Erabiltzailea e2;
	
	@BeforeEach
	void setUp() throws Exception {
		e1=new Erabiltzailea();
		e2=new Erabiltzailea("Hector", 21, "Hect.M", "1234H", "h.martinez@gmail.com", "Erabiltzaile");
	}

	@Test
	void testGetErabiltzaile_izena() {
		assertEquals("Hect.M", e2.getErabiltzaile_izena());
	}

	@Test
	void testSetErabiltzaile_izena() {
		e1.setErabiltzaile_izena("Iñ.G");
		assertEquals("Iñ.G", e1.getErabiltzaile_izena());
	}

	@Test
	void testGetPasahitza() {
		assertEquals("1234H", e2.getPasahitza());
	}

	@Test
	void testSetPasahitza() {
		e1.setPasahitza("1234I");
		assertEquals("1234I", e1.getPasahitza());
	}

	@Test
	void testGetGmail() {
		assertEquals("h.martinez@gmail.com", e2.getGmail());
	}

	@Test
	void testSetGmail() {
		e1.setGmail("m.perez.@gmail.com");
		assertEquals("m.perez.@gmail.com", e1.getGmail());
	}

	@Test
	void testGetMota() {
		assertEquals("Erabiltzaile", e2.getMota());
	}

	@Test
	void testSetMota() {
		e1.setMota("Admin");
		assertEquals("Admin", e1.getMota());
	}

}
