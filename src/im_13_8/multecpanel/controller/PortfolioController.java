package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.Cluster;
import im_13_8.multecpanel.entiteiten.DetailInfo;
import im_13_8.multecpanel.entiteiten.ListItem;
import im_13_8.multecpanel.model.PortfolioModel;
import im_13_8.multecpanel.model.VakModel;

import java.util.ArrayList;

public class PortfolioController {
	private PortfolioModel model;
		
	public PortfolioController() {
		model = new PortfolioModel();
	}
	
	public ArrayList<ListItem> getListitems() {
		return model.getPortfolio();
	}
}
