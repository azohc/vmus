package controller;

import java.sql.SQLException;

import javax.swing.SwingUtilities;

import model.AppService;
import view.MainInterface;

public class Controller {
	
	private static Controller instance;
	
	private MainInterface _mainInterface;
	private AppService appService;
	
	private Controller () 
	{
		appService=new AppService();
		_mainInterface=new MainInterface(this);
	}
	
	public static Controller getInstance() {
		if(instance == null)
			instance = new Controller();
		return instance;
	}
	
	public  void registerNewUser(String username, String email,String password) throws SQLException
	{
		appService.registerNewUser(username, email, password);
		
	}
	public boolean loginUser(String username,String password) throws SQLException
	{
		return appService.loginUser(username, password);
	}
	
	public void changeToGamePanel()
	{
		_mainInterface.clayout.show(_mainInterface.cardPanel, "game");
	}

	


}
