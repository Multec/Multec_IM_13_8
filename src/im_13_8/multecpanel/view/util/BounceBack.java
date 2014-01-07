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

public class BounceBack implements IGestureEventListener {
	private float travelled;
	private IBounceBackObserver observer;
	private String name;
	private boolean moveHorizontal;
	
	public BounceBack(String name, IBounceBackObserver observer) {
		this(name, observer, true);
	}
	
	public BounceBack(String name, IBounceBackObserver observer, boolean moveHorizontal) {
		this.observer = observer;
		this.name = name;
		this.moveHorizontal = moveHorizontal;
	}
	
	@Override
	public boolean processGestureEvent(MTGestureEvent ge) {
		DragEvent dragEvent = (DragEvent)ge;
		MTComponent target = (MTComponent)ge.getTargetComponent();
		if(moveHorizontal) {
			dragEvent.getTranslationVect().setY(0);
		}
		else {
			dragEvent.getTranslationVect().setX(0);
		}
		switch (dragEvent.getId()) {
		case MTGestureEvent.GESTURE_DETECTED:
			if(moveHorizontal) {
				travelled = dragEvent.getTranslationVect().x;
			}
			else {
				travelled = dragEvent.getTranslationVect().y;
			}
			target.translate(dragEvent.getTranslationVect());
			if(observer != null) {
				observer.hoveredOn(name, travelled, target);
			}
			break;
		case MTGestureEvent.GESTURE_UPDATED:
			if(moveHorizontal) {
				travelled += dragEvent.getTranslationVect().x;
			}
			else {
				travelled += dragEvent.getTranslationVect().y;
			}
			target.translate(dragEvent.getTranslationVect());
			if(observer != null) {
				observer.hoveredOn(name, travelled, target);
			}
			break;
		case MTGestureEvent.GESTURE_ENDED:
			if(observer != null) {
				observer.releasedOn(name, travelled, target);
			}
			Animation animation = new Animation("Returns", new MultiPurposeInterpolator(0, -travelled, 500, 0, 1, 1), target);
			animation.addAnimationListener(new IAnimationListener() {	
				@Override
				public void processAnimationEvent(AnimationEvent ae) {
					// TODO Auto-generated method stub
					MTComponent target = (MTComponent)ae.getTargetObject();
					if(moveHorizontal) {
						target.translate(new Vector3D(ae.getCurrentStepDelta(), 0));
					}
					else {
						target.translate(new Vector3D(0, ae.getCurrentStepDelta()));
					}
				}
			});
			animation.start();
			break;
		}
		return false;
	}
}
