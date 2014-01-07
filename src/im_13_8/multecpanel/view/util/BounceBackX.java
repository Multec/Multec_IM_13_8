package im_13_8.multecpanel.view.util;

import org.mt4j.components.MTComponent;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragEvent;
import org.mt4j.util.animation.Animation;
import org.mt4j.util.animation.AnimationEvent;
import org.mt4j.util.animation.IAnimationListener;
import org.mt4j.util.animation.MultiPurposeInterpolator;
import org.mt4j.util.math.Vector3D;

public class BounceBackX implements IGestureEventListener {
	private float travelledX;
	private IBounceBackObserver observer;
	private String name;
	
	public BounceBackX(String name, IBounceBackObserver observer) {
		this.observer = observer;
		this.name = name;
	}
	
	@Override
	public boolean processGestureEvent(MTGestureEvent ge) {
		DragEvent dragEvent = (DragEvent)ge;
		MTComponent target = (MTComponent)ge.getTargetComponent();
		dragEvent.getTranslationVect().setY(0);
		switch (dragEvent.getId()) {
		case MTGestureEvent.GESTURE_DETECTED:
			travelledX = dragEvent.getTranslationVect().x;
			target.translate(dragEvent.getTranslationVect());
			if(observer != null) {
				observer.hoveredOn(name, travelledX, target);
			}
			break;
		case MTGestureEvent.GESTURE_UPDATED:
			travelledX += dragEvent.getTranslationVect().x;
			target.translate(dragEvent.getTranslationVect());
			if(observer != null) {
				observer.hoveredOn(name, travelledX, target);
			}
			break;
		case MTGestureEvent.GESTURE_ENDED:
			if(observer != null) {
				observer.releasedOn(name, travelledX, target);
			}
			Animation animation = new Animation("Returns", new MultiPurposeInterpolator(0, -travelledX, 500, 0, 1, 1), target);
			animation.addAnimationListener(new IAnimationListener() {	
				@Override
				public void processAnimationEvent(AnimationEvent ae) {
					// TODO Auto-generated method stub
					MTComponent target = (MTComponent)ae.getTargetObject();
					target.translate(new Vector3D(ae.getCurrentStepDelta(), 0));
				}
			});
			animation.start();
			break;
		}
		return false;
	}
}
