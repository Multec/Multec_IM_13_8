package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.DetailInfo;
import im_13_8.multecpanel.model.DatabaseQuery;
import im_13_8.multecpanel.model.DetailModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetailController {
	private DetailModel model;
	
	public DetailController() {
		model = new DetailModel();
	}
	
	public DetailInfo getDetailInfo(String name) {
		return model.getDetailInfo(name);
	}

}
