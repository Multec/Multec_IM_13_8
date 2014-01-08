package im_13_8.multecpanel.model;
import java.sql.*;

public class DatabaseConnection {
	private Connection dbConnection;

	public DatabaseConnection() throws Exception {
		// Access drivers from JAR file
		Class.forName("com.mysql.jdbc.Driver");
			
		this.dbConnection = DriverManager.getConnection("jdbc:mysql://iwt5.ehb.be/multiscreen", "multiscreen", "Sm358");
	}
	
	public Connection getConnection() {
		return this.dbConnection;
	}
	
	public void closeConnection() throws SQLException {
		this.dbConnection.close();
	}
}
