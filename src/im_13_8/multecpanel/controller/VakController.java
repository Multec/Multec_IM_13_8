package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.Cluster;
import im_13_8.multecpanel.entiteiten.DetailInfo;
import im_13_8.multecpanel.entiteiten.ListItem;
import im_13_8.multecpanel.model.VakModel;

import java.util.ArrayList;

/**
 *
 * @author Sam Coenen
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This controller is used to communicate between the VakView and VakModel.
 *
 */
public class VakController {
	private VakModel model;
	private String name;
		
	/**
	 * Create a new VakController.
	 * @param name The name of the model which needs to be accessed.
	 */
	public VakController(String name) {
		model = new VakModel();
		this.name = name;
	}
	
	/**
	 * 
	 * @return All items returned by the model.
	 */
	public ArrayList<ListItem> getListitems() {
		return model.getVakken();
	}
	
	/**
	 * 
	 * @return One item returned by the model.
	 */
	public DetailInfo getVakItem() {
		return model.getDetailInfo(this.name);
	}
	
	/**
	 * 
	 * @return All clusters returned by the model.
	 */
	public ArrayList<Cluster> getClusters() {
		return model.getClusters();
	}
}
