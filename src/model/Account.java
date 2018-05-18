package model;

import java.sql.SQLException;

import dao.DAOFacade;

public class Account {
	String loggedUsername;
	public Account(String u)
	{
		this.loggedUsername=u;
	}
	public String getLoggedUsername()
	{
		return this.loggedUsername;
	}
public boolean checkUser(String username,String password) throws SQLException
{
	return DAOFacade.checkUser(username, password);
}
}
