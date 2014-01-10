package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.DetailInfo;
import im_13_8.multecpanel.model.DetailModel;

/**
 *
 * @author Sam Coenen
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This class is used to communicate between a DetailView and DetailModel.
 *
 */

public class DetailController {
	private DetailModel model;
	
	/**
	 * Create a new DetailController.
	 */
	public DetailController() {
		model = new DetailModel();
	}
	
	/**
	 * 
	 * @param name The item you want informtion about.
	 * @return The item returned by the model.
	 */
	public DetailInfo getDetailInfo(String name) {
		return model.getDetailInfo(name);
	}

}
