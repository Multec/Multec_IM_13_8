package im_13_8.multecpanel.entiteiten;

public class ListItem{
	private String afbeelingpath;
	private String tekstlinks;
	private String tekstRechts;
	private String soort;
	private String cluster;
	
	public String getAfbeelingpath() {
		return afbeelingpath;
	}

	public void setAfbeelingpath(String afbeelingpath) {
		this.afbeelingpath = afbeelingpath;
	}

	public String getTekstlinks() {
		return tekstlinks;
	}

	public void setTekstlinks(String tekstlinks) {
		this.tekstlinks = tekstlinks;
	}

	public String getTekstRechts() {
		return tekstRechts;
	}

	public void setTekstRechts(String tekstRechts) {
		this.tekstRechts = tekstRechts;
	}

	public String getSoort() {
		return soort;
	}

	public void setSoort(String soort) {
		this.soort = soort;
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public ListItem(String afbeelingpath, String tekstlinks,
			String tekstRechts, String soort, String cluster) {
		this.afbeelingpath = afbeelingpath;
		this.tekstlinks = tekstlinks;
		this.tekstRechts = tekstRechts;
		this.soort = soort;
		this.cluster = cluster;
	}	
}
