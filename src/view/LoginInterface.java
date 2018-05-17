package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSlider;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import DAO.Language;
import controller.Controller;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class LoginInterface {

	private JFrame frame;
	private JPasswordField passwordField;//this is the password field
	private JTextArea textArea ;//this is the username field
	private Controller controller;

	public LoginInterface(Controller ctrl) {
		this.controller=ctrl;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 671, 450);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.setPreferredSize(new Dimension(1000, 1000));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		frame.getContentPane().add(panel);
		panel.setPreferredSize(new Dimension(50, 500));
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(190, 5, 285, 60);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(12, 5, 97, 25);
		panel.add(btnNewButton_1);

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(50, 500));

		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblVolume = new JLabel("Username");
		lblVolume.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVolume.setBounds(12, 13, 90, 38);
		panel_2.add(lblVolume);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(114, 83, 176, 38);
		panel_2.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(12, 83, 90, 38);
		panel_2.add(lblPassword);
		

		 textArea = new JTextArea();
		textArea.setBounds(114, 13, 176, 38);
		panel_2.add(textArea);
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Enabled");
		rdbtnNewRadioButton.setBounds(493, 21, 127, 25);
		panel_2.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		
		JLabel lblNewLabel_1 = new JLabel("Remember Me");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(335, 13, 133, 38);
		panel_2.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(402, 66, 141, 57);
		panel_2.add(btnNewButton);
	
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setForeground(Color.GRAY);
		panel_1.setPreferredSize(new Dimension(50, 500));

		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Dont't have an account? Register here");
		lblNewLabel_2.setBounds(12, 37, 241, 68);
		panel_1.add(lblNewLabel_2);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(407, 43, 141, 57);
		panel_1.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new RegisterInterface(controller);
			}
		});
	}
}
