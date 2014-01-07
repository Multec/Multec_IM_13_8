package im_13_8.multecpanel.view.util;

import im_13_8.multecpanel.Application;

import org.mt4j.components.MTComponent;
import org.mt4j.components.visibleComponents.shapes.MTEllipse;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragProcessor;
import org.mt4j.util.math.Vector3D;

import im_13_8.multecpanel.view.util.ArrowDown;

public class BackButton extends MTEllipse {
	private IBackButtonObserver obs;
	
	public BackButton(Application app, IBackButtonObserver observer) {
		super(app, new Vector3D(app.width / 2, -20), 75, 75);
		this.obs = observer;
		Arrow arrow = new ArrowDown(app);
		
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
		
		this.removeAllGestureEventListeners();
		this.addGestureListener(DragProcessor.class, new BounceBack(null, new IBounceBackObserver() {
			
			@Override
			public boolean releasedOn(Object args, float travelled, MTComponent component) {
				return false;
			}
			
			@Override
			public boolean hoveredOn(Object args, float travelled, MTComponent target) {
				if(travelled > 100) {
					obs.goBack();
					return true;
				}
				return false;
			}
		}, false, true, false));
	}
}
