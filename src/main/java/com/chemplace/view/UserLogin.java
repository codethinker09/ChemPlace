package com.chemplace.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chemplace.view.model.dao.UserDao;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
@Component
public class UserLogin extends JFrame {
	
	private JFrame frame;
	private JTextField username;
	
	@Autowired
	private UserDao userDao;
	private JPasswordField password;
	 
	@Autowired
	SelectModule selectModule;
	
	

	/**
	 * Launch the application.
	 */
	/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public UserLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 548, 345);
		setTitle("User Login Form");
		setResizable(false);
		getContentPane().setLayout(null);
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 539, 316);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLoginDetails = new JLabel("Login ");
		lblLoginDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLoginDetails.setBounds(256, 11, 92, 29);
		panel.add(lblLoginDetails);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(59, 51, 420, 208);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUserId = new JLabel("User Id");
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserId.setBounds(44, 44, 88, 21);
		panel_1.add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(44, 91, 88, 21);
		panel_1.add(lblPassword);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.BOLD, 12));
		username.setBounds(168, 41, 178, 29);
		panel_1.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(168, 83, 178, 29);
		panel_1.add(password);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String usernametext=username.getText();
				String passwordtext=password.getText();
				
				if(usernametext.equalsIgnoreCase(""))
				{
					
					JOptionPane.showMessageDialog(frame,
					        "Please enter username.");
					
				}
				
				else if(passwordtext.equalsIgnoreCase(""))
				{
					JOptionPane.showMessageDialog(frame,
					        "Please enter password.");
				}
				else
				{
					boolean isValid=userDao.isLoginValid(usernametext, passwordtext);
					if(isValid)
					{
						 setVisible(false);
						//SelectModule selectModule=selectModule;
						selectModule.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(frame,
						        "Please enter valid username and password.");
					}
					
				}
				
				 
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(158, 154, 89, 29);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
           setVisible(false);
				
				//WelcomePage.getSelectModule().setVisible(false);
				}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(257, 154, 89, 29);
		panel_1.add(btnNewButton_1);
		
		
	}
}
