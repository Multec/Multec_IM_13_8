package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.MenuItem;

import java.util.ArrayList;

public class MenuController {
	private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	
	public MenuController(String whichMenu) {
		if (whichMenu == "hoofdMenu") {
			this.menuItems.clear();
			this.menuItems.add(new MenuItem("Portfolio", "images/portfolioBlack.jpg", "portfolio"));
			this.menuItems.add(new MenuItem("Studie", "images/studieBlack.jpg", "studie"));
			this.menuItems.add(new MenuItem("Events", "images/eventsBlack.jpg", "events"));
			this.menuItems.add(new MenuItem("Campus", "images/campusBlack.jpg", "campus"));
			this.menuItems.add(new MenuItem("School", "images/schoolBlack.jpg", "school"));
		} else if(whichMenu == "school") {
			this.menuItems.clear();
			this.menuItems.add(new MenuItem("Studentenraad", "images/studentenraadBlack.jpg", "studentenraad"));
			this.menuItems.add(new MenuItem("Studenten-\nvereniging", "images/studentenverenigingBlack.jpg", "studentenvereniging"));
			this.menuItems.add(new MenuItem("Traject\nBegeleiding", "images/trajectBegeleidingBlack.jpg", "trajectBegeleiding"));
		} else if (whichMenu =="studie") {
			this.menuItems.clear();
			this.menuItems.add(new MenuItem("Vakken", "images/vakkenBlack.jpg", "vakken"));
			this.menuItems.add(new MenuItem("Specialisaties", "images/specialisatiesBlack.jpg", "specialisaties"));
			this.menuItems.add(new MenuItem("Docenten", "images/docentenBlack.jpg", "docenten"));
		}
	}
	
	public ArrayList<MenuItem> getMenuItems() {
		return this.menuItems;
	}
}
