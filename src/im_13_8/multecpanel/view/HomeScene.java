package im_13_8.multecpanel.view;

import java.util.ArrayList;

import im_13_8.multecpanel.Application;
import im_13_8.multecpanel.controller.HomeController;
import im_13_8.multecpanel.entiteiten.Richting;
import im_13_8.multecpanel.view.util.ArrowLeft;
import im_13_8.multecpanel.view.util.ArrowRight;
import im_13_8.multecpanel.view.util.Background;

import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.shapes.MTRectangle.PositionAnchor;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragProcessor;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.animation.Animation;
import org.mt4j.util.animation.AnimationEvent;
import org.mt4j.util.animation.IAnimationListener;
import org.mt4j.util.animation.MultiPurposeInterpolator;
import org.mt4j.util.math.Vector3D;

import processing.core.PImage;

public class HomeScene extends AbstractScene {
	private HomeController controller;
	private ArrayList<ArrowRight> arrowsRight;
	private ArrayList<ArrowLeft> arrowsLeft;

	public HomeScene(Application app, String name) {
		super(app, name);
		controller = new HomeController();
		ArrayList<Richting> richtingen = controller.getRichtingen();
		
		this.getCanvas().addChild(new Background("images/background/homeScherm.jpg", app));
		
		float transboxheight = 292;
		MTRectangle transBox = new MTRectangle(0, app.height / 2 - transboxheight / 2, app.width, transboxheight, app);
		transBox.setFillColor(app.getTransparantBlack());
		transBox.setNoStroke(true);
		transBox.removeAllGestureEventListeners();
		this.getCanvas().addChild(transBox);
		
		//multec logo
		float multecWidth = 469;
		float multecHeight = 146;
		MTRectangle multecLogo = new MTRectangle(0, 0,  multecWidth, multecHeight, app);
		PImage multecImage = app.loadImage("images/logos/multec.png");
		multecLogo.setTexture(multecImage);
		multecLogo.setNoStroke(true);
		multecLogo.removeAllGestureEventListeners();
		multecLogo.setAnchor(PositionAnchor.UPPER_LEFT);
		multecLogo.setPositionRelativeToParent(new Vector3D(0, app.height / 2 - multecHeight / 2));
		transBox.addChild(multecLogo);
		multecLogo.addGestureListener(DragProcessor.class, new IGestureEventListener() {
			
			@Override
			public boolean processGestureEvent(MTGestureEvent ge) {
				DragEvent dragEvent = (DragEvent)ge;
				switch (dragEvent.getId()) {
				case MTGestureEvent.GESTURE_DETECTED:
					break;
				case MTGestureEvent.GESTURE_UPDATED:
					break;
				case MTGestureEvent.GESTURE_ENDED:
					break;
				}
				return false;
			}
		});
		
		//ehb logo
		float ehbWidth = 377;
		float ehbHeight = 290;
		MTRectangle ehbLogo = new MTRectangle(0, 0,  ehbWidth, ehbHeight, app);
		PImage ehbImage = app.loadImage("images/logos/ehblogo.png");
		ehbLogo.setTexture(ehbImage);
		ehbLogo.setNoStroke(true);
		ehbLogo.removeAllGestureEventListeners();
		ehbLogo.setAnchor(PositionAnchor.UPPER_LEFT);
		ehbLogo.setPositionRelativeToParent(new Vector3D(app.width / 2 - ehbWidth / 2, app.height / 2 - ehbHeight / 2));
		transBox.addChild(ehbLogo);
		
		//digx logo
		float digxWidth = 378;
		float digxHeight = 204;
		MTRectangle digxLogo = new MTRectangle(0, 0,  digxWidth, digxHeight, app);
		PImage digxImage = app.loadImage("images/logos/digx.png");
		digxLogo.setTexture(digxImage);
		digxLogo.setNoStroke(true);
		digxLogo.removeAllGestureEventListeners();
		digxLogo.setAnchor(PositionAnchor.UPPER_LEFT);
		digxLogo.setPositionRelativeToParent(new Vector3D(app.width - digxWidth, app.height / 2 - digxHeight / 2));
		transBox.addChild(digxLogo);
		digxLogo.addGestureListener(DragProcessor.class, new IGestureEventListener() {
			
			@Override
			public boolean processGestureEvent(MTGestureEvent ge) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		
		arrowsRight = new ArrayList<ArrowRight>();
		float firstArrowRightX = 494; //609 - 494 = 115
		float intervalRight = 115;
		for (int i = 0; i < 3; i++) {
			ArrowRight toTheRight = new ArrowRight(app);
			toTheRight.setAnchor(PositionAnchor.CENTER);
			toTheRight.setPositionRelativeToParent(new Vector3D(firstArrowRightX + i * intervalRight, app.height / 2));
			this.getCanvas().addChild(toTheRight);
			arrowsRight.add(toTheRight);
		}
		
		arrowsLeft = new ArrayList<ArrowLeft>();
		float firstArrowLeftX = 1242;
		float intervalLeft = 115;
		for (int i = 0; i < 3; i++) {
			ArrowLeft toTheLeft = new ArrowLeft(app);
			toTheLeft.setAnchor(PositionAnchor.CENTER);
			toTheLeft.setPositionRelativeToParent(new Vector3D(firstArrowLeftX + i * intervalLeft, app.height / 2));
			this.getCanvas().addChild(toTheLeft);
			arrowsLeft.add(toTheLeft);
		}
		
		Animation arrowsBlinking = new Animation("arrowsBlinking", new MultiPurposeInterpolator(0, 2, 2000, 0, 0, -1), this);
		arrowsBlinking.addAnimationListener(new IAnimationListener() {
			@Override
			public void processAnimationEvent(AnimationEvent ae) {
				int value = Math.round(ae.getCurrentValue());
				
				for (int i = 0; i < 3; i++) {
					arrowsRight.get(i).setNormal();
					arrowsLeft.get(i).setNormal();
				}
				
				arrowsRight.get(value).setBright();
				arrowsLeft.get(2 - value).setBright();
			}
		});
		arrowsBlinking.start();
	}

	@Override
	public void init() {
	}

	@Override
	public void shutDown() {
		
	}

}
