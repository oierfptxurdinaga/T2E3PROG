package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Partidua;
import ConexioaBD.Conexioa_BD;

public class MenuEpaileaDAO {
	Connection coon = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
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
	
	
	public boolean EmaitzakSartu(String Jokalari_L, String Jokalari_K,int ML, int MK, String IdPartidua) {
		
		boolean Insertado = false;
		String sql ="UPDATE `tbpartidua` \r\n"
				+ "SET `partiduaId`=',`denboraldiaID`='[value-2]',`jardunaldiaID`='[value-3]',`taldeLokalID`='[value-4]',`taldeKanpokoID`='[value-5]',`golLokal`='[value-6]',`golKanpoko`='[value-7]',`arbitroaId`='[value-8]'\r\n"
				+ "WHERE 1";
		try {
			coon = Conexioa_BD.conexioa();
			ps = coon.prepareStatement(sql);
			ps.setString(MK, sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return Insertado;
		
	}
}
