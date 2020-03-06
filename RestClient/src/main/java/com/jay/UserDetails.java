package com.jay;

public class UserDetails {
	
	String id;
	String name;
	String age;
	public String getId() {
		return id;
	}

	public String getname() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public UserDetails(String id, String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public UserDetails() {
		super();
	}
}
