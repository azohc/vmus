package controller;

import view.SettingsInterface;

public class Main {

	public static void main(String[] args) {
Controller ctrl;
ctrl=Controller.getInstance();
SettingsInterface settings=new SettingsInterface(ctrl);
	}

}
