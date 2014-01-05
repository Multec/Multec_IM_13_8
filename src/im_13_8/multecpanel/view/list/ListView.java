package im_13_8.multecpanel.view.list;

import im_13_8.multecpanel.controller.ListItemController;
import im_13_8.multecpanel.entiteiten.ListItem;

import java.util.ArrayList;

import org.mt4j.MTApplication;
import org.mt4j.sceneManagement.AbstractScene;

public class ListView extends AbstractScene {
	private ListItemController controller;
	private ArrayList<String> clusters;
	private ListItemSliderView listitemsliderview;
	
	public ListView(MTApplication app, String name) {
		super(app, name);
		controller = new ListItemController();
		ArrayList<ListItem> listitems = controller.getListitems();
		clusters = controller.getClusters();
		
		listitemsliderview = new ListItemSliderView(0, 50, app.width, app.height / 2, listitems, app);
		this.getCanvas().addChild(listitemsliderview);
		
		SliderView slider = new SliderView(app.width / 2, app.height - 200, clusters, app);
		this.getCanvas().addChild(slider);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void shutDown() {
		// TODO Auto-generated method stub

	}

}
