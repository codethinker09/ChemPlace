package com.chemplace.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.chemplace.view.model.beans.ProjectTbl;
import com.chemplace.view.model.dao.LicenceKeyDao;
import com.chemplace.view.model.dao.ProjectDao;
import com.chemplace.view.model.dao.UserDao;
@Component
public class WelcomePage extends JFrame {
	 
	private JFrame frame;
	private JTextField txtPleaseEnterLicense;
	List<ProjectTbl> projectlist;
	
	@Autowired
	 private ProjectDao projectDao;
	@Autowired
	Home home;
	@Autowired
	LicenceKeyDao licenceKeyDao;
	@Autowired
	UserDao userDao;
	 
	static WelcomePage welcomePagei;
 
	static String keyvalue="";
	
	//public final Action action = new SwingAction();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	 
	   
		
	  EventQueue.invokeLater(new Runnable() {
			public void run() {
				

				ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
				 welcomePagei = ctx.getBean(WelcomePage.class);
				
				
				/*// setUserRegistration1((UserRegistration)ctx.getBean("userRegistration"));
				 setSelectModule((SelectModule)ctx.getBean("selectModule"));
				 setHome((Home)ctx.getBean("home"));
				 setInput((InputModuleAcid_Carbonate)ctx.getBean("inputModuleAcid_Carbonate"));
				 setUserLogin((UserLogin)ctx.getBean("userLogin"));
				 
				 setAboutChemPlace((AboutChemPlace)ctx.getBean("aboutChemPlace"));
				 setBarChartView((BarChartView)ctx.getBean("barChartView"));
				 setEditProject((EditProject)ctx.getBean("editProject"));
				 setLineChartView((LineChartView)ctx.getBean("lineChartView"));
				 setNewProject((NewProject)ctx.getBean("newProject"));
				 setOpenProject((OpenProject)ctx.getBean("openProject"));
				 setSystemRequirement((SystemRequirement)ctx.getBean("systemRequirement"));
				 setTechnicalManual((TechnicalManual)ctx.getBean("technicalManual"));
				 setUserManual((UserManual)ctx.getBean("userManual"));
				 setView3D((View3D)ctx.getBean("view3D"));
				 setViewInput((ViewInput)ctx.getBean("viewInput"));
				 setViewOutput((ViewOutput)ctx.getBean("viewOutput"));*/
				 welcomePagei.isKeyExpire();
				 
				 
				 
			    // welcomePagei.initialize();	
				// welcomePagei.frame.setVisible(true);
				 
				 
			}
		});
			 
	}

	
	 
	 
	
	/**
	 * Create the application.
	 */
	public WelcomePage() {
		System.out.println("WelcomePage");
		initialize();
	}

	void isKeyExpire()
	{
		boolean isexpirekey=licenceKeyDao.isLiceseExpire();
		
		if(isexpirekey)
		{
			//welcomePagei.initialize();
            home.setVisible(true);
		    
		}
		else
		{
			
			welcomePagei.frame.setVisible(true);
			
		}
		
		
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		 
		frame = new JFrame("Welcome");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setFont(new Font("Arial", Font.BOLD, 16));
		frame.setBounds(100, 100, 521, 300);
		frame.getContentPane().setLayout(null);
		 
		Label label = new Label("Welcome to Chemplace");
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setAlignment(Label.CENTER);
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(169, 28, 214, 22);
		frame.getContentPane().add(label);
		
		txtPleaseEnterLicense = new JTextField();
		txtPleaseEnterLicense.setToolTipText("");
		txtPleaseEnterLicense.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPleaseEnterLicense.setBounds(246, 107, 172, 22);
		frame.getContentPane().add(txtPleaseEnterLicense);
		txtPleaseEnterLicense.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Please enter license key:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(98, 102, 157, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("SUBMIT");
		 
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String getEnterKey=txtPleaseEnterLicense.getText();
				/*JOptionPane.showMessageDialog(frame,
				        "Please enter valid license number");
				*/
				boolean islicencetrue;
				
				if(getEnterKey.equalsIgnoreCase(""))
				{
					JOptionPane.showMessageDialog(frame,
					        "Please enter license number.");
				}
				else
				{
					try
					{
						islicencetrue=licenceKeyDao.getLicenceKey(getEnterKey);
						
						if(islicencetrue)
						{
							/*JOptionPane.showMessageDialog(frame,
							        "your licence ke is true");*/
							
							
					        //subtracting days from Date in Java
					        
					        try
					        {
					        	keyvalue=getEnterKey;
					        	Calendar cal = Calendar.getInstance();
						        cal.setTimeZone(TimeZone.getTimeZone("GMT"));
						      
						        System.out.println("current date: " + getDate(cal));
						        String datestartstr=getDate(cal);
						        
						         
						        cal.add(Calendar.MONTH, 6);
						       
						        String endDatestr=getDate(cal);
						        
					        	System.out.println("start date="+datestartstr);
					        	System.out.println("end date="+endDatestr);
					        	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					            Date startdate =formatter.parse(datestartstr);
					            Date enddate=formatter.parse(endDatestr);
					            System.out.println("start date="+startdate);
					        	System.out.println("end date="+enddate);
					        	
					        	//licenceKeyDao.isLiceseExpire();

					             licenceKeyDao.updateDate(getEnterKey, startdate, enddate); 
					            
					        
					         
					        }
					        catch(Exception e)
					        {
					        	e.printStackTrace();
					        }

							
							 
							
							frame.setVisible(false); 
							for(int i=0; i<=10; i++)
							  {
					             
					              
					              try{
					                      FileWriter fw = new FileWriter("D:/exported/PrgFile.txt");
					                      BufferedWriter bw = new BufferedWriter(fw);
					                     // System.out.println(rs.getInt("cid"));
					                      bw.write(i+"TYTRHYDT"); // \n is for to write in a new Line .
					                      bw.newLine();
					                      bw.close();
					              }
					              catch (Exception e) {
					                  System.out.println("Errrrr......... writing to a file..... :P"+e);
					              }
					}
							
							
							  
							 home.setVisible(true);
							
						}
						else
						{
							JOptionPane.showMessageDialog(frame,
							        "Please enter valid license number.");
						}
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
					
				
			}
		});
		
		
		/*btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String getEnterKey=txtPleaseEnterLicense.getText();
				if(getEnterKey.equalsIgnoreCase(""))
				{
					JOptionPane.showMessageDialog(frame,
					        "Please enter valid license number");
				}
				else if(getEnterKey.equalsIgnoreCase("dk121"))
				{
					
				SelectModule selectModule=new SelectModule();
				      
						selectModule.setVisible(true);
					
					
						  
				
				}
				else
				{
					JOptionPane.showMessageDialog(frame,
					        "Please enter valid license number");
				}
				
				
			}
		});*/
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(213, 184, 89, 31);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLOSE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(312, 184, 89, 31);
		frame.getContentPane().add(btnNewButton_1);
		//frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frame.getContentPane(), label, txtPleaseEnterLicense, lblNewLabel, btnNewButton}));
	}
	
	
	 
	public static String getDate(Calendar cal){
        return "" + cal.get(Calendar.DATE) +"/" +
                (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR);
    }
  
    /**
     *
     * @return current Date from Calendar in HH:mm:SS format
     *
     * adding 1 into month because Calendar month starts from zero
     */
    public static String getTime(Calendar cal){
        return "" + cal.get(Calendar.HOUR_OF_DAY) +":" +
                (cal.get(Calendar.MINUTE)) + ":" + cal.get(Calendar.SECOND);
    }


	
	
}
