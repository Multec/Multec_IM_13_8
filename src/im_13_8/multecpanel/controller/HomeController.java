package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.Richting;

import java.util.ArrayList;

public class HomeController {

	public ArrayList<Richting> getRichtingen() {
		ArrayList<Richting> richtingen = new ArrayList<Richting>();
		richtingen.add(new Richting("Multec"));
		richtingen.add(new Richting("Dig-x"));
		return richtingen;
	}

}
