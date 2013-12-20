package im_13_8.multecpanel.view.menu;

import org.mt4j.components.MTComponent;
import org.mt4j.components.visibleComponents.font.FontManager;
import org.mt4j.components.visibleComponents.font.IFont;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;

import processing.core.PApplet;
import processing.core.PImage;

public class MenuItemView extends MTComponent {
	private MTColor transBlack = new MTColor(0, 0, 0, 200);
	private IFont fontMenu;

	public MenuItemView(float x, float y, float width, float height,
			PApplet mtApplication, String name, String imgPathName, int indexInArray) {
		super(mtApplication);
		
		this.translate(new Vector3D(x,y));
		MTRectangle menuItemView = new MTRectangle(width, height, mtApplication);
		
		fontMenu = FontManager.getInstance().createFont(mtApplication, "MyriadPro-Regular", 60, true);
		// font werkt nog niet!
		
		PImage bgImage = mtApplication.loadImage(imgPathName);
		
		menuItemView.setTexture(bgImage);
		menuItemView.setNoStroke(true);
		this.addChild(menuItemView);
		
		MTRectangle transBox = new MTRectangle(0, height / 15 * 11, width, height / 15 * 4, mtApplication);
		transBox.setFillColor(transBlack);
		transBox.setNoStroke(true);
		this.addChild(transBox);
		
		MTTextArea textBox = new MTTextArea(mtApplication, fontMenu);
		this.addChild(textBox);

		textBox.setNoFill(true);
		textBox.setNoStroke(true);
		textBox.setText(name);
		textBox.setPositionRelativeToParent(new Vector3D(width / 2, height/10 * 8));
		clearAllGestures();
	}
	
	private void clearAllGestures() {
		for (MTComponent comp : this.getChildren()) {
			comp.unregisterAllInputProcessors();
			comp.removeAllChildren();
		}
	}

}
