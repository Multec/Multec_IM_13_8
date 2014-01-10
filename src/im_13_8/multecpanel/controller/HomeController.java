package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.Richting;

import java.util.ArrayList;


/**
 *
 * @author Johan Sergeyssels
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This class returns the majors used in our application.
 *
 */

public class HomeController {

	/**
	 * 
	 * @return The majors used in our application.
	 */
	public ArrayList<Richting> getRichtingen() {
		ArrayList<Richting> richtingen = new ArrayList<Richting>();
		richtingen.add(new Richting("Multec"));
		richtingen.add(new Richting("Dig-x"));
		return richtingen;
	}

}
