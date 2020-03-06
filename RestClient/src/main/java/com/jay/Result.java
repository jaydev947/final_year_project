package com.jay;

public class Result {
	
	int error_code;
	String error_message;
	String long_msg;
	String short_msg;
	
	public int getError_code() {
		return error_code;
	}

	public String getError_message() {
		return error_message;
	}

	public String getLong_msg() {
		return long_msg;
	}

	public String getShort_msg() {
		return short_msg;
	}



	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	public void setLong_msg(String long_msg) {
		this.long_msg = long_msg;
	}

	public void setShort_msg(String short_msg) {
		this.short_msg = short_msg;
	}

	public Result() {
	}
	
	public Result(int error_code, String error_message, String long_msg, String short_msg) {
		super();
		this.error_code = error_code;
		this.error_message = error_message;
		this.long_msg = long_msg;
		this.short_msg = short_msg;
	}
	

}
