package im_13_8.multecpanel.model;
import java.sql.*;

public class Database {

	public static Connection getConnection() throws Exception {
		// Access drivers from JAR file
		Class.forName("com.mysql.jdbc.Driver");
			
		return DriverManager.getConnection("jdbc:mysql://iwt5.ehb.be/multiscreen", "multiscreen", "Sm358");
	}
}
