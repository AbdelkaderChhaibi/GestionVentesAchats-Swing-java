package controles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modeles.FamilleProduit;

public class FamilleProduitService {
	Connexion m;
	Connection cn;
	Statement st;
	public FamilleProduitService()  {
	
		
		try {
			m = new Connexion();
			 cn=m.getCon();
			  st=cn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public FamilleProduit getFamilleProduitByCode(int code) {
		String sql="select *  from familleproduit where code="+code;
		FamilleProduit f=new  FamilleProduit();
		
		try {
			ResultSet s = st.executeQuery(sql);
		
		
			while(s.next()) {
				f=new FamilleProduit(s.getLong(1),s.getString(2));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
	
	
	

}
