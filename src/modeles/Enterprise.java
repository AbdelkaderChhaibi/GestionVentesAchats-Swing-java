 package modeles;

import java.util.Vector;

public class Enterprise {
	private String matriculeFiscale;
	private String raisonSociale;
	private String type;
	private String descriptionActivite;
	private Vector<CompteBancaire> comptebancaire;
	private String address;
	private String numTelFixe;
	private String numTelPortable;
	private String fax;
	private String eMail;
	private String siteWeb;
	private String etatFiscale;
	

	public Enterprise() {
		// TODO Auto-generated constructor stub
	}


	public Enterprise(String matriculeFiscale, String raisonSociale, String type, String descriptionActivite,
			Vector<CompteBancaire> comptebancaire, String address, String numTelFixe, String numTelPortable, String fax,
			String eMail, String siteWeb, String etatFiscale) {
		super();
		this.matriculeFiscale = matriculeFiscale;
		this.raisonSociale = raisonSociale;
		this.type = type;
		this.descriptionActivite = descriptionActivite;
		this.comptebancaire = comptebancaire;
		this.address = address;
		this.numTelFixe = numTelFixe;
		this.numTelPortable = numTelPortable;
		this.fax = fax;
		this.eMail = eMail;
		this.siteWeb = siteWeb;
		this.etatFiscale = etatFiscale;
	}


	public String getMatriculeFiscale() {
		return matriculeFiscale;
	}


	public void setMatriculeFiscale(String matriculeFiscale) {
		this.matriculeFiscale = matriculeFiscale;
	}


	public String getRaisonSociale() {
		return raisonSociale;
	}


	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDescriptionActivite() {
		return descriptionActivite;
	}


	public void setDescriptionActivite(String descriptionActivite) {
		this.descriptionActivite = descriptionActivite;
	}


	public Vector<CompteBancaire> getComptebancaire() {
		return comptebancaire;
	}


	public void setComptebancaire(Vector<CompteBancaire> comptebancaire) {
		this.comptebancaire = comptebancaire;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getNumTelFixe() {
		return numTelFixe;
	}


	public void setNumTelFixe(String numTelFixe) {
		this.numTelFixe = numTelFixe;
	}


	public String getNumTelPortable() {
		return numTelPortable;
	}


	public void setNumTelPortable(String numTelPortable) {
		this.numTelPortable = numTelPortable;
	}


	public String getFax() {
		return fax;
	}


	public void setFax(String fax) {
		this.fax = fax;
	}


	public String geteMail() {
		return eMail;
	}


	public void seteMail(String eMail) {
		this.eMail = eMail;
	}


	public String getSiteWeb() {
		return siteWeb;
	}


	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}


	public String getEtatFiscale() {
		return etatFiscale;
	}


	public void setEtatFiscale(String etatFiscale) {
		this.etatFiscale = etatFiscale;
	}
	

}
