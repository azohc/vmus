package controller;

import view.LoginInterface;
import view.RegisterInterface;
import view.SettingsInterface;

public class Main {

	public static void main(String[] args) {
Controller ctrl;
ctrl=Controller.getInstance();
//SettingsInterface settings=new SettingsInterface(ctrl);
LoginInterface l=new LoginInterface(ctrl);
//RegisterInterface r =new RegisterInterface(ctrl);
	}

}
