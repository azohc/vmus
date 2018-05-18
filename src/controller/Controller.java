package controller;

import java.sql.SQLException;

import javax.swing.SwingUtilities;

import model.AppService;
import view.MainInterface;

public class Controller {
	
	private static Controller instance;
	
	private static MainInterface _mainInterface;
	private static AppService appService;
	
	private Controller () {
		appService=new AppService();
		_mainInterface=new MainInterface();
	}
	
	public static Controller getInstance() {
		if(instance == null)
			instance = new Controller();
		return instance;
	}
	
	public   static void registerNewUser(String username, String email,String password) throws SQLException
	{appService.registerNewUser(username, email, password);
		
	}
	public static boolean loginUser(String username,String password) throws SQLException
	{
		return appService.loginUser(username, password);
	}
	
	public static void changeToGamePanel()
	{
		_mainInterface.clayout.show(_mainInterface.cardPanel, "game");
	}

	


}
