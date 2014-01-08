package im_13_8.multecpanel.view.menu;

import im_13_8.multecpanel.Application;
import im_13_8.multecpanel.controller.MenuController;
import im_13_8.multecpanel.entiteiten.MenuItem;
import im_13_8.multecpanel.entiteiten.ParentEntiteit;
import im_13_8.multecpanel.view.detail.DetailView;
import im_13_8.multecpanel.view.list.ListView;
import im_13_8.multecpanel.view.util.BackButton;
import im_13_8.multecpanel.view.util.BounceBack;
import im_13_8.multecpanel.view.util.CustomScene;
import im_13_8.multecpanel.view.util.CustomTransition;
import im_13_8.multecpanel.view.util.IBackButtonObserver;
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

public class Menu extends CustomScene implements IBounceBackObserver {
	private ArrayList<MenuItem> menuItems;
	private int listCount;
	private int menuWidth;
	private int menuHeight;

	public Menu(Application app, String name, ParentEntiteit parent) {
		super(app, name, parent);
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
		
		BackButton backButton = new BackButton(app, this);
		this.getCanvas().addChild(backButton);
	}

	@Override
	public boolean releasedOn(Object args, float travelled, MTComponent component) {
		return false;
	}

	protected void gotoScene(Object args, Application app) {
		MenuItem menuitem = (MenuItem)args;
		
		String menuSoort = menuitem.getmenuSoort(); //Speeding up the following if...else
		String menuID = menuitem.getMenuID();
		
		ParentEntiteit parent = new ParentEntiteit("menu", this.getName());
		parent.setParent(this.parent);
		
		transition.setDirection("up");
		app.goToScene(menuSoort, menuID, parent);
	}

	@Override
	public boolean hoveredOn(Object args, float travelled, MTComponent target) {
		if (travelled < -100) {
			this.gotoScene(args, this.app);
			return true;
		}
		return false;
	}
}
