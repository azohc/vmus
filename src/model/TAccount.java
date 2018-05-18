package model;

import java.sql.SQLException;

public class TAccount {
	String username,email,pass;

	public TAccount(String username,String email,String pass) throws SQLException
	{
		this.username=username;
		this.email=email;
		this.pass=pass;
	}
	public void setPass(String password) {
		this.pass = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername()
	{
		return this.username;
	}
	public String getEmail()
	{
		return this.email;
	}
	public String getPassword()
	{
		return this.pass;
	}

}
