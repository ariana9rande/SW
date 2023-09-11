package com.hjh.model;

public class Member
{
	private long id;
	private String email;
	private String password;
	private String name;
	private String registerDateTime;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegisterDateTime() {
		return registerDateTime;
	}
	public void setRegisterDateTime(String registerDateTime) {
		this.registerDateTime = registerDateTime;
	}
	
	public void changePassword(String oldPassword, String newPassword)
	{
		if(!password.equals(oldPassword))
		{
			throw new WrongIdPasswordException();
		}
		this.password = newPassword;
	}
}
