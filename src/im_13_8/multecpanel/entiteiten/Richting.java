package im_13_8.multecpanel.entiteiten;

/**
 * @author Johan Sergeyssels
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This class is used to store a major.
 *
 */
public class Richting {
	private String naam;

	/**
	 * @return The name of the major.
	 */
	public String getNaam() {
		return naam;
	}

	/**
	 * 
	 * @param naam The name of the major. 
	 */
	public void setNaam(String naam) {
		this.naam = naam;
	}

	/**
	 * Create a new major.
	 * @param naam The name of the major.
	 */
	public Richting(String naam) {
		super();
		this.naam = naam;
	}
}
