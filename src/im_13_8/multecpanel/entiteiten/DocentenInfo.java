package im_13_8.multecpanel.entiteiten;

public class DocentenInfo{
	private String docentNaam;
	private String docentImgThumbPath;
	private String docentMoviePath;
	
	public DocentenInfo(String docentNaam, String docentImgThumbPath, String docentMoviePath) {
		this.docentNaam = docentNaam;
		this.docentImgThumbPath = docentImgThumbPath;
		this.docentMoviePath = docentMoviePath;
	}

	public String getDocentNaam() {
		return docentNaam;
	}

	public void setDocentNaam(String docentNaam) {
		this.docentNaam = docentNaam;
	}

	public String getDocentImgThumbPath() {
		return this.docentImgThumbPath;
	}

	public void setDocentImgThumbPath(String docentImgThumbPath) {
		this.docentImgThumbPath = docentImgThumbPath;
	}

	public String getDocentMoviePath() {
		return docentMoviePath;
	}

	public void setDocentMoviePath(String docentMoviePath) {
		this.docentMoviePath = docentMoviePath;
	}
		
}
