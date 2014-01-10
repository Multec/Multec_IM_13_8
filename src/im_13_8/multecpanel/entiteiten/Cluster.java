package im_13_8.multecpanel.entiteiten;

/**
 *
 * @author Johan Sergeyssels
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This class is used to create a cluster.
 *
 */
public class Cluster {
	private String naam;
	private int aantal;
	
	/**
	 * Create a new cluster.
	 * @param naam The name of the cluster.
	 * @param aantal The number of items inside this cluster.
	 */
	public Cluster(String naam, int aantal) {
		super();
		this.setNaam(naam);
		this.setAantal(aantal);
	}

	/**
	 * 
	 * @return The name of the cluster.
	 */
	public String getNaam() {
		return naam;
	}

	/**
	 * 
	 * @param naam Set the name of the cluster.
	 */
	public void setNaam(String naam) {
		this.naam = naam;
	}

	/**
	 * 
	 * @return The number of items inside this cluster.
	 */
	public int getAantal() {
		return aantal;
	}

	/**
	 * 
	 * @param aantal Set the number of items inside this cluster.
	 */
	public void setAantal(int aantal) {
		this.aantal = aantal;
	}
}
