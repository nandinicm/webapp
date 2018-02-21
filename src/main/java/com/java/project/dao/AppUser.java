package com.java.project.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "users" )
public class AppUser {

	@Id
	private String id;
	private String username;
	private String password;

	public AppUser()
	{
	}

    public String getId() {
        return id;
    }

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

    @Override
	public String toString()
	{
		return String.format("AppUser[id=%s, username='%s']", id, username);
	}

}
