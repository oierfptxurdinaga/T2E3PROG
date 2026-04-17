package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Partidua;
import ConexioaBD.Conexioa_BD;

/**
 * Epailearen menuko datu-baseko eragiketak (partiduak ikusi, golak sartu eta emaitzak ezabatu) 
 * kudeatzen dituen DAO klasea.
 */
public class MenuEpaileaDAO {
	Connection coon = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	/**
	 * Denboraldi zehatz bateko partidu guztien zerrenda lortzen du datu-basetik.
	 * @param DenboIzen Denboraldiaren izena.
	 * @return Partidua objektuen ArrayList bat.
	 */
	public ArrayList<Partidua> PartiduakAtera(String DenboIzen) {
		
		ArrayList<Partidua> PartiduGuztiak = new ArrayList<Partidua>();
		String sql="SELECT p.partiduaId,p.denboraldiaID,p.jardunaldiaID,tl.izenaT AS TizL,tk.izenaT As TizK,p.golLokal,p.golKanpoko,p.arbitroaId\r\n"
				+ "FROM tbpartidua p\r\n"
				+ "JOIN tbdenboraldia d ON p.denboraldiaID=d.denboraldiaID\r\n"
				+"JOIN tbtaldea tl ON p.taldeLokalID=tl.taldeID\r\n"
				+"JOIN tbtaldea tk ON p.taldeKanpokoID=tk.taldeID\r\n"
				+ "WHERE d.Izena = ?"
				+ "ORDER BY partiduaId ";
		
		try {
			coon = Conexioa_BD.conexioa();
			ps = coon.prepareStatement(sql);
			ps.setString(1,DenboIzen);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int Pid = rs.getInt("partiduaId");
				int Did = rs.getInt("denboraldiaID");
				int Jid = rs.getInt("jardunaldiaID");
				String TizenL = rs.getString("TizL");
				String TizenK = rs.getString("TizK");
				int GlL = rs.getInt("golLokal");
				int GlK = rs.getInt("golKanpoko");
				
				Partidua par = new Partidua(Pid, TizenL, TizenK, GlL, GlK, Jid,Did);
				PartiduGuztiak.add(par);
			}
			
		}catch(SQLException e) {
			System.out.println("Error: "+ e.getMessage());
			e.printStackTrace();
		}
		
		return PartiduGuztiak;
	}
	
	
	/**
	 * Partidu batean sartutako gol bat erregistratzen du: golen taulan datua sartzen du
	 * eta partiduaren taulan dagokion markagailua (etxekoa edo kanpokoa) eguneratzen du.
	 * @param partiduaId Partiduaren identifikadorea.
	 * @param jokalariaId Gola sartu duen jokalariaren identifikadorea.
	 * @param minutua Gola sartu den minutua.
	 * @param jardunalID Jardunaldiaren identifikadorea.
	 * @param esLocal true etxeko taldeak sartu badu, false kanpokoak sartu badu.
	 * @return true eragiketa ondo egin bada, false bestela.
	 */
	public boolean registrarGol(int partiduaId, int jokalariaId, int minutua, int jardunalID, boolean esLocal) {
		
		String sqlGola = "INSERT INTO `tbgola`(`denboraldiaID`,`partiduaId`, `jardunaldiaID`, `jokalariId`, `minutua`) VALUES (3,?,?,?,?)";
		try {
	        coon = Conexioa_BD.conexioa();
	      
	        ps = coon.prepareStatement(sqlGola);
	        ps.setInt(1, partiduaId); 
	        ps.setInt(2, jardunalID); 
	        ps.setInt(3, jokalariaId);
	        ps.setInt(4, minutua);
	        ps.executeUpdate();
	        
	        String campo = esLocal ? "golLokal" : "golKanpoko";
	        String sqlPart = "UPDATE tbpartidua SET " + campo + " = " + campo + " + 1 WHERE partiduaId = ?";
	        PreparedStatement psP = coon.prepareStatement(sqlPart);
	        psP.setInt(1, partiduaId);
	        psP.executeUpdate();
	        
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	/**
	 * Partidu baten emaitzak hutsean uzten ditu (golak 0-ra pasatuz) 
	 * eta partidu horretan sartutako gol guztien erregistroak ezabatzen ditu.
	 * @param partiduaId Emaitzak ezabatu nahi diren partiduaren identifikadorea.
	 */
	public void EmaitzakEzabatu(int partiduaId) {
		
		String sql="UPDATE `tbpartidua` SET `golLokal` = 0, `golKanpoko` = 0\r\n"
				+"WHERE `partiduaId` = ?";
		try {
			coon = Conexioa_BD.conexioa();
			ps = coon.prepareStatement(sql);
			ps.setInt(1, partiduaId);
			ps.executeUpdate();
			
			String sqlEzb ="DELETE FROM `tbgola` WHERE `partiduaId` = ?";
			PreparedStatement psE = coon.prepareStatement(sqlEzb);
			psE.setInt(1, partiduaId);
			psE.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Error: "+ e.getMessage());
			e.printStackTrace();
		}
	}
	    
}