package model;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

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
			_account.setLoggedUsername(username);
			_account.loadFriendsList();
			System.out.println("HEREEEEE"+_account.getFriendsList());


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
				props.put("mail.smtp.user", "virtualmusgame@gmail.com");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "465");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.socketFactory.fallback", "false");
				SecurityManager security = System.getSecurityManager();
				try {
					Authenticator auth = new SMTPAuthenticator();
					Session session = Session.getInstance(props, auth);
					MimeMessage msg = new MimeMessage(session);
					msg.setText("Hello user, your password is: "+pass);
					msg.setSubject("Recovery Password");
					msg.setFrom(new InternetAddress("virtualmusgame@gmail.com"));
					msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
					Transport.send(msg);
					System.out.println("Message send Successfully");
				}

				catch (Exception mex) {
					mex.printStackTrace();
				}
			}
	}
	public class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("virtualmusgame@gmail.com", "virtualMus10");
		}
	}
	
	public Account getCurrentUser()
	{
		return this._account;
	}
	public boolean addFriend(String user1) throws SQLException 
	{
		TAccount _user1=new TAccount(user1,null,null);
		return _account.addFriend(_user1);
	}
	public List<String> getFriends()
	{
		return _account.getFriendsList();
	}
}
