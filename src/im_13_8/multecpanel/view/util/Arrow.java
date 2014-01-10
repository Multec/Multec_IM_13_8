package im_13_8.multecpanel.view.util;

import im_13_8.multecpanel.Application;

import org.mt4j.components.visibleComponents.shapes.MTRectangle;

import processing.core.PImage;

/**
*
* @author Johan Sergeyssels
* Integration: Multiscreen
* Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
* 
* object that shows arrow
*
*/
public class Arrow extends MTRectangle {
	protected PImage normal;
	protected PImage bright;
	private boolean isNormal;
	
	/**
	 * 
	 * @param width width of the object
	 * @param height height of the object
	 * @param pathNormal path of the arrowimage
	 * @param pathBright path of the arrow-bright-image
	 * @param app the application
	 */
	public Arrow(float width, float height, String pathNormal, String pathBright, Application app) {
		super(0, 0, width, height, app);
		this.normal = app.loadImage(pathNormal);
		this.bright = app.loadImage(pathBright);
		this.setNoStroke(true);
		this.removeAllGestureEventListeners();
		setNormal();
	}
	
	/**
	 * 
	 * @return returns true when the arrow is normal
	 */
	public boolean isNormal() {
		return this.isNormal;
	}
	
	/**
	 * set the arrow bright
	 */
	public void setBright() {
		this.setTexture(bright);
		isNormal = false;
	}
	
	/**
	 * set the arrow normal
	 */
	public void setNormal() {
		this.setTexture(normal);
		isNormal = true;
	}
}
