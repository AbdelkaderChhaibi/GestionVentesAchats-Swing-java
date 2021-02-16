package modeles;

import java.util.Date;
import java.util.Vector;

public class FactureFLibre {
	private String code;
	private Date dateBon;
	private Date datereception;
	private String adress;
	private String infoRelative;
	private Vector<ProduitBR> listeProduit;
	public FactureFLibre() {
	
		
	}
	
	public FactureFLibre(String code, Date dateBon, Date datereception, String adress, String infoRelative,
			Vector<ProduitBR> listeProduit) {
		super();
		this.code = code;
		this.dateBon = dateBon;
		this.datereception = datereception;
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
	public Date getDateBon() {
		return dateBon;
	}
	public void setDateBon(Date dateBon) {
		this.dateBon = dateBon;
	}
	public Date getDateReception() {
		return datereception;
	}
	public void setDateReception(Date dateReception) {
		this.datereception = dateReception;
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
