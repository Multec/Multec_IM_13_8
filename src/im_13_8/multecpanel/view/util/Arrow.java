package im_13_8.multecpanel.view.util;

import im_13_8.multecpanel.Application;

import org.mt4j.components.visibleComponents.shapes.MTRectangle;

import processing.core.PImage;

public class Arrow extends MTRectangle {
	protected PImage normal;
	protected PImage bright;
	private boolean isNormal;
	
	public Arrow(float width, float height, String pathNormal, String pathBright, Application app) {
		super(0, 0, width, height, app);
		this.normal = app.loadImage(pathNormal);
		this.bright = app.loadImage(pathBright);
		this.setNoStroke(true);
		this.removeAllGestureEventListeners();
		setNormal();
	}
	
	public boolean isNormal() {
		return this.isNormal;
	}
	
	public void setBright() {
		this.setTexture(bright);
		isNormal = false;
	}
	
	public void setNormal() {
		this.setTexture(normal);
		isNormal = true;
	}
}
