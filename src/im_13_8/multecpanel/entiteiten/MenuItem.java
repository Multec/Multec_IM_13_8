package im_13_8.multecpanel.entiteiten;

public class MenuItem{
	private String menuName;
	private String menuImgPath;
	private String menuID;
	private String menuImgPathColor;
	private String menuSoort;

	public MenuItem(String menuName, String menuImgPath, String menuImgPathColor, String menuID, String menuSoort) {
		this.menuName = menuName;
		this.menuImgPath = menuImgPath;
		this.menuID = menuID;
		this.menuSoort = menuSoort;
		this.setMenuImgPathColor(menuImgPathColor);
	}
	
	public String getName() {
		return this.menuName;
	}
	
	public String getImgPath() {
		return this.menuImgPath;
	}

	public String getMenuImgPathColor() {
		return menuImgPathColor;
	}

	public void setMenuImgPathColor(String menuImgPathColor) {
		this.menuImgPathColor = menuImgPathColor;
	}

	public String getMenuID() {
		return menuID;
	}
	
	public String getmenuSoort() {
		return this.menuSoort;
	}
	
}
