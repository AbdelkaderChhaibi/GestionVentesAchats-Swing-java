package controles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import modeles.CompteBancaire;

public class CompteService {
	Connexion m;
	Connection cn;
	Statement st;
	public CompteService() {
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
	
	public Vector<CompteBancaire> getAllCompteByCode(String code){
		Vector<CompteBancaire> c=new Vector<CompteBancaire>();
		String req="select * from comptebancaire where codeclient='"+code+"'";
		try {
			ResultSet set=st.executeQuery(req);
			while(set.next()) {
				c.add(new CompteBancaire(set.getString(1),set.getString(2),set.getString(3),set.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	
	return c;
		
		
		
	}
	public void deleteAllCompte(String code) {
		String req="delete from comptebancaire where codeclient='"+code+"'";
		try {
			st.execute(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	public void deleteCompte(String rib) {
		String req="delete from comptebancaie where codeclient='"+rib+"'";
		try {
			st.execute(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
 public void updateCompte(CompteBancaire c) {
	 String req="update comptebancaire set banque='"+c.getBanque()+
			 "', agence='"+c.getAgence()+", rib='"+c.getRIB()+"' ,rib='"
			 +c.getRIB()+"',code='"+c.getCodeClient()+"'";
	 try {
		st.executeUpdate(req);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 }
	 
public void ajoutCompte(CompteBancaire c) {
	String req="insert into comptebancaire (banque,agence,rib,codeclient)values('"+c.getBanque()+"','"+
c.getAgence()+"','"+c.getRIB()+"','"+c.getCodeClient()+"')";
	try {
		st.execute(req);
	} catch (SQLException e) {
		e.printStackTrace();
		
	}
	
	
	
	
}

	
}
