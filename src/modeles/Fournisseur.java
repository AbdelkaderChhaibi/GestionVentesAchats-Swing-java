package modeles;

import java.util.Vector;

public class Fournisseur extends Personne {

	public Fournisseur() {
		super();
	}

	public Fournisseur(String code, String matriculeFiscale, String raisonSocial, String type,
			String descriptionActivite, Vector<CompteBancaire> comptebancaire, String address, String numTelFixe,
			String numTelPortable, String fax, String eMail, String siteWeb, String etatFiscale) {
		super(code, matriculeFiscale, raisonSocial, type, descriptionActivite, comptebancaire, address, numTelFixe,
				numTelPortable, fax, eMail, siteWeb, etatFiscale);
	}

}
