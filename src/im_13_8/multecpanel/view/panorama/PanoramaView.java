package im_13_8.multecpanel.view.panorama;

import java.util.ArrayList;

import im_13_8.multecpanel.Application;
import im_13_8.multecpanel.controller.PanoramaController;
import im_13_8.multecpanel.entiteiten.ListItem;
import im_13_8.multecpanel.entiteiten.ParentEntiteit;
import im_13_8.multecpanel.view.list.ListItemSliderView;
import im_13_8.multecpanel.view.util.BackButton;
import im_13_8.multecpanel.view.util.CustomScene;

public class PanoramaView extends CustomScene {
	private PanoramaController controller;
	
	public PanoramaView(Application app, String name, ParentEntiteit parent) {
		super(app, name, parent);
		
		controller = new PanoramaController();
		ArrayList<ListItem> items = controller.getListitems();
		
		ListItemSliderView listitemsliderview = new ListItemSliderView(0, 0, app.width, app.height / 10, items, app);
		this.getCanvas().addChild(listitemsliderview);
		
		BackButton backButton = new BackButton(app, this);
		this.getCanvas().addChild(backButton);
	}

}
