package ConexioaBD;

import java.sql.*;

public class Conexioa_BD {

	public static Connection conexioa() {

		Connection coon = null;
		
		String url="jdbc:mysql://localhost:3306/temporada_futbol";
		String user="root";
		String password="";
		
		try {
			coon=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
			e.printStackTrace();
		}
		
		return coon;
	}
}
