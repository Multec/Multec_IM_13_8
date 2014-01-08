package im_13_8.multecpanel.view.detail;

import im_13_8.multecpanel.Application;
import im_13_8.multecpanel.controller.DetailController;
import im_13_8.multecpanel.entiteiten.DetailInfo;
import im_13_8.multecpanel.entiteiten.ParentEntiteit;
import im_13_8.multecpanel.view.util.BackButton;
import im_13_8.multecpanel.view.util.Background;
import im_13_8.multecpanel.view.util.CustomScene;
import im_13_8.multecpanel.view.util.CustomTransition;
import im_13_8.multecpanel.view.util.IBackButtonObserver;

import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.math.Vector3D;

public class DetailView extends CustomScene {
	
	private DetailController controller;
	private DetailInfo detailInfo;
	
	public DetailView(Application app, String name, ParentEntiteit parent){
		super(app, name, parent);
		
		
		controller = new DetailController();
		detailInfo = controller.getDetailInfo();
			
		this.getCanvas().addChild(new Background(detailInfo.getVakImgPath(), app));
			 
		MTRectangle blackTrans = new MTRectangle(0, app.height / 15 * 11, app.width, app.height / 15 * 4, app);
		blackTrans.setFillColor(app.getTransparantBlack());
		blackTrans.setNoStroke(true);
		blackTrans.removeAllGestureEventListeners();
		this.getCanvas().addChild(blackTrans);
			 
		MTTextArea titel = new MTTextArea(app, app.getFontTitle()); 
		titel.setNoFill(true);
		titel.setNoStroke(true);
		titel.setText(detailInfo.getVakNaam());
		titel.translate(new Vector3D(25, app.height/20 * 15));
		titel.removeAllGestureEventListeners();
		this.getCanvas().addChild(titel);
			 
		MTTextArea omschrijving = new MTTextArea(app, app.getFontText()); 
		omschrijving.setNoFill(true);
		omschrijving.setNoStroke(true);
		omschrijving.setText(detailInfo.getVakOmschrijving());
		omschrijving.translate(new Vector3D(25, app.height/20 * 17));
		omschrijving.removeAllGestureEventListeners();
		this.getCanvas().addChild(omschrijving);
		
		BackButton backButton = new BackButton(app, this);
		this.getCanvas().addChild(backButton);
	}
}
