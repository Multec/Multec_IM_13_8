package im_13_8.multecpanel.controller;

import im_13_8.multecpanel.entiteiten.DetailInfo;

import java.util.ArrayList;

/*
import java.sql.*;
import com.mysql.jdbc.PreparedStatement;

public class DetailController {
	public DetailInfo getDetailInfo() throws Exception {
		// Access drivers from JAR file
		Class.forName("com.mysql.jdbc.Driver");
	
		// Creating variable for connection "con"
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://iwt5.ehb.be/multiscreen", "multiscreen", "Sm358");
	
		// Creating query
		java.sql.PreparedStatement statement = con.prepareStatement("select * from vak");
	
		// Create variable to execute query
		ResultSet result = statement.executeQuery();
	
		DetailInfo detail;
		while (result.next()) {
			detail = new DetailInfo(result.getString(2), result.getString(3), result.getString(4));
		}
		
		return detail;
	}
}
 */



public class DetailController {

	
	public DetailInfo getDetailInfo(){
		
		DetailInfo detail = new DetailInfo("IOS Development", "In dit vak leren jullie programmeren voor de iPod, iPhone en de iPad.", "images/iosDevelopment.jpg");
		
		return detail;
	}

}
