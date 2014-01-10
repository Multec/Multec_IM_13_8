package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.ListItem;
import im_13_8.multecpanel.model.PortfolioModel;


import java.util.ArrayList;

/**
 *
 * @author Sam Coenen
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This class is used to communicate between ListView and PortfolioModel.
 *
 */

public class PortfolioController {
	private PortfolioModel model;
		
	/**
	 * Create a new PortfolioController.
	 */
	public PortfolioController() {
		model = new PortfolioModel();
	}
	
	/**
	 * 
	 * @return The clusters returned by the model.
	 */
	public ArrayList<ListItem> getListitems() {
		return model.getPortfolio();
	}
}
