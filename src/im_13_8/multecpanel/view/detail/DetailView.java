package im_13_8.multecpanel.view.detail;

import im_13_8.multecpanel.Application;
import im_13_8.multecpanel.controller.DetailController;
import im_13_8.multecpanel.entiteiten.DetailInfo;

import org.mt4j.MTApplication;
import org.mt4j.components.visibleComponents.font.FontManager;
import org.mt4j.components.visibleComponents.font.IFont;
import org.mt4j.components.visibleComponents.shapes.MTEllipse;
import org.mt4j.components.visibleComponents.shapes.MTLine;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.widgets.MTBackgroundImage;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;
import org.mt4j.util.math.Vertex;

public class DetailView extends AbstractScene {
	
	private DetailController controller;
	private DetailInfo detailInfo;
	
	public DetailView(Application app, String name){
		super(app, name);
		
		controller = new DetailController();
		detailInfo = controller.getDetailInfo();
			
		MTBackgroundImage background = new MTBackgroundImage(app, app.loadImage(detailInfo.getVakImgPath()) , true);
		this.getCanvas().addChild(background);
			 
		MTRectangle blackTrans = new MTRectangle(0, app.height / 15 * 11, app.width, app.height / 15 * 4, app);
		blackTrans.setFillColor(app.getTransparantBlack());
		blackTrans.setNoStroke(true);
		this.getCanvas().addChild(blackTrans);
			 
		MTTextArea titel = new MTTextArea(app, app.getFontTitle()); 
		this.getCanvas().addChild(titel);
		titel.setNoFill(true);
		titel.setNoStroke(true);
		titel.setText(detailInfo.getVakNaam());
		titel.translate(new Vector3D(25, app.height/20 * 15));
			 
		MTTextArea omschrijving = new MTTextArea(app, app.getFontText()); 
		omschrijving.setNoFill(true);
		omschrijving.setNoStroke(true);
		omschrijving.setText(detailInfo.getVakOmschrijving());
		omschrijving.translate(new Vector3D(25, app.height/20 * 17));
		this.getCanvas().addChild(omschrijving);
		
		MTEllipse back = new MTEllipse(app, new Vector3D(860,0), 75, 75);
		back.setFillColor(app.getTransparantBlack());
		back.setNoStroke(true);
		this.getCanvas().addChild(back);
		
		MTLine pijl1 = new MTLine(app, new Vertex(830, 20), new Vertex(860, 50));
		pijl1.setNoFill(true);
		pijl1.setFillColor(app.getTransparantWhite());
		pijl1.setStrokeWeight(3);
		getCanvas().addChild(pijl1);
		
		MTLine pijl2 = new MTLine(app, new Vertex(860, 50), new Vertex(890, 20));
		pijl2.setNoFill(true);
		pijl2.setFillColor(app.getTransparantWhite());
		pijl2.setStrokeWeight(3);
		getCanvas().addChild(pijl2);
	}
		

	public void init() {
	}

	public void shutDown() {
	}
	
}
