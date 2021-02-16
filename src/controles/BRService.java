package controles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import modeles.BonReception;
import modeles.ProduitBR;

public class BRService {
	Connexion m;
	Connection cn;
	Statement st;
	public BRService()  {			
		try {
			m = new Connexion();
			 cn=m.getCon();
			  st=cn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public Vector<BonReception> getAllBonReception() throws ParseException  {

		Vector<BonReception> c=new Vector<BonReception>();
		String req="select * from br";
		try {
			ResultSet s=st.executeQuery(req);
			ProduitBRService cs=new ProduitBRService();
			while(s.next()) {
				Vector<ProduitBR>b=new Vector<ProduitBR>();
				b=cs.getAllProduit(s.getString(1));
				c.add(new BonReception(s.getString(1),s.getString(2),new SimpleDateFormat("yyyy-mm-dd").parse(s.getString(3)),
						new SimpleDateFormat("yyyy-mm-dd").parse(s.getString(4)),s.getString(5),s.getString(6),b));		
			}
		} catch (SQLException e) {
			e.printStackTrace();			
		}

	return c;
}
public void deleteBR(String code) {
	String req="delete from br where code='"+code+"'";
	ProduitBRService sc =new ProduitBRService();
	sc.deleteAllproduit(code);
	try {
		st.execute(req);
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public void ajoutbr(BonReception br) {
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
   String req="INSERT INTO `br`(`code`, `fournisseur`, `dateb`, `dater`, `adresse`, `info`) VALUES"
		+ " ('"+br.getCode()+"','"+br.getFournisseur()+"','"+dateFormat.format(br.getDateBon())+"'"
		+ ",'"+dateFormat.format(br.getDateReception())+"','"+br.getAdress()+"','"+br.getInfoRelative()+"')";
			
	 ProduitBRService cs=new ProduitBRService();
	for (ProduitBR p : br.getListeProduit()) {
		cs.ajoutProduitBR(p,br.getCode());
	}
	try {
		st.execute(req);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}	
}
public void updatebr(BonReception br)	{
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	   String req="UPDATE `br` SET `code`='"+br.getCode()+"',`fournisseur`='"+br.getFournisseur()+"',"
	   		+ "`dateb`='"+dateFormat.format(br.getDateBon())+"',`dater`='"+dateFormat.format(br.getDateReception())+"',"
	   		+ "`adresse`='"+br.getAdress()+"',`info`='"+br.getInfoRelative()+"' WHERE `code`='"+br.getCode()+"'";
					
			 ProduitBRService cs=new ProduitBRService();
			 cs.deleteAllproduit(br.getCode());
			for (ProduitBR p : br.getListeProduit()) {
				cs.ajoutProduitBR(p,br.getCode());
			}
			try {
				st.execute(req);
			} catch (SQLException e) {
				e.printStackTrace();
			}	
}
}
