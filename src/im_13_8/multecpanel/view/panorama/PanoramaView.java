package im_13_8.multecpanel.view.panorama;

import java.util.ArrayList;

import org.mt4j.components.TransformSpace;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.shapes.MTRectangle.PositionAnchor;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragProcessor;
import org.mt4j.util.math.Vector3D;

import processing.core.PImage;
import im_13_8.multecpanel.Application;
import im_13_8.multecpanel.controller.PanoramaController;
import im_13_8.multecpanel.entiteiten.ListItem;
import im_13_8.multecpanel.entiteiten.ParentEntiteit;
import im_13_8.multecpanel.view.list.IListItemSliderObserver;
import im_13_8.multecpanel.view.list.ListItemSliderView;
import im_13_8.multecpanel.view.util.BackButton;
import im_13_8.multecpanel.view.util.CustomScene;

public class PanoramaView extends CustomScene {
	private PanoramaController controller;
	private MTRectangle panorama;
	
	public PanoramaView(Application app, String name, ParentEntiteit parent) {
		super(app, name, parent);
		
		controller = new PanoramaController();
		ArrayList<ListItem> items = controller.getListitems();
		
		MTRectangle transBox = new MTRectangle(0, app.height / 15 * 11, app.width, app.height / 15 * 4, app);
		transBox.setFillColor(app.getTransparantBlack());
		transBox.setNoStroke(true);
		transBox.removeAllGestureEventListeners();
		this.getCanvas().addChild(transBox);
		
		final Application application = app;
		ListItemSliderView listitemsliderview = new ListItemSliderView(0, app.height / 15 * 11, app.width, 250, items, app, 250, -270);
		listitemsliderview.registerListItemSliderObserver(new IListItemSliderObserver() {
			
			@Override
			public void listItemSelected(ListItemSliderView view, ListItem item) {
				loadImage(item.getSoort(), application);
			}
		});
		this.getCanvas().addChild(listitemsliderview);
		
		BackButton backButton = new BackButton(app, this);
		this.getCanvas().addChild(backButton);
		
	}
	
	private void loadImage(String path, Application app) {
		PImage image = app.loadImage(path);
		
		
		panorama = new MTRectangle(0, 0,  image.width, image.height, app);
		panorama.removeAllGestureEventListeners();
		panorama.setAnchor(PositionAnchor.CENTER);
		panorama.setNoStroke(true);
		panorama.setPositionRelativeToParent(new Vector3D(app.width / 2, app.height / 2, -1));
		panorama.setTexture(image);
		panorama.setWidthXYRelativeToParent(image.width);
		panorama.setHeightXYRelativeToParent(image.height);
		panorama.addGestureListener(DragProcessor.class, new IGestureEventListener() {
			
			@Override
			public boolean processGestureEvent(MTGestureEvent ge) {
				DragEvent event = (DragEvent)ge;
				event.getTranslationVect().setY(0);
				panorama.translate(event.getTranslationVect());
				return false;
			}
		});
		this.getCanvas().addChild(panorama);
	}

}
