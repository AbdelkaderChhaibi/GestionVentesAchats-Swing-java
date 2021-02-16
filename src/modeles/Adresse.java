package modeles;

public class Adresse {
	private int numRue;
	private String rue;
	private String ville;
	private int CodePostale;
	private String gouvernorat;
	private String paye;

	public Adresse() {
		// TODO Auto-generated constructor stub
	}
	
	public Adresse(int numRue, String rue, String ville, int codePostale, String gouvernorat, String paye) {
		super();
		this.numRue = numRue;
		this.rue = rue;
		this.ville = ville;
		CodePostale = codePostale;
		this.gouvernorat = gouvernorat;
		this.paye = paye;
	}

	public int getNumRue() {
		return numRue;
	}

	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCodePostale() {
		return CodePostale;
	}

	public void setCodePostale(int codePostale) {
		CodePostale = codePostale;
	}

	public String getGouvernorat() {
		return gouvernorat;
	}

	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}

	public String getPaye() {
		return paye;
	}

	public void setPaye(String paye) {
		this.paye = paye;
	}

	@Override
	public String toString() {
		return "Adresse [numRue=" + numRue + ", rue=" + rue + ", ville=" + ville + ", CodePostale=" + CodePostale
				+ ", gouvernorat=" + gouvernorat + ", paye=" + paye + "]";
	}
	

}
