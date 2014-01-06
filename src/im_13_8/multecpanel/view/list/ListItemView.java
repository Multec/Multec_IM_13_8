package im_13_8.multecpanel.view.list;

import im_13_8.multecpanel.entiteiten.ListItem;

import org.mt4j.components.MTComponent;
import org.mt4j.components.TransformSpace;
import org.mt4j.components.visibleComponents.font.FontManager;
import org.mt4j.components.visibleComponents.font.IFont;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.shapes.MTRectangle.PositionAnchor;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragProcessor;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;

import processing.core.PApplet;
import processing.core.PImage;

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
	
	public ListItemView(float x, float y, float width, float height, ListItem listItem, PApplet app) {
		super(app);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.listItem = listItem;
		this.translate(new Vector3D(x - width / 2, y - height / 2));
		
		MTColor white = new MTColor(255, 255, 255);
		IFont fontArial = FontManager.getInstance().createFont(app, 
				"MyriadPro-Regular.otf", 
				25, 	//Font size
				white,  //Font fill color
				white
				);
		
		final ListItemView liv = this;
		
		tekstfieldlinks = new MTTextArea(app, fontArial);
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
		
		tekstfieldrechts = new MTTextArea(app, fontArial);
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
	}
	
	public void translateX(float x) {
		this.x += x;
		this.translate(new Vector3D(x, 0));
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
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
	
	public ListItem getListItem() {
		return listItem;
	}
}
