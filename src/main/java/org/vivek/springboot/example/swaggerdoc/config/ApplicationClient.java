package org.vivek.springboot.example.swaggerdoc.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationClient {
	 private String username;
	    private String password;
	    private String[] roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}
}