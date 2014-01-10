package im_13_8.multecpanel.model;

import im_13_8.multecpanel.entiteiten.Cluster;
import im_13_8.multecpanel.entiteiten.ListItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Sam Coenen
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This class is used to fetch events from the database..
 *
 */
public class EventModel {
	private DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
	
	/**
	 * 
	 * @return All the items stored in the database.
	 */
	public ArrayList<ListItem> getEvents() {
		ResultSet queryResult = null;
		DatabaseQuery dbQuery = null;
		try {
			dbQuery = new DatabaseQuery(
			"SELECT * FROM events ORDER BY Event_date, Event_name;");
			queryResult = dbQuery.getResult();
		} catch (SQLException e) {
			System.out.println("There was an error while "
					+ "executing the query. Error:" + e);
		}

		ArrayList<ListItem> events = new ArrayList<ListItem>();
		try {
			while(queryResult.next()) {
				events.add(new ListItem(
						queryResult.getString("Event_thumb_path"),
						queryResult.getString("Event_name"),
						"",
						"",
						df.format(queryResult.getDate("Event_date"))));
			}
			
		} catch (SQLException e) {
			System.out.println("There was an error while "
					+ "getting the row from the query result. Error:" + e);
		}
		dbQuery.close();
		
		return events;
	}
	
	/**
	 * 
	 * @return The clusters of the events, rename them so we can use them
	 */
	public ArrayList<Cluster> getClusters() {
		ResultSet queryResult = null;
		DatabaseQuery dbQuery = null;
		try {
			dbQuery = new DatabaseQuery(
			"SELECT count(*), Event_date FROM events "
			+ "GROUP BY (Event_date >= now());");
			queryResult = dbQuery.getResult();
		} catch (SQLException e) {
			System.out.println("There was an error while "
					+ "executing the query. Error:" + e);
		}

		ArrayList<Cluster> clusters = new ArrayList<Cluster>();
		try {
			while(queryResult.next()) {
				if (queryResult.getDate("Event_date").before(new Date())) {
					clusters.add(new Cluster("Oude events",
							queryResult.getInt("count(*)")));
				} else {
					clusters.add(new Cluster("Aankomende events",
							queryResult.getInt("count(*)")));
				}
			}
			
		} catch (SQLException e) {
			System.out.println("There was an error while "
					+ "getting the row from the query result. Error:" + e);
		}
		dbQuery.close();
		
		return clusters;
	}

}
