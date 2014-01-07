package im_13_8.multecpanel.view.menu;

import im_13_8.multecpanel.Application;

import org.mt4j.components.MTComponent;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapProcessor;
import org.mt4j.util.MTColor;
import org.mt4j.util.animation.Animation;
import org.mt4j.util.animation.AnimationEvent;
import org.mt4j.util.animation.IAnimationListener;
import org.mt4j.util.animation.MultiPurposeInterpolator;
import org.mt4j.util.math.Vector3D;

import processing.core.PImage;

public class MenuItemView extends MTComponent {

	private PImage bgImage;
	private PImage bgImageColor;
	private boolean colored;
	private MTRectangle menuItemView;
	private MTRectangle menuItemViewColored;
	private Animation fadeout;
	
	public MenuItemView(float x, float y, float width, float height,
			Application app, String name, String imgPathName, String imgcolor, int indexInArray) {
		super(app);
		
		this.translate(new Vector3D(x,y));
		menuItemView = new MTRectangle(width, height, app);
		bgImage = app.loadImage(imgPathName);
		menuItemView.setTexture(bgImage);
		menuItemView.setNoStroke(true);
		this.addChild(menuItemView);
		
		menuItemViewColored = new MTRectangle(width, height, app);
		bgImageColor = app.loadImage(imgcolor);
		menuItemViewColored.setTexture(bgImageColor);
		menuItemViewColored.setFillColor(new MTColor(255, 255, 255, 0));
		menuItemViewColored.setNoStroke(true);
		this.addChild(menuItemViewColored);
		colored = false;
		
		MTRectangle transBox = new MTRectangle(0, height / 15 * 11, width, height / 15 * 4, app);
		transBox.setFillColor(app.getTransparantBlack());
		transBox.setNoStroke(true);
		this.addChild(transBox);
		
		MTTextArea textBox = new MTTextArea(app, app.getFontTitle());
		this.addChild(textBox);

		textBox.setNoFill(true);
		textBox.setNoStroke(true);
		textBox.setText(name);
		textBox.setPositionRelativeToParent(new Vector3D(width / 2, height/10 * 8.5f));
		
		final MTComponent component = this;
		for (MTComponent comp : this.getChildren()) {
			comp.removeAllGestureEventListeners();
			comp.addGestureListener(DragProcessor.class, new IGestureEventListener() {
				
				@Override
				public boolean processGestureEvent(MTGestureEvent ge) {
					ge.setTargetComponent(component);
					component.processGestureEvent(ge);
					return false;
				}
			});
			comp.registerInputProcessor(new TapProcessor(app));
			comp.addGestureListener(TapProcessor.class, new IGestureEventListener() {
				
				@Override
				public boolean processGestureEvent(MTGestureEvent ge) {
					component.processGestureEvent(ge);
					return false;
				}
			});
		}
	}
	
	public void setColored() {
		menuItemViewColored.setFillColor(new MTColor(255, 255, 255, 255));
		colored = true;
	}
	
	public void setBlackWhite() {
		menuItemViewColored.setFillColor(new MTColor(255, 255, 255, 0));
		colored = false;
		if(fadeout != null) {
			fadeout.stop();
		}
		fadeout = new Animation("Returns", new MultiPurposeInterpolator(255, 0, 2000, 0, 1, 1), menuItemViewColored);
		fadeout.addAnimationListener(new IAnimationListener() {
			
			@Override
			public void processAnimationEvent(AnimationEvent ae) {
				// TODO Auto-generated method stub
				System.out.println(ae.getCurrentStepDelta());
				menuItemViewColored.setFillColor(new MTColor(255, 255, 255, ae.getCurrentValue()));
			}
		});
		fadeout.start();
	}
	
	public boolean isColored() {
		return colored;
	}
	
	//pijltjes nog toevoegen
	
	private void clearAllGestures() {
		for (MTComponent comp : this.getChildren()) {
			comp.unregisterAllInputProcessors();
			//comp.removeAllChildren();
		}
	}

}
