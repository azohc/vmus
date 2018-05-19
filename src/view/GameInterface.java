package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameInterface extends JPanel{

	public JPanel mainPanel;
	
	public GameInterface() {
		this.setLayout(new BorderLayout());
		mainPanel = new JPanel(new BorderLayout());
		this.setPreferredSize(new Dimension(671, 450));
		initGUI();
		this.add(mainPanel);
	}
	
	private void initGUI() {
		JPanel panelPresentacion = new JPanel();
		JLabel lblNewLabel = new JLabel("Welcome to virtual mus!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(190, 5, 285, 60);
		panelPresentacion.add(lblNewLabel);
		mainPanel.add(panelPresentacion, BorderLayout.NORTH);
		
		
		JPanel gamesButtons = new JPanel();
		gamesButtons.setPreferredSize(new Dimension(671, 300));
		gamesButtons.setLayout(new BoxLayout(gamesButtons, BoxLayout.X_AXIS));
		gamesButtons.setPreferredSize(new Dimension(671, 200));
		
		ImageIcon type1_2 = new ImageIcon(loadImage("2Player.png"));
		Image typei1_2 = type1_2.getImage();
		Image typei2_2 = typei1_2.getScaledInstance(190, 190, java.awt.Image.SCALE_SMOOTH);
		ImageIcon type2_2 = new ImageIcon(typei2_2);
		JButton TwoPlayers = new JButton(type2_2);
		gamesButtons.add(TwoPlayers);
		
		ImageIcon type1_4 = new ImageIcon(loadImage("4Player.png"));
		Image typei1_4 = type1_4.getImage();
		Image typei2_4 = typei1_4.getScaledInstance(190, 190, java.awt.Image.SCALE_SMOOTH);
		ImageIcon type2_4 = new ImageIcon(typei2_4);
		JButton FourPlayers = new JButton(type2_4);
		gamesButtons.add(FourPlayers);
		
		ImageIcon type1_1 = new ImageIcon(loadImage("1Player.png"));
		Image typei1_1 = type1_1.getImage();
		Image typei2_1 = typei1_1.getScaledInstance(190, 190, java.awt.Image.SCALE_SMOOTH);
		ImageIcon type2_1 = new ImageIcon(typei2_1);
		JButton SinglePlayer = new JButton(type2_1);
		gamesButtons.add(SinglePlayer);
		
		mainPanel.add(gamesButtons);
		
		JPanel lowerPanel = new JPanel();
		lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.X_AXIS));
		mainPanel.add(lowerPanel, BorderLayout.SOUTH);
		
		JPanel toolbar = new JPanel();
		toolbar.setLayout(new BoxLayout(toolbar, BoxLayout.X_AXIS));
		
		ImageIcon set1 = new ImageIcon(loadImage("settings-512.png"));
		Image img1 = set1.getImage();
		Image img2 = img1.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon set2 = new ImageIcon(img2);
		JButton settings = new JButton(set2);
				
		toolbar.add(settings);
		
		ImageIcon fri1 = new ImageIcon(loadImage("655186-200.png"));
		Image frii1 = fri1.getImage();
		Image frii2 = frii1.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon fri2 = new ImageIcon(frii2);
		JButton friends = new JButton(fri2);
				
		toolbar.add(friends);
			
		ImageIcon req1 = new ImageIcon(loadImage("request.png"));
		Image reqi1 = req1.getImage();
		Image reqi2 = reqi1.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon req2 = new ImageIcon(reqi2);
		JButton request = new JButton(req2);
			
		toolbar.add(request);
		
		toolbar.add(Box.createRigidArea(new Dimension(136,0)));
		
		ImageIcon out1 = new ImageIcon(loadImage("log_out.png"));
		Image outi1 = out1.getImage();
		Image outi2 = outi1.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon out2 = new ImageIcon(outi2);
		JButton log_out = new JButton(out2);
			
		toolbar.add(log_out);
		
		mainPanel.add(toolbar, BorderLayout.SOUTH);
		
	}
	
	private static Image loadImage(String path) {
        return Toolkit.getDefaultToolkit().createImage(path);
    }
}
