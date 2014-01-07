package im_13_8.multecpanel.entiteiten;

public class DetailInfo{
	private String vakNaam;
	private String vakOmschrijving;
	private String vakImgPath;
	
	public DetailInfo(String vakNaam, String vakOmschrijving, String vakImgPath){
		this.vakNaam = vakNaam;
		this.vakOmschrijving = vakOmschrijving;
		this.vakImgPath = vakImgPath;
	}

	public String getVakNaam() {
		return vakNaam;
	}

	public void setVakNaam(String vakNaam) {
		this.vakNaam = vakNaam;
	}

	public String getVakOmschrijving() {
		return vakOmschrijving;
	}

	public void setVakOmschrijving(String vakOmschrijving) {
		this.vakOmschrijving = vakOmschrijving;
	}

	public String getVakImgPath() {
		return vakImgPath;
	}

	public void setVakImgPath(String vakImgPath) {
		this.vakImgPath = vakImgPath;
	}
	
}
