package com.jay;

public class Main {

	public static void main(String[] args) {
		
		
		ClientSidedRequest clientSidedRequest = new ClientSidedRequest("http://192.168.1.22:8080/user");
		
		UserDetails insertUser = new UserDetails("31211","jay_dev","jaydev");
		UserDetails modifyUser = new UserDetails("31211","jaydev","25");
		
		Result postResult = clientSidedRequest.setUserDetails(insertUser);
//		Result modifyResult = clientSidedRequest.modifyUserDetails(modifyUser);
//		UserDetails recivedUser = clientSidedRequest.getUserDetails("3121");
//		Result deleteResult = clientSidedRequest.deleteUserDetails("3121");
		
//		System.out.println(recivedUser.getAge());
//		System.out.println(postResult.getError_code()+"--"+postResult.getError_message());
//		System.out.println(modifyResult.getError_code()+"--"+modifyResult.getError_message());
//		System.out.println(deleteResult.getError_code()+"--"+deleteResult.getError_message());
		
		ClientSidedRequest client2 = new ClientSidedRequest("http://192.168.1.22:8080/users");
		UserDetails[] allUsers = client2.getAllUsers();
		for(UserDetails user : allUsers) {
			System.out.println(user.getname());
		}
		
		
		
		
		
	}

}
