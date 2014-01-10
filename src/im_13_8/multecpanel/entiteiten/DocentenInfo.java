package im_13_8.multecpanel.entiteiten;

/**
*
* @author Sam Coenen
* Integration: Multiscreen
* Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
* 
* This class is used to store a teacher.
*
*/

public class DocentenInfo{
	private String docentNaam;
	private String docentImgThumbPath;
	private String docentMoviePath;
	
	/**
	 * Create a new Docent.
	 * @param docentNaam The name of the teacher.
	 * @param docentImgThumbPath The path to the thumbnail img of the teacher.
	 * @param docentMoviePath The path to the movie of the teacher.
	 */
	public DocentenInfo(String docentNaam, String docentImgThumbPath, 
			String docentMoviePath) {
		this.docentNaam = docentNaam;
		this.docentImgThumbPath = docentImgThumbPath;
		this.docentMoviePath = docentMoviePath;
	}

	/**
	 * 
	 * @return The name of the teacher.
	 */
	public String getDocentNaam() {
		return docentNaam;
	}

	/**
	 * 
	 * @param docentNaam Set the name of the teacher.
	 */
	public void setDocentNaam(String docentNaam) {
		this.docentNaam = docentNaam;
	}

	/**
	 * 
	 * @return The path to the thumbnail image of the teacher.
	 */
	public String getDocentImgThumbPath() {
		return this.docentImgThumbPath;
	}

	/**
	 * 
	 * @param docentImgThumbPath Set the path to the thumbnail img of teacher.
	 */
	public void setDocentImgThumbPath(String docentImgThumbPath) {
		this.docentImgThumbPath = docentImgThumbPath;
	}

	/**
	 * 
	 * @return The path to the movie of the teacher.
	 */
	public String getDocentMoviePath() {
		return docentMoviePath;
	}

	/**
	 * 
	 * @param docentMoviePath The path to the movie of the teacher.
	 */
	public void setDocentMoviePath(String docentMoviePath) {
		this.docentMoviePath = docentMoviePath;
	}
		
}
