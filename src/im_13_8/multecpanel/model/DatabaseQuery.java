package im_13_8.multecpanel.model;
import java.sql.*;


/**
 *
 * @author Sam Coenen
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This class is used to send a query to our database connection.
 *
 */
public class DatabaseQuery {
	private Connection dbConnection;
	private ResultSet result;
	private java.sql.PreparedStatement statement;
	
	/**
	 * Create a new database query.
	 * @param query The query which you want to perform.
	 * @param name Argument which we insert into the query.
	 * @throws SQLException If the query cannot be executed.
	 */
	public DatabaseQuery(String query, String name) throws SQLException {
		try {
			this.dbConnection = Database.getConnection();
		} catch (Exception e) {
			System.out.println(
			"There was an error while connecting to the database. Error: "
			+ e);
		}
		
		statement = this.dbConnection.prepareStatement(query);
						
		// Add out argument to our query, prevent injection.
		statement.setString(1, name);
		this.result = statement.executeQuery();
	}
	
	/**
	 * Create a new database query.
	 * @param query The query which you want to perform.
	 * @throws SQLException If the query cannot be executed.
	 */
	public DatabaseQuery(String query) throws SQLException {
		try {
			this.dbConnection = Database.getConnection();
		} catch (Exception e) {
			System.out.println(
			"There was an error while connecting to the database. Error: "
			+ e);
		}
		

		statement = this.dbConnection.prepareStatement(query);
						
		this.result = statement.executeQuery();
	}
	
	/**
	 * 
	 * @return The result of the query.
	 * @throws SQLException If there was no result.
	 */
	public ResultSet getResult() throws SQLException {
		return result;
	}
	
	/**
	 * Close everything related to the database to prevent memory leaks.
	 */
	public void close() {
		try {
			this.statement.close();
			this.dbConnection.close();
		} catch (Exception e) {
			System.out.println(
			"There was an error while closing the database. Error: "
			+ e);
		}
	}

}
