package im_13_8.multecpanel.view.list;

import im_13_8.multecpanel.Application;
import im_13_8.multecpanel.controller.ListItemController;
import im_13_8.multecpanel.entiteiten.Cluster;
import im_13_8.multecpanel.entiteiten.ListItem;
import im_13_8.multecpanel.entiteiten.ParentEntiteit;
import im_13_8.multecpanel.view.util.BackButton;
import im_13_8.multecpanel.view.util.Background;
import im_13_8.multecpanel.view.util.CustomScene;
import im_13_8.multecpanel.view.util.CustomTransition;
import im_13_8.multecpanel.view.util.IBackButtonObserver;

import java.util.ArrayList;

import org.mt4j.components.visibleComponents.shapes.MTRectangle.PositionAnchor;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.math.Vector3D;

public class ListView extends CustomScene {
	private ListItemController controller;
	private ArrayList<Cluster> clusters;
	private ListItemSliderView listitemsliderview;
	private SliderView slider;
	
	public ListView(final Application app, String name, final ParentEntiteit parent) {
		super(app, name, parent);
		float imagesY = 313;
		float sliderY = 975;
		controller = new ListItemController();
		ArrayList<ListItem> listitems = controller.getListitems();
		clusters = controller.getClusters();
		
		this.getCanvas().addChild(new Background("images/background/background_erasmuslogo.png", app));
		
		MTTextArea textTitle = new MTTextArea(app, app.getFontTitle());
		textTitle.setNoFill(true);
		textTitle.setNoStroke(true);
		textTitle.setText(name);
		textTitle.setAnchor(PositionAnchor.UPPER_LEFT);
		textTitle.setPositionRelativeToParent(new Vector3D(50, 50));
		textTitle.removeAllGestureEventListeners();
		this.getCanvas().addChild(textTitle);
		
		listitemsliderview = new ListItemSliderView(0, imagesY, app.width, app.height / 2.5f, listitems, app);
		listitemsliderview.registerListItemSliderObserver(new IListItemSliderObserver() {
			
			@Override
			public void listItemSelected(ListItemSliderView view, ListItem item) {
				int position = listitemsliderview.getListItems().indexOf(item);
				slider.setPosition(position);
			}

			@Override
			public void listItemDoubleClicked(ListItem item) {
				System.out.println(item.getTekstlinks());
				ParentEntiteit newParent = new ParentEntiteit("list","vakken");
				newParent.setParent(parent);
				transition.setDirection("up");
				goToScene("vak", item.getTekstlinks(), newParent);
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
		
		BackButton backButton = new BackButton(app, this);
		this.getCanvas().addChild(backButton);
	}
}
