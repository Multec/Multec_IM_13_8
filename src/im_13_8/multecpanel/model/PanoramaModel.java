package im_13_8.multecpanel.model;

import im_13_8.multecpanel.entiteiten.ListItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Sam Coenen
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This class is used to fetch all panoramas from the database.
 *
 */
public class PanoramaModel {
	
	/**
	 * 
	 * @return The panorama's from the database.
	 */
	public ArrayList<ListItem> getPanoramas() {
		ResultSet queryResult = null;
		DatabaseQuery dbQuery = null;
		try {
			dbQuery = new DatabaseQuery(
					"SELECT * FROM panorama order by Panorama_naam;");
			queryResult = dbQuery.getResult();
		} catch (SQLException e) {
			System.out.println("There was an error while "
					+ "executing the query. Error:" + e);
		}

		ArrayList<ListItem> panoramas = new ArrayList<ListItem>();
		try {
			while(queryResult.next()) {
				panoramas.add(new ListItem(
						queryResult.getString("thumb_panorama"),
						queryResult.getString("Panorama_naam"),
						"",
						queryResult.getString("path_panorama"),
						""));
			}
			
		} catch (SQLException e) {
			System.out.println("There was an error while "
					+ "getting the row from the query result. Error:" + e);
		}
		dbQuery.close();
		
		return panoramas;
	}
}
