package im_13_8.multecpanel.controller;

import java.util.ArrayList;

import im_13_8.multecpanel.entiteiten.DetailInfo;
import im_13_8.multecpanel.entiteiten.DocentenInfo;
import im_13_8.multecpanel.entiteiten.ListItem;
import im_13_8.multecpanel.model.DocentenModel;

public class DocentenController {
	private DocentenModel model;

	public DocentenController() {
		model = new DocentenModel();
	}
	
	public ArrayList<ListItem> getListItems() {
		return model.getDocenten();
	}
	
	public DocentenInfo getDocentInfo(String docentName) {
		return model.getDocentInfo(docentName);
	}

}
