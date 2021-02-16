package controles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import modeles.ProduitBR;

public class ProduitBRService {

	Connexion m;
	Connection cn;
	Statement st;
	public ProduitBRService() {
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
public Vector<ProduitBR> getAllProduit(String codebr){
	String sql="select * from produitbr where codebr='"+codebr+"'";
	Vector<ProduitBR> vb=new Vector<ProduitBR>();
			
	
	try {
		ResultSet set=st.executeQuery(sql);
		while(set.next()) {
			vb.add(new ProduitBR(set.getString(1),set.getString(2),set.getString(3),set.getInt(4),
					set.getDouble(5),set.getDouble(6)));
		}
	} catch (SQLException e) {
		e.printStackTrace();
		
	}
return vb;	
}
public void deleteByRef( String ref) {
	String req="delete from produitbr where reference='"+ref+"'";
	try {
		st.execute(req);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	 
}
public void deleteAllproduit( String codebr) {
	String req="delete from produitbr where codebr='"+codebr+"'";
	try {
		st.execute(req);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	 
}
public void ajoutProduitBR(ProduitBR p ,String codebr) {
	String req="INSERT INTO `produitbr`(`reference`, `designation`, `uniteMesure`, "
			+ "`quantite`, `prixunitaire`, `tva`, `codebr`) VALUES "
			+ "('"+p.getReference()+"','"+p.getDesignation()+"','"+p.getUniteMesure()+"',"
			+ "'"+p.getQuantite()+"','"+p.getPrixUnitaireHorsTaxe()+"','"+p.getTaxeTva()+"','"+codebr+"')";
	try {
		st.execute(req);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	 
}
	
	
	
	
	
	

}
