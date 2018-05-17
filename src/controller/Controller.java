package controller;

import model.AppService;
import view.MainInterface;

public class Controller {
	
	private static Controller instance;
	
	private MainInterface _mainInterface;
	private AppService appService;
	
	private Controller () {
		
	}
	
	public static Controller getInstance() {
		if(instance == null)
			instance = new Controller();
		return instance;
	}
	
	public  void registerNewUser(String username, String password)
	{
		
	}
	


}
