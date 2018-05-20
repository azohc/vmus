package model;

import java.sql.SQLException;

import dao.DAOFacade;

public class Account {
	String loggedUsername;
	TFriends addedFriends;
	
	DAOFacade _dao;
	
	public Account(DAOFacade dao)
	{
		_dao = dao;
		addedFriends = new TFriends();
	}
	public void setLoggedUsername(String user)
	{
		loggedUsername = user;
	}
	public String getLoggedUsername()
	{
		return this.loggedUsername;
	}
	public boolean checkUser(String username,String password) throws SQLException
	{
		return _dao.checkUser(username, password);
	}
	public void addUser(TAccount _tAccount) throws SQLException {
		_dao.addNewUser(_tAccount);
	}
	public String getPassByEmail(String email) throws SQLException{
		return _dao.getPassByEmail(email);
	}
}
