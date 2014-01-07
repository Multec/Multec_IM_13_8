package im_13_8.multecpanel.entiteiten;

public class ParentEntiteit {
	private String parentSoort;
	private String parentID;
	private ParentEntiteit parent;
	
	public ParentEntiteit(String parentSoort, String parentID) {
		this.parentSoort = parentSoort;
		this.parentID = parentID;
	}

	public String getParentSoort() {
		return this.parentSoort;
	}
	
	public String getParentID() {
		return this.parentID;
	}

	public ParentEntiteit getParent() {
		return parent;
	}

	public void setParent(ParentEntiteit parent) {
		this.parent = parent;
	}
}
