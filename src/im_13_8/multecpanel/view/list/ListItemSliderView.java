package im_13_8.multecpanel.view.list;

import im_13_8.multecpanel.Application;
import im_13_8.multecpanel.entiteiten.ListItem;

import java.util.ArrayList;

import org.mt4j.components.MTComponent;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.shapes.MTRectangle.PositionAnchor;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapProcessor;
import org.mt4j.util.MTColor;
import org.mt4j.util.animation.Animation;
import org.mt4j.util.animation.AnimationEvent;
import org.mt4j.util.animation.IAnimationListener;
import org.mt4j.util.animation.MultiPurposeInterpolator;
import org.mt4j.util.math.Vector3D;

/**
*
* @author Johan Sergeyssels
* Integration: Multiscreen
* Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
* 
* slider that shows listitemviews
*
*/
public class ListItemSliderView extends MTComponent {
	private ArrayList<IListItemSliderObserver> observers;
	private ArrayList<ListItem> listitems;
	private ArrayList<ListItemView> listitemViews;
	private float width;
	private float height;
	private MTRectangle touchRect;
	private float distancebetween;
	private Animation gotoAnimation;
	private Application app;
	private float tilewidth;
	private int loaded;
	private int amountToLoad;
	
	/**
	 * registering the observer for this object
	 * @param observer the observer that needs to be registered
	 */
	public void registerListItemSliderObserver(IListItemSliderObserver observer) {
		observers.add(observer);
	}
	
	/**
	 * 
	 * @return height of this component
	 */
	public float getHeight() {
		return height;
	}
	
	/**
	 * 
	 * @return the listitems being displayed
	 */
	public ArrayList<ListItem> getListItems() {
		return listitems;
	}
	
	/**
	 * 
	 * 
	 * @param x x-position
	 * @param y y-position
	 * @param width width
	 * @param height height
	 * @param listitems listitems that needs to be displayed
	 * @param app the application
	 */
	public ListItemSliderView(float x, float y, float width, float height, ArrayList<ListItem> listitems, Application app) {
		this(x, y, width, height, listitems, app, app.width / 2.5f, (width / 2) - (width - (height * 0.8f) / 2));
	}
	
	/**
	 * 
	 * @param x x-cošrdinate
	 * @param y y-cošrdinate
	 * @param width width
	 * @param height height
	 * @param listitems listitems that needs to be displayed
	 * @param app the application
	 * @param tilewidth the width of a tile
	 * @param dbetween the width between tiles (between the x-cošrds)
	 */
	public ListItemSliderView(float x, float y, float width, float height, ArrayList<ListItem> listitems, Application app, float tilewidth, float dbetween) {
		super(app);
		this.observers = new ArrayList<IListItemSliderObserver>();
		this.listitems = listitems;
		this.listitemViews = new ArrayList<ListItemView>();
		this.width = width;
		this.height = height;
		this.translate(new Vector3D(x, y));
		this.distancebetween = dbetween;
		this.app = app;
		this.tilewidth = tilewidth;
		
		touchRect = new MTRectangle(0, 0, width, height, app);
		touchRect.setFillColor(new MTColor(0, 0, 0, 0));
		touchRect.setStrokeColor(new MTColor(0, 0, 0, 0));
		touchRect.setAnchor(PositionAnchor.UPPER_LEFT);
		touchRect.setPositionRelativeToParent(new Vector3D(0, 0));
		touchRect.removeAllGestureEventListeners();
		touchRect.addGestureListener(DragProcessor.class, new IGestureEventListener() {
			private float travelledX;
			@Override
			public boolean processGestureEvent(MTGestureEvent ge) {
				DragEvent dragEvent = (DragEvent)ge;
				switch (dragEvent.getId()) {
				case MTGestureEvent.GESTURE_DETECTED:
					travelledX = dragEvent.getTranslationVect().x;
					moveListItemsViews(dragEvent.getTranslationVect().x);
					break;
				case MTGestureEvent.GESTURE_UPDATED:
					travelledX += dragEvent.getTranslationVect().x;
					moveListItemsViews(dragEvent.getTranslationVect().x);
					break;
				case MTGestureEvent.GESTURE_ENDED:
					float travelXfurther = 0;
					if(travelledX < -10) {
						travelXfurther = distancebetween / 2;
					}
					else if(travelledX > 10){
						travelXfurther = distancebetween / -2;
					}
					Animation animation = new Animation("gotoclosest", new MultiPurposeInterpolator(0, travelXfurther, 500, 0, 1, 1), this);
					animation.addAnimationListener(new IAnimationListener() {
						@Override
						public void processAnimationEvent(AnimationEvent ae) {
							switch (ae.getId()) {
							case AnimationEvent.ANIMATION_STARTED:
							case AnimationEvent.ANIMATION_UPDATED:
								moveListItemsViews(ae.getCurrentStepDelta());
								break;
							case AnimationEvent.ANIMATION_ENDED:
								moveListItemsViews(ae.getCurrentStepDelta());
								int loadamount = (int) (travelledX / distancebetween) + 1;
								loadmore(loadamount);
								gotoClosestListItem();
								break;
							default:
								break;
							}
						}
					});
					animation.start();
					break;
				default:
					break;
				}
				return false;
			}
		});
		this.addChild(touchRect);
		
		amountToLoad = listitems.size();
		for (int i = 0; i < amountToLoad && i < 7; i++) {
			addListItemView(i);
			loaded = i;
		}
	}

	private void loadmore(int amount) {
		if(amountToLoad > loaded) {
			int end = loaded + amount + 1;
			for(int i = loaded + 1; i < end && i < amountToLoad; i++) {
				addListItemView(i);
				loaded = i;
			}
		}
	}
	
	private void addListItemView(int i) {
		float position = (width / 2); // - distancebetween * i;
		if(i > 0) {
			position = listitemViews.get(listitemViews.size() - 1).getX() - distancebetween;
		}
		
		ListItemView liv = new ListItemView(position , height / 2, tilewidth, height, listitems.get(i), app);
		liv.addGestureListener(DragProcessor.class, new IGestureEventListener() {
			
			@Override
			public boolean processGestureEvent(MTGestureEvent ge) {
				touchRect.processGestureEvent(ge);
				return false;
			}
		});
		
		final ListItem listitem = liv.getListItem();
		liv.addGestureListener(TapProcessor.class, new IGestureEventListener() {
			
			@Override
			public boolean processGestureEvent(MTGestureEvent ge) {
				notifyListItemDoubleClicked(listitem);
				return false;
			}
		});
		listitemViews.add(liv);
		checkPosition(listitemViews.get(i));
		this.addChild(listitemViews.get(i));
	}
	
	private void gotoClosestListItem() {
		if(listitemViews.size() > 0){
			float mid = width / 2;
			ListItemView closest = listitemViews.get(0);
			float d = Math.abs(mid - closest.getX());
			
			for (int i = 1; i < listitemViews.size(); i++) {
				float di = Math.abs(mid - listitemViews.get(i).getX());
				if(di < d) {
					closest = listitemViews.get(i);
					d = di;
				}
			}
			
			float translateX = mid - closest.getX();
			gotoX(translateX);
		}
	}
	
	private void gotoX(float x) {
		if(gotoAnimation != null) {
			gotoAnimation.stop();
		}
		gotoAnimation = new Animation("goto", new MultiPurposeInterpolator(0, x, 300, 0, 1, 1), this);
		gotoAnimation.addAnimationListener(new IAnimationListener() {
			@Override
			public void processAnimationEvent(AnimationEvent ae) {
				switch (ae.getId()) {
				case AnimationEvent.ANIMATION_STARTED:
				case AnimationEvent.ANIMATION_UPDATED:
				case AnimationEvent.ANIMATION_ENDED:
					moveListItemsViews(ae.getCurrentStepDelta());
					break;
				default:
					break;
				}
			}
		});
		gotoAnimation.start();
	}
	
	private void checkPosition(ListItemView listItemView) {
		float mid = this.width / 2;
		if(Math.round(listItemView.getX()) == Math.round(mid)) {
			listItemView.setBig();
			notifyListItemSelected(listItemView.getListItem());
		}
		else {
			listItemView.setSmall();
		}
	}
	
	private void notifyListItemSelected(ListItem item) {
		for (IListItemSliderObserver observer : observers) {
			observer.listItemSelected(this, item);
		}
	}
	
	private void notifyListItemDoubleClicked(ListItem item) {
		for (IListItemSliderObserver observer : observers) {
			observer.listItemDoubleClicked(item);
		}
	}

	private void moveListItemsViews(float x) {
		for (ListItemView listItemView : listitemViews) {
			listItemView.translateX(x);
			checkPosition(listItemView);
		}
	}
	
	/**
	 * 
	 * @param position select the item with index position
	 */
	public void setPosition(int position) {
		if(position >= 0 && position < amountToLoad) {
			loadmore(1);
			ListItemView listitemview = listitemViews.get(position);
			float mid = width / 2;
			float translateX = mid - listitemview.getX();
			gotoX(translateX);
		}
	}
}
