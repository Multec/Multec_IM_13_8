package im_13_8.multecpanel.view;

import java.util.ArrayList;

import im_13_8.multecpanel.Application;
import im_13_8.multecpanel.controller.HomeController;
import im_13_8.multecpanel.entiteiten.Richting;
import im_13_8.multecpanel.entiteiten.ParentEntiteit;
import im_13_8.multecpanel.view.menu.Menu;
import im_13_8.multecpanel.view.util.ArrowLeft;
import im_13_8.multecpanel.view.util.ArrowRight;
import im_13_8.multecpanel.view.util.Background;
import im_13_8.multecpanel.view.util.BounceBack;
import im_13_8.multecpanel.view.util.IBounceBackObserver;

import org.mt4j.components.MTComponent;
import org.mt4j.components.interfaces.IMTComponent;
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

public class HomeScene extends AbstractScene implements IBounceBackObserver{
	private HomeController controller;
	private ArrayList<ArrowRight> arrowsRight;
	private ArrayList<ArrowLeft> arrowsLeft;
	private PImage ehbImage;
	private PImage ehbImageBright;
	private float ehbWidth;
	private MTRectangle ehbLogo;
	private float midX;
	private Application app;
	private ArrayList<Richting> richtingen;

	public HomeScene(Application app, String name) {
		super(app, name);
		this.app = app;
		controller = new HomeController();
		richtingen = controller.getRichtingen();
		
		this.getCanvas().addChild(new Background("images/background/homeScherm.jpg", app));
		
		float transboxheight = 292;
		MTRectangle transBox = new MTRectangle(0, app.height / 2 - transboxheight / 2, app.width, transboxheight, app);
		transBox.setFillColor(app.getTransparantBlack());
		transBox.setNoStroke(true);
		transBox.removeAllGestureEventListeners();
		this.getCanvas().addChild(transBox);
		this.midX = app.width / 2;
		
		//ehb logo
		ehbWidth = 377;
		float ehbHeight = 290;
		ehbLogo = new MTRectangle(0, 0,  ehbWidth, ehbHeight, app);
		ehbImage = app.loadImage("images/logos/ehblogo.png");
		ehbImageBright = app.loadImage("images/logos/ehblogo_bright.png");
		ehbLogo.setTexture(ehbImage);
		ehbLogo.setNoStroke(true);
		ehbLogo.removeAllGestureEventListeners();
		ehbLogo.setAnchor(PositionAnchor.UPPER_LEFT);
		ehbLogo.setPositionRelativeToParent(new Vector3D(midX - ehbWidth / 2, app.height / 2 - ehbHeight / 2));
		transBox.addChild(ehbLogo);
		
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
		
		Animation arrowsBlinking = new Animation("arrowsBlinking", new MultiPurposeInterpolator(0, 2, 2000, 0, 1, -1), this);
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
		final float midX = app.width / 2 - multecWidth;
		multecLogo.addGestureListener(DragProcessor.class, new BounceBack("multec", this));
		
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
		digxLogo.addGestureListener(DragProcessor.class, new BounceBack("digx", this));
	}

	@Override
	public void init() {
	}

	@Override
	public void shutDown() {
		
	}

	@Override
	public boolean releasedOn(Object args, float travelledX, MTComponent component) {
		String name = (String)args;
		if(name == "multec" && travelledX >= midX - ehbWidth && travelledX <= midX) {
			// open multec
			app.setRichting(richtingen.get(0));
			ParentEntiteit parent = new ParentEntiteit("home", "home");
			app.goToScene("menu", "hoofdMenu", parent);
			return true;
		} 
		else if(name == "digx" && travelledX <= -midX + ehbWidth && travelledX >= -midX) {
			// open digx
		}
		ehbLogo.setTexture(ehbImage);
		return false;
	}

	@Override
	public boolean hoveredOn(Object args, float travelledX, MTComponent target) {
		String name = (String)args;
		if(name == "multec" && travelledX >= midX - ehbWidth && travelledX <= midX) {
			ehbLogo.setTexture(ehbImageBright);
		} 
		else if(name == "digx" && travelledX <= -midX + ehbWidth && travelledX >= -midX) {
			ehbLogo.setTexture(ehbImageBright);
		}
		else {
			ehbLogo.setTexture(ehbImage);
		}
		return false;
	}

}
