package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Jokalaria;

class JokalariaTest {

	Jokalaria j1;
	Jokalaria j2;
	
	@BeforeEach
	void setUp() throws Exception {
		j1=new Jokalaria();
		j2=new Jokalaria("Markel", 19, 10, 1, 8);
	}

	@Test
	void testGetJokalariId() {
		assertEquals(10, j2.getJokalariId());
	}

	@Test
	void testSetJokalariId() {
		j1.setJokalariId(7);
		assertEquals(2, j1.getJokalariId());
	}

	@Test
	void testGetTaldeID() {
		assertEquals(1, j2.getTaldeID());
	}

	@Test
	void testSetTaldeID() {
		j1.setTaldeID(2);
		assertEquals(2, j1.getTaldeID());
	}

	@Test
	void testGetZbkJo() {
		assertEquals(8, j2.getZbkJo());
	}

	@Test
	void testSetZbkJo() {
		j1.setZbkJo(7);
		assertEquals(7, j1.getZbkJo());
	}

}
