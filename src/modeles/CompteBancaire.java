package modeles;

public class CompteBancaire {
	private String banque;
	private String agence;
	private String RIB;
	private String codeClient;
	public CompteBancaire() {
		super();
	}
	public CompteBancaire(String banque, String agence, String RIB,String codeClient ) {
		super();
		this.banque = banque;
		this.agence = agence;
		this.RIB = RIB;
		this.codeClient=codeClient;
		
	}
	public String getBanque() {
		return banque;
	}
	public void setBanque(String banque) {
		this.banque = banque;
	}
	public String getAgence() {
		return agence;
	}
	public void setAgence(String agence) {
		this.agence = agence;
	}
	public String getRIB() {
		return RIB;
	}
	public void setRIB(String rIB) {
		RIB = rIB;
	}
	public String getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(String codeClient) {
		this.codeClient = codeClient;
	}
	@Override
	public String toString() {
		return "CompteBancaire [banque=" + banque + ", agence=" + agence + ", RIB=" + RIB + ", codeClient=" + codeClient
				+ "]";
	}
	
	

}
