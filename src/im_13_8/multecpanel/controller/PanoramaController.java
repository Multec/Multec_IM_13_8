package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.ListItem;
import im_13_8.multecpanel.model.PanoramaModel;

import java.util.ArrayList;

public class PanoramaController {
	private PanoramaModel model;
	
	public PanoramaController() {
		model = new PanoramaModel();
	}
	
	public ArrayList<ListItem> getListitems() {
		return model.getPanoramas();
	}
}
