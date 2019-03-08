package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_connect {
	/**
	String jdbcUrl;
	String user ;
	String pass ;
	Connection myConn = null;
	
	public DB_connect(){
		this.jdbcUrl = "jdbc:mysql://localhost:3306/justsimpleusers?useSSL=false";
		this.user = "justanotheruser";
		this.pass = "123qweQWE";
	}
	
	public DB_connect(String url, String user, String pwd){
		this.jdbcUrl = url;
		this.user = user;
		this.pass = pwd;
	}	
	
	public Connection connect() {
		try {Class.forName("com.mysql.jdbc.Driver"); 	//TODO omit, shouldnt be needed
		} catch (ClassNotFoundException e1) {e1.printStackTrace();}
		
		
		try {
			System.out.println("Connecting...");
			myConn = DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection: Success");
		}
		catch(Exception e) {
			System.out.println("Connection: Failed");
			e.printStackTrace();
			
		}
		return myConn;
	}
	
	**/
	
}
