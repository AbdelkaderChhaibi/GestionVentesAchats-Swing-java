package modeles;

public final class FamilleProduit {
	private  long code ;
	private  String designation;

	public FamilleProduit(long code, String designation) {
		this.code = code;
		this.designation = designation;
	}

	public FamilleProduit() {
		// TODO Auto-generated constructor stub
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	

}
