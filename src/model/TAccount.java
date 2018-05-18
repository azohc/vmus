package model;

import java.sql.SQLException;

import dao.DAOFacade;

public class TAccount {
	String username,email,pass;
public TAccount(String username,String email,String pass) throws SQLException
{
	this.username=username;
	this.email=email;
	this.pass=pass;
	this.save();
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
public void save() throws SQLException
{
	DAOFacade.addNewUser(username, email, pass);
}
}
