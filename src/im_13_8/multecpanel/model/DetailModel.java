package im_13_8.multecpanel.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import im_13_8.multecpanel.entiteiten.DetailInfo;

/**
 *
 * @author Sam Coenen
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This class is used to fetch detail information from the database.
 *
 */
public class DetailModel {
	
	/**
	 * 
	 * @param name The detailscreen you want info about.
	 * @return The detailscreen result from the query.
	 */
	public DetailInfo getDetailInfo(String name) {
		ResultSet queryResult = null;
		DatabaseQuery dbQuery = null;
		try {
			dbQuery = new DatabaseQuery(
			"SELECT * FROM detailScherm WHERE detailSchermNaam = ? limit 1;",
			name);
			queryResult = dbQuery.getResult();
		} catch (SQLException e) {
			System.out.println(
			"There was an error while executing the query. Error:"
			+ e);
		}

		DetailInfo detail = null;
		try {
			if(queryResult.next()) {
				detail = new DetailInfo(
						queryResult.getString("detailSchermNaam"),
						queryResult.getString("detailSchermBeschrijving"),
						queryResult.getString("detailSchermImagePath"));
			}
			
		} catch (SQLException e) {
			System.out.println(
			"There was an error while getting the row from the query result. Error:"
			+ e);
		}
		dbQuery.close();
		
		return detail;
	}

}
