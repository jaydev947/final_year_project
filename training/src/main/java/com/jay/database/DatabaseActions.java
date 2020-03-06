package com.jay.database;

public interface DatabaseActions<F,Q> {
	
	public F fetch(String ...readDetails);
	public boolean write(Q ...writeDetails);
	public boolean delete(String ...details);
	public boolean update(String ...details); 

}
