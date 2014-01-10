package im_13_8.multecpanel;

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
import org.mt4j.util.MTColor;

/**
 *
 * @author Sam Coenen, Johan Sergeyssels
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This class is our start-up class for our whole project. It preloads
 * all the fonts and colors used in our application to speed up all
 * the other scenes. We also created the necessary getters for this.
 * We also created the goToScene function here which it used by the other
 * scenes to be able to navigate between screens.
 *
 */
public class Application extends MTApplication {
	private static final long serialVersionUID = 1338975063241354882L;
	private IFont fontTitle;
	private IFont fontText;
	private MTColor transparantBlack;
	private MTColor digixRed;
	private MTColor white;
	private MTColor transparantWhite;
	private Richting richting;

	/**
	 * Preload all colors and fonts, set the frameRate and open the first scene
	 */
	@Override
	public void startUp() {
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initialize();
	}
	
	/**
	 * @return The font used for titles
	 */
	public IFont getFontTitle() {
		return this.fontTitle;
	}
	
	/**
	 * @return The font used for text
	 */
	public IFont getFontText() {
		return this.fontText;
	}
	
	/**
	 * @return The color transparant black, used for transparant boxes.
	 */
	public MTColor getTransparantBlack() {
		return this.transparantBlack;
	}
	
	/**
	 * @return The color white, used for text.
	 */
	public MTColor getWhite() {
		return this.white;
	}
	
	/**
	 * @return The color transparant white, used for arrows.
	 */
	public MTColor getTransparantWhite() {
		return this.transparantWhite;
	}

	/**
	 * @param richting Set the major.
	 */
	public void setRichting(Richting richting) {
		this.richting = richting;
	}

	/**
	 * @return The major.
	 */
	public Richting getRichting() {
		return this.richting;
	}
	
	/**
	 * @param soortScene Type of scene to navigate to.
	 * @param sceneID The ID of the scene we want to go to.
	 * @param parent The parent of the scene we want to go to (current scene)
	 */
	public void goToScene(String soortScene, String sceneID, 
			ParentEntiteit parent) {
		
		//check which kind of scene we have to open
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
