package com.auction.couchdb.web.dto;

/**
 * Created by hsupar on 9/16/2016.
 */
public class UserDto {

	private String email;

	private String name;

	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDto{" + "email='" + email + "', name='" + name
			+ "', password='" + password + "'}";
	}
}
