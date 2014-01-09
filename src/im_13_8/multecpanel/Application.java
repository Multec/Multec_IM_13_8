package im_13_8.multecpanel;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import im_13_8.multecpanel.entiteiten.Richting;
import im_13_8.multecpanel.entiteiten.ParentEntiteit;
import im_13_8.multecpanel.view.HomeScene;
import im_13_8.multecpanel.view.detail.DetailView;
import im_13_8.multecpanel.view.detail.VakView;
import im_13_8.multecpanel.view.image.ImageScene;
import im_13_8.multecpanel.view.list.ListView;
import im_13_8.multecpanel.view.menu.Menu;
import im_13_8.multecpanel.view.movie.MovieScene;
import im_13_8.multecpanel.view.panorama.PanoramaView;

import org.mt4j.MTApplication;
import org.mt4j.components.visibleComponents.font.FontManager;
import org.mt4j.components.visibleComponents.font.IFont;
import org.mt4j.sceneManagement.Iscene;
import org.mt4j.util.MTColor;

public class Application extends MTApplication {
	private static final long serialVersionUID = 1338975063241354882L;
	private IFont fontTitle;
	private IFont fontText;
	private MTColor transparantBlack;
	private MTColor digixRed;
	private MTColor white;
	private MTColor transparantWhite;
	private Richting richting;

	@Override
	public void startUp() {
		
		/**
		 * Preload all colors and fonts
		 */
		transparantBlack = new MTColor(0, 0, 0, 200);
		digixRed = new MTColor(239,71,64);
		white = new MTColor(255, 255, 255);
		transparantWhite = new MTColor(255,255,255, 150);
		fontTitle = FontManager.getInstance().createFont(this,
				"MyriadPro-Light.svg", 
				87, 	//Font size
				digixRed, //Fill Color
				digixRed // Stroke Color
		);
		
		fontText = FontManager.getInstance().createFont(this, 
				"MyriadPro-Light.svg", 
				30, 	//Font size
				white,  //Font fill color
				white   //Font stroke color
		);
		
		
		this.frameRate(60);
		this.addScene(new HomeScene(this, "Kies een richting"));
	}

	public static void main(String[] args) {
		initialize();
	}
	
	public IFont getFontTitle() {
		return this.fontTitle;
	}
	
	public IFont getFontText() {
		return this.fontText;
	}
	
	public MTColor getTransparantBlack() {
		return this.transparantBlack;
	}
	
	public MTColor getWhite() {
		return this.white;
	}
	
	public MTColor getTransparantWhite() {
		return this.transparantWhite;
	}

	public void setRichting(Richting richting) {
		this.richting = richting;
	}

	public Richting getRichting() {
		return this.richting;
	}
	
	public void goToScene(String soortScene, String sceneID, ParentEntiteit parent) {
		System.out.println(this.getScenes().length);
		System.out.println(Runtime.getRuntime().totalMemory() + "/" + Runtime.getRuntime().maxMemory());
		
		if (soortScene == "menu") { 
			this.changeScene(new Menu(this, sceneID, parent));
		} else if (soortScene == "detail") {
			this.changeScene(new DetailView(this, sceneID, parent));
		} else if (soortScene == "vak") {
			this.changeScene(new VakView(this, sceneID, parent));
		} else if (soortScene == "list") {
			this.changeScene(new ListView(this, sceneID, parent));
		} else if (soortScene == "home") {
			this.changeScene(new HomeScene(this, sceneID));
		} else if(soortScene == "image") {
			this.changeScene(new ImageScene(this, sceneID, parent));
		} else if(soortScene == "movie") {
			this.changeScene(new MovieScene(this, sceneID, parent));
		} else if(soortScene == "pano"){
			this.changeScene(new PanoramaView(this, sceneID, parent));
		}
	}
}
