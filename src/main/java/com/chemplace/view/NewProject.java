package com.chemplace.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chemplace.view.model.beans.ModuleSubmoduleTbl;
import com.chemplace.view.model.beans.ProjectTbl;
import com.chemplace.view.model.beans.UserTbl;
import com.chemplace.view.model.dao.ModuleSubModuledao;
import com.chemplace.view.model.dao.ProjectDao;
import com.chemplace.view.model.dao.ProjectDaoImp;
import com.chemplace.view.model.dao.UserDao;
import com.chemplace.view.model.dao.UserDaoImp;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
@Component
public class NewProject extends JFrame {
     
    
    @Autowired
	InputModuleAcid_Carbonate inputModuleAcid_Carbonate;
	
	private JPanel contentPane;
	private JTextField textProjectName;
	private JTextField textCompanyName;
	private JTextField textUserName;
	
	
	String projectname="";
	String companyName="";
	String userName="";
	
	@Autowired
	private ProjectDao projectDaoImp;
	
	@Autowired
	private ModuleSubModuledao moduleSubModuledao;
	
	@Autowired
	private UserDao userDaoImp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewProject frame = new NewProject();
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
	public NewProject() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(132, 100, 559, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//JFrame.setDefaultLookAndFeelDecorated (true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 546, 329);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblEnterProjectDetails = new JLabel("Project Information");
		lblEnterProjectDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterProjectDetails.setBounds(206, 11, 216, 22);
		panel.add(lblEnterProjectDetails);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(32, 44, 467, 242);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblProjectName = new JLabel("Project Name");
		lblProjectName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProjectName.setBounds(35, 31, 124, 31);
		panel_1.add(lblProjectName);
		
		JLabel lblChemicalName = new JLabel("User Name");
		lblChemicalName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChemicalName.setBounds(35, 103, 124, 37);
		panel_1.add(lblChemicalName);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCompanyName.setBounds(35, 70, 124, 31);
		panel_1.add(lblCompanyName);
		
		textProjectName = new JTextField();
		textProjectName.setBounds(156, 31, 261, 31);
		panel_1.add(textProjectName);
		textProjectName.setColumns(10);
		
		textCompanyName = new JTextField();
		textCompanyName.setBounds(156, 70, 261, 31);
		panel_1.add(textCompanyName);
		textCompanyName.setColumns(10);
		
		textUserName = new JTextField();
		textUserName.setBounds(156, 107, 261, 31);
		panel_1.add(textUserName);
		textUserName.setColumns(10);
		
		JButton saveProjectDetail = new JButton("Submit");
		saveProjectDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
			 projectname=textProjectName.getText().toString().trim();
			 companyName=textCompanyName.getText().toString().trim();
			 userName=textUserName.getText().toString().trim();
            
			if(Home.getIsmoduleSelected()==0)
			{
				JOptionPane.showInternalMessageDialog(contentPane, "Please Select module.");
			}
			else if(projectname.equalsIgnoreCase(""))
			{
				JOptionPane.showInternalMessageDialog(contentPane, "Please Select module.");
			}
			else if(companyName.equalsIgnoreCase(""))
			{
				JOptionPane.showInternalMessageDialog(contentPane, "Please Select module.");
			}
			else if(userName.equalsIgnoreCase(""))
			{
				JOptionPane.showInternalMessageDialog(contentPane, "Please Select module.");
			}
			else
			{
				//JOptionPane.showInternalMessageDialog(contentPane, "Please Select module.");
				
				createproject();
				
				
			}
			
			
				
				
			}
		});
		saveProjectDetail.setFont(new Font("Tahoma", Font.BOLD, 12));
		saveProjectDetail.setBounds(170, 177, 89, 28);
		panel_1.add(saveProjectDetail);
		
		JButton btncancel = new JButton("Close");
		btncancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btncancel.setBounds(269, 177, 89, 28);
		panel_1.add(btncancel);
	}
	
	public void createproject()
	{
		int userid=0;
		
		UserTbl userTbl=new UserTbl();
		userTbl.setUserName(userName);
		
		  userid=userDaoImp.isUserExist(userName);
		  if(userid==0)
		   {
		     userid=userDaoImp.save(userTbl);
		   }
		  
		userTbl.setUserId(userid);
		ProjectTbl projectTbl=new ProjectTbl();
		 
		projectTbl.setProjectName(projectname);
		projectTbl.setCompanyName(companyName);
		projectTbl.setUserName(userName);
		projectTbl.setUserTbl(userTbl);
		
		
		ModuleSubmoduleTbl moduleSubmoduleTbl=new ModuleSubmoduleTbl();
 
		List<ModuleSubmoduleTbl>modulelist=moduleSubModuledao.getAllModuleData(Home.getIsmoduleSelected());
		
		
		
		moduleSubmoduleTbl.setModuleName(modulelist.get(0).getModuleName());
		moduleSubmoduleTbl.setSubModuleId(modulelist.get(0).getSubModuleId());
		moduleSubmoduleTbl.setModuleId(modulelist.get(0).getSubModuleId());
		moduleSubmoduleTbl.setModuleSubmId(modulelist.get(0).getModuleSubmId());
		
	    projectTbl.setModuleSubmoduleTbl(moduleSubmoduleTbl);
	
		
	    
	    int projectid=projectDaoImp.save(projectTbl);
		System.out.println("projectid="+projectid);
		Home.setCurrentProjectid(projectid);
		textProjectName.setText(""); 
	    textCompanyName.setText(""); 
	    textUserName.setText(""); 
		
	     setVisible(false);
		 //InputModuleAcid_Carbonate inputModuleAcid_Carbonate1=new InputModuleAcid_Carbonate();
	     
		inputModuleAcid_Carbonate.setVisible(true);
		inputModuleAcid_Carbonate.resetFormData();
		
	}
	
}
