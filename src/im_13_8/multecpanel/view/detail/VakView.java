package im_13_8.multecpanel.view.detail;

import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.util.math.Vector3D;

import im_13_8.multecpanel.Application;
import im_13_8.multecpanel.controller.VakController;
import im_13_8.multecpanel.entiteiten.DetailInfo;
import im_13_8.multecpanel.entiteiten.ParentEntiteit;
import im_13_8.multecpanel.view.util.BackButton;
import im_13_8.multecpanel.view.util.Background;
import im_13_8.multecpanel.view.util.CustomScene;


/**
 *
 * @author Sam Coenen
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This class is used to display a course.
 *
 */
public class VakView extends CustomScene {
	private DetailInfo vakInfo;

	/**
	 * 
	 * @param app The application.
	 * @param name The name of the course.
	 * @param parent The name of the parent scene.
	 */
	public VakView(Application app, String name, ParentEntiteit parent) {
		super(app, name, parent);
		
		VakController controller = new VakController(name);
		vakInfo = controller.getVakItem();
			
		this.getCanvas().addChild(new Background(vakInfo.getVakImgPath(),
				app));
			 
		MTRectangle blackTrans = new MTRectangle(0, app.height / 15 * 11,
				app.width, app.height / 15 * 4, app);
		blackTrans.setFillColor(app.getTransparantBlack());
		blackTrans.setNoStroke(true);
		blackTrans.removeAllGestureEventListeners();
		this.getCanvas().addChild(blackTrans);
			 
		MTTextArea titel = new MTTextArea(app, app.getFontTitle()); 
		titel.setNoFill(true);
		titel.setNoStroke(true);
		titel.setText(vakInfo.getVakNaam());
		titel.translate(new Vector3D(25, app.height/20 * 15));
		titel.removeAllGestureEventListeners();
		this.getCanvas().addChild(titel);
			 
		MTTextArea omschrijving = new MTTextArea(25, app.height/20 * 17,
				app.width - 50, app.height / 20 * 3,app.getFontText(), app); 
		omschrijving.setNoFill(true);
		omschrijving.setNoStroke(true);
		omschrijving.setText(vakInfo.getVakOmschrijving());
		omschrijving.removeAllGestureEventListeners();
		this.getCanvas().addChild(omschrijving);
		
		BackButton backButton = new BackButton(app, this);
		this.getCanvas().addChild(backButton);
	}

}
