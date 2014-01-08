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
	private MTRectangle panorama2;
	private MTRectangle comp;
	
	public PanoramaView(Application app, String name, ParentEntiteit parent) {
		super(app, name, parent);
		
		comp = new MTRectangle(0, 0, 0, 0, app);
		this.getCanvas().addChild(comp);
		
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
				
			}

			@Override
			public void listItemDoubleClicked(ListItem item) {
				loadImage(item.getSoort(), application);
			}
		});
		this.getCanvas().addChild(listitemsliderview);
		
		BackButton backButton = new BackButton(app, this);
		this.getCanvas().addChild(backButton);
		
		if(items.size() > 0) {
			loadImage(items.get(0).getSoort(), app);
		}
	}
	
	private void loadImage(String path, Application app) {
		PImage image = app.loadImage(path);
		
		if(this.panorama != null) {
			panorama.destroy();
		}
		if(this.panorama2 != null) {
			panorama2.destroy();
		}
		this.panorama = createPanorama(app, image);
		this.panorama2 = createPanorama(app, image);
		
		panorama.setPositionRelativeToParent(new Vector3D(0, 0, -1));
		panorama2.setPositionRelativeToParent(new Vector3D(-image.width, 0, -1));
		System.out.println(Runtime.getRuntime().totalMemory() + "/" + Runtime.getRuntime().maxMemory());
	}

	private MTRectangle createPanorama(Application app, PImage image) {

		MTRectangle pano = new MTRectangle(0, 0,  image.width, image.height, app);
		pano.removeAllGestureEventListeners();
		pano.setAnchor(PositionAnchor.UPPER_LEFT);
		pano.setNoStroke(true);
		pano.setTexture(image);
		pano.setWidthXYRelativeToParent(image.width);
		pano.setHeightXYRelativeToParent(image.height);
		final float imagewidth = image.width;
		final float appwidth = app.width;
		
		pano.addGestureListener(DragProcessor.class, new IGestureEventListener() {
			
			@Override
			public boolean processGestureEvent(MTGestureEvent ge) {
				DragEvent event = (DragEvent)ge;
				event.getTranslationVect().setY(0);
				comp.translate(event.getTranslationVect());
				float currentx = comp.getPosition(TransformSpace.RELATIVE_TO_PARENT).x;
				if(currentx > imagewidth) {
					comp.setPositionGlobal(new Vector3D(0, 0));
				}
				
				if(currentx < appwidth - imagewidth) {
					comp.setPositionGlobal(new Vector3D(appwidth, 0));
				}
				return false;
			}
		});
		comp.addChild(pano);
		return pano;
	}

}
