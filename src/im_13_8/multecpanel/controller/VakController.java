package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.Cluster;
import im_13_8.multecpanel.entiteiten.DetailInfo;
import im_13_8.multecpanel.entiteiten.ListItem;
import im_13_8.multecpanel.model.VakModel;

import java.util.ArrayList;

public class VakController {
	private VakModel model;
	private String name;
		
	public VakController(String name) {
		model = new VakModel();
		this.name = name;
	}
	
	public ArrayList<ListItem> getListitems() {
		return model.getVakken();
	}
	
	public DetailInfo getVakItem() {
		return model.getDetailInfo(this.name);
	}
	
	public ArrayList<Cluster> getClusters() {
		return model.getClusters();
	}
}
