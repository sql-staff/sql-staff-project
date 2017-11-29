package com.sqlstaff.domain;

import java.sql.Date;

public class UserLogVO {
	private int log_id;
	private int user_id;
	private String log_ip;
	private Date log_dt;
	
	public int getLog_id() {
		return log_id;
	}
	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getLog_ip() {
		return log_ip;
	}
	public void setLog_ip(String log_ip) {
		this.log_ip = log_ip;
	}
	public Date getLog_dt() {
		return log_dt;
	}
	public void setLog_dt(Date log_dt) {
		this.log_dt = log_dt;
	}
	
	@Override
	public String toString() {
		return "UserLogVO [log_id=" + log_id + ", user_id=" + user_id + ", log_ip=" + log_ip + ", log_dt=" + log_dt
				+ "]";
	}
}
