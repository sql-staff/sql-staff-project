package com.sqlstaff.domain;

public class ShareVO {
	private int share_id;
	private int user_id;
	private String share_link;
	private String share_query;
	
	public int getShare_id() {
		return share_id;
	}
	public void setShare_id(int share_id) {
		this.share_id = share_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getShare_link() {
		return share_link;
	}
	public void setShare_link(String share_link) {
		this.share_link = share_link;
	}
	public String getShare_query() {
		return share_query;
	}
	public void setShare_query(String share_query) {
		this.share_query = share_query;
	}
	
	@Override
	public String toString() {
		return "ShareVO [share_id=" + share_id + ", user_id=" + user_id + ", share_link=" + share_link
				+ ", share_query=" + share_query + "]";
	}
}
