package im_13_8.multecpanel.entiteiten;

public class Cluster {
	private String naam;
	private int aantal;
	
	public Cluster(String naam, int aantal) {
		super();
		this.setNaam(naam);
		this.setAantal(aantal);
	}



	public String getNaam() {
		return naam;
	}



	public void setNaam(String naam) {
		this.naam = naam;
	}



	public int getAantal() {
		return aantal;
	}



	public void setAantal(int aantal) {
		this.aantal = aantal;
	}
}
