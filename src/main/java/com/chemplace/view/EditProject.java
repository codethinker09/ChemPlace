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
public class EditProject extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditProject frame = new EditProject();
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
	public EditProject() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(132, 100, 647, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 631, 371);
		contentPane.add(panel);
		
		JLabel lblEditProject = new JLabel("Edit Project");
		lblEditProject.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblEditProject);
	}

}
