package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Jokalaria;
import modelo.Sailkapena;
import ConexioaBD.Conexioa_BD;

public class MenuAdmDAO {
	
	Connection coon = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ArrayList<Jokalaria> JokalariakAtera(String Tizena) {
		
		//Sql a sortzen dugu.
		String sql="SELECT tj.jokalariId,tj.izena,tj.zbkJo,tj.adina,tj.taldeID FROM tbjokalaria tj JOIN tbtaldea tt ON tj.taldeID=tt.taldeID WHERE tt.izenaT=?";
		
		ArrayList<Jokalaria> Jokatera = new ArrayList<Jokalaria>();
		
		try {
			coon=Conexioa_BD.conexioa();
			ps=coon.prepareStatement(sql);
			ps.setString(1, Tizena);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				int Jid =rs.getInt("jokalariId");
				String Jizen= rs.getString("izena");
				int Jzbk =rs.getInt("zbkJo");
				int Jadina=rs.getInt("adina");
				int Tid = rs.getInt("taldeID");
				int Jgol=0;
				
				Jokalaria j = new Jokalaria(Jizen, Jadina, Jid,Tid,Jzbk,Jgol);
				Jokatera.add(j);
			}
			
			
		}catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		return Jokatera;
	}
	public void JokalariBerriakSartu(String Tizena, String Jizena,int JokalariId,int Jdorsal,int Jadina,int Tid) {
		
			
		String sql="INSERT INTO `tbjokalaria`(`jokalariId`, `izena`, `taldeID`, `zbkJo`, `adina`) VALUES (?,?,?,?,?)";
		
		try {
			
			coon = Conexioa_BD.conexioa();
			ps = coon.prepareStatement(sql);
			
			ps.setInt(1, JokalariId);
			ps.setString(2, Jizena);
			ps.setInt(3, Tid);
			ps.setInt(4, Jdorsal);
			ps.setInt(5, Jadina);
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Error: "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public boolean JokalariakEzabatu(int JokalariId) {
		String sql="DELETE FROM tbjokalaria WHERE jokalariId =?";
		
	try {
		coon = Conexioa_BD.conexioa();
		ps = coon.prepareStatement(sql);
		ps.setInt(1, JokalariId);
		
		int EzabatutakoZutabeak = ps.executeUpdate();
		return EzabatutakoZutabeak > 0;
		
	}catch(SQLException e) {
		System.out.println("Error: "+e.getMessage());
		return false;
		
	}			
}
	
	public ArrayList<Jokalaria> GuztiaAtera(String Tizena) {
		ArrayList<Jokalaria> DatuakAtera = new ArrayList<Jokalaria>();
		String sql="SELECT j.jokalariId, j.izena, j.adina, j.zbkJo,COUNT(g.golakID)as G_T\r\n"
				+ "FROM tbjokalaria j\r\n"
				+ "JOIN tbtaldea t ON j.taldeID = t.taldeID\r\n"
				+ "LEFT JOIN tbgola g ON j.jokalariId = g.jokalariId\r\n"
				+ "WHERE t.izenaT=?\r\n"
				+ "GROUP BY j.izena\r\n"
				+ "ORDER BY 1 ";
		try {
			coon = Conexioa_BD.conexioa();
			ps = coon.prepareStatement(sql);
			ps.setString(1, Tizena);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int Jid = rs.getInt("jokalariId");
				String Jizen = rs.getString("izena");
				int Jadina = rs.getInt("adina");
				int Jzbk = rs.getInt("zbkJo");
				int Jgol = rs.getInt("G_T");
				
				Jokalaria j = new Jokalaria(Jizen, Jadina, Jid, Jid, Jzbk,Jgol);
				DatuakAtera.add(j);
			}
			
		}catch(SQLException e) {
			System.out.println("Error: "+ e.getMessage());
			e.printStackTrace();
		}
		return DatuakAtera;
	}
	
	public ArrayList<Jokalaria> KanpokoakAtera(String Tizena_K) {
		ArrayList<Jokalaria> DatuakAtera = new ArrayList<Jokalaria>();
		String sql="SELECT j.jokalariId, j.izena, j.adina, j.zbkJo,COUNT(g.golakID)as G_T\r\n"
				+ "FROM tbjokalaria j\r\n"
				+ "JOIN tbtaldea t ON j.taldeID = t.taldeID\r\n"
				+ "LEFT JOIN tbgola g ON j.jokalariId = g.jokalariId\r\n"
				+ "WHERE t.izenaT=?\r\n"
				+ "GROUP BY j.izena\r\n"
				+ "ORDER BY 1 ";
		try {
			coon = Conexioa_BD.conexioa();
			ps = coon.prepareStatement(sql);
			ps.setString(1, Tizena_K);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int Jid = rs.getInt("jokalariId");
				String Jizen = rs.getString("izena");
				int Jadina = rs.getInt("adina");
				int Jzbk = rs.getInt("zbkJo");
				int Jgol = rs.getInt("G_T");
				
				Jokalaria j = new Jokalaria(Jizen, Jadina, Jid, Jid, Jzbk,Jgol);
				DatuakAtera.add(j);
			}
			
		}catch(SQLException e) {
			System.out.println("Error: "+ e.getMessage());
			e.printStackTrace();
		}
		return DatuakAtera;
	}
	
	public boolean JokalariakAldatu(String Jizena_E, int kanpoko_fila) {	
	boolean	JokAldatu = false;
	String sql="UPDATE `tbjokalaria` SET `taldeID`= ? WHERE `izena` = ?";	
	
	try {
		coon = Conexioa_BD.conexioa();
		ps = coon.prepareStatement(sql);
		ps.setInt(1, kanpoko_fila);
		ps.setString(2, Jizena_E);
		ps.executeUpdate();
		
		JokAldatu = true;
		return JokAldatu;
		
	}catch(SQLException e) {
		System.out.println("Error: "+ e.getMessage());
		e.printStackTrace();
	}
		return false;
	}
	
	public ArrayList<Sailkapena> SailkapenAtera(int Denb_Zenbakia ) {
		ArrayList<Sailkapena>Sailakpenak = new ArrayList<Sailkapena>();
		
		String sql="SELECT `taldeID`,`izenat`,`TPG`,`TPE`,`TPP`,`TGOL`,`TPTS`,`NumPART` FROM vligaklasifikazioa0"+ Denb_Zenbakia;
		
		try {
			
			coon = Conexioa_BD.conexioa();
			ps = coon.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int Tid = rs.getInt("taldeID");
				String izenat = rs.getString("izenat");
				int TG = rs.getInt("TPG");
				int TE = rs.getInt("TPE");
				int TP = rs.getInt("TPP");
				int TGL = rs.getInt("TGOL");
				int TPS = rs.getInt("TPTS");
			
				Sailkapena s = new Sailkapena(Tid, izenat, TG, TE, TP, TGL, TPS);
				Sailakpenak.add(s);
			}
			
		} catch (SQLException e) {
			System.out.println("Error: "+ e.getMessage());
			e.printStackTrace();
		}
		
		return Sailakpenak;
	}
	
}
