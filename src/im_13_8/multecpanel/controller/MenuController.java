package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.MenuItem;

import java.util.ArrayList;

public class MenuController {
	private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	
	public MenuController() {
		this.menuItems.add(new MenuItem("Portfolio", "images/portfolioBlack.jpg", "portfolio"));
		this.menuItems.add(new MenuItem("Studie", "images/studieBlack.jpg", "studie"));
		this.menuItems.add(new MenuItem("Events", "images/eventsBlack.jpg", "events"));
		this.menuItems.add(new MenuItem("Campus", "images/campusBlack.jpg", "campus"));
		this.menuItems.add(new MenuItem("School", "images/schoolBlack.jpg", "school"));
	}
	
	public ArrayList<MenuItem> getMenuItems() {
		return this.menuItems;
	}
}
