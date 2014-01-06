package im_13_8.multecpanel.view.menu;

import im_13_8.multecpanel.controller.MenuController;
import im_13_8.multecpanel.entiteiten.MenuItem;

import java.util.ArrayList;

import org.mt4j.MTApplication;
import org.mt4j.sceneManagement.AbstractScene;

public class Menu extends AbstractScene {
	private ArrayList<MenuItem> menuItems;
	private int listCount;
	private int menuWidth;
	private int menuHeight;

	public Menu(MTApplication mtApplication, String name) {
		super(mtApplication, name);
		
		this.menuItems = new MenuController().getMenuItems();
		this.listCount = this.menuItems.size();
		this.menuWidth = mtApplication.width / this.listCount;
		this.menuHeight = mtApplication.height;
		
		int indexInArray = 0;
		
		for (MenuItem menuItem : this.menuItems) {
			MenuItemView temp = new MenuItemView(menuWidth * indexInArray, 
					0, 
					menuWidth, 
					menuHeight, 
					mtApplication, 
					menuItem.getName(), 
					menuItem.getImgPath(),
					indexInArray
			);
			
			indexInArray++;
			this.getCanvas().addChild(temp);
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shutDown() {
		// TODO Auto-generated method stub
		
	}
}
