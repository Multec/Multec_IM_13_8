package im_13_8.multecpanel.model;
import java.sql.*;


/**
 *
 * @author Sam Coenen
 * Integration: Multiscreen
 * Erasmushogeschool Brussel 2Ba Multimedia & Communicatietechnologie
 * 
 * This class is used to create a connection to our database.
 *
 */

public class Database {

	/**
	 * Create a new connection to the database.
	 * @return The connection with the database.
	 * @throws Exception If the application cannot connect to the database.
	 */
	public static Connection getConnection() throws Exception {
		// Access drivers from JAR file
		Class.forName("com.mysql.jdbc.Driver");
			
		return DriverManager.getConnection(
				"jdbc:mysql://iwt5.ehb.be/multiscreen", "multiscreen", "Sm358");
	}
}
