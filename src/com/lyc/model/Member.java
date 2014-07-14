package com.lyc.model;

public class Member {
	private long id;
	private String firstName;
	public Member(String firstName){
		this.firstName = firstName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
}
