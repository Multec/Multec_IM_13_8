package im_13_8.multecpanel.model;

import im_13_8.multecpanel.entiteiten.Cluster;
import im_13_8.multecpanel.entiteiten.DetailInfo;
import im_13_8.multecpanel.entiteiten.ListItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DocentenModel {

	public DocentenModel() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<ListItem> getDocenten() {
		ResultSet queryResult = null;
		DatabaseQuery dbQuery = null;
		try {
			dbQuery = new DatabaseQuery("SELECT * FROM docent ORDER BY docentnaam;");
			queryResult = dbQuery.getResult();
		} catch (SQLException e) {
			System.out.println("There was an error while executing the query. Error:" + e);
		}

		ArrayList<ListItem> docenten = new ArrayList<ListItem>();
		try {
			while(queryResult.next()) {
				docenten.add(new ListItem(queryResult.getString("path_thumb_docent"), queryResult.getString("docentennaam"), "", "docent", ""));
			}
			
		} catch (SQLException e) {
			System.out.println("There was an error while getting the row from the query result. Error:" + e);
		}
		dbQuery.close();
		
		return docenten;
	}
	
	public DetailInfo getDocentInfo(String docentName) {
		ResultSet queryResult = null;
		DatabaseQuery dbQuery = null;
		try {
			dbQuery = new DatabaseQuery("SELECT * FROM docent WHERE docentnaam = ? limit 1;", docentName);
			queryResult = dbQuery.getResult();
		} catch (SQLException e) {
			System.out.println("There was an error while executing the query. Error:" + e);
		}

		DetailInfo docent = null;
		try {
			if(queryResult.next()) {
				docent = new DetailInfo(queryResult.getString("docentnaam"), "", queryResult.getString("path_film"));
			}
			
		} catch (SQLException e) {
			System.out.println("There was an error while getting the row from the query result. Error:" + e);
		}
		dbQuery.close();
		
		return docent;
	}

}
