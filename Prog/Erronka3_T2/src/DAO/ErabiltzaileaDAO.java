package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ConexioaBD.Conexioa_BD;

/**
 * Erabiltzaileen datuak (login-a egiteko) kudeatzen dituen DAO klasea.
 * Datu-basearekin konektatzen da erabiltzaile-izenak eta pasahitzak egiaztatzeko.
 */
public class ErabiltzaileaDAO {

	Connection coon = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/**
	 * Datu-basean bilatzen du emandako erabiltzaile-izena existitzen den ala ez.
	 * @param EraIzena Bilatu nahi den erabiltzailearen izena.
	 * @return Datu-basetik ateratako erabiltzaile-izena.
	 */
	public String ErabitzaielIzenaAtera(String EraIzena) {
		
		String eizn="";
		String sql="SELECT `erabitzaile_izena` FROM `terabiltzaile_prog` WHERE erabitzaile_izena=? ";
		
		try {
			coon=Conexioa_BD.conexioa();
			ps=coon.prepareStatement(sql);
			ps.setString(1, EraIzena);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				eizn = rs.getString("erabitzaile_izena");
				
				
			}
		}catch (SQLException e) {
			System.out.println("Error: "+ e.getMessage());
		}
		
		return eizn;
	}
	
	/**
	 * Datu-basean bilatzen du emandako erabiltzailearen pasahitza.
	 * @param EraIzena Bilatu nahi den erabiltzailearen izena.
	 * @return Datu-basetik ateratako pasahitza.
	 */
	public String ErabitzaielPasahitzaAtera(String EraIzena) {
		String epass="";
		String sql="SELECT `pasahitza` FROM `terabiltzailea_prog` WHERE erabitzaile_izena=? ";
		
		try {
			coon=Conexioa_BD.conexioa();
			ps=coon.prepareStatement(sql);
			ps.setString(1, EraIzena);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				epass = rs.getString("pasahitza");
				
				
			}
		}catch (SQLException e) {
			System.out.println("Error: "+ e.getMessage());
		}
		
		return epass;
	}
	
	/**
	 * Sistemara sartu den erabiltzailearen rola gordetzen duen aldagai estatikoa.
	 */
	public static String Erabiltzailemota; {
	}
	
	}