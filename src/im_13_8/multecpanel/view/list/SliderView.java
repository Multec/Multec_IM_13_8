package im_13_8.multecpanel.view.list;

import java.util.ArrayList;

import org.mt4j.MTApplication;
import org.mt4j.components.MTComponent;
import org.mt4j.components.visibleComponents.shapes.MTEllipse;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.util.math.Vector3D;

public class SliderView extends MTComponent {
	public SliderView(int x, int y, ArrayList<String> clusters,
			MTApplication app) {
		super(app);
		
		float height = 10;
		float width = clusters.size() * 50;
		
		this.translate(new Vector3D(x - width / 2, y));
		
		createCirkel(app, 0, height);
		createCirkel(app, width, height);
		
		MTRectangle mtRectangle = new MTRectangle(0, height / 2, width, height / 10, app);
		this.addChild(mtRectangle);
	}
	
	private void createCirkel(MTApplication app, float x, float height) {
		MTEllipse cirkel = new MTEllipse(app, new Vector3D(x, height / 2), height,  height);
		this.addChild(cirkel);
	}
	

}
