package controller;

import javax.swing.SwingUtilities;

import view.MainInterface;

public class Main {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainInterface();
			}
		});
	}

}
