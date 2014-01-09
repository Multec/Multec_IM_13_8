package im_13_8.multecpanel.view.movie;

import org.mt4j.components.visibleComponents.widgets.video.MTMovieClip;
import org.mt4j.util.math.Vertex;

import im_13_8.multecpanel.Application;
import im_13_8.multecpanel.controller.MovieController;
import im_13_8.multecpanel.entiteiten.Movie;
import im_13_8.multecpanel.entiteiten.ParentEntiteit;
import im_13_8.multecpanel.view.util.BackButton;
import im_13_8.multecpanel.view.util.CustomScene;

public class MovieScene extends CustomScene {

	private MovieController controller;
	
	public MovieScene(Application app, String name, ParentEntiteit parent) {
		super(app, name, parent);
		
		controller = new MovieController();
		Movie movie = controller.getMovie(name);
		
		MTMovieClip clip = new MTMovieClip(movie.getPath(), new Vertex(0, 0), app);
		this.getCanvas().addChild(clip);
		this.getCanvas().addChild(new BackButton(app, this));
	}

}
