package im_13_8.multecpanel.view.menu;

import im_13_8.multecpanel.Application;
import im_13_8.multecpanel.controller.MenuController;
import im_13_8.multecpanel.entiteiten.MenuItem;
import im_13_8.multecpanel.view.detail.DetailView;
import im_13_8.multecpanel.view.list.ListView;
import im_13_8.multecpanel.view.util.BackButton;
import im_13_8.multecpanel.view.util.BounceBack;
import im_13_8.multecpanel.view.util.IBounceBackObserver;

import java.util.ArrayList;

import org.mt4j.MTApplication;
import org.mt4j.components.MTComponent;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapProcessor;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.animation.Animation;
import org.mt4j.util.animation.AnimationEvent;
import org.mt4j.util.animation.IAnimationListener;
import org.mt4j.util.animation.MultiPurposeInterpolator;
import org.mt4j.util.math.Vector3D;

public class Menu extends AbstractScene implements IBounceBackObserver {
	private ArrayList<MenuItem> menuItems;
	private int listCount;
	private int menuWidth;
	private int menuHeight;
	private Application app;

	public Menu(Application app, String name) {
		super(app, name);
		this.app = app;
		this.menuItems = new MenuController(name).getMenuItems();
		this.listCount = this.menuItems.size();
		this.menuWidth = app.width / this.listCount;
		this.menuHeight = app.height;
		
		int indexInArray = 0;
		
		for (MenuItem menuItem : this.menuItems) {
			final MenuItemView temp = new MenuItemView(menuWidth * indexInArray, 
					0, 
					menuWidth, 
					menuHeight, 
					app, 
					menuItem,
					indexInArray
			);
			
			indexInArray++;
			this.getCanvas().addChild(temp);
			temp.addGestureListener(DragProcessor.class, new BounceBack(menuItem, this, false, false));
			temp.addGestureListener(TapProcessor.class, new IGestureEventListener() {
				
				@Override
				public boolean processGestureEvent(MTGestureEvent ge) {
					switch (ge.getId()) {
					case MTGestureEvent.GESTURE_DETECTED:
						temp.setColored();
						break;
					case MTGestureEvent.GESTURE_UPDATED:
						
						break;
					case MTGestureEvent.GESTURE_ENDED:
						temp.setBlackWhite();
						break;
					}
					return false;
				}
			});
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

	@Override
	public void releasedOn(Object args, float travelled, MTComponent component) {
		if (travelled < -250) {
			this.gotoScene(args, this.app);
		}
	}

	protected void gotoScene(Object args, Application app) {
		MenuItem menuitem = (MenuItem)args;
		
		String menuSoort = menuitem.getmenuSoort(); //Speeding up the following if...else
		String menuID = menuitem.getMenuID();
		
		if (menuSoort == "menu") { //From most used to least used - optimized to the max!
			app.changeScene(new Menu(app, menuID));
		} else if (menuSoort == "detail") {
			app.changeScene(new DetailView(app, menuID));
		} else if (menuSoort == "list") {
			app.changeScene(new ListView(app, menuID));
		} else {
			//app.changeScene(new Panorama(app, menuID));
		}
		
	}

	@Override
	public void hoveredOn(Object args, float travelled, MTComponent target) {
		
	}
}
