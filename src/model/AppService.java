package model;

import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

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
	
	public void recoverPass(String email) throws SQLException{
		
			String pass = _account.getPassByEmail(email);
			if(pass.equals("User not valid")) {
				System.out.println("User not valid");
			}
			else
			{
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
				props.put("mail.smtp.port", "587"); //TLS Port
				props.put("mail.smtp.auth", "true"); //enable authentication
				props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
				
				   //create Authenticator object to pass in Session.getInstance argument
				Authenticator auth = new Authenticator() {
					//override the getPasswordAuthentication method
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("virtualmusgame@gmail.com", "virtualMus10");
					}
				};
				Session session = Session.getInstance(props, auth);
				
				_account.sendEmail(session, email,"Password recovery", pass);
			}
	}
}
