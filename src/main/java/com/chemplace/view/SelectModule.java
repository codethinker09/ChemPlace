package com.chemplace.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@Component
public class SelectModule extends JFrame {
	
public JFrame frame;

@Autowired
Home home;
 
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				SelectModule frame = new SelectModule();
				frame.setVisible(true);
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public SelectModule() {
		
		initialize();
		
	}
		
	public void initialize() {
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 687, 422);
		setTitle("Select Module & Sub Module");
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 681, 394);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblSelectModule = new JLabel("Module");
		lblSelectModule.setBounds(136, 41, 115, 39);
		panel.add(lblSelectModule);
		lblSelectModule.setFont(new Font("Tahoma", Font.BOLD, 12));
		
	
		JLabel lblSelectModule_1 = new JLabel("Select Module & Sub Module");
		lblSelectModule_1.setBounds(269, 11, 193, 26);
		panel.add(lblSelectModule_1);
		lblSelectModule_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		final JLabel lblNewLabel = new JLabel("Sub Module");
		lblNewLabel.setBounds(449, 41, 115, 38);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		
		
		
		final JButton btnNewButton_3 = new JButton("Carbonate");
		btnNewButton_3.setBounds(355, 102, 121, 45);
		panel.add(btnNewButton_3);
		
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				
				 setVisible(false);
				
			 
				 
				 
				home.setVisible(true);
				
								
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		
		final JButton btnNewButton_5 = new JButton("Carbonate");
		btnNewButton_5.setBounds(355, 160, 121, 45);
		panel.add(btnNewButton_5);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		final JButton btnNewButton_6 = new JButton("SandStone");
		btnNewButton_6.setBounds(496, 158, 108, 45);
		panel.add(btnNewButton_6);
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		final JButton btnNewButton_4 = new JButton("SandStone");
		btnNewButton_4.setBounds(496, 102, 108, 45);
		panel.add(btnNewButton_4);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnNewButton = new JButton("Fracture Stimulation");
		btnNewButton.setBounds(44, 162, 262, 39);
		panel.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnNewButton_3.setVisible(false);
				btnNewButton_4.setVisible(false);
				
				btnNewButton_5.setVisible(true);
				btnNewButton_6.setVisible(true);
				lblNewLabel.setVisible(true);
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		JButton btnNewButton_7 = new JButton("Matrix Acid Stimulation");
		btnNewButton_7.setBounds(44, 101, 262, 44);
		panel.add(btnNewButton_7);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton_5.setVisible(false);
				btnNewButton_6.setVisible(false);
				
				btnNewButton_3.setVisible(true);
				btnNewButton_4.setVisible(true);
				lblNewLabel.setVisible(true);
				
			}
		});
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		
		
		JButton btnNewButton_1 = new JButton("SandStone Compatibility Analysis ");
		btnNewButton_1.setBounds(44, 220, 262, 46);
		panel.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton_2 = new JButton("Economic Evaluation ");
		btnNewButton_2.setBounds(44, 277, 262, 47);
		panel.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 setVisible(false);
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClose.setBounds(559, 357, 89, 26);
		panel.add(btnClose);
		btnNewButton_6.setVisible(false);
		btnNewButton_5.setVisible(false);
		btnNewButton_4.setVisible(false);
		
		
		
		
		
		btnNewButton_3.setVisible(false);
		lblNewLabel.setVisible(false);

	}
}
