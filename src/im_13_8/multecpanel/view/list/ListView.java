package im_13_8.multecpanel.view.list;

import im_13_8.multecpanel.Application;
import im_13_8.multecpanel.controller.ListItemController;
import im_13_8.multecpanel.entiteiten.Cluster;
import im_13_8.multecpanel.entiteiten.ListItem;

import java.util.ArrayList;

import org.mt4j.MTApplication;
import org.mt4j.components.visibleComponents.font.FontManager;
import org.mt4j.components.visibleComponents.font.IFont;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.shapes.MTRectangle.PositionAnchor;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;

import processing.core.PImage;

public class ListView extends AbstractScene {
	private ListItemController controller;
	private ArrayList<Cluster> clusters;
	private ListItemSliderView listitemsliderview;
	private SliderView slider;
	
	public ListView(Application app, String name) {
		super(app, name);
		float imagesY = 313;
		float sliderY = 975;
		controller = new ListItemController();
		ArrayList<ListItem> listitems = controller.getListitems();
		clusters = controller.getClusters();
		
		PImage backgroundimage = app.loadImage("images/background/background_erasmuslogo.png");
		MTRectangle background = new MTRectangle(0, 0, app.width, app.height, app);
		background.setTexture(backgroundimage);
		background.setNoStroke(true);
		background.setNoFill(false);
		background.setAnchor(PositionAnchor.UPPER_LEFT);
		background.setPositionRelativeToParent(new Vector3D(0, 0));
		background.removeAllGestureEventListeners();
		this.getCanvas().addChild(background);
		
		MTColor red = new MTColor(255, 0, 0);
		IFont fontArial = FontManager.getInstance().createFont(app, 
				"MyriadPro-Regular.otf", 
				50, 	//Font size
				red,  //Font fill color
				red
		);	
		MTTextArea textTitle = new MTTextArea(app);
		textTitle.setNoFill(true);
		textTitle.setNoStroke(true);
		textTitle.setFont(fontArial);
		textTitle.setText(name);
		textTitle.setAnchor(PositionAnchor.UPPER_LEFT);
		textTitle.setPositionRelativeToParent(new Vector3D(50, 50));
		this.getCanvas().addChild(textTitle);
		
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
