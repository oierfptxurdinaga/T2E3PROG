package ConexioaBD;

import java.sql.*;

/**
 * Datu-basearekin (MySQL) konexioa ezartzeko ardura duen klasea.
 * Aplikazioko gainontzeko DAO klaseek metodo hau erabiltzen dute 
 * datu-basean kontsultak edo aldaketak egiteko.
 * @author [HIIM/T2]
 * @version 1.0
 */
public class Conexioa_BD {

    /**
     * "temporada_futbol" datu-basearekin konexioa sortzen du JDBC bidez.
     * Tokiko zerbitzarira (localhost) konektatzen da, "root" erabiltzailearekin.
     * * @return Datu-basearekin irekitako Connection objektua. Konexioak huts egiten badu, null itzuliko du.
     */
    public static Connection conexioa() {

        Connection conn = null;
        
        String url="jdbc:mysql://localhost:3306/temporada_futbol";
        String user="root";
        String password="";
        
        try {
            conn=DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        
        return conn;
    }
}