package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Jokalaria;
import ConexioaBD.Conexioa_BD;

public class MenuAdmDAO {
	
	Connection coon = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ArrayList<Jokalaria> Jokalariak_atera(String Tizena) {
		
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
				
				Jokalaria j = new Jokalaria(Jizen, Jadina, Jid,Tid,Jzbk);
				Jokatera.add(j);
			}
			
			
		}catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		return Jokatera;
	}
	public void btnSartu(String Tizena, String Jizena,int JokalariId,int Jdorsal,int Jadina) {
		
		int n=0;
		if(Tizena.equals("LA MERCED")) {
			n=1;
		}else if(Tizena.equals("MORAZA")) {
			n=2;
		}else if(Tizena.equals("SANTUTXU FC")) {
			n=3;
		}else if(Tizena.equals("CD BASKONIA")) {
			n=4;
		}else if(Tizena.equals("CD ARIZ")) {
			n=5;
		}else if(Tizena.equals("SD HUMORE ONA")) {
			n=6;
		}
			
		String sql="INSERT INTO `tbjokalaria`(`jokalariId`, `izena`, `taldeID`, `zbkJo`, `adina`) VALUES (?,?,"+n+",?,?)";
		
		try {
			
			coon = Conexioa_BD.conexioa();
			ps = coon.prepareStatement(sql);
			
			ps.setInt(1, JokalariId);
			ps.setString(2, Jizena);
			ps.setInt(3, Jdorsal);
			ps.setInt(4, Jadina);
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Error: "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public boolean btnEzabatu(int JokalariId) {
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
		String sql="SELECT j.jokalariId,j.izena,j.adina,j.zbkJo\r\n"
				+ "FROM tbtaldea t\r\n"
				+ "JOIN tbjokalaria j on t.taldeID=j.taldeID\r\n"
				+ "JOIN tbgola g on j.jokalariId=g.jokalariId\r\n"
				+ "WHERE t.izenaT= ?\r\n"
				+ "GROUP BY 1 ASC";
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
				
				Jokalaria j = new Jokalaria(Jizen, Jadina, Jid, Jid, Jzbk);
				DatuakAtera.add(j);
			}
			
		}catch(SQLException e) {
			System.out.println("Error: "+ e.getMessage());
			e.printStackTrace();
		}
		return DatuakAtera;
	}
}
