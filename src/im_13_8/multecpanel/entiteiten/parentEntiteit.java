package im_13_8.multecpanel.entiteiten;

public class parentEntiteit {
	private String parentSoort;
	private String parentID;
	
	public parentEntiteit(String parentSoort, String parentID) {
		this.parentSoort = parentSoort;
		this.parentID = parentID;
	}

	public String getParentSoort() {
		return this.parentSoort;
	}
	
	public String getParentID() {
		return this.parentID;
	}
}
