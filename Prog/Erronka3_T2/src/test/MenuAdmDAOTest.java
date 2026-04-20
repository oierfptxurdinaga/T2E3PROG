package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import DAO.MenuAdmDAO;
import modelo.Jokalaria;
import modelo.Sailkapena;

class MenuAdmDAOTest {

    MenuAdmDAO dao;

    @BeforeEach
    void setUp() throws Exception {
        dao = new MenuAdmDAO();
    }

    @Test
    void testJokalariakAtera() {
        ArrayList<Jokalaria> lista = dao.JokalariakAtera("LA MERCED");
        assertNotNull(lista);
    }

    @Test
    void testJokalariBerriakSartuEtaEzabatu() {
        dao.JokalariBerriakSartu("LA MERCED", "Test Player", 999, 99, 25, 1);
        
        boolean borrado = dao.JokalariakEzabatu(999);
        assertTrue(borrado, "El jugador de prueba 999 debería haber sido borrado");
    }

    @Test
    void testJokalariakAldatu() {
        boolean resultado = dao.JokalariakAldatu("NombreInexistente", 1);
        assertTrue(resultado); 
    }

    @Test
    void testSailkapenAtera() {
        ArrayList<Sailkapena> lista = dao.SailkapenAtera(1);
        assertNotNull(lista);
    }

    @Test
    void testGuztiaAtera() {
        ArrayList<Jokalaria> lista = dao.GuztiaAtera("LA MERCED");
        assertNotNull(lista);
    }
}