
package controles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import modeles.Client;
import modeles.CompteBancaire;
import modeles.Personne;

public class ClientService {
	Connexion m;
	Connection cn;
	Statement st;
	public ClientService()  {
	
		
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
	
	public Vector<Personne> getAllClient()  {

			Vector<Personne> c=new Vector<Personne>();
			String req="select * from client";
			try {
				ResultSet s=st.executeQuery(req);
				CompteService cs=new CompteService();
				while(s.next()) {
					Vector<CompteBancaire>b=new Vector<CompteBancaire>();
					b=cs.getAllCompteByCode(s.getString(1));
					c.add(new Client(s.getString(1),s.getString(2),s.getString(3),s.getString(4),s.getString(5),
							b,s.getString(6),s.getString(7),s.getString(8),s.getString(9),s.getString(10),s.getString(11),s.getString(12)));

					
					
					
					
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
		
		return c;
		
		
	}
	
	public void deleteClient(String code) {
		String req="delete from client where code='"+code+"'";
		CompteService sc =new CompteService();
		sc.deleteAllCompte(code);
		try {
			st.execute(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
 public void updateClient(Personne personne) {
	 String req="UPDATE `client` SET `code`='"+personne.getCode()+"',`matricule`='"+personne.getMatriculeFiscale()+"',"
	 		+ "`raison`='"+personne.getRaisonSocial()+"',`type`='"+personne.getType()+"',`description`='"+personne.getDescriptionActivite()+"',"
	 		+ "`address`='"+personne.getAddress()+"',`numfixe`='"+personne.getNumTelFixe()+"',`numportable`='"+personne.getNumTelPortable()+"',"
	 		+ "`fax`='"+personne.getFax()+"',`email`='"+personne.geteMail()+"',`siteweb`='"+personne.getSiteWeb()+"',"
	 		+ "`etat`='"+personne.getEtatFiscale()+"' WHERE code='"+personne.getCode()+"'";
	      CompteService sc=new CompteService();
	      for (CompteBancaire compte : personne.getComptebancaire()) {
	    	  sc.updateCompte(compte);
			
		}
	 try {
		st.execute(req);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 }
	 
public void ajoutClient(Personne personne) {
	String req="INSERT INTO `client`(`code`, `matricule`, `raison`, `type`, `description`,"
			+ " `address`, `numfixe`, `numportable`, `fax`, `email`, `siteweb`, `etat`) VALUES "
			+ "('"+personne.getCode()+"','"+personne.getMatriculeFiscale()+"','"+personne.getRaisonSocial()+"','"+personne.getType()+"','"+personne.getDescriptionActivite()+"','"+
			personne.getAddress()+"','"+personne.getNumTelFixe()+"','"+personne.getNumTelPortable()
			+"','"+personne.getFax()+"','"+personne.geteMail()+"','"+personne.getSiteWeb()+"','"+personne.getEtatFiscale()+"')";
	 CompteService cs=new CompteService();
	for (CompteBancaire compte : personne.getComptebancaire()) {
		cs.ajoutCompte(compte);
		
	}
	try {
		st.execute(req);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
}
	 
	 
	 
	 
	 

	
	
	
	
	
	
	

}
