package view;

import javax.swing.JSlider;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enums.Language;
import controller.Controller;

import java.awt.Color;

public class SettingsInterface extends JPanel{

	private JSlider slider;//FOR VOLUME
	private JRadioButton rdbtnNewRadioButton;//FOR NOTIFICATION
	private JComboBox comboBox;//FOR LANGUAGE


	public SettingsInterface() {
		initialize();
	}


	private void initialize() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(671, 450));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		this.add(panel);
		panel.setPreferredSize(new Dimension(50, 500));
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Settings Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(190, 5, 285, 60);
		panel.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(50, 500));

		this.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblVolume = new JLabel("Volume");
		lblVolume.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVolume.setBounds(12, 13, 90, 38);
		panel_2.add(lblVolume);
		
		slider = new JSlider(JSlider.HORIZONTAL,0,100,100);
		slider.setBounds(0, 59, 653, 26);
		panel_2.add(slider);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(50, 500));

		this.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNotification = new JLabel("Notification");
		lblNotification.setBounds(12, 6, 147, 20);
		lblNotification.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNotification);
		
		rdbtnNewRadioButton = new JRadioButton("Enabled");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(136, 5, 127, 25);
		panel_1.add(rdbtnNewRadioButton);
		
		JLabel lblLanguage = new JLabel("Language");
		lblLanguage.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLanguage.setBounds(12, 53, 161, 45);
		panel_1.add(lblLanguage);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Language.values()));
		comboBox.setBounds(168, 48, 111, 56);
		panel_1.add(comboBox);
		JButton btnNewButton = new JButton("Save Settings");
		btnNewButton.setBounds(500, 48, 141, 57);
		
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
	}
}
