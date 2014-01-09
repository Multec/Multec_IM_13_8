package im_13_8.multecpanel.controller;

import java.util.ArrayList;

import im_13_8.multecpanel.entiteiten.Cluster;
import im_13_8.multecpanel.entiteiten.ListItem;
import im_13_8.multecpanel.model.EventModel;

public class EventController {
	private EventModel model;
	
	public EventController() {
		model = new EventModel();
	}
		
	public ArrayList<ListItem> getListitems() {
		return model.getEvents();
	}
	
	public ArrayList<Cluster> getClusters() {
		return model.getClusters();
	}
}
