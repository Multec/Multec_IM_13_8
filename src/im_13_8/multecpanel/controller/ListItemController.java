package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.Cluster;
import im_13_8.multecpanel.entiteiten.ListItem;
import im_13_8.multecpanel.model.VakModel;

import java.util.ArrayList;

public class ListItemController {
private VakModel vakmodel;
	
	public ListItemController() {
		vakmodel = new VakModel();
	}
	
	public ArrayList<ListItem> getListitems(String name) {
		if(name == "vakken") { 
			return vakmodel.getVakken();
		}
		if(name == "docenten") {
			ArrayList<ListItem> docenten = new ArrayList<ListItem>();
			docenten.add(new ListItem("images/docenten_thumbnails/dirly.jpg", "Dirly", "", "movie", ""));
			
			return docenten;
		}
		return new ArrayList<ListItem>();
	}

	public ArrayList<Cluster> getClusters() {
		return vakmodel.getClusters();
	}

}
