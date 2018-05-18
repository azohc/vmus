package model;

import java.sql.SQLException;

import dao.DAOFacade;
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
	
	public AppService()
	{
		DAOFacade f = new DAOFacade();
		_account = new Account(f);
		_settings = new Settings(f);
		_requests = new Requests(f);
		_friends = new Friends(f);
		_game = new Game(f);
	}
	
	public void applySettings(int vol,Language lang,boolean notif)
	{ 
		
	}
	
	public  void registerNewUser(String username, String email, String password) throws SQLException
	{
		_tAccount=new TAccount(username,email,password);
		
		if(!_account.checkUser(username, password))
		{
			_account.addUser(_tAccount);
		}
	}
	
	public boolean loginUser(String username,String password) throws SQLException
	{
		if( _account.checkUser(username, password) )
		{
			
			return true;
		}
		return false;
	}
}
