package im_13_8.multecpanel.view.util;

import im_13_8.multecpanel.Application;

import org.mt4j.components.MTComponent;
import org.mt4j.components.visibleComponents.shapes.MTEllipse;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.shapes.MTRectangle.PositionAnchor;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragProcessor;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;

import im_13_8.multecpanel.view.util.ArrowDown;

/**
*
* @author Johan Sergeyssels
* Integration: Multiscreen
* Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
* 
* back button of all the scene
*
*/
public class BackButton extends MTEllipse {
	private IBackButtonObserver obs;
	
	/**
	 * 
	 * @param app the application
	 * @param observer the scene where the button is on
	 */
	public BackButton(Application app, IBackButtonObserver observer) {
		super(app, new Vector3D(app.width / 2, -20), 75, 75);
		this.obs = observer;
		final Arrow arrow = new ArrowDown(app);
		
		setFillColor(app.getTransparantBlack());
		setNoStroke(true);
		
		this.addChild(arrow);
		arrow.setNormal();
		arrow.setPositionRelativeToParent(new Vector3D(app.width / 2 ,25));
		final MTComponent comp = this;
		arrow.addGestureListener(DragProcessor.class, new IGestureEventListener() {
			
			@Override
			public boolean processGestureEvent(MTGestureEvent ge) {
				ge.setTargetComponent(comp);
				comp.processGestureEvent(ge);
				return false;
			}
		});
		
		MTRectangle touchRect = new MTRectangle(0, 0, 300, 150, app);
		touchRect.setFillColor(new MTColor(0, 0, 0, 0));
		touchRect.setStrokeColor(new MTColor(0, 0, 0, 0));
		touchRect.setAnchor(PositionAnchor.UPPER_LEFT);
		touchRect.setPositionRelativeToParent(new Vector3D(app.width / 2 - 150, 0));
		touchRect.removeAllGestureEventListeners();
		touchRect.addGestureListener(DragProcessor.class, new IGestureEventListener() {
			
			@Override
			public boolean processGestureEvent(MTGestureEvent ge) {
				ge.setTargetComponent(comp);
				comp.processGestureEvent(ge);
				return false;
			}
		});
		
		this.addChild(touchRect);
		
		this.removeAllGestureEventListeners();
		this.addGestureListener(DragProcessor.class, new BounceBack(null, new IBounceBackObserver() {
			
			@Override
			public boolean releasedOn(Object args, float travelled, MTComponent component) {
				return false;
			}
			
			@Override
			public boolean hoveredOn(Object args, float travelled, MTComponent target) {
				
				if(travelled > 50) {
					obs.goBack();
					return true;
				}
				return false;
			}
		}, false, true, false));
	}
}
