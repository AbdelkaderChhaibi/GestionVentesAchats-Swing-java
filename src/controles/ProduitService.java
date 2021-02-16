package controles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import modeles.FamilleProduit;
import modeles.Fournisseur;
import modeles.Produit;

public class ProduitService {
	Connexion m;
	Connection cn;
	Statement st;
	public ProduitService()  {
	
		
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
	
	public Vector<Produit> getAllProduit(){
		
		
		Vector<Produit> p=new Vector<Produit>();
		String req="select * from produit";
		try {
			ResultSet s=st.executeQuery(req);
			//FornisseurService frs=new FornisseurService();
			while(s.next()) {
				//Fournisseur f=frs.getFournisseurByCode(s.getString(4));
				
				p.add(new Produit(s.getString(1),s.getString(2),s.getString(3),s.getString(4),s.getString(5),
						s.getInt(6),s.getInt(7),s.getDouble(8),s.getDouble(9)));				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	
	return p;
	
	}
	
	public void ajoutProduit(Produit p) {
		String sql="INSERT INTO `produit`(`reference`, `designation`, `uniteMesure`, `fournisseur`, "
				+ "`familleproduit`, `Stoke`, `StokeMin`, `prixUnitaireHorsTaxe`, `taxeTva`) VALUES ('"
				+p.getReference()+"','"+p.getDesignation()+"','"+p.getUniteMesure()+"','"+p.getFournisseur()+"','"
						+p.getFamilleproduit()+"',"+p.getStoke()+","+p.getStokeMin()+","+p.getPrixUnitaireHorsTaxe()+
						","+p.getTaxeTva()+")";
		try {
			st.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
public void modifProduit(Produit p) {
	String sql="UPDATE `produit` SET `reference`='"+p.getReference()+"',`designation`='"+p.getDesignation()+"',"
			+ "`uniteMesure`='"+p.getUniteMesure()+"',`fournisseur`='"+p.getFournisseur()+"',"
			+ "`familleproduit`="+p.getFamilleproduit()+",`Stoke`="+p.getStoke()+",`StokeMin`="+p.getStokeMin()+","
			+ "`prixUnitaireHorsTaxe`="+p.getPrixUnitaireHorsTaxe()+",`taxeTva`="+p.getTaxeTva()+" WHERE `reference`='"+p.getReference()+"'";
    try {
		st.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
public void deleteProduit(String ref) {
	String sql="DELETE FROM `produit` WHERE `reference`='"+ref+"'";
	try {
		st.execute(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	
	
}
