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
	private Object args;
	private boolean moveHorizontal;
	private boolean enablePositive;
	private boolean enableNegative;
	private Animation animation;
	
	public BounceBack(Object args, IBounceBackObserver observer) {
		this(args, observer, true);
	}
	
	public BounceBack(Object args, IBounceBackObserver observer, boolean moveHorizontal) {
		this(args, observer, moveHorizontal, true);
	}
	
	public BounceBack(Object args, IBounceBackObserver observer, boolean moveHorizontal, boolean enablePositive) {
		this(args, observer, moveHorizontal, enablePositive, true);
	}
	
	public BounceBack(Object args, IBounceBackObserver observer, boolean moveHorizontal, boolean enablePositive, boolean enableNegative) {
		this.observer = observer;
		this.args = args;
		this.moveHorizontal = moveHorizontal;
		this.enablePositive = enablePositive;
		this.enableNegative = enableNegative;
	}
	
	public void stopAnimation() {
		if(this.animation != null) {
			this.animation.stop();
		}
	}
	
	@Override
	public boolean processGestureEvent(MTGestureEvent ge) {
		boolean canStopAnimation = false;
		boolean canMove = true;
		DragEvent dragEvent = (DragEvent)ge;
		MTComponent target = (MTComponent)ge.getTargetComponent();
		float value = 0;
		if(moveHorizontal) {
			dragEvent.getTranslationVect().setY(0);
			value = dragEvent.getTranslationVect().x;
		}
		else {
			dragEvent.getTranslationVect().setX(0);
			value = dragEvent.getTranslationVect().y;
		}
		if(!this.enablePositive && value > 0) {
			value = 0;
			canMove = false;
		}
		if(!this.enableNegative && value < 0) {
			value = 0;
			canMove = false;
		}
		switch (dragEvent.getId()) {
		case MTGestureEvent.GESTURE_DETECTED:
			travelled = value;
			if(canMove) {
				target.translate(dragEvent.getTranslationVect());
			}
			if(observer != null) {
				if(observer.hoveredOn(args, travelled, target)) {
					canStopAnimation = true;
				}
			}
			break;
		case MTGestureEvent.GESTURE_UPDATED:
			travelled += value;
			if(canMove) {
				target.translate(dragEvent.getTranslationVect());
			}
			if(observer != null) {
				if(observer.hoveredOn(args, travelled, target)) {
					canStopAnimation = true;
				}
			}
			break;
		case MTGestureEvent.GESTURE_ENDED:
			if(observer != null) {
				if(observer.releasedOn(args, travelled, target)){
					canStopAnimation = true;
				}
			}
			//stopAnimation();
			animation = new Animation("Returns", new MultiPurposeInterpolator(0, -travelled, 500, 0, 1, 1), target);
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
		if(canStopAnimation) {
			stopAnimation();
		}
		return false;
	}
}
