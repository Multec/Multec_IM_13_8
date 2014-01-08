package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.Cluster;
import im_13_8.multecpanel.entiteiten.DetailInfo;
import im_13_8.multecpanel.entiteiten.ListItem;
import im_13_8.multecpanel.model.DetailModel;
import im_13_8.multecpanel.model.VakModel;

import java.util.ArrayList;

public class ListItemController {
private VakModel model;
	
	public ListItemController() {
		model = new VakModel();
	}
	
	public ArrayList<ListItem> getListitems() {
		return model.getDetailInfo();
	}

	public ArrayList<Cluster> getClusters() {
		return model.getClusters();
	}

}
