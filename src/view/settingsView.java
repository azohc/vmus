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

import enums.Language;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class settingsView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					settingsView window = new settingsView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public settingsView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 671, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.setPreferredSize(new Dimension(1000, 1000));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		frame.getContentPane().add(panel);
		panel.setPreferredSize(new Dimension(50, 500));
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Settings Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(190, 5, 285, 60);
		panel.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(50, 500));

		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblVolume = new JLabel("Volume");
		lblVolume.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVolume.setBounds(12, 13, 90, 38);
		panel_2.add(lblVolume);
		
		JSlider slider = new JSlider();
		slider.setBounds(0, 59, 653, 26);
		panel_2.add(slider);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(50, 500));

		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNotification = new JLabel("Notification");
		lblNotification.setBounds(12, 6, 147, 20);
		lblNotification.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNotification);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Enabled");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(136, 5, 127, 25);
		panel_1.add(rdbtnNewRadioButton);
		
		JLabel lblLanguage = new JLabel("Language");
		lblLanguage.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLanguage.setBounds(12, 53, 161, 45);
		panel_1.add(lblLanguage);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Language.values()));
		comboBox.setBounds(168, 48, 111, 56);
		panel_1.add(comboBox);
		
		JButton btnNewButton = new JButton("Save Settings");
	
		btnNewButton.setBounds(500, 48, 141, 57);
		panel_1.add(btnNewButton);
	}
}
