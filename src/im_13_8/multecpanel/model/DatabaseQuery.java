package im_13_8.multecpanel.model;
import java.sql.*;

import com.mysql.jdbc.PreparedStatement;

public class DatabaseQuery {
	private Connection dbConnection;
	private ResultSet result;
	private java.sql.PreparedStatement statement;
	
	public DatabaseQuery(String query) throws SQLException {
		try {
			this.dbConnection = new DatabaseConnection().getConnection();
		} catch (Exception e) {
			System.out.println("There was an error while connecting to the database. Error: " + e);
		}
		
		// Creating query
		statement = this.dbConnection.prepareStatement(query);
						
		// Create variable to execute query
		this.result = statement.executeQuery();
	}
	
	public ResultSet getResult() throws SQLException {
		return result;
	}
	
	public void closeQuery() throws SQLException {
		this.statement.close();
	}

}
