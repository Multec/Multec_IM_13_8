package im_13_8.multecpanel.view.detail;

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

	private MTColor black = new MTColor(0, 0, 0, 200);
	private MTColor white = new MTColor(255,255,255);
	private MTColor whiteArrow = new MTColor(255,255,255, 150);
	private MTColor transBlack = new MTColor(0, 0, 0, 200);
	private MTColor digixRed = new MTColor(239,71,64);
	
	private DetailController controller;
	private DetailInfo detailInfo;
	
	public DetailView(MTApplication mtApplication, String name){
		super(mtApplication, name);
		
		IFont fontDetailTitle = FontManager.getInstance().createFont(mtApplication,
				"MyriadPro-Regular.otf", 
				87, 	//Font size
				digixRed, //Fill Color
				digixRed // Stroke Color
		);
		//Moet op termijn ingeladen worden op de start van de app
		
		controller = new DetailController();
		detailInfo = controller.getDetailInfo();
			
		MTBackgroundImage background = new MTBackgroundImage(mtApplication, mtApplication.loadImage(detailInfo.getVakImgPath()) , true);
		this.getCanvas().addChild(background);
			
			 
		MTRectangle blackTrans = new MTRectangle(0, mtApplication.height / 15 * 11, mtApplication.width, mtApplication.height / 15 * 4, mtApplication);
		blackTrans.setFillColor(black);
		blackTrans.setNoStroke(true);
		this.getCanvas().addChild(blackTrans);
			 
		IFont fontOmschrijving = FontManager.getInstance().createFont(mtApplication, "arial.ttf", 25, white,  white);
			 
			 
		MTTextArea titel = new MTTextArea(mtApplication, fontDetailTitle); 
		this.getCanvas().addChild(titel);
		titel.setNoFill(true);
		titel.setNoStroke(true);
		titel.setText(detailInfo.getVakNaam());
		titel.translate(new Vector3D(25, mtApplication.height/20 * 15));
			 
		MTTextArea omschrijving = new MTTextArea(mtApplication, fontOmschrijving); 
		omschrijving.setNoFill(true);
		omschrijving.setNoStroke(true);
		omschrijving.setText(detailInfo.getVakOmschrijving());
		omschrijving.translate(new Vector3D(25, mtApplication.height/20 * 17));
		this.getCanvas().addChild(omschrijving);
		
		MTEllipse back = new MTEllipse(mtApplication, new Vector3D(860,0), 75, 75);
		back.setFillColor(black);
		back.setNoStroke(true);
		this.getCanvas().addChild(back);
		
		MTLine pijl1 = new MTLine(mtApplication, new Vertex(830, 20), new Vertex(860, 50));
		pijl1.setNoFill(true);
		pijl1.setFillColor(whiteArrow);
		pijl1.setStrokeWeight(3);
		getCanvas().addChild(pijl1);
		
		MTLine pijl2 = new MTLine(mtApplication, new Vertex(860, 50), new Vertex(890, 20));
		pijl2.setNoFill(true);
		pijl2.setFillColor(whiteArrow);
		pijl2.setStrokeWeight(3);
		getCanvas().addChild(pijl2);
	}
		

	public void init() {
	}

	public void shutDown() {
	}
	
}
