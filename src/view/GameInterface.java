package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

@SuppressWarnings("serial")
public class GameInterface extends JPanel {

	public JPanel mainPanel;
	public JPanel settings;
	public JPanel friends;
	private CardLayout cl;

	public GameInterface() {

		cl = new CardLayout();
		setLayout(cl);
		mainPanel = new JPanel(new BorderLayout());
		add(mainPanel, "main");
		add(createTwoPlayerPanel(), "2p");
		add(createFourPlayerPanel(), "4p");
		add(createRandomGamePanel(), "rnd");
		initGUI();
		cl.show(this, "main");
	}

	private void initGUI() {
		JPanel panelPresentacion = new JPanel();
		JLabel lblNewLabel = new JLabel("Welcome to virtual mus!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(190, 5, 285, 60);
		panelPresentacion.add(lblNewLabel);
		mainPanel.add(panelPresentacion, BorderLayout.NORTH);

		JPanel gamesButtons = new JPanel(new BorderLayout());
		gamesButtons.setPreferredSize(new Dimension(671, 300));
	//	gamesButtons.setLayout(new BoxLayout(gamesButtons, BoxLayout.X_AXIS));

		ImageIcon type1_2 = new ImageIcon(loadImage("2Players.png"));
		Image typei1_2 = type1_2.getImage();
		Image typei2_2 = typei1_2.getScaledInstance(190, 190, java.awt.Image.SCALE_SMOOTH);
		ImageIcon type2_2 = new ImageIcon(typei2_2);
		JButton TwoPlayers = new JButton(type2_2);
		TwoPlayers.setToolTipText("2Player Game");
		gamesButtons.add(TwoPlayers, BorderLayout.LINE_START);
		TwoPlayers.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switchPanel("2p");
				;
			}

		});

		ImageIcon type1_4 = new ImageIcon(loadImage("4Player.png"));
		Image typei1_4 = type1_4.getImage();
		Image typei2_4 = typei1_4.getScaledInstance(190, 190, java.awt.Image.SCALE_SMOOTH);
		ImageIcon type2_4 = new ImageIcon(typei2_4);
		JButton FourPlayers = new JButton(type2_4);
		gamesButtons.add(FourPlayers, BorderLayout.LINE_END);
		FourPlayers.setToolTipText("4Player Game");
		FourPlayers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				switchPanel("4p");
				;
			}

		});

		ImageIcon type1_1 = new ImageIcon(loadImage("1Player.png"));
		Image typei1_1 = type1_1.getImage();
		Image typei2_1 = typei1_1.getScaledInstance(190, 190, java.awt.Image.SCALE_SMOOTH);
		ImageIcon type2_1 = new ImageIcon(typei2_1);
		JButton SinglePlayer = new JButton(type2_1);
		gamesButtons.add(SinglePlayer, BorderLayout.CENTER);
		SinglePlayer.setToolTipText("Random Game");
		SinglePlayer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				switchPanel("rnd");
				;
			}

		});


		mainPanel.add(gamesButtons, BorderLayout.CENTER);

		JPanel lowerPanel = new JPanel();
		lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.X_AXIS));
		mainPanel.add(lowerPanel, BorderLayout.SOUTH);

		JPanel toolbar = new JPanel();
		toolbar.setLayout(new BoxLayout(toolbar, BoxLayout.X_AXIS));

		ImageIcon set1 = new ImageIcon(loadImage("settings.png"));
		Image img1 = set1.getImage();
		Image img2 = img1.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon set2 = new ImageIcon(img2);
		JButton settings = new JButton(set2);
		settings.setToolTipText("Settings");
		settings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.getInstance().changeToSettingsPanel();				
			}
			
		});
		toolbar.add(settings);

		ImageIcon fri1 = new ImageIcon(loadImage("friends.png"));
		Image frii1 = fri1.getImage();
		Image frii2 = frii1.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon fri2 = new ImageIcon(frii2);
		JButton friends = new JButton(fri2);
		friends.setToolTipText("Friends");
		friends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.getInstance().changeToFriendPanel();				
			}
			
		});
		toolbar.add(friends);

		ImageIcon req1 = new ImageIcon(loadImage("request.png"));
		Image reqi1 = req1.getImage();
		Image reqi2 = reqi1.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon req2 = new ImageIcon(reqi2);
		JButton request = new JButton(req2);
		request.setToolTipText("Requests");
		request.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.getInstance().changeToRequestPanel();				
			}
			
		});
		toolbar.add(request);

		toolbar.add(Box.createRigidArea(new Dimension(136, 0)));

		ImageIcon out1 = new ImageIcon(loadImage("LogOut.png"));
		Image outi1 = out1.getImage();
		Image outi2 = outi1.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon out2 = new ImageIcon(outi2);
		JButton log_out = new JButton(out2);
		log_out.setToolTipText("Log out");
		log_out.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				Controller.getInstance().changeToAccountPanel();
			}
	});
		toolbar.add(log_out);

		mainPanel.add(toolbar, BorderLayout.SOUTH);

	}

	private static Image loadImage(String path) {
		return Toolkit.getDefaultToolkit().createImage(path);
	}

	private JPanel createTwoPlayerPanel() {

		JPanel twoPPanel = new JPanel();
		twoPPanel.setLayout(new FlowLayout());

		JButton back = new JButton("Back");
		back.setBounds(0, 0, 30, 50);
		twoPPanel.add(back);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel("main");
			}
		});

		JButton searchGame = new JButton("Find 2P Game");
		searchGame.setBounds(111, 222, 33, 88);
		twoPPanel.add(searchGame);
		searchGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO try to implement game search
			}
		});

		JButton createGame = new JButton("Create 2P Game");
		createGame.setBounds(111, 233, 33, 88);
		twoPPanel.add(createGame);
		createGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO search for friend, then create request : RequestType.DUOGAME &&
				// Account.getCurrentUser
			}
		});

		return twoPPanel;
	}

	private JPanel createFourPlayerPanel() {

		JPanel fourPPanel = new JPanel();
		fourPPanel.setLayout(new FlowLayout());

		JButton back = new JButton("Back");
		back.setBounds(0, 0, 30, 50);
		fourPPanel.add(back);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel("main");
			}
		});

		JButton searchGame = new JButton("Find 4P Game");
		searchGame.setBounds(111, 222, 33, 88);
		fourPPanel.add(searchGame);
		searchGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO try to implement game search
			}
		});

		JButton createGame = new JButton("Create 4P Game");
		createGame.setBounds(111, 233, 33, 88);
		fourPPanel.add(createGame);
		createGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO search for friend, then create request : RequestType.GROUPGAME && Account.getCurrentUser
			}
		});

		return fourPPanel;
	}
	
	private JPanel createRandomGamePanel() {
		
		JPanel rndPanel = new JPanel();
		rndPanel.setLayout(new FlowLayout());

		
		JButton back = new JButton("Back");
		back.setBounds(0 , 0, 30, 50);
		rndPanel.add(back);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel("main");
			}
		});
		
		JButton searchGame = new JButton("Find Random Game");
		searchGame.setBounds(111, 222, 33, 88);
		rndPanel.add(searchGame);
		searchGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO try to implement game search
			}
		});
			
		
		return rndPanel;
	}

	private void switchPanel(String panel) {
		cl.show(this, panel);
	}

}
