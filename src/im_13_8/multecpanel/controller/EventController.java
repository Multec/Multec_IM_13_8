package im_13_8.multecpanel.controller;

import java.util.ArrayList;

import im_13_8.multecpanel.entiteiten.Cluster;
import im_13_8.multecpanel.entiteiten.ListItem;
import im_13_8.multecpanel.model.EventModel;


/**
 *
 * @author Sam Coenen
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This class is used to communicate between our ListItem and model.
 *
 */
public class EventController {
	private EventModel model;
	
	/**
	 * Create a new EventController.
	 */
	public EventController() {
		model = new EventModel();
	}
		
	/**
	 * 
	 * @return All items returned by the model.
	 */
	public ArrayList<ListItem> getListitems() {
		return model.getEvents();
	}
	
	/**
	 * 
	 * @return The cluster returned by the model.
	 */
	public ArrayList<Cluster> getClusters() {
		return model.getClusters();
	}
}
