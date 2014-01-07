package im_13_8.multecpanel.view.menu;

import im_13_8.multecpanel.Application;

import org.mt4j.components.MTComponent;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.util.math.Vector3D;

import processing.core.PImage;

public class MenuItemView extends MTComponent {

	public MenuItemView(float x, float y, float width, float height,
			Application app, String name, String imgPathName, int indexInArray) {
		super(app);
		
		this.translate(new Vector3D(x,y));
		MTRectangle menuItemView = new MTRectangle(width, height, app);
		
		PImage bgImage = app.loadImage(imgPathName);
		
		menuItemView.setTexture(bgImage);
		menuItemView.setNoStroke(true);
		this.addChild(menuItemView);
		
		MTRectangle transBox = new MTRectangle(0, height / 15 * 11, width, height / 15 * 4, app);
		transBox.setFillColor(app.getTransparantBlack());
		transBox.setNoStroke(true);
		this.addChild(transBox);
		
		MTTextArea textBox = new MTTextArea(app, app.getFontTitle());
		this.addChild(textBox);

		textBox.setNoFill(true);
		textBox.setNoStroke(true);
		textBox.setText(name);
		textBox.setPositionRelativeToParent(new Vector3D(width / 2, height/10 * 8.5f));
		clearAllGestures();
	}
	
	//pijltjes nog toevoegen
	
	private void clearAllGestures() {
		for (MTComponent comp : this.getChildren()) {
			comp.unregisterAllInputProcessors();
			//comp.removeAllChildren();
		}
	}

}
