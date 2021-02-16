package controles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
  private Connection con;
	public Connexion() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		 String url="jdbc:mysql://localhost:3306/Projetjava";
		 con  =DriverManager.getConnection(url,"root","");

	} 
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	

}
