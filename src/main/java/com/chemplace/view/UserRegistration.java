package com.chemplace.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.chemplace.view.model.beans.UserTbl;
import com.chemplace.view.model.dao.UserDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@Component
public class UserRegistration extends JFrame {
	
	private JFrame frame;
	private JTextField userName;
	private JTextField userId;
	private JPasswordField userPassword;
	private JPasswordField userRePassword;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	SelectModule selectModule;
	
	
	 

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			UserRegistration1 userRegistration1 = new UserRegistration1();
			userRegistration1.setVisible(true);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public UserRegistration()
	{
		initialize();
	}
	
	
	public void initialize() {
		setBounds(100, 100, 629, 353);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 617, 315);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(44, 51, 506, 218);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNewLabel = new JLabel("Name");
					lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
					lblNewLabel.setBounds(37, 23, 155, 27);
					panel_1.add(lblNewLabel);
				}
				{
					JLabel lblNewLabel_1 = new JLabel("User Id");
					lblNewLabel_1.setToolTipText("For Login");
					lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
					lblNewLabel_1.setBounds(37, 54, 155, 20);
					panel_1.add(lblNewLabel_1);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Password");
					lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
					lblNewLabel_2.setBounds(37, 85, 155, 20);
					panel_1.add(lblNewLabel_2);
				}
				{
					JLabel lblConfirmPassword = new JLabel("Confirm Password");
					lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
					lblConfirmPassword.setBounds(37, 116, 140, 15);
					panel_1.add(lblConfirmPassword);
				}
				{
					userName = new JTextField();
					userName.setFont(new Font("Tahoma", Font.BOLD, 12));
					userName.setBounds(202, 27, 237, 20);
					panel_1.add(userName);
					userName.setColumns(10);
				}
				{
					userId = new JTextField();
					userId.setFont(new Font("Tahoma", Font.BOLD, 12));
					userId.setBounds(202, 55, 237, 20);
					panel_1.add(userId);
					userId.setColumns(10);
				}
				{
					userPassword = new JPasswordField();
					userPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
					userPassword.setBounds(202, 86, 237, 20);
					panel_1.add(userPassword);
				}
				{
					userRePassword = new JPasswordField();
					userRePassword.setFont(new Font("Tahoma", Font.BOLD, 12));
					userRePassword.setBounds(202, 114, 237, 20);
					panel_1.add(userRePassword);
				}
				{
					JButton btnNewButton = new JButton("Submit");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							
					String userNametext=userName.getText();
					String userIdtext=userId.getText();
					String userPasswordtext=userPassword.getText();
					String userRePasswordtext=userRePassword.getText();
					if(userNametext.equalsIgnoreCase(""))
					{
						JOptionPane.showMessageDialog(frame,
						        "Please enter your name.");
					}
					else if(userIdtext.equalsIgnoreCase(""))
					{

						JOptionPane.showMessageDialog(frame,
						        "Please enter userid.");
					}
					else if(userPasswordtext.equalsIgnoreCase(""))
					{
						JOptionPane.showMessageDialog(frame,
						        "Please enter password.");
					}
					else if(userRePasswordtext.equalsIgnoreCase(""))
					{
						JOptionPane.showMessageDialog(frame,
						        "Please enter confirm password.");
					}
					else if(!userPasswordtext.equalsIgnoreCase(userRePasswordtext))
					{
						JOptionPane.showMessageDialog(frame,
						        "Enter the same password.");
					}
					else
					{
						UserTbl userTbl=new UserTbl();
						userTbl.setUserName(userNametext);
						userTbl.setLicenseKey(WelcomePage.keyvalue);
						userTbl.setUserLoginid(userIdtext);
						userTbl.setUserPassword(userPasswordtext);
						userTbl.setUserPhone("999999999");
						userDao.save(userTbl);
						setVisible(false);
						 
						selectModule.setVisible(true);
						
						
					}
					
					
							
						}
					});
					btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnNewButton.setBounds(202, 154, 89, 32);
					panel_1.add(btnNewButton);
				}
				{
					JButton btnClose = new JButton("Close");
					btnClose.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.exit(0);
							}
					});
					btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnClose.setBounds(311, 154, 89, 32);
					panel_1.add(btnClose);
				}
			}
			{
				JLabel lblRegistration = new JLabel("Registration");
				lblRegistration.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblRegistration.setBounds(266, 11, 111, 29);
				panel.add(lblRegistration);
			}
		}
	}
}
