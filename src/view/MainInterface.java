package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;

@SuppressWarnings("serial")
public class MainInterface extends JFrame{
	private Controller ctrl;
	public FriendInterface _friend;
	public SettingsInterface _settings;
	public RequestInterface _request;
	public GameInterface _game;
	public AccountInterface _account;
		
	public JPanel cardPanel;
	public CardLayout clayout;
	
	public MainInterface(Controller c){
		this.ctrl=c;
		
		initGUI();
		
	}
	
	private void initGUI() {

		clayout = new CardLayout();
		cardPanel = new JPanel(clayout);
		setContentPane(cardPanel);

	
		_account = new AccountInterface();
		_settings = new SettingsInterface();
		_game = new GameInterface();
		
		cardPanel.add(_account, "account");
		cardPanel.add(_settings, "settings");
		cardPanel.add(_game, "game");
		
		clayout.show(cardPanel, "account");
		
				
		
		//DIMENSIONS
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) (screenSize.height * 0.5);
		int width = (int) (screenSize.width * 0.5);
		setPreferredSize(new Dimension(width, height));
		
		setTitle("Virtual Mus L");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}
	
	private static Image loadImage(String path) {
        return Toolkit.getDefaultToolkit().createImage(path);
    }


}