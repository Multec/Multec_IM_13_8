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


/* 
 			import com.mysql.jdbc.PreparedStatement;
 			// Creating query
			java.sql.PreparedStatement statement = con.prepareStatement("select * from vak");
		
			// Create variable to execute query
			ResultSet result = statement.executeQuery();
		
			DetailInfo detail;
			while (result.next()) {
				detail = new DetailInfo(result.getString(2), result.getString(3), result.getString(4));
			}
			
			return detail;
*/
