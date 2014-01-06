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
		items.add(new ListItem("test.png", "test", "testrechts", "afbeelding", "testen"));
		items.add(new ListItem("test.png", "test1", "testrechts1", "afbeelding", "testen"));
		items.add(new ListItem("test.png", "test2", "testrechts2", "afbeelding", "testen"));
		items.add(new ListItem("test.png", "test3", "testrechts3", "afbeelding", "testen"));
		items.add(new ListItem("test.png", "test4", "testrechts4", "afbeelding", "testen2"));
		items.add(new ListItem("test.png", "test5", "testrechts5", "afbeelding", "testen2"));
		items.add(new ListItem("test.png", "test6", "testrechts6", "afbeelding", "testen3"));
		items.add(new ListItem("test.png", "test7", "testrechts7", "afbeelding", "testen3"));
		return items;
	}

	public ArrayList<Cluster> getClusters() {
		ArrayList<Cluster> clusters = new ArrayList<Cluster>();
		clusters.add(new Cluster("testen", 4));
		clusters.add(new Cluster("testen2", 2));
		clusters.add(new Cluster("testen3", 2));
		return clusters;
	}

}
