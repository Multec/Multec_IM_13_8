package im_13_8.multecpanel.view.list;

import im_13_8.multecpanel.Application;
import im_13_8.multecpanel.entiteiten.ListItem;

import org.mt4j.components.MTComponent;
import org.mt4j.components.TransformSpace;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.shapes.MTRectangle.PositionAnchor;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapEvent;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapProcessor;
import org.mt4j.util.math.Vector3D;

import processing.core.PImage;

/**
*
* @author Johan Sergeyssels
* Integration: Multiscreen
* Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
* 
* object that shows a lisitem
*
*/
public class ListItemView extends MTComponent {
	private ListItem listItem;
	private float width;
	private float height;
	private MTTextArea tekstfieldlinks;
	private MTTextArea tekstfieldrechts;
	private float smallratio = 0.8f;
	private MTRectangle imageRect;
	private float x;
	private float y;
	private boolean isBig;
	
	/**
	 * 
	 * @param x x-cošrdinate
	 * @param y y-cošrdinate
	 * @param width width of the object
	 * @param height height of the object
	 * @param listItem listitem that is getting displayed
	 * @param app the application
	 */
	public ListItemView(float x, float y, float width, float height, ListItem listItem, Application app) {
		super(app);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.listItem = listItem;
		this.translate(new Vector3D(x - width / 2, y - height / 2));
		
		final ListItemView liv = this;
		
		tekstfieldlinks = new MTTextArea(app, app.getFontText());
		tekstfieldlinks.setNoStroke(true);
		tekstfieldlinks.setNoFill(true);
		tekstfieldlinks.setText(listItem.getTekstlinks());
		tekstfieldlinks.setAnchor(PositionAnchor.UPPER_LEFT);
		tekstfieldlinks.removeAllGestureEventListeners();
		tekstfieldlinks.addGestureListener(DragProcessor.class, new IGestureEventListener() {
			
			@Override
			public boolean processGestureEvent(MTGestureEvent ge) {
				liv.processGestureEvent(ge);
				return false;
			}
		});
		this.addChild(tekstfieldlinks);
		
		tekstfieldrechts = new MTTextArea(app, app.getFontText());
		tekstfieldrechts.setNoStroke(true);
		tekstfieldrechts.setNoFill(true);
		tekstfieldrechts.setText(listItem.getTekstRechts());
		tekstfieldrechts.setAnchor(PositionAnchor.UPPER_LEFT);
		tekstfieldrechts.removeAllGestureEventListeners();
		tekstfieldrechts.addGestureListener(DragProcessor.class, new IGestureEventListener() {
			
			@Override
			public boolean processGestureEvent(MTGestureEvent ge) {
				liv.processGestureEvent(ge);
				return false;
			}
		});
		this.addChild(tekstfieldrechts);
		
		imageRect = new MTRectangle(0, 0, width, height, app);
		PImage bgImage = app.loadImage(listItem.getAfbeelingpath());
		imageRect.setTexture(bgImage);
		imageRect.setNoFill(false);
		imageRect.setNoStroke(true);
		imageRect.setAnchor(PositionAnchor.UPPER_LEFT);
		imageRect.removeAllGestureEventListeners();
		imageRect.addGestureListener(DragProcessor.class, new IGestureEventListener() {
			
			@Override
			public boolean processGestureEvent(MTGestureEvent ge) {
				liv.processGestureEvent(ge);
				return false;
			}
		});
		this.addChild(imageRect);
		
		this.isBig = true;
		setSmall();
		
		final ListItemView view = this;
		for (MTComponent comp : this.getChildren()) {
			comp.registerInputProcessor(new TapProcessor(app, 25, true, 350));
			comp.addGestureListener(TapProcessor.class, new IGestureEventListener() {
				
				@Override
				public boolean processGestureEvent(MTGestureEvent ge) {
					TapEvent te = (TapEvent)ge;
					if (te.isDoubleTap()){
						view.processGestureEvent(ge);
					}
					return false;
				}
			});
		}
	}
	
	/**
	 * 
	 * @param x value this object getting translated over the x-axis
	 */
	public void translateX(float x) {
		this.x += x;
		this.translate(new Vector3D(x, 0));
	}
	
	/**
	 * 
	 * @return the x-cošrdinate
	 */
	public float getX() {
		return this.x;
	}
	
	/**
	 * 
	 * @return the y-cošrdinate
	 */
	public float getY() {
		return this.y;
	}
	
	/**
	 *  reduces this object
	 */
	public void setSmall() {
		if(this.isBig) {
			float side = (1 - smallratio) / 2;
			imageRect.scale(smallratio,  smallratio, smallratio, new Vector3D(width / 2, height / 2));
			imageRect.setPositionRelativeToParent(new Vector3D(width * side, height * side));
			tekstfieldlinks.setPositionRelativeToParent(new Vector3D(width * side, height * (1 - side)));
			tekstfieldrechts.setPositionRelativeToParent(new Vector3D((width - tekstfieldrechts.getWidthXY(TransformSpace.RELATIVE_TO_PARENT)) * (1 - side), height * (1 - side)));
			this.isBig = false;
		}
	}
	
	/**
	 * enlarges this object
	 */
	public void setBig() {
		if(!this.isBig) {
			float bigratio = 1 / smallratio;
			imageRect.scale(bigratio,  bigratio, bigratio, new Vector3D(width / 2, height / 2));
			imageRect.setPositionRelativeToParent(new Vector3D(0, 0));
			tekstfieldlinks.setPositionRelativeToParent(new Vector3D(0, height));
			tekstfieldrechts.setPositionRelativeToParent(new Vector3D(width - tekstfieldrechts.getWidthXY(TransformSpace.RELATIVE_TO_PARENT), height));
			this.isBig = true;
		}
	}
	
	/**
	 * 
	 * @return listitem that is being displayed
	 */
	public ListItem getListItem() {
		return listItem;
	}
}
