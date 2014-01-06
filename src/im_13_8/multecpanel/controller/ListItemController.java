package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.Cluster;
import im_13_8.multecpanel.entiteiten.ListItem;

import java.util.ArrayList;

public class ListItemController {

	public ListItemController() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<ListItem> getListitems() {
		ArrayList<ListItem> items = new ArrayList<ListItem>();
		items.add(new ListItem("images/docenten_thumbnails/bert.jpg", "bert", "testrechts", "afbeelding", "testen"));
		items.add(new ListItem("images/docenten_thumbnails/dirly.jpg", "dirly", "testrechts1", "afbeelding", "testen"));
		items.add(new ListItem("images/docenten_thumbnails/frank.jpg", "frank", "testrechts2", "afbeelding", "testen"));
		items.add(new ListItem("images/docenten_thumbnails/herman.jpg", "herman", "testrechts3", "afbeelding", "testen"));
		items.add(new ListItem("images/docenten_thumbnails/jan.jpg", "jan", "testrechts4", "afbeelding", "testen2"));
		items.add(new ListItem("images/docenten_thumbnails/janklaas.jpg", "janklaas", "testrechts5", "afbeelding", "testen2"));
		items.add(new ListItem("images/docenten_thumbnails/johan.jpg", "johan", "testrechts6", "afbeelding", "testen3"));
		items.add(new ListItem("images/docenten_thumbnails/maarten.jpg", "maarten", "testrechts7", "afbeelding", "testen3"));
		items.add(new ListItem("images/docenten_thumbnails/philip.jpg", "philip", "testrechts7", "afbeelding", "testen3"));
		items.add(new ListItem("images/docenten_thumbnails/robbie.jpg", "robbie", "testrechts7", "afbeelding", "testen3"));
		items.add(new ListItem("images/docenten_thumbnails/stefan.jpg", "stefan", "testrechts7", "afbeelding", "testen3"));
		items.add(new ListItem("images/docenten_thumbnails/wouter.jpg", "wouter", "testrechts7", "afbeelding", "testen3"));
		return items;
	}

	public ArrayList<Cluster> getClusters() {
		ArrayList<Cluster> clusters = new ArrayList<Cluster>();
		clusters.add(new Cluster("testen", 4));
		clusters.add(new Cluster("testen2", 2));
		clusters.add(new Cluster("testen3", 6));
		return clusters;
	}

}
