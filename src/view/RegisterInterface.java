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

import controller.Controller;
import enums.Language;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class RegisterInterface {

	private JFrame frame;
	private JPasswordField passwordField_1;//password
	private JPasswordField passwordField_2;//password confirmation
	private JTextArea textArea;//username field
	private JTextArea textArea_1;//email field
	private Controller controller;

	public RegisterInterface(Controller ctrl) {
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
	//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.setPreferredSize(new Dimension(1000, 1000));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		frame.getContentPane().add(panel);
		panel.setPreferredSize(new Dimension(50, 500));
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(190, 5, 285, 60);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(12, 5, 97, 25);
		panel.add(btnNewButton_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("Button.background"));
		panel_2.setPreferredSize(new Dimension(50, 500));

		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblVolume = new JLabel("Username");
		lblVolume.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVolume.setBounds(12, 13, 90, 38);
		panel_2.add(lblVolume);
		
		 textArea = new JTextArea();
		textArea.setBounds(192, 83, 176, 38);
		panel_2.add(textArea);
		
		JLabel lblPassword = new JLabel("Email");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(12, 74, 90, 38);
		panel_2.add(lblPassword);
		
		 textArea_1 = new JTextArea();
		textArea_1.setBounds(192, 22, 176, 38);
		panel_2.add(textArea_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.background"));
		panel_1.setForeground(Color.GRAY);
		panel_1.setPreferredSize(new Dimension(50, 500));

		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(474, 28, 141, 57);
		panel_1.add(btnRegister);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword_1.setBounds(12, 13, 90, 38);
		panel_1.add(lblPassword_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(191, 14, 176, 38);
		panel_1.add(passwordField_1);
		
		JLabel lblPasswordAgain = new JLabel("Password again");
		lblPasswordAgain.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPasswordAgain.setBounds(12, 63, 149, 38);
		panel_1.add(lblPasswordAgain);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(191, 65, 176, 38);
		panel_1.add(passwordField_2);
	}
}
