package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.File;
import java.time.LocalDate;

import DAO.LogDAO;

class LogDAOTest {

    @BeforeEach
    void setUp() throws Exception {
        LogDAO.inicializarLogger();
    }

    @Test
    void testGetLogger() {
        Logger log = LogDAO.getLogger();
        assertNotNull(log);
        assertEquals("Hiim.log", log.getName());
    }

    @Test
    void testLogEscritura() {
        Logger log = LogDAO.getLogger();
        try {
            log.log(Level.INFO, "Test unitario ejecutado correctamente");
            assertTrue(true);
        } catch (Exception e) {
            fail("El logger no debería lanzar excepciones al escribir: " + e.getMessage());
        }
    }

    @Test
    void testArchivoLogCreado() {
        String nombreArchivo = "Log/" + LocalDate.now() + "Log_Aplicacion.log";
        File archivo = new File(nombreArchivo);
        
        assertTrue(archivo.exists(), "El archivo de log debería haberse creado en: " + nombreArchivo);
    }
}