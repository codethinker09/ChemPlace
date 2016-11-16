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
public class TechnicalManual extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TechnicalManual frame = new TechnicalManual();
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
	public TechnicalManual() {
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
		
		JLabel lblTechnicalManual = new JLabel("Technical Manual");
		lblTechnicalManual.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTechnicalManual.setBounds(254, 11, 151, 24);
		panel.add(lblTechnicalManual);
	}

}
