package controller;

import view.MainInterface;

public class Controller {
	private static Controller instance;
	private MainInterface _mainInterface;
	
	private Controller () {
		
	}
	
	public static Controller getInstance() {
		if(instance == null)
			instance = new Controller();
		return instance;
	}

}
