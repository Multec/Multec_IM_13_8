package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.Cluster;
import im_13_8.multecpanel.entiteiten.ListItem;
import im_13_8.multecpanel.model.DocentenModel;
import im_13_8.multecpanel.model.VakModel;

import java.util.ArrayList;

public class ListItemController {
private VakModel vakmodel;
private DocentenModel docentModel;
	
	public ListItemController() {
		vakmodel = new VakModel();
		docentModel = new DocentenModel();
	}
	
	public ArrayList<ListItem> getListitems(String name) {
		if(name == "vakken") { 
			return vakmodel.getVakken();
		}
		if(name == "docenten") {
			return docentModel.getDocenten();
		}
		return new ArrayList<ListItem>();
	}

	public ArrayList<Cluster> getClusters(String name) {
		if(name == "vakken") { 
			return vakmodel.getClusters();
		}
		return new ArrayList<Cluster>();
	}

}
