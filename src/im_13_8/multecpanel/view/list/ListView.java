package im_13_8.multecpanel.view.list;

import im_13_8.multecpanel.controller.ListItemController;
import im_13_8.multecpanel.entiteiten.Cluster;
import im_13_8.multecpanel.entiteiten.ListItem;

import java.util.ArrayList;

import org.mt4j.MTApplication;
import org.mt4j.sceneManagement.AbstractScene;

public class ListView extends AbstractScene {
	private ListItemController controller;
	private ArrayList<Cluster> clusters;
	private ListItemSliderView listitemsliderview;
	private SliderView slider;
	
	public ListView(MTApplication app, String name) {
		super(app, name);
		float imagesY = 313;
		float sliderY = 925;
		controller = new ListItemController();
		ArrayList<ListItem> listitems = controller.getListitems();
		clusters = controller.getClusters();
		
		listitemsliderview = new ListItemSliderView(0, imagesY, app.width, app.height / 2.5f, listitems, app);
		listitemsliderview.registerListItemSliderObserver(new IListItemSliderObserver() {
			
			@Override
			public void listItemSelected(ListItemSliderView view, ListItem item) {
				int position = listitemsliderview.getListItems().indexOf(item);
				slider.setPosition(position);
			}
		});
		
		this.getCanvas().addChild(listitemsliderview);
		
		slider = new SliderView(app.width / 2, sliderY, clusters, listitems.size(), app);
		slider.registerSliderViewObserver(new ISliderViewObserver() {
			
			@Override
			public void sliderViewChanged(int position) {
				listitemsliderview.setPosition(position);
			}
		});
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
