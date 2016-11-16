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
public class SystemRequirement extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemRequirement frame = new SystemRequirement();
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
	public SystemRequirement() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(132, 100, 651, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 635, 367);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSystemRequirement = new JLabel("System Requirement");
		lblSystemRequirement.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSystemRequirement.setBounds(259, 0, 183, 24);
		panel.add(lblSystemRequirement);
	}
}
