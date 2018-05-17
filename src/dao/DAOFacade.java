package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import enums.Language;

public class DAOFacade {
	private static DatabaseDAO database = null;
	private static TextDAO textFile;
	static {
		database = DatabaseDAO.getInstance();
		try {
			textFile=new TextDAO("set.ini");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// private static TextDAO text=null;
	public DAOFacade() {
	}

	public static boolean checkUser(String username, String password) throws SQLException {
return database.checkUser(username, password);
	}
	public static boolean checkUsernameExists(String username) throws SQLException {
return database.checkUsernameExists(username);
	}

	public static void addNewUser(String username, String password,String email) throws SQLException {

		database.addNewUser(username, password,email);
	}
	public static void loadSettings() throws IOException
	{
		textFile.loadFile();
	}
public static int getVolume()
{
	return textFile.getVolume();
}
public static Language getLang()
{
	return textFile.getLang();
}
public static boolean getNotif()
{
	return textFile.getNotif();
}
//	public static void main(String[] args) throws SQLException, IOException {
//		//System.out.println(DAOFacade.checkUsernameExists("zz"));
//		System.out.println(DAOFacade.getVolume());
//		System.out.println(DAOFacade.getNotif());
//		System.out.println(DAOFacade.getLang());
//		DAOFacade.loadSettings();
//		System.out.println(DAOFacade.getVolume());
//		System.out.println(DAOFacade.getNotif());
//		System.out.println(DAOFacade.getLang());
//
//	
//	}

}
