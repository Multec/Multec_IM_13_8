package im_13_8.multecpanel.view.movie;

import org.mt4j.components.visibleComponents.widgets.video.MTMovieClip;
import org.mt4j.util.math.Vertex;

import im_13_8.multecpanel.Application;
import im_13_8.multecpanel.entiteiten.ParentEntiteit;
import im_13_8.multecpanel.view.util.CustomScene;

public class MovieScene extends CustomScene {

	public MovieScene(Application app, String name, ParentEntiteit parent) {
		super(app, name, parent);
		MTMovieClip clip = new MTMovieClip("movies/Dirly.mp4", new Vertex(0, 0), app);
		this.getCanvas().addChild(clip);
	}

}
