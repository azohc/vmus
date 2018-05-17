package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainInterface extends JFrame{

	public FriendInterface _friend;
	public SettingsInterface _settings;
	public RequestInterface _request;
	public GameInterface _game;
	public AccountInterface _account;
		
	public JPanel cardPanel;
	public CardLayout clayout;
	
	public MainInterface(){
		
		initGUI();
		
	}
	
	private void initGUI() {

		clayout = new CardLayout();
		cardPanel = new JPanel(clayout);
		setContentPane(cardPanel);

	
		_account = new AccountInterface();
		cardPanel.add(_account, "account");
		clayout.show(cardPanel, "account");
		
		//TODO add more interfaces to card layout, and card layout to game interface -> for different gametypes?
				
		
		//DIMENSIONS
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) (screenSize.height * 0.5);
		int width = (int) (screenSize.width * 0.4);
		setPreferredSize(new Dimension(width, height));
		
		setTitle("Virtual Mus L");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}
	
	private static Image loadImage(String path) {
        return Toolkit.getDefaultToolkit().createImage(path);
    }


}