package im_13_8.multecpanel.controller;

import java.util.ArrayList;

import im_13_8.multecpanel.entiteiten.DocentenInfo;
import im_13_8.multecpanel.entiteiten.ListItem;
import im_13_8.multecpanel.model.DocentenModel;


/**
 *
 * @author Sam Coenen
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This class is used to communicate between ListView and DocentenModel.
 *
 */

public class DocentenController {
	private DocentenModel model;

	/**
	 * Create a new DocentenController.
	 */
	public DocentenController() {
		model = new DocentenModel();
	}
	
	/**
	 * 
	 * @return All items returned by the model.
	 */
	public ArrayList<ListItem> getListItems() {
		return model.getDocenten();
	}
	
	/**
	 * 
	 * @param docentName The name of the teacher.
	 * @return The teacher information returned by the model.
	 */
	public DocentenInfo getDocentInfo(String docentName) {
		return model.getDocentInfo(docentName);
	}

}
