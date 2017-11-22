package com.sqlstaff.domain;

public class UserVO {
	private int user_id;
	private String user_email;
	private String user_pw;
	private String user_name;
	private String user_auto_login;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
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
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_auto_login() {
		return user_auto_login;
	}
	public void setUser_auto_login(String user_auto_login) {
		this.user_auto_login = user_auto_login;
	}
	
	@Override
	public String toString() {
		return "UserVO [user_id=" + user_id + ", user_email=" + user_email + ", user_pw=" + user_pw + ", user_name="
				+ user_name + ", user_auto_login=" + user_auto_login + "]";
	}
}