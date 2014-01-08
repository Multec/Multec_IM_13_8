package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.ListItem;

import java.util.ArrayList;

public class PanoramaController {
	public ArrayList<ListItem> getListitems() {
		ArrayList<ListItem> items = new ArrayList<ListItem>();
		items.add(new ListItem("images/locaties_thumbnails/classRoom.jpg", "B103", "B", "afbeelding", "testen"));
		items.add(new ListItem("images/locaties_thumbnails/edited_pano_fablab.jpg", "fablab", "B", "afbeelding", "testen"));
		items.add(new ListItem("images/locaties_thumbnails/inkom.jpg", "inkom", "A", "afbeelding", "testen"));
		items.add(new ListItem("images/locaties_thumbnails/Panorama-parking.jpg", "parking", "buiten", "afbeelding", "testen"));
		items.add(new ListItem("images/locaties_thumbnails/Panorama-audi.jpg", "auditorium", "A", "afbeelding", "testen2"));
		items.add(new ListItem("images/locaties_thumbnails/Panorama-resto.jpg", "resto", "D", "afbeelding", "testen2"));
		items.add(new ListItem("images/locaties_thumbnails/Panorama-verdieping.jpg", "labyrint", "A", "afbeelding", "testen3"));
		items.add(new ListItem("images/locaties_thumbnails/Panorama-verdieping+.jpg", "gang", "A", "afbeelding", "testen3"));
		items.add(new ListItem("images/locaties_thumbnails/Panorama4_grasveld.jpg", "plein", "buiten", "afbeelding", "testen3"));
		return items;
	}
}
