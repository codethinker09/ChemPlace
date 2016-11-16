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
public class ViewInput extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewInput frame = new ViewInput();
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
	public ViewInput() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(132, 100, 1163, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1147, 644);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblInputData = new JLabel("Input Data");
		lblInputData.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInputData.setBounds(257, 11, 174, 30);
		panel.add(lblInputData);
	}

}
