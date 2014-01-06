package im_13_8.multecpanel.view.list;

import im_13_8.multecpanel.entiteiten.Cluster;
import im_13_8.multecpanel.entiteiten.ListItem;

import java.util.ArrayList;

import org.mt4j.MTApplication;
import org.mt4j.components.MTComponent;
import org.mt4j.components.visibleComponents.font.FontManager;
import org.mt4j.components.visibleComponents.font.IFont;
import org.mt4j.components.visibleComponents.shapes.MTEllipse;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.shapes.MTRectangle.PositionAnchor;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragProcessor;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;

public class SliderView extends MTComponent {
	private MTRectangle slider;
	private int position;
	private float itemwidth;
	private int count;
	private ArrayList<ISliderViewObserver> observers;
	private float height;
	
	public void registerSliderViewObserver(ISliderViewObserver observer) {
		observers.add(observer);
	}
	
	public SliderView(float x, float y, ArrayList<Cluster> clusters, int length,
			MTApplication app) {
		super(app);
		this.observers = new ArrayList<ISliderViewObserver>();
		height = 10;
		float width = app.width * 0.8f;
		itemwidth = width / length;
		position = 0;
		notifySliderViewChanged(position);
		this.count = length;
		
		this.translate(new Vector3D(x - width / 2, y));
		
		createCirkel(app, 0, height);
		createCirkel(app, width, height);
		
		MTColor white = new MTColor(255, 255, 255);
		IFont fontArial = FontManager.getInstance().createFont(app, 
				"MyriadPro-Regular.otf", 
				25, 	//Font size
				white,  //Font fill color
				white
		);	
		
		float nextY = 0;
		for (Cluster cluster : clusters) {
			nextY += cluster.getAantal() * itemwidth;
			createCirkel(app, nextY, height);
			
			MTTextArea tekstfield = new MTTextArea(app, fontArial);
			tekstfield.setNoStroke(true);
			tekstfield.setNoFill(true);
			tekstfield.setText(cluster.getNaam());
			tekstfield.setAnchor(PositionAnchor.CENTER);
			tekstfield.setPositionRelativeToParent(new Vector3D(nextY - (cluster.getAantal() * itemwidth / 2), height * 4));
			tekstfield.removeAllGestureEventListeners();
			this.addChild(tekstfield);
		}
		
		MTRectangle mtRectangle = new MTRectangle(0, height / 2, width, height / 10, app);
		this.addChild(mtRectangle);
		
		this.slider = new MTRectangle(0, 0, itemwidth, height * 2, app);
		
		this.slider.setAnchor(PositionAnchor.UPPER_LEFT);
		this.slider.setPositionRelativeToParent(new Vector3D(0, - height / 2));
		this.slider.addChild(new MTEllipse(app, new Vector3D(0, height), height, height));
		this.slider.addChild(new MTEllipse(app, new Vector3D(itemwidth, height), height, height));
		MTRectangle touchRect = new MTRectangle(0, 0, itemwidth * 1.5f, height  * 7, app);
		touchRect.setAnchor(PositionAnchor.UPPER_LEFT);
		touchRect.setNoFill(true);
		touchRect.setNoStroke(true);
		touchRect.setPositionRelativeToParent(new Vector3D(- itemwidth * 0.5f, - height * 6));
		this.slider.addChild(touchRect);
		for (MTComponent child : this.slider.getChildren()) {
			child.removeAllGestureEventListeners();
			child.addGestureListener(DragProcessor.class,  new IGestureEventListener() {
				
				@Override
				public boolean processGestureEvent(MTGestureEvent ge) {
					slider.processGestureEvent(ge);
					return false;
				}
			});
		}
		this.addChild(slider);
		this.slider.removeAllGestureEventListeners();
		this.slider.addGestureListener(DragProcessor.class, new IGestureEventListener() {
			private float travelledX;
			@Override
			public boolean processGestureEvent(MTGestureEvent ge) {
				DragEvent dragEvent = (DragEvent)ge;
				dragEvent.getTranslationVect().setY(0);
				switch (dragEvent.getId()) {
				case MTGestureEvent.GESTURE_DETECTED:
					travelledX = dragEvent.getTranslationVect().x;
					break;
				case MTGestureEvent.GESTURE_UPDATED:
					travelledX += dragEvent.getTranslationVect().x;
				case MTGestureEvent.GESTURE_ENDED:
					if(travelledX >= itemwidth && position < count - 1) {
						slider.translate(new Vector3D(itemwidth, 0));
						travelledX = 0;
						position++;
						notifySliderViewChanged(position);
					}
					else if(travelledX <= -itemwidth && position > 0){
						slider.translate(new Vector3D(-itemwidth, 0));
						travelledX = 0;
						position--;
						notifySliderViewChanged(position);
					}
				default:
					break;
				}
				
				return false;
			}
		});
	}
	
	public void setPosition(int position) {
		if(position >= 0 && position < count && position != this.position) {
			slider.setPositionRelativeToParent(new Vector3D(itemwidth * position, - height / 2));
			this.position = position;
		}
	}
	
	public void notifySliderViewChanged(int position) {
		for (ISliderViewObserver observer : observers) {
			observer.sliderViewChanged(position);
		}
	}
	
	private void createCirkel(MTApplication app, float x, float height) {
		MTEllipse cirkel = new MTEllipse(app, new Vector3D(x, height / 2), height,  height);
		this.addChild(cirkel);
	}
	

}
