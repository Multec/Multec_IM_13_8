package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.Movie;

public class MovieController {
	public Movie getMovie(String name) {
		return new Movie("movies/Dirly.mp4");
	}
}
