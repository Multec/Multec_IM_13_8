package im_13_8.multecpanel.entiteiten;

/**
 *
 * @author Sam Coenen
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This class is used to store an item used in our menu's.
 *
 */

public class MenuItem{
	private String menuName;
	private String menuImgPath;
	private String menuID;
	private String menuImgPathColor;
	private String menuSoort;

	/**
	 * Create a new menu item.
	 * @param menuName The title displayed on the menu item.
	 * @param menuImgPath The path to the standard image of the menu item.
	 * @param menuImgPathColor The path to the image when it's highlighted.
	 * @param menuID The ID of the menu item.
	 * @param menuSoort The kind of menu.
	 */
	public MenuItem(String menuName, String menuImgPath, 
			String menuImgPathColor, String menuID, String menuSoort) {
		this.menuName = menuName;
		this.menuImgPath = menuImgPath;
		this.menuID = menuID;
		this.menuSoort = menuSoort;
		this.menuImgPathColor = menuImgPathColor;
	}
	
	/**
	 * 
	 * @return The menu item name.
	 */
	public String getName() {
		return this.menuName;
	}
	
	/**
	 * 
	 * @return The path to the standard image of the menu item.
	 */
	public String getImgPath() {
		return this.menuImgPath;
	}

	/**
	 * 
	 * @return The path to the image of the menu item when highlighted.
	 */
	public String getMenuImgPathColor() {
		return menuImgPathColor;
	}

	/**
	 * 
	 * @return The ID of the menu item.
	 */
	public String getMenuID() {
		return menuID;
	}
	
	/**
	 * 
	 * @return The kind of the menu item.
	 */
	public String getMenuSoort() {
		return this.menuSoort;
	}
	
}
