package com.chemplace.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;
import javax.swing.JLabel;
import java.awt.Font;
@Component
public class UserManual extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManual frame = new UserManual();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserManual() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(132, 100, 648, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 632, 359);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUserManual = new JLabel("User Manual");
		lblUserManual.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserManual.setBounds(282, 11, 152, 26);
		panel.add(lblUserManual);
	}

}
