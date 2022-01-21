package page;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabasePage {
	
	public static String getData(String columName) throws Throwable {
// This is the driver needed to interact with the mysql database		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String sqlUrl = "jdbc:mysql://localhost:3306/jan2021";
		String sqlUsername = "root";
		String sqlPassword = "root";
		String query = "select * from users";

//We are just creating a connection to your local Database by creating object from connection interface		
		Connection con = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
		
//Empowering the con ref variable to execute queries		
		Statement smt = con.createStatement();
		
//We are just executing the query		
		ResultSet rs = smt.executeQuery(query);
		
		while(rs.next()) {
			return rs.getString(columName);
		}
		
		return columName;
		
		
		
	}

}
