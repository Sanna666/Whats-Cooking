package database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
/**
 * 
 * @author Sofia Larsson
 * @author Linus Forsberg
 *
 */
public class DBConnection {
	private String driver;
	private String url;
	private String username;
	private String password;
	
	public DBConnection(){
		this.driver = "org.postgresql.Driver";
		this.url = "jdbc:postgresql://104.155.0.136/test";
		this.username = "postgres";
		this.password = "bigheadteam";
	}
	public String getDriver(){
		return this.driver;
	}
	public String getUrl(){
		return this.url;
	}
	public String getUsername(){
		return this.username;
	}
	public String getPassword(){
		return this.password;
	}
	
	   public void initiate() {
		   Connection connection = null;
		   // Try for Driver
		   try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
				e.printStackTrace();
				return;
			}
		   //Try to connect to database with details
		   try {
				connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword());

			} catch (SQLException e) {
				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				return;
			}
		   //If user details match and connection was successful or not
		   if (connection != null) {
				System.out.println("You are connected!");
			} else {
				System.out.println("Failed to make connection!");
			}
	   }
	   
}

