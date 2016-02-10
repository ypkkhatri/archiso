package com.yog.mt.enums;

public enum UserType {
	ADMIN("A", "Admin"),
	USER("U", "User");
	
	private String code;
	private String title;
	
	private UserType(String code, String title) {
		this.code = code;
		this.title = title;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getTitle() {
		return title;
	}
}
