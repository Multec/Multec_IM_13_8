package im_13_8.multecpanel.view.util;

import im_13_8.multecpanel.Application;

import org.mt4j.components.visibleComponents.shapes.MTEllipse;
import org.mt4j.util.math.Vector3D;

import im_13_8.multecpanel.view.util.ArrowDown;

public class BackButton extends MTEllipse {

	public BackButton(Application app) {
		super(app, new Vector3D(app.width / 2, -20), 75, 75);
		Arrow arrow = new ArrowDown(app);
		
		setFillColor(app.getTransparantBlack());
		setNoStroke(true);
		
		this.addChild(arrow);
		arrow.setNormal();
		arrow.setPositionRelativeToParent(new Vector3D(app.width / 2 ,25));
	}
	
	

}
