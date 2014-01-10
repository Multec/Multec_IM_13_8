package im_13_8.multecpanel.view.util;

import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.util.math.Vector3D;
import processing.core.PApplet;
import processing.core.PImage;

/**
*
* @author Johan Sergeyssels
* Integration: Multiscreen
* Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
* 
* background for scenes
*
*/
public class Background extends MTRectangle {

	/**
	 * 
	 * @param path path of the backgroundimage
	 * @param app the application
	 */
	public Background(String path, PApplet app) {
		super(0, 0, app.width, app.height, app);
		PImage backgroundimage = app.loadImage(path);
		this.setTexture(backgroundimage);
		this.setNoStroke(true);
		this.setNoFill(false);
		this.setAnchor(PositionAnchor.UPPER_LEFT);
		this.setPositionRelativeToParent(new Vector3D(0, 0));
		this.removeAllGestureEventListeners();
	}

}
