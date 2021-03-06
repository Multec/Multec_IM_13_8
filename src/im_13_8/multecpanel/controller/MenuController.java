package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.MenuItem;

import java.util.ArrayList;

/**
 *
 * @author Sam Coenen
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This class is a controller which returns hardcoded menu items.
 *
 */
public class MenuController {
	private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	
	/**
	 * Create a new menu controller.
	 * @param whichMenu The kind of menu.
	 */
	public MenuController(String whichMenu) {
		if (whichMenu == "hoofdMenu") {
			this.menuItems.clear();
			this.menuItems.add(new MenuItem("Portfolio", 
					"images/portfolioBlack.jpg",
					"images/portfolio.jpg", 
					"portfolio",
					"list"));
			this.menuItems.add(new MenuItem("Studie",
					"images/studieBlack.jpg",
					"images/studie.jpg",
					"studie",
					"menu"));
			this.menuItems.add(new MenuItem("Events",
					"images/eventsBlack.jpg",
					"images/events.jpg",
					"events",
					"list"));
			this.menuItems.add(new MenuItem("Campus",
					"images/campusBlack.jpg",
					"images/campus.jpg",
					"campus",
					"pano"));
			this.menuItems.add(new MenuItem("School",
					"images/schoolBlack.jpg",
					"images/school.jpg",
					"school",
					"menu"));
		} else if(whichMenu == "school") {
			this.menuItems.clear();
			this.menuItems.add(new MenuItem("Studentenraad",
					"images/studentenraadBlack.jpg", 
					"images/studentenraad.jpg",
					"studentenraad", 
					"detail"));
			this.menuItems.add(new MenuItem("Studenten-\nvereniging", 
					"images/studentenverenigingBlack.jpg", 
					"images/studentenvereniging.jpg",
					"studentenvereniging", 
					"detail"));
			this.menuItems.add(new MenuItem("Traject\nBegeleiding", 
					"images/trajectBegeleidingBlack.jpg", 
					"images/trajectBegeleiding.jpg",
					"trajectBegeleiding", 
					"detail"));
		} else if (whichMenu =="studie") {
			this.menuItems.clear();
			this.menuItems.add(new MenuItem("Vakken",
					"images/vakkenBlack.jpg",
					"images/vakken.jpg",
					"vakken",
					"list"));
			this.menuItems.add(new MenuItem("Specialisaties",
					"images/specialisatiesBlack.jpg",
					"images/specialisaties.jpg",
					"specialisaties",
					"detail"));
			this.menuItems.add(new MenuItem("Docenten", 
					"images/docentenBlack.jpg",
					"images/docenten.jpg", 
					"docenten",
					"list"));
		}
	}
	
	/**
	 * 
	 * @return The arrayList created by this controller.
	 */
	public ArrayList<MenuItem> getMenuItems() {
		return this.menuItems;
	}
}
