package model;

import java.sql.SQLException;

import enums.Language;

public class AppService {

	private Account _account;
	private Game _game;
	private Settings _settings;
	private Requests _requests;
	private Friends _friends;
	
	//DATA TRANSFER OBJECTS
	private TAccount _tAccount;
	private TGame _tGame;
	private TSettings _tSettings;
	private TRequest _tRequest;
	private TFriends _tFriends;
	
	public void applySettings(int vol,Language lang,boolean notif)
	{ _settings=new Settings();
	
		
	}
	
	public  void registerNewUser(String username, String email, String password) throws SQLException
	{
		_tAccount=new TAccount(username,email,password);
	}
	
	public boolean loginUser(String username,String password) throws SQLException
	{
		_account=new Account(username);
		return _account.checkUser(username, password);
	}
}
