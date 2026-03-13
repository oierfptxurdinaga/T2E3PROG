package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ConexioaBD.Conexioa_BD;

import modelo.Erabiltzailea;

public class ErabiltzaileaDAO {

	Connection coon = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public String ErabitzaielIzenaAtera(String EraIzena) {
		
		String eizn="";
		String sql="SELECT `erabitzaile_izena` FROM `terabiltzailea_prog` WHERE erabitzaile_izena=? ";
		
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
	}

