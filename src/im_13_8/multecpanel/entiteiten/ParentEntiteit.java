package im_13_8.multecpanel.entiteiten;

/**
 * @author Sam Coenen
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This class is used to store a parent of a scene.
 *
 */

public class ParentEntiteit {
	private String parentSoort;
	private String parentID;
	private ParentEntiteit parent;
	
	/**
	 * Create a new parent.
	 * @param parentSoort Type of parent scene.
	 * @param parentID Name of parent scene.
	 */
	public ParentEntiteit(String parentSoort, String parentID) {
		this.parentSoort = parentSoort;
		this.parentID = parentID;
	}

	/**
	 * 
	 * @return The kind of scene of the parent.
	 */
	public String getParentSoort() {
		return this.parentSoort;
	}
	
	/**
	 * 
	 * @return The ID of the scene of the parent.
	 */
	public String getParentID() {
		return this.parentID;
	}

	/**
	 * 
	 * @return The parent.
	 */
	public ParentEntiteit getParent() {
		return parent;
	}

	/**
	 * 
	 * @param parent The parent.
	 */
	public void setParent(ParentEntiteit parent) {
		this.parent = parent;
	}
}
