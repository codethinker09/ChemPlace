package com.chemplace.view;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.chemplace.view.model.beans.ProjectTbl;
import com.chemplace.view.model.dao.JListData;
import com.chemplace.view.model.dao.ProjectDao;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 

@Component
public class OpenProject extends JFrame {
	@Autowired
	private ProjectDao projectDao;
	public List<ProjectTbl> projectlist;
	 
	public String  data_1[];
	
	    @Autowired
		InputModuleAcid_Carbonate inputModuleAcid_Carbonate;
	
	
	    DefaultListModel listModel = new DefaultListModel();
	
	
	
	 
	
	
	 public OpenProject() {
		 System.out.println("open project");
		 System.out.println(projectDao);
		 /*ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		 OpenProject openProject = ctx.getBean(OpenProject.class);*/
		 intialize();
	 }
 
 public void intialize() {
		// TODO Auto-generated method stub

	 
	 
 	
	  // projectlist=projectDao.getProjectList();
     //	   String  data_arr[] = new String [projectlist.size()];
	 
	  
		 String query="SELECT * FROM project_tbl";
		 listModel = new DefaultListModel();
		// DefaultListModel model=new DefaultListModel();
		// DefaultListModel projectidArray = new DefaultListModel();
		// DefaultListModel model1=new DefaultListModel();
		 try
		 {    
			 int  projectidArray[] = new int [1000];
	    Class.forName("org.postgresql.Driver");
		Statement stmt = null;
		ResultSet rs;                                                                          
		Connection conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/chemplaceproddb","postgres","wsmrt12345");
		stmt=(Statement) conn.createStatement();
		rs=stmt.executeQuery(query);
		projectlist=new ArrayList<ProjectTbl>();
		while (rs.next()) 
		{
			
		ProjectTbl projectTbl=new ProjectTbl();
		String projectname = rs.getString("project_name");
		int projectid = rs.getInt("project_id");
		projectTbl.setProjectName(projectname);
		projectTbl.setProjectId(projectid);
		projectlist.add(projectTbl);
		listModel.addElement(projectname);
		//listModel.ad
		//model1.addElement(projectid);
		}
		
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	   
	   
    /* for(int i=0;i<15;i++)
     {
    	 //data_arr[i]=projectlist.get(i).getCompanyName().toString();
  	   JListData listData=new JListData();

  	   //listData.setProjectName(projectlist.get(i).getCompanyName().toString());
  	   
  	   listModel.addElement("FDERFF"+i);
  	   
     }*/
	    setBounds(132, 100, 476, 367);
	    JLabel lblProjectList = new JLabel("Project List");
      lblProjectList.setFont(new Font("Tahoma", Font.BOLD, 13));
      lblProjectList.setBounds(168, 11, 98, 21);
      getContentPane().add(lblProjectList);
      getContentPane().setLayout(null);
     
      JPanel panel_1 = new JPanel();
      panel_1.setBounds(54, 43, 326, 248);
      getContentPane().add(panel_1);
      panel_1.setLayout(null);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(0, 0, 326, 248);
      panel_1.add(scrollPane);
      
      
      
 
	final JList  dataList = new JList(listModel);
  scrollPane.setViewportView(dataList);
  
          dataList.addListSelectionListener(new ListSelectionListener() {
  
              @Override
              public void valueChanged(ListSelectionEvent arg0) {
            	   //inputModuleAcid_Carbonate=new InputModuleAcid_Carbonate();
               
              //	JOptionPane.showMessageDialog(null,dataList.getSelectedValue().toString()+dataList.getSelectedIndex()+"  Projectid=: "+projectlist.get(dataList.getSelectedIndex()).getProjectId());
              	inputModuleAcid_Carbonate.setVisible(true);
              	
              	 setVisible(false);
         		
              	inputModuleAcid_Carbonate.resetFormData();
         		inputModuleAcid_Carbonate.openproject((projectlist.get(dataList.getSelectedIndex()).getProjectId()));
              	Home.setCurrentProjectid(projectlist.get(dataList.getSelectedIndex()).getProjectId());
              	System.out.println("gjhj"+projectDao);
              	   
              }
          });
  


 // setVisible(true);
  
   


	}

public  String[] getprojectlist()
		{
			  projectlist=projectDao.getProjectList();
			  String  data_arr[] = new String [projectlist.size()];
		       for(int i=0;i<projectlist.size();i++)
		       {
		      	 data_arr[i]=projectlist.get(i).getCompanyName().toString();
		       }
		       return data_arr;
		}
	
	 
    
   
}