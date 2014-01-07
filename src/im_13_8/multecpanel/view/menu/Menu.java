package im_13_8.multecpanel.view.menu;

import im_13_8.multecpanel.Application;
import im_13_8.multecpanel.controller.MenuController;
import im_13_8.multecpanel.entiteiten.MenuItem;
import im_13_8.multecpanel.view.util.BackButton;

import java.util.ArrayList;

import org.mt4j.MTApplication;
import org.mt4j.sceneManagement.AbstractScene;

public class Menu extends AbstractScene {
	private ArrayList<MenuItem> menuItems;
	private int listCount;
	private int menuWidth;
	private int menuHeight;

	public Menu(Application app, String name) {
		super(app, name);
		
		this.menuItems = new MenuController(name).getMenuItems();
		this.listCount = this.menuItems.size();
		this.menuWidth = app.width / this.listCount;
		this.menuHeight = app.height;
		
		int indexInArray = 0;
		
		for (MenuItem menuItem : this.menuItems) {
			MenuItemView temp = new MenuItemView(menuWidth * indexInArray, 
					0, 
					menuWidth, 
					menuHeight, 
					app, 
					menuItem.getName(), 
					menuItem.getImgPath(),
					indexInArray
			);
			
			indexInArray++;
			this.getCanvas().addChild(temp);
		}
		
		BackButton backButton = new BackButton(app);
		this.getCanvas().addChild(backButton);
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
