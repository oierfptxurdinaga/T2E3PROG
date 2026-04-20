package DAO;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;

/**
 * Aplikazioaren gertaerak (log-ak) fitxategi batean erregistratzeko kudeatzailea.
 * Eguneroko fitxategiak sortzen ditu ekintza guztiak gordetzeko.
 */
public class LogDAO {
    // Programa guztirako instantzia bat sortzen dugu:
    private static final Logger logger = Logger.getLogger("Hiim.log");

    /**
     * Logger-a hasieratzen du. "Log" karpetan eguneko datarekin fitxategi bat sortzen du 
     * (edo dagoenari informazioa gehitzen dio) eta formatu sinplea ezartzen dio.
     */
    public static void inicializarLogger() {
        try {
            // "true" ipintzen dugu berriro ejekutatzerakoan dagoen logina ez ezabatzeko:
            FileHandler fh = new FileHandler("Log/"+LocalDate.now()+"_Log_Aplicacion.log", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            
            logger.setUseParentHandlers(false); 
            
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Programako beste klaseetatik Logger instantzia eskuratzeko metodoa,
     * mezu berriak (info, warning, error...) idatzi ahal izateko.
     * @return Aplikazioaren Logger objektua.
     */
    public static Logger getLogger() {
        return logger;
    }
}