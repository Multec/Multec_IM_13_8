package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.Resource;

public class MovieController {
	public Resource getMovie(String name) {
		return new Resource("movies/Dirly.mp4");
	}
}
