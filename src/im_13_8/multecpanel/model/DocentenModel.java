package im_13_8.multecpanel.model;

import im_13_8.multecpanel.entiteiten.DocentenInfo;
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
 * This class is used to fetch a teacher from the database..
 *
 */
public class DocentenModel {
	
	/**
	 * 
	 * @return All teachers from the database
	 */
	public ArrayList<ListItem> getDocenten() {
		ResultSet queryResult = null;
		DatabaseQuery dbQuery = null;
		try {
			dbQuery = new DatabaseQuery(
					"SELECT * FROM docent ORDER BY docentnaam;");
			queryResult = dbQuery.getResult();
		} catch (SQLException e) {
			System.out.println(
			"There was an error while executing the query. Error:" + e);
		}

		ArrayList<ListItem> docenten = new ArrayList<ListItem>();
		try {
			while(queryResult.next()) {
				docenten.add(new ListItem(
						queryResult.getString("path_thumb_docent"),
						queryResult.getString("docentnaam"), "",
						"movie", ""));
			}
			
		} catch (SQLException e) {
			System.out.println(
			"There was an error while getting the "
			+ "row from the query result. Error:" + e);
		}
		dbQuery.close();
		
		return docenten;
	}
	
	/**
	 * 
	 * @param docentName The teacher you want to fetch.
	 * @return The information about the teacher from the database.
	 */
	public DocentenInfo getDocentInfo(String docentName) {
		ResultSet queryResult = null;
		DatabaseQuery dbQuery = null;
		try {
			dbQuery = new DatabaseQuery(
			"SELECT * FROM docent WHERE docentnaam = ? limit 1;",
			docentName);
			queryResult = dbQuery.getResult();
		} catch (SQLException e) {
			System.out.println("There was an error while"
					+ " executing the query. Error:" + e);
		}

		DocentenInfo docent = null;
		try {
			if(queryResult.next()) {
				docent = new DocentenInfo(
						queryResult.getString("docentnaam"),
						"", queryResult.getString("path_film"));
			}
			
		} catch (SQLException e) {
			System.out.println("There was an error while "
					+ "getting the row from the query result. Error:" + e);
		}
		dbQuery.close();
		
		return docent;
	}

}
