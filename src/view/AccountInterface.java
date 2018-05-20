package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

import controller.Controller;

@SuppressWarnings("serial")
public class AccountInterface extends JPanel {

	private JPasswordField loginPass;//this is the password field
	private JTextArea loginName ;//this is the username field
	private JPasswordField regPass;//password
	private JPasswordField regPassConf;//password confirmation
	private JTextArea regName;//username field
	private JTextArea regEmail;//email field
	

	private JTextArea recoverEmail;//email field
	
	private CardLayout cl;
	
	public AccountInterface() {
	
		cl = new CardLayout();
		setLayout(cl);
		add(loginInterface(), "login");
		add(registerInterface(), "register");
		add(recoverEmailInterface(), "recover");
		cl.show(this, "login");
	}
	
	private JPanel loginInterface() {
		JPanel login = new JPanel();
		
		login.setLayout(new BoxLayout(login, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		login.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(190, 5, 285, 60);
		panel.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(50, 500));

		login.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblVolume = new JLabel("Username");
		lblVolume.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVolume.setBounds(12, 13, 90, 38);
		panel_2.add(lblVolume);
		
		loginPass = new JPasswordField();
		loginPass.setBounds(114, 83, 176, 38);
		loginPass.setBorder(BorderFactory.createEtchedBorder());
		panel_2.add(loginPass);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(12, 83, 90, 38);
		panel_2.add(lblPassword);
		
		loginName = new JTextArea();
		loginName.setBorder(BorderFactory.createEtchedBorder());
		loginName.setBounds(114, 13, 176, 38);
		panel_2.add(loginName);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(402, 66, 141, 57);
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           try {
        	   if(Controller.getInstance().loginUser(loginName.getText(), loginPass.getText()))
        		   Controller.getInstance().changeToGamePanel();
        	   else
        		   System.out.println("null");

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
            }
        });
	
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setForeground(Color.GRAY);
		panel_1.setPreferredSize(new Dimension(50, 500));

		login.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Dont't have an account? Register here:");
		lblNewLabel_2.setBounds(12, 37, 300, 68);
		panel_1.add(lblNewLabel_2);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(407, 43, 141, 57);
		panel_1.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(AccountInterface.this, "register");
			}
		});
		return login;
	}
	
	private JPanel registerInterface() {
		JPanel register = new JPanel();
		
		register.setLayout(new BoxLayout(register, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		register.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(190, 5, 285, 60);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(474, 25, 141, 57);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(AccountInterface.this, "login");
			}
		});
	

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("Button.background"));
		panel_2.setPreferredSize(new Dimension(50, 500));
		
		panel_2.add(btnNewButton_1);
		register.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblVolume = new JLabel("Username");
		lblVolume.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVolume.setBounds(12, 13, 90, 38);
		panel_2.add(lblVolume);
		
		regName = new JTextArea();
		regName.setBorder(new EtchedBorder());
		regName.setBounds(192, 83, 176, 38);
		panel_2.add(regName);
		
		JLabel lblPassword = new JLabel("Email");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(12, 74, 90, 38);
		panel_2.add(lblPassword);
		
		regEmail = new JTextArea();
		regEmail.setBorder(new EtchedBorder());
		regEmail.setBounds(192, 22, 176, 38);
		panel_2.add(regEmail);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.background"));
		panel_1.setForeground(Color.GRAY);
		panel_1.setPreferredSize(new Dimension(50, 500));

		register.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(474, 28, 141, 57);
		panel_1.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	             try {
					Controller.getInstance().registerNewUser(regName.getText(),regEmail.getText(), regPass.getText());
					showLogin();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            }

				
	        });
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword_1.setBounds(12, 13, 90, 38);
		panel_1.add(lblPassword_1);
		
		regPass = new JPasswordField();
		regPass.setBounds(191, 14, 176, 38);
		panel_1.add(regPass);
		
		JLabel lblPasswordAgain = new JLabel("Password again");
		lblPasswordAgain.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPasswordAgain.setBounds(12, 63, 149, 38);
		panel_1.add(lblPasswordAgain);
		
		regPassConf = new JPasswordField();
		regPassConf.setBounds(191, 65, 176, 38);
		panel_1.add(regPassConf);
		
		return register;
	}
	
	private JPanel recoverEmailInterface() {
		JPanel register = new JPanel();
		
		register.setLayout(new BoxLayout(register, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		register.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Recover Password Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(190, 15, 285, 60);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(100, 200, 100, 50);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(AccountInterface.this, "login");
			}
		});
	

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("Button.background"));
		panel_2.setPreferredSize(new Dimension(50, 500));
		
		panel_2.add(btnNewButton_1);
		register.add(panel_2);
		panel_2.setLayout(null);
		
		
		JLabel lblPassword = new JLabel("Email");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(12, 74, 90, 38);
		panel_2.add(lblPassword);
		
		recoverEmail = new JTextArea();
		recoverEmail.setBorder(new EtchedBorder());
		recoverEmail.setBounds(95, 74, 176, 38);
		panel_2.add(recoverEmail);
		
		JButton btnRegister = new JButton("Recover Email");
		btnRegister.setBounds(400, 74, 141, 38);
		panel_2.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	             try {
					Controller.getInstance().recoverPass(recoverEmail.getText());
					showLogin();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            }

				
	        });
		
		return register;
	}
	
	private void showLogin() {
		cl.show(this, "login");
	}
}
