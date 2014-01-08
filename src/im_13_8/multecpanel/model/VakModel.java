package im_13_8.multecpanel.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import im_13_8.multecpanel.entiteiten.Cluster;
import im_13_8.multecpanel.entiteiten.DetailInfo;
import im_13_8.multecpanel.entiteiten.ListItem;

public class VakModel {
	
	public VakModel() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<ListItem> getVakken() {
		ResultSet queryResult = null;
		DatabaseQuery dbQuery = null;
		try {
			dbQuery = new DatabaseQuery("SELECT * FROM vak ORDER BY pijler, vaknaam;");
			queryResult = dbQuery.getResult();
		} catch (SQLException e) {
			System.out.println("There was an error while executing the query. Error:" + e);
		}

		ArrayList<ListItem> vakken = new ArrayList<ListItem>();
		try {
			while(queryResult.next()) {
				vakken.add(new ListItem(queryResult.getString("path_afbeelding"), queryResult.getString("vaknaam"), "", "vak", queryResult.getString("pijler")));
			}
			
		} catch (SQLException e) {
			System.out.println("There was an error while getting the row from the query result. Error:" + e);
		}
		dbQuery.close();
		
		return vakken;
	}
	
	public ArrayList<Cluster> getClusters() {
		ResultSet queryResult = null;
		DatabaseQuery dbQuery = null;
		try {
			dbQuery = new DatabaseQuery("SELECT count(*) AS number, pijler FROM vak GROUP BY pijler;");
			queryResult = dbQuery.getResult();
		} catch (SQLException e) {
			System.out.println("There was an error while executing the query. Error:" + e);
		}

		ArrayList<Cluster> clusters = new ArrayList<Cluster>();
		try {
			while(queryResult.next()) {
				clusters.add(new Cluster(queryResult.getString("pijler"), queryResult.getInt("number")));
			}
			
		} catch (SQLException e) {
			System.out.println("There was an error while getting the row from the query result. Error:" + e);
		}
		dbQuery.close();
		
		return clusters;
	}
	
	public DetailInfo getDetailInfo(String name) {
		ResultSet queryResult = null;
		DatabaseQuery dbQuery = null;
		try {
			dbQuery = new DatabaseQuery("SELECT * FROM vak WHERE vaknaam = ? limit 1;", name);
			queryResult = dbQuery.getResult();
		} catch (SQLException e) {
			System.out.println("There was an error while executing the query. Error:" + e);
		}

		DetailInfo detail = null;
		try {
			if(queryResult.next()) {
				detail = new DetailInfo(queryResult.getString("vaknaam"), queryResult.getString("vakbeschrijving"), queryResult.getString("path_afbeelding"));
			}
			
		} catch (SQLException e) {
			System.out.println("There was an error while getting the row from the query result. Error:" + e);
		}
		dbQuery.close();
		
		return detail;
	}

}
