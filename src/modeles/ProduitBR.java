package modeles;

public class ProduitBR {
	private String reference;
	private String designation;
	private String uniteMesure;
	private int quantite;
	private double prixUnitaireHorsTaxe;
	private double taxeTva;
	public ProduitBR() {
		
	}
	public ProduitBR(String reference, String designation, String uniteMesure, int quantite,
			double prixUnitaireHorsTaxe, double taxeTva) {
		super();
		this.reference = reference;
		this.designation = designation;
		this.uniteMesure = uniteMesure;
		this.quantite = quantite;
		this.prixUnitaireHorsTaxe = prixUnitaireHorsTaxe;
		this.taxeTva = taxeTva;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getUniteMesure() {
		return uniteMesure;
	}
	public void setUniteMesure(String uniteMesure) {
		this.uniteMesure = uniteMesure;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrixUnitaireHorsTaxe() {
		return prixUnitaireHorsTaxe;
	}
	public void setPrixUnitaireHorsTaxe(double prixUnitaireHorsTaxe) {
		this.prixUnitaireHorsTaxe = prixUnitaireHorsTaxe;
	}
	public double getTaxeTva() {
		return taxeTva;
	}
	public void setTaxeTva(double taxeTva) {
		this.taxeTva = taxeTva;
	}
   public double TotalePrixHorsTaxe() {
	   return this.prixUnitaireHorsTaxe*this.quantite;
   }
   public double TotalePrixTaxe() {
	   return (this.prixUnitaireHorsTaxe*this.quantite)*(1+this.taxeTva);
   }
  

}
