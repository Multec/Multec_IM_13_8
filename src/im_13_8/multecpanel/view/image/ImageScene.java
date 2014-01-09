package im_13_8.multecpanel.view.image;

import org.mt4j.components.visibleComponents.shapes.MTRectangle;

import processing.core.PImage;
import im_13_8.multecpanel.Application;
import im_13_8.multecpanel.controller.ImageController;
import im_13_8.multecpanel.entiteiten.ParentEntiteit;
import im_13_8.multecpanel.entiteiten.Resource;
import im_13_8.multecpanel.view.util.BackButton;
import im_13_8.multecpanel.view.util.CustomScene;

public class ImageScene extends CustomScene {

	private ImageController controller;
	
	public ImageScene(Application app, String name, ParentEntiteit parent) {
		super(app, name, parent);
		
		controller = new ImageController();
		Resource resource = controller.GetImage(name);
		
		PImage image = app.loadImage(resource.getPath());
		MTRectangle rect = new MTRectangle(app.width / 2 - image.width / 2, app.height / 2 - image.height / 2, image.width, image.height, app);
		rect.setNoStroke(true);
		rect.removeAllGestureEventListeners();
		this.getCanvas().addChild(rect);
		
		this.getCanvas().addChild(new BackButton(app, this));
	}

}
