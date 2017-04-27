package com.ckt.ckttodo.pojo;

public class Member {
	private int mem_id;
	private String mem_name;
	private String mem_password;
	private String mem_email;
	private String mem_level;
	private String token;
	private String token_create_time;
	public Member member() {
		return new Member();
	}
	public int getMem_id() {
		return mem_id;
	}

	public void setMem_id(int mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_password() {
		return mem_password;
	}

	public void setMem_password(String mem_password) {
		this.mem_password = mem_password;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_level() {
		return mem_level;
	}

	public void setMem_level(String mem_level) {
		this.mem_level = mem_level;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getToken_create_time() {
		return token_create_time;
	}

	public void setToken_create_time(String token_create_time) {
		this.token_create_time = token_create_time;
	}
}
