package model;

import java.sql.SQLException;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
	
	public void sendEmail(Session session, String toEmail, String subject, String body){
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("virtualmusgame@gmail.com", "NoReply-JD"));

	      msg.setReplyTo(InternetAddress.parse("virtualmusgame@gmail.com", false));

	      msg.setSubject(subject, "UTF-8");

	      msg.setText(body, "UTF-8");

	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      System.out.println("Message is ready");
    	  Transport.send(msg);  

	      System.out.println("EMail Sent Successfully!!");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}
}
