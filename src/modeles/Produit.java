package modeles;

public class Produit {
	private String reference;
	private String designation;
	private String uniteMesure;
	private String fournisseur;
	private String familleproduit;
	private int Stoke;
	private int StokeMin;
	private double prixUnitaireHorsTaxe;
	private double taxeTva;
	public Produit(String reference, String designation, String uniteMesure, String fournisseur,
			String familleproduit, int stoke, int stokeMin, double prixUnitaireHorsTaxe, double taxeTva) {
		super();
		this.reference = reference;
		this.designation = designation;
		this.uniteMesure = uniteMesure;
		this.fournisseur = fournisseur;
		this.familleproduit = familleproduit;
		Stoke = stoke;
		StokeMin = stokeMin;
		this.prixUnitaireHorsTaxe = prixUnitaireHorsTaxe;
		this.taxeTva = taxeTva;
	}
	public Produit() {
		// TODO Auto-generated constructor stub
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
	public String getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}
	public String getFamilleproduit() {
		return familleproduit;
	}
	public void setFamilleproduit(String familleproduit) {
		this.familleproduit = familleproduit;
	}
	public int getStoke() {
		return Stoke;
	}
	public void setStoke(int stoke) {
		Stoke = stoke;
	}
	public int getStokeMin() {
		return StokeMin;
	}
	public void setStokeMin(int stokeMin) {
		StokeMin = stokeMin;
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
	
	

}
