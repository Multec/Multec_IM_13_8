package im_13_8.multecpanel.entiteiten;

public class MenuItem {
	private String menuName;
	private String menuImgPath;
	private String menuID;

	public MenuItem(String menuName, String menuImgPath, String menuID) {
		this.menuName = menuName;
		this.menuImgPath = menuImgPath;
		this.menuID = menuID;
	}
	
	public String getName() {
		return this.menuName;
	}
	
	public String getImgPath() {
		return this.menuImgPath;
	}
	
}
