package im_13_8.multecpanel.entiteiten;

/**
 * @author Johan Sergeyssels
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This class is used to store a remote resource path and name.
 * This would have been used for loading images, sketches and movies in our
 * application if we have enough time to implement everything.
 *
 */
public class Resource {
	private String path;

	/**
	 * 
	 * @return The path of the remote object.
	 */
	public String getPath() {
		return path;
	}

	/**
	 * 
	 * @param path Set the path of the remote object.
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	/**
	 * Create a new resource.
	 * @param path The path to the remote object.
	 */
	public Resource(String path) {
		this.path = path;
	}
}
