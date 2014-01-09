package im_13_8.multecpanel.model;

import im_13_8.multecpanel.entiteiten.Cluster;
import im_13_8.multecpanel.entiteiten.ListItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PortfolioModel {

	public PortfolioModel() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<ListItem> getPortfolio() {
		ResultSet queryResult = null;
		DatabaseQuery dbQuery = null;
		try {
			dbQuery = new DatabaseQuery("SELECT * FROM taak ORDER BY taaknaam;");
			queryResult = dbQuery.getResult();
		} catch (SQLException e) {
			System.out.println("There was an error while executing the query. Error:" + e);
		}

		ArrayList<ListItem> taken = new ArrayList<ListItem>();
		try {
			while(queryResult.next()) {
				int vakID = queryResult.getInt("ID_vak");
				DatabaseQuery getVakNameQuery = new DatabaseQuery("SELECT vaknaam FROM vak WHERE ID_vak = ?", String.valueOf(vakID));
				ResultSet getVakNameResult = getVakNameQuery.getResult();
				getVakNameResult.first();
				String vakName = getVakNameResult.getString("vaknaam");
				taken.add(new ListItem(queryResult.getString("path_thumb_taak"), queryResult.getString("taaknaam"), vakName, "", ""));
			}
			
		} catch (SQLException e) {
			System.out.println("There was an error while getting the row from the query result. Error:" + e);
		}
		dbQuery.close();
		
		return taken;
	}
}
