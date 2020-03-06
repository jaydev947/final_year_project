package com.jay.server;


public interface UserManagement {
	
	UserDetails getUserDetails(String id);
	Result setUserDetails(UserDetails userDetails);
	Result modifyUserDetails(UserDetails userDetails);
	Result deleteUserDetails(String id);
//	UserDetails[] getAllUsers();

}
