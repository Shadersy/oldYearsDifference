package ru.gvozdilin.springmvc1.springmvcwebapp2.model;

import java.io.Serializable;

public class UserForm implements Serializable{
	
	private long firstUserId;
	private long secondUserId;
	
	public void setFirstUserId(long firstUserId) {
		this.firstUserId = firstUserId;
	}
	
	public long getFirstUserId() {
		return firstUserId;
	}
	
	public void setSecondUserId(long secondUserId) {
		this.secondUserId = secondUserId;
	}
	
	public long getSecondUserId() {
		return secondUserId;
	}
}
