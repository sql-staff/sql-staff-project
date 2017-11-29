package com.sqlstaff.dto;

public class LoginDTO {
	private String user_email;
	private String user_pw;
	private String user_auto_login;
	
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_auto_login() {
		return user_auto_login;
	}
	public void setUser_auto_login(String user_auto_login) {
		this.user_auto_login = user_auto_login;
	}
	
	@Override
	public String toString() {
		return "LoginDTO [user_email=" + user_email + ", user_pw=" + user_pw + ", user_auto_login=" + user_auto_login
				+ "]";
	}
}
