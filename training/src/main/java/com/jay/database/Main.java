package com.jay.database;

import com.jay.server.UserDetails;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		DatabaseCommunicator databaseCommunicator = new DatabaseCommunicator("org.postgresql.Driver","jdbc:postgresql://localhost:5432/testdb","postgres", "jaydev@1");
		UserDetails userDetails = new UserDetails("102","jaydev","21");
		UserDetails userlist = databaseCommunicator.fetch("102","user");
		System.out.println(userDetails.getAge());
		

	}

}
