package com.jay.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.server.Authentication.User;

import com.jay.server.UserDetails;

public class DatabaseCommunicator {
	
	String link;
	String driver;
	String username;
	String password;
//	Connection connection;
//	Statement stmt;

	public DatabaseCommunicator(String driver,String link,String username,String password) {
		
		this.link=link;
		this.driver=driver;
		this.username=username;
		this.password=password;

//		connection = getConnection(driver,link,username,password);
//		try {
//			stmt = connection.createStatement();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
	

	private  Connection getConnection() {
	      Connection c = null;
	      try {
	         Class.forName(this.driver);
	         c = DriverManager.getConnection(link,username,password);
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Opened database successfully");
	      return c;
	      
	      
	   }
	
	public boolean insert(UserDetails userDetails,String tableName) {
		int inserted = 0;
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			
			String sql = "INSERT INTO \""+tableName+"\" (id,name,age) "
		            + "VALUES ('"+userDetails.getId()+"','"+userDetails.getname()+"', '"+userDetails.getAge()+"');";
			inserted = stmt.executeUpdate(sql);
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(inserted>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean delete(String id,String tableName) {
		int deleted = 0;
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			String sql= "Delete from \""+tableName+"\" where id = '"+id+"'";
			deleted = stmt.executeUpdate(sql);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(deleted>0) {
			return true;
		}else {
			return false;
		}
		
	}

	
	public boolean update(UserDetails userDetails,String tableName) {
		int updated = 0;
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			String sql = "update \""+tableName+"\" set id = '"+userDetails.getId()+"', name = '"+userDetails.getname()+"',age = '"+userDetails.getAge()+"' where id = '"+userDetails.getId()+"' ;";
			updated = stmt.executeUpdate(sql);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(updated>0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public UserDetails fetch(String id,String tableName) {
		ResultSet rs ;
		UserDetails user=null;
		String sql = "select * from  \""+tableName+"\" where id = '"+id+"';";
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			user = new UserDetails(rs.getString(1),rs.getString(2),rs.getString(3));
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public UserDetails[] fetchAll(String tableName) {
		List<UserDetails> userList = new ArrayList<UserDetails>();
		ResultSet rs ;
		String sql = "select * from  \""+tableName+"\" ;";
		 try {
			 Connection conn = getConnection();
				Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				userList.add(new UserDetails(rs.getString(1),rs.getString(2),rs.getString(3)));
				
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 UserDetails[] userDetailsArray = new UserDetails[userList.size()];
		 int i=0;
		 for(UserDetails user : userList) {
			 userDetailsArray[i++]=user; 
		 }
		 return userDetailsArray;
		
		
		
	}
	
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.print("connection closed");
	}
	

}
