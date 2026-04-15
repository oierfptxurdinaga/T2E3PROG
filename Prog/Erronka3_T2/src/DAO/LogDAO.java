package DAO;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;

public class LogDAO {
    // Programa guztirako instantzia bat sortzen dugu:
    private static final Logger logger = Logger.getLogger("Hiim.log");

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

    public static Logger getLogger() {
        return logger;
    }
}