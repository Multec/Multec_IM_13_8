package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.Cluster;
import im_13_8.multecpanel.entiteiten.ListItem;
import im_13_8.multecpanel.model.DocentenModel;
import im_13_8.multecpanel.model.EventModel;
import im_13_8.multecpanel.model.PortfolioModel;
import im_13_8.multecpanel.model.VakModel;

import java.util.ArrayList;

public class ListItemController {
private VakModel vakmodel;
private DocentenModel docentModel;
private EventModel eventModel;
private PortfolioModel portfolioModel;
	
	public ListItemController() {
		vakmodel = new VakModel();
		docentModel = new DocentenModel();
		eventModel = new EventModel();
		portfolioModel = new PortfolioModel();
		
	}
	
	public ArrayList<ListItem> getListitems(String name) {
		if(name == "vakken") { 
			return vakmodel.getVakken();
		}
		if(name == "docenten") {
			return docentModel.getDocenten();
		}
		if(name == "events") {
			return eventModel.getEvents();
		}
		if(name == "portfolio") {
			return portfolioModel.getPortfolio();
		}
		return new ArrayList<ListItem>();
	}

	public ArrayList<Cluster> getClusters(String name) {
		if(name == "vakken") { 
			return vakmodel.getClusters();
		}
		if (name == "events") {
			return eventModel.getClusters();
		}
		return new ArrayList<Cluster>();
	}

}
