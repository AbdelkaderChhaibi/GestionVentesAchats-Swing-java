package modeles;

import java.util.Date;
import java.util.Vector;

public class BonReception {
	private String code;
	private String fournisseur;
	private Date dateBon;
	private Date dateReception;
	private String adress;
	private String infoRelative;
	private Vector<ProduitBR> listeProduit;
	public BonReception() {
	
		
	}
	public BonReception(String code, String fournisseur, Date dateBon, Date dateReception, String adress,
			String infoRelative, Vector<ProduitBR> listeProduit) {
		super();
		this.code = code;
		this.fournisseur = fournisseur;
		this.dateBon = dateBon;
		this.dateReception = dateReception;
		this.adress = adress;
		this.infoRelative = infoRelative;
		this.listeProduit = listeProduit;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}
	public Date getDateBon() {
		return dateBon;
	}
	public void setDateBon(Date dateBon) {
		this.dateBon = dateBon;
	}
	public Date getDateReception() {
		return dateReception;
	}
	public void setDateReception(Date dateReception) {
		this.dateReception = dateReception;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getInfoRelative() {
		return infoRelative;
	}
	public void setInfoRelative(String infoRelative) {
		this.infoRelative = infoRelative;
	}
	public Vector<ProduitBR> getListeProduit() {
		return listeProduit;
	}
	public void setListeProduit(Vector<ProduitBR> listeProduit) {
		this.listeProduit = listeProduit;
	}
	public double getMantontTotaleHorsTva() {
		double s=0;
		for (ProduitBR p : listeProduit) {
			s=s+p.TotalePrixTaxe();
			
		}
		return s;
	}

	public double getTtc() {
		double s=0;
		for (ProduitBR p : listeProduit) {
			s=s+p.TotalePrixHorsTaxe();
			
		}
		return s;
	}

	
	
	

}
