package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import enums.Language;
import model.TAccount;

public class DAOFacade {
	private static DatabaseDAO database = null;
	private static TextDAO textFile;
		
	public DAOFacade()
	{
		database = DatabaseDAO.getInstance();
		try {
			textFile=new TextDAO("set.ini");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean checkUser(String username, String password) throws SQLException {
		return database.checkUser(username, password);
	}
	public boolean checkUsernameExists(String username) throws SQLException {
		return database.checkUsernameExists(username);
	}
	public String getPassByEmail(String email) throws SQLException {
		return database.getPassByEmail(email);
	}
	public void addNewUser(TAccount _user) throws SQLException
	{
		database.addNewUser(_user);
	}
	public void loadSettings() throws IOException
	{
		textFile.loadFile();
	}
	public int getVolume()
	{
		return textFile.getVolume();
	}
	public Language getLang()
	{
		return textFile.getLang();
	}
	public boolean getNotif()
	{
		return textFile.getNotif();
	}
	public void addFriend(TAccount user1,TAccount user2)
	{
		database.addFriend(user1, user2);
	}
	public boolean checkFriendship(TAccount _user1, TAccount _user2) throws SQLException 
		{
			return database.checkFriendship(_user1, _user2);
		}

}
