package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.Controller;

@SuppressWarnings("serial")
public class FriendInterface extends JPanel {

	private CardLayout cl;
	private JTable table;
	public static JTextArea friendsList; 
	JTextArea searchFriendTextArea;

	public FriendInterface() throws SQLException, InterruptedException {

		cl = new CardLayout();
		setLayout(cl);
		add(mainPanel(), "mainPanel");
		add(addFriend(), "addFriend");
		cl.show(this, "addFriend");

		// mainPanel();
	}

	private JPanel mainPanel() {
		JPanel mainPanel;
		mainPanel = new JPanel(new BorderLayout());

		JPanel panelPresentacion = new JPanel();
		JLabel lblNewLabel = new JLabel("Friends");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(190, 5, 285, 60);
		panelPresentacion.add(lblNewLabel);
		mainPanel.add(panelPresentacion, BorderLayout.NORTH);

		JPanel friendsButtons = new JPanel();
		friendsButtons.setPreferredSize(new Dimension(671, 300));
		friendsButtons.setLayout(new BoxLayout(friendsButtons, BoxLayout.X_AXIS));
		friendsButtons.setPreferredSize(new Dimension(671, 200));

		ImageIcon type1_2 = new ImageIcon(loadImage("+.png"));
		Image typei1_2 = type1_2.getImage();
		Image typei2_2 = typei1_2.getScaledInstance(135, 135, java.awt.Image.SCALE_SMOOTH);
		ImageIcon type2_2 = new ImageIcon(typei2_2);
		JButton friends = new JButton(type2_2);
		friendsButtons.add(friends);

		ImageIcon search1 = new ImageIcon(loadImage("search.png"));
		Image search2 = search1.getImage();
		Image search3 = search2.getScaledInstance(135, 135, java.awt.Image.SCALE_SMOOTH);
		ImageIcon search4 = new ImageIcon(search3);
		JButton search = new JButton(search4);
		friendsButtons.add(search);

		ImageIcon petition1 = new ImageIcon(loadImage("petition.png"));
		Image petition2 = petition1.getImage();
		Image petition3 = petition2.getScaledInstance(135, 135, java.awt.Image.SCALE_SMOOTH);
		ImageIcon petition4 = new ImageIcon(petition3);
		JButton petition = new JButton(petition4);
		friendsButtons.add(petition);

		ImageIcon myfriends1 = new ImageIcon(loadImage("friends1.png"));
		Image myfriends2 = myfriends1.getImage();
		Image myfriends3 = myfriends2.getScaledInstance(135, 135, java.awt.Image.SCALE_SMOOTH);
		ImageIcon myfriends4 = new ImageIcon(myfriends3);
		JButton myfriends = new JButton(myfriends4);
		friendsButtons.add(myfriends);

		JPanel backButton = new JPanel();

		ImageIcon back1 = new ImageIcon(loadImage("back1.png"));
		Image back2 = back1.getImage();
		Image back3 = back2.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		ImageIcon back4 = new ImageIcon(back3);
		JButton back = new JButton(back4);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Controller.getInstance().changeToGamePanel();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		backButton.add(back);

		mainPanel.add(backButton, BorderLayout.PAGE_END);
		mainPanel.add(friendsButtons);
		return mainPanel;
	}

	public JPanel addFriend() throws SQLException, InterruptedException {
		JPanel mainPanel;
		mainPanel = new JPanel(new BorderLayout());

		JPanel panelPresentacion = new JPanel();
		JLabel lblNewLabel = new JLabel("Search a friend");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(190, 5, 285, 60);
		panelPresentacion.add(lblNewLabel);
		mainPanel.add(panelPresentacion, BorderLayout.NORTH);

		JPanel friendsButtons = new JPanel();
		friendsButtons.setPreferredSize(new Dimension(671, 300));
		friendsButtons.setPreferredSize(new Dimension(671, 200));

		ImageIcon type1_2 = new ImageIcon(loadImage("ss+.png"));
		Image typei1_2 = type1_2.getImage();
		Image typei2_2 = typei1_2.getScaledInstance(135, 135, java.awt.Image.SCALE_SMOOTH);
		ImageIcon type2_2 = new ImageIcon(typei2_2);

		ImageIcon search1 = new ImageIcon(loadImage("search.png"));
		Image search2 = search1.getImage();
		Image search3 = search2.getScaledInstance(135, 135, java.awt.Image.SCALE_SMOOTH);
		ImageIcon search4 = new ImageIcon(search3);

		ImageIcon petition1 = new ImageIcon(loadImage("petition.png"));
		Image petition2 = petition1.getImage();
		Image petition3 = petition2.getScaledInstance(135, 135, java.awt.Image.SCALE_SMOOTH);
		ImageIcon petition4 = new ImageIcon(petition3);

		ImageIcon myfriends1 = new ImageIcon(loadImage("friends1.png"));
		Image myfriends2 = myfriends1.getImage();
		Image myfriends3 = myfriends2.getScaledInstance(135, 135, java.awt.Image.SCALE_SMOOTH);
		ImageIcon myfriends4 = new ImageIcon(myfriends3);

		JPanel backButton = new JPanel();

		ImageIcon back1 = new ImageIcon(loadImage("back1.png"));
		Image back2 = back1.getImage();
		Image back3 = back2.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		ImageIcon back4 = new ImageIcon(back3);
		JButton back = new JButton(back4);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					Controller.getInstance().changeToGamePanel();
				} catch (SQLException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		backButton.add(back);

		mainPanel.add(backButton, BorderLayout.PAGE_END);
		mainPanel.add(friendsButtons);
		friendsButtons.setLayout(new BoxLayout(friendsButtons, BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 200));
		friendsButtons.add(panel);
		panel.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(76, 33, 172, 52);
		panel.add(textArea);

		JButton btnNewButton = new JButton("Add a friend");
		btnNewButton.setBounds(346, 47, 149, 37);
		panel.add(btnNewButton);
		friendsList = new JTextArea();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
	if(Controller.getInstance().addFriends(textArea.getText()))
		System.out.println("Friend added");
	else System.out.println("Friend ALREADY EXIST");
} catch (SQLException | InterruptedException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}	
}
		});		
		friendsList.setText("Your friends:\n");
		friendsList.setBounds(205, 119, 130, 133);
		friendsList.setEditable(false);
		


		     
		

		
	
		//List<String> friends=Controller.getInstance().
		panel.add(friendsList);
		return mainPanel;

	}

	private static Image loadImage(String path) {
		return Toolkit.getDefaultToolkit().createImage(path);
	}
	public static void friendsList() throws SQLException, InterruptedException
	{
		List<String> friends;
		friends = Controller.getInstance().getFriends();
		if(friends==null)
			friends=new ArrayList<String>();
		for(int i=0;i<friends.size();i++)
		{
			friendsList.setText(friendsList.getText()+ " " +friends.get(i)+ "\n" );

		}

	}

}
