package controles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import modeles.CompteBancaire;
import modeles.Enterprise;

public class ServiceEnterprise {
	Connexion m;
	Connection cn;
	Statement st;
	public ServiceEnterprise() {
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
	public Enterprise getEnterprise() {
		String sql="select * from enterprise";
		Enterprise e=new Enterprise();
		try {
			ResultSet s=st.executeQuery(sql);
			CompteService cs=new CompteService();
			while(s.next()) {
				Vector<CompteBancaire>b=new Vector<CompteBancaire>();
				b=cs.getAllCompteByCode(s.getString(1));
				e=new Enterprise(s.getString(1),s.getString(2),s.getString(3),s.getString(4),
						b,s.getString(5),s.getString(6),s.getString(7),s.getString(8),s.getString(9),s.getString(10),s.getString(11));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return e;
	}
  public void modifEnterprise(Enterprise e) {
	  String sql="UPDATE `enterprise` SET `matricule`='"+e.getMatriculeFiscale()+"',`raison`='"+e.getRaisonSociale()+
			  "',`type`='"+e.getType()+"',`description`='"+e.getDescriptionActivite()+"',"
			  		+ "`adresse`='"+e.getAddress()+"',`numtelfixe`='"+e.getNumTelFixe()+"'"
	  		+ ",`numtelportable`='"+e.getNumTelPortable()+"',`fax`='"+e.getFax()+"',`email`='"+e.geteMail()+"',"
	  				+ "`siteweb`='"+e.getSiteWeb()+"',"
	  		+ "`etat`='"+e.getEtatFiscale()+"' WHERE `matricule`='"+e.getMatriculeFiscale()+"'";
	  try {
		st.executeUpdate(sql);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
  }
public void enregistrerEnterprise(Enterprise e) {
	String sql="INSERT INTO `enterprise`(`matricule`, `raison`, `type`, `description`, `adresse`,"
			+ " `numtelfixe`, `numtelportable`, `fax`, `email`, `siteweb`, `etat`) VALUES "
			+ "('"+e.getMatriculeFiscale()+"','"+e.getRaisonSociale()+"','"+e.getType()+"','"+e.getDescriptionActivite()+"','"+e.getAddress()+"','"+e.getNumTelFixe()+"'"
			+ ",'"+e.getNumTelPortable()+"','"+e.getFax()+"','"+e.geteMail()+"','"+e.getSiteWeb()+"','"+e.getEtatFiscale()+"')";
	
}
  
  
}
