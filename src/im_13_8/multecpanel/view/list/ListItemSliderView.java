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

public class ListItemSliderView extends MTComponent {
	private ArrayList<IListItemSliderObserver> observers;
	private ArrayList<ListItem> listitems;
	private ArrayList<ListItemView> listitemViews;
	private float width;
	private float height;
	private MTRectangle touchRect;
	private float distancebetween;
	private Animation gotoAnimation;
	
	public void registerListItemSliderObserver(IListItemSliderObserver observer) {
		observers.add(observer);
	}
	
	public float getHeight() {
		return height;
	}
	
	public ArrayList<ListItem> getListItems() {
		return listitems;
	}
	
	public ListItemSliderView(float x, float y, float width, float height, ArrayList<ListItem> listitems, Application app) {
		this(x, y, width, height, listitems, app, app.width / 2.5f, (width / 2) - (width - (height * 0.8f) / 2));
	}
	
	public ListItemSliderView(float x, float y, float width, float height, ArrayList<ListItem> listitems, Application app, float tilewidth, float dbetween) {
		super(app);
		this.observers = new ArrayList<IListItemSliderObserver>();
		this.listitems = listitems;
		this.listitemViews = new ArrayList<ListItemView>();
		this.width = width;
		this.height = height;
		this.translate(new Vector3D(x, y));
		this.distancebetween = dbetween;
		
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
		
		for (int i = 0; i < listitems.size(); i++) {
			float position = (width / 2) - distancebetween * i;
			
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
	
	public void notifyListItemSelected(ListItem item) {
		for (IListItemSliderObserver observer : observers) {
			observer.listItemSelected(this, item);
		}
	}
	
	public void notifyListItemDoubleClicked(ListItem item) {
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
	
	public void setPosition(int position) {
		if(position >= 0 && position < listitems.size()) {
			ListItemView listitemview = listitemViews.get(position);
			float mid = width / 2;
			float translateX = mid - listitemview.getX();
			gotoX(translateX);
		}
	}
}
