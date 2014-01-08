package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.DetailInfo;
import im_13_8.multecpanel.model.DatabaseQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetailController {
	private ResultSet queryResult;
	private DatabaseQuery dbQuery;
	
	public DetailInfo getDetailInfo() {
		
		try {
			this.dbQuery = new DatabaseQuery("SELECT * FROM vak");
			queryResult = this.dbQuery.getResult();
		} catch (SQLException e) {
			System.out.println("There was an error while executing the query. Error:" + e);
		}

		DetailInfo detail = null;
		try {
			this.queryResult.first();
			detail = new DetailInfo(this.queryResult.getString(2), this.queryResult.getString(3), this.queryResult.getString(4));
		} catch (SQLException e) {
			System.out.println("There was an error while getting the row from the query result. Error:" + e);
		}
		
		try {
			this.dbQuery.closeQuery();
		} catch (SQLException e) {
			System.out.println("There was an error while trying to close the resultset. Error: " + e);
		}
		return detail;
	}

}
