package im_13_8.multecpanel.entiteiten;

/**
 *
 * @author Sam Coenen
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This class is used to store the information used by a DetailView.
 *
 */

public class DetailInfo{
	private String vakNaam;
	private String vakOmschrijving;
	private String vakImgPath;
	
	/**
	 * Create a new DetailInfo.
	 * @param vakNaam The title displayed on the screen.
	 * @param vakOmschrijving The explanation displayed on the screen.
	 * @param vakImgPath The image used for the background of the screen.
	 */
	public DetailInfo(String vakNaam, String vakOmschrijving, 
			String vakImgPath){
		this.vakNaam = vakNaam;
		this.vakOmschrijving = vakOmschrijving;
		this.vakImgPath = vakImgPath;
	}

	/**
	 * 
	 * @return The title of the screen.
	 */
	public String getVakNaam() {
		return vakNaam;
	}

	/**
	 * 
	 * @param vakNaam Set the title of the screen.
	 */
	public void setVakNaam(String vakNaam) {
		this.vakNaam = vakNaam;
	}

	/**
	 * 
	 * @return The description text of the screen.
	 */
	public String getVakOmschrijving() {
		return vakOmschrijving;
	}

	/**
	 * 
	 * @param vakOmschrijving Set the description text of the screen.
	 */
	public void setVakOmschrijving(String vakOmschrijving) {
		this.vakOmschrijving = vakOmschrijving;
	}

	/**
	 * 
	 * @return The path used for the background image.
	 */
	public String getVakImgPath() {
		return vakImgPath;
	}

	/**
	 * 
	 * @param vakImgPath Set the path of the background image.
	 */
	public void setVakImgPath(String vakImgPath) {
		this.vakImgPath = vakImgPath;
	}
	
}
