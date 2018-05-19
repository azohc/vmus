package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import controller.Controller;

@SuppressWarnings("serial")
public class RequestInterface extends JPanel {

	private JPanel mainPanel;
	
	
	
	public RequestInterface() {
		
		mainPanel = new JPanel(new BorderLayout());
		initGUI();
		this.add(mainPanel);
	}
	
	private void initGUI() {
		
		JPanel panelPresentacion = new JPanel();
		JLabel lblNewLabel = new JLabel("Request");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(190, 5, 285, 60);
		panelPresentacion.add(lblNewLabel);
		mainPanel.add(panelPresentacion, BorderLayout.NORTH);
		
		Border b = BorderFactory.createLineBorder(Color.BLACK, 2);
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.X_AXIS));
		mainPanel.add(textPanel);
		
		JTextArea friendreq = new JTextArea();
		friendreq.setEditable(false);
		friendreq.setLineWrap(true);
		friendreq.setText("Friend notifications");
		friendreq.setWrapStyleWord(true);
		JScrollPane area3 = new JScrollPane(friendreq);
		area3.setPreferredSize(new Dimension(200, 200));
		area3.setBorder(BorderFactory.createTitledBorder(b, "Friend"));
		
		JTextArea duoreq = new JTextArea();
		duoreq.setEditable(false);
		duoreq.setLineWrap(true);
		duoreq.setText("Duo Game notifications");
		duoreq.setWrapStyleWord(true);
		
		JScrollPane area2 = new JScrollPane(duoreq);
		area2.setPreferredSize(new Dimension(200, 200));
		area2.setBorder(BorderFactory.createTitledBorder(b, "DuoGame"));
		
		JTextArea groupreq = new JTextArea();
		groupreq.setEditable(false);
		groupreq.setLineWrap(true);
		groupreq.setText("Group Game notifications");
		groupreq.setWrapStyleWord(true);
		
		JScrollPane area1 = new JScrollPane(groupreq);
		area1.setPreferredSize(new Dimension(200, 200));
		area1.setBorder(BorderFactory.createTitledBorder(b, "GroupGame"));
		
		textPanel.add(area3);
		textPanel.add(area2);
		textPanel.add(area1);
		
		JPanel backButton = new JPanel();
		
		ImageIcon back1 = new ImageIcon(loadImage("back1.png"));
		Image  back2 =  back1.getImage();
		Image  back3 =  back2.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		ImageIcon  back4 = new ImageIcon(back3);
		JButton  back = new JButton (back4);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Controller.getInstance().changeToGamePanel();
		   }
		});
		backButton.add(back);
		mainPanel.add(backButton, BorderLayout.PAGE_END);	
	}

	private static Image loadImage(String path) {
        return Toolkit.getDefaultToolkit().createImage(path);
    }
}
