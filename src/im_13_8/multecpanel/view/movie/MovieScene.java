package im_13_8.multecpanel.view.movie;

import org.mt4j.components.visibleComponents.widgets.video.MTMovieClip;
import org.mt4j.util.math.Vertex;

import im_13_8.multecpanel.Application;
import im_13_8.multecpanel.controller.DocentenController;
import im_13_8.multecpanel.entiteiten.DocentenInfo;
import im_13_8.multecpanel.entiteiten.ParentEntiteit;
import im_13_8.multecpanel.view.util.BackButton;
import im_13_8.multecpanel.view.util.CustomScene;
/**
*
* @author Johan Sergeyssels
* Integration: Multiscreen
* Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
* 
* scene of the movie
*
*/
public class MovieScene extends CustomScene {

	private DocentenController controller;
	
	public MovieScene(Application app, String name, ParentEntiteit parent) {
		super(app, name, parent);
		
		controller = new DocentenController();
		DocentenInfo docent = controller.getDocentInfo(name);
		
		MTMovieClip clip = new MTMovieClip(docent.getDocentMoviePath(), new Vertex(-15, -35), app);
		this.getCanvas().addChild(clip);
		
		this.getCanvas().addChild(new BackButton(app, this));
	}
	
	@Override
	public void goBack() {
		//stop movie
		
		//
		super.goBack();
	}

}
