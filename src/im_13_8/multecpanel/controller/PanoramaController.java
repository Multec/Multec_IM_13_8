package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.ListItem;
import im_13_8.multecpanel.model.PanoramaModel;

import java.util.ArrayList;

/**
 *
 * @author Johan Sergeyssels
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This class is used to communicate between PanoramaView and PanoramaModel.
 *
 */
public class PanoramaController {
	private PanoramaModel model;
	
	/**
	 * Create a new panorama controller.
	 */
	public PanoramaController() {
		model = new PanoramaModel();
	}
	
	/**
	 * 
	 * @return All items returned by the model.
	 */
	public ArrayList<ListItem> getListitems() {
		return model.getPanoramas();
	}
}
