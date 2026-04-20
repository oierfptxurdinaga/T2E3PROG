package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import DAO.ErabiltzaileaDAO;

class ErabiltzaileaDAOTest {

	ErabiltzaileaDAO dao;
	String usuarioExistente;
	String passwordEsperada;
	
	@BeforeEach
	void setUp() throws Exception {
		dao = new ErabiltzaileaDAO();
		
		usuarioExistente = "M.pg";
		passwordEsperada = "1234M";
	}

	@Test
	void testErabitzaielIzenaAtera() {
		String resultado = dao.ErabitzaielIzenaAtera(usuarioExistente);
		assertEquals(usuarioExistente, resultado);
	}

	@Test
	void testErabitzaielPasahitzaAtera() {
		String resultado = dao.ErabitzaielPasahitzaAtera(usuarioExistente);
		assertEquals(passwordEsperada, resultado);
	}

	@Test
	void testUsuarioNoExistente() {
		String resultado = dao.ErabitzaielIzenaAtera("UsuarioInexistente_999");
		assertEquals("", resultado);
	}
}