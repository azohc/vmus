package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import dao.DAOFacade;
import dao.DatabaseDAO;

public class Account {
	String loggedUsername;
	TFriends addedFriends;
	private List<String> friends;

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
	public boolean addFriend(TAccount _user) throws SQLException
	{ friends.add(_user.getUsername());
		TAccount aux=new TAccount(this.getLoggedUsername(),null,null);
		if(!_dao.checkFriendship(aux, _user))
		{_dao.addFriend(aux, _user);
		return true;
		}
		return false;
	}
	public List<String> getFriendsList()
	{
		return this.friends;
	}
	public void loadFriendsList() throws SQLException
	{
		List<String> aux_friends=DatabaseDAO.getInstance().getUserFriends(new TAccount(this.loggedUsername,null,null));
	this.friends=new ArrayList<String>(aux_friends);
	}

}
