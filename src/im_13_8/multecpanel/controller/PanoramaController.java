package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.ListItem;

import java.util.ArrayList;

public class PanoramaController {
	public ArrayList<ListItem> getListitems() {
		ArrayList<ListItem> items = new ArrayList<ListItem>();
		items.add(new ListItem("images/locaties_thumbnails/classRoom.jpg", "B103", "B", "images/pano/classRoom.jpg", "testen"));
		items.add(new ListItem("images/locaties_thumbnails/edited_pano_fablab.jpg", "fablab", "B", "images/pano/inkom.jpg", "testen"));
		items.add(new ListItem("images/locaties_thumbnails/inkom.jpg", "inkom", "A", "images/pano/pano_fablab.jpg", "testen"));
		items.add(new ListItem("images/locaties_thumbnails/Panorama-parking.jpg", "parking", "buiten", "images/pano/Panorama-audi.jpg", "testen"));
		items.add(new ListItem("images/locaties_thumbnails/Panorama-audi.jpg", "auditorium", "A", "images/pano/Panorama-bib.jpg", "testen2"));
		items.add(new ListItem("images/locaties_thumbnails/Panorama-resto.jpg", "resto", "D", "images/pano/Panorama-parking.jpg", "testen2"));
		items.add(new ListItem("images/locaties_thumbnails/Panorama-verdieping.jpg", "labyrint", "A", "images/pano/Panorama-resto.jpg", "testen3"));
		items.add(new ListItem("images/locaties_thumbnails/Panorama-verdieping+.jpg", "gang", "A", "images/pano/Panorama-verdieping.jpg", "testen3"));
		items.add(new ListItem("images/locaties_thumbnails/Panorama4_grasveld.jpg", "plein", "buiten", "images/pano/Panorama4_grasveld.jpg", "testen3"));
		return items;
	}
}
