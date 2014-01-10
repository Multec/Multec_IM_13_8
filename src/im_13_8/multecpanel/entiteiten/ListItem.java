package im_13_8.multecpanel.entiteiten;
/**
 *
 * @author Johan Sergeyssels
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This class is used to store an item used in our sliders.
 *
 */
public class ListItem{
	private String afbeelingpath;
	private String tekstlinks;
	private String tekstRechts;
	private String soort;
	private String cluster;
	
	/**
	 * 
	 * @return The path to the image.
	 */
	public String getAfbeelingpath() {
		return afbeelingpath;
	}

	/**
	 * 
	 * @param afbeelingpath Set the path to the image.
	 */
	public void setAfbeelingpath(String afbeelingpath) {
		this.afbeelingpath = afbeelingpath;
	}

	/**
	 * 
	 * @return The text displayed on the left side of the image.
	 */
	public String getTekstlinks() {
		return tekstlinks;
	}

	/**
	 * 
	 * @param tekstlinks The text displayed on the left side of the image.
	 */
	public void setTekstlinks(String tekstlinks) {
		this.tekstlinks = tekstlinks;
	}

	/**
	 * 
	 * @return The text displayed on the right side of the image.
	 */
	public String getTekstRechts() {
		return tekstRechts;
	}

	/**
	 * 
	 * @param tekstRechts The text displayed on the right side of the image.
	 */
	public void setTekstRechts(String tekstRechts) {
		this.tekstRechts = tekstRechts;
	}

	/**
	 * 
	 * @return The kind of list item.
	 */
	public String getSoort() {
		return soort;
	}

	/**
	 * 
	 * @param soort Set the kind of list item.
	 */
	public void setSoort(String soort) {
		this.soort = soort;
	}

	/**
	 * 
	 * @return The cluster to which this list item belongs.
	 */
	public String getCluster() {
		return cluster;
	}

	/**
	 * 
	 * @param cluster The cluster to which this list item belongs.
	 */
	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	/**
	 * Create a new list item.
	 * @param afbeelingpath The path to the image.
	 * @param tekstlinks The text displayed on the left side of the image.
	 * @param tekstRechts The text displayed on the right side of the image.
	 * @param soort The kind of list item.
	 * @param cluster The cluster to which this list item belongs.
	 */
	public ListItem(String afbeelingpath, String tekstlinks,
			String tekstRechts, String soort, String cluster) {
		this.afbeelingpath = afbeelingpath;
		this.tekstlinks = tekstlinks;
		this.tekstRechts = tekstRechts;
		this.soort = soort;
		this.cluster = cluster;
	}	
}
