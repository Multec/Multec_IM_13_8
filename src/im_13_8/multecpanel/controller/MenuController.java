package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.MenuItem;

import java.util.ArrayList;

public class MenuController {
	private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	
	public MenuController() {
		this.menuItems.add(new MenuItem("Portfolio", "images/portfolioEdited.jpg", "portfolio"));
		this.menuItems.add(new MenuItem("Studie", "images/studieEdited.jpg", "studie"));
		this.menuItems.add(new MenuItem("Events", "images/eventsEdited.jpg", "events"));
		this.menuItems.add(new MenuItem("Campus", "images/campusEdited.jpg", "campus"));
		this.menuItems.add(new MenuItem("School", "images/schoolEdited.jpg", "school"));
	}
	
	public ArrayList<MenuItem> getMenuItems() {
		return this.menuItems;
	}
}
