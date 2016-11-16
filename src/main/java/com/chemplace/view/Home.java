package com.chemplace.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chemplace.view.model.beans.ProjectTbl;
import com.chemplace.view.model.dao.ProjectDao;
@Component
public class Home extends JFrame{

public static	List<ProjectTbl> projectlist;
	
	public JFrame frame;
	
	 
	
	@Autowired
	View3D view3d;
	@Autowired
	BarChartView barChartView;
	@Autowired
	LineChartView lineChartView;
	@Autowired
	UserManual userManual;
	@Autowired
	AboutChemPlace aboutChemPlace;
	@Autowired
	SystemRequirement systemRequirement;
	@Autowired
	TechnicalManual technicalManual;
	@Autowired
	ViewOutput viewOutput;
	
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	ViewInput viewInput;
	@Autowired
	NewProject newProject;
	@Autowired
	InputModuleAcid_Carbonate inputModuleAcid_Carbonate;
	@Autowired
	OpenProject openProject;
	@Autowired
	SelectModule selectModule;
	
	 
 	public static int currentProjectid=0;
	
	public static int getCurrentProjectid() {
		return currentProjectid;
	}

	public static void setCurrentProjectid(int currentProjectid) {
		Home.currentProjectid = currentProjectid;
	}

	public static int ismoduleSelected=0;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Home frame = new Home();
				frame.setVisible(true);
			}
		});
	}*/
	
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frmChemplace.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	 

	public static int getIsmoduleSelected() {
		return ismoduleSelected;
	}

	public void setIsmoduleSelected(int ismoduleSelected) {
		this.ismoduleSelected = ismoduleSelected;
	}

	/**
	 * Create the application.
	 */
	public Home() {
		
		System.out.println("Home Class");
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1, 1, 1350, 720);
		setTitle("ChemPlace Home");
		setResizable(false);
		getContentPane().setLayout(null);
		
		/*  this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	        this.setUndecorated(true);
	        this.setAlwaysOnTop(true);
	        this.setResizable(false); 
	        this.setVisible(true);
		*/
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 118, 182));
		panel.setBounds(0, 0, 1334, 690);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1354, 33);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.setBounds(0, 0, 1354, 33);
		panel_1.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setForeground(Color.BLACK);
		mnFile.setFont(new Font("Arial", Font.BOLD, 13));
		menuBar.add(mnFile);
		
		JMenuItem mntmNewProject = new JMenuItem("New Project");
		mntmNewProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 int moduleid=0;
				 moduleid=getIsmoduleSelected();
				
				if(moduleid==0)
				{
				  
					JOptionPane.showMessageDialog(null, "Please select module");
					
				}
				else
				{
					newProject.setVisible(true);
					//isprojectopen=false;
					 
				}
				
			
			}
		});
		mntmNewProject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			
				
			}
		});
		mntmNewProject.setFont(new Font("Arial", Font.BOLD, 12));
		mnFile.add(mntmNewProject);
		
		JMenuItem mntmOpenProject = new JMenuItem("Open Project");
		mntmOpenProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				OpenProject openProject=new OpenProject();
//				openProject.setVisible(true);
				 
				openProject.setVisible(true);
				openProject.intialize();
				//isprojectopen=true;
				
			}
		});
		mntmOpenProject.setFont(new Font("Arial", Font.BOLD, 12));
		mnFile.add(mntmOpenProject);
		
		JMenuItem mntmEditPreoject = new JMenuItem("Edit Preoject");
		mntmEditPreoject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			OpenProject openProject=new OpenProject();
			openProject.setVisible(true);
			
				openProject.setVisible(true);
			}
		});
		mntmEditPreoject.setFont(new Font("Arial", Font.BOLD, 12));
		mnFile.add(mntmEditPreoject);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setFont(new Font("Arial", Font.BOLD, 12));
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Close Project");
		mntmExit.setFont(new Font("Arial", Font.BOLD, 12));
		mnFile.add(mntmExit);
		
		JMenuItem mntmExit_1 = new JMenuItem("Exit");
		mntmExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		mntmExit_1.setFont(new Font("Arial", Font.BOLD, 12));
		mnFile.add(mntmExit_1);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setForeground(Color.BLACK);
		mnEdit.setFont(new Font("Arial", Font.BOLD, 13));
		menuBar.add(mnEdit);
		
		JMenuItem mntmCut = new JMenuItem("Copy");
		mntmCut.setFont(new Font("Arial", Font.BOLD, 12));
		mnEdit.add(mntmCut);
		
		JMenuItem mntmPast = new JMenuItem("Past");
		mntmPast.setFont(new Font("Arial", Font.BOLD, 12));
		mnEdit.add(mntmPast);
		
		JMenuItem mntmSelectAll = new JMenuItem("Select All");
		mntmSelectAll.setFont(new Font("Arial", Font.BOLD, 12));
		mnEdit.add(mntmSelectAll);
		
		JMenu mnView = new JMenu("View");
		mnView.setForeground(Color.BLACK);
		mnView.setFont(new Font("Arial", Font.BOLD, 13));
		menuBar.add(mnView);
		
		JMenuItem mntmInput = new JMenuItem("Input");
		mntmInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				viewInput.setVisible(true);
			}
		});
		mntmInput.setFont(new Font("Arial", Font.BOLD, 12));
		mnView.add(mntmInput);
		
		JMenuItem mntmOutput = new JMenuItem("Output");
		mntmOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				viewOutput.setVisible(true);
			}
		});
		mntmOutput.setFont(new Font("Arial", Font.BOLD, 12));
		mnView.add(mntmOutput);
		
		
		
		JMenuItem mntmd = new JMenuItem("3D");
		mntmd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					view3d.setVisible(true);
			}
		});
		mntmd.setFont(new Font("Arial", Font.BOLD, 12));
		mnView.add(mntmd);
		
		JMenu mnNewMenu = new JMenu("Plot");
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 13));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Bar Chart");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				barChartView.setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("Arial", Font.BOLD, 12));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Line Chart");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		lineChartView.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Arial", Font.BOLD, 12));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnModule = new JMenu("Module");
		mnModule.setForeground(Color.BLACK);
		mnModule.setFont(new Font("Arial", Font.BOLD, 13));
		menuBar.add(mnModule);
		
		JMenu mntmNewMenuItem_2 = new JMenu("Matrix Acid Stimulation");
		mntmNewMenuItem_2.setFont(new Font("Arial", Font.BOLD, 12));
		mnModule.add(mntmNewMenuItem_2);
		
		  JMenuItem MCarbonate = new JMenuItem("Carbonate");
		  MCarbonate.addMouseListener(new MouseAdapter() {
		  	@Override
		  	public void mouseClicked(MouseEvent arg0) {
		  		
		  		JOptionPane.showMessageDialog(null, "ACID Carbonate Module Selected.");
		  	}
		  });
		  MCarbonate.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		     
		  		setIsmoduleSelected(2);  		
		  		
		  	}
		  });
		    mntmNewMenuItem_2.add(MCarbonate);
		    mntmNewMenuItem_2.addSeparator();
		    mnModule.add(mntmNewMenuItem_2);
		    
		    JMenuItem SandStoneModule = new JMenuItem("SandStone");
		    SandStoneModule.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		setIsmoduleSelected(3);  
		    		
		    	}
		    });
		    mntmNewMenuItem_2.add(SandStoneModule);
		   // mntmNewMenuItem_2.addSeparator();
		    mnModule.add(mntmNewMenuItem_2);
		
		
		JMenu mntmNewMenuItem_3 = new JMenu("Fracture Stimulation");
		mntmNewMenuItem_3.setFont(new Font("Arial", Font.BOLD, 12));
		mnModule.add(mntmNewMenuItem_3);
		

		 JMenuItem Carbonate2 = new JMenuItem("Carbonate");
			    mntmNewMenuItem_3.add(Carbonate2);
			    mntmNewMenuItem_3.addSeparator();
			    mnModule.add(mntmNewMenuItem_3);
			    
			    JMenuItem SandStone2 = new JMenuItem("SandStone");
			    mntmNewMenuItem_3.add(SandStone2);
			   // mntmNewMenuItem_3.addSeparator();
			    mnModule.add(mntmNewMenuItem_3);
				
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("SandStone Compatibility Analysis ");
		mntmNewMenuItem_4.setFont(new Font("Arial", Font.BOLD, 12));
		mnModule.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Economic Evaluation ");
		mntmNewMenuItem_5.setFont(new Font("Arial", Font.BOLD, 12));
		mnModule.add(mntmNewMenuItem_5);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setForeground(Color.BLACK);
		mnHelp.setFont(new Font("Arial", Font.BOLD, 13));
		menuBar.add(mnHelp);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("System  Requirements");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			systemRequirement.setVisible(true);
			}
		});
		mntmNewMenuItem_6.setFont(new Font("Arial", Font.BOLD, 12));
		mnHelp.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Technical Manual");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			technicalManual.setVisible(true);
			}
		});
		mntmNewMenuItem_7.setFont(new Font("Arial", Font.BOLD, 12));
		mnHelp.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("User Manual");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			userManual.setVisible(true);
			}
		});
		mntmNewMenuItem_8.setFont(new Font("Arial", Font.BOLD, 12));
		mnHelp.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("About ChemPlace");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			aboutChemPlace.setVisible(true);
			}
		});
		mntmNewMenuItem_9.setFont(new Font("Arial", Font.BOLD, 12));
		mnHelp.add(mntmNewMenuItem_9);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 32, 1354, 33);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newProject.setVisible(true);
				}
		});
		button.setIcon(new ImageIcon(Home.class.getResource("/images/newproject.png")));
		button.setBounds(10, 0, 33, 28);
		panel_2.add(button);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				
				openProject.setVisible(true);
				}
		});
		btnNewButton_4.setIcon(new ImageIcon(Home.class.getResource("/images/Openproject.png")));
		btnNewButton_4.setBounds(45, 0, 33, 28);
		panel_2.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon(Home.class.getResource("/images/Saveaswi.png")));
		btnNewButton_5.setBounds(81, 0, 27, 28);
		panel_2.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setIcon(new ImageIcon(Home.class.getResource("/images/copy.jpg")));
		btnNewButton_6.setBounds(110, 0, 33, 28);
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				barChartView.setVisible(true);
			}
		});
		btnNewButton_7.setIcon(new ImageIcon(Home.class.getResource("/images/chart.jpg")));
		btnNewButton_7.setBounds(145, 0, 41, 28);
		panel_2.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view3d.setVisible(true);
				}
		});
		btnNewButton_8.setIcon(new ImageIcon(Home.class.getResource("/images/3d.jpg")));
		btnNewButton_8.setBounds(188, 0, 41, 28);
		panel_2.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.setIcon(new ImageIcon(Home.class.getResource("/images/zoomin.png")));
		btnNewButton_9.setBounds(364, 0, 41, 28);
		panel_2.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("");
		btnNewButton_10.setIcon(new ImageIcon(Home.class.getResource("/images/zoomout.png")));
		btnNewButton_10.setBounds(405, 0, 41, 28);
		panel_2.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineChartView.setVisible(true);
			}
		});
		btnNewButton_11.setIcon(new ImageIcon(Home.class.getResource("/images/line_chart_icon.jpg")));
		btnNewButton_11.setBounds(229, 0, 41, 28);
		panel_2.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runtime rt=Runtime.getRuntime();
		        try {
		            rt.exec("c:/WINDOWS/system32/calc.exe");
		           
		        } catch (IOException ex) {
		           
		        }
		        
		    
			}
		});
		btnNewButton_12.setIcon(new ImageIcon(Home.class.getResource("/images/Calculator.png")));
		btnNewButton_12.setBounds(271, 0, 41, 28);
		panel_2.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runtime rt=Runtime.getRuntime();
		        try {
		            rt.exec("c:/WINDOWS/system32/notepad.exe");
		           
		        } catch (IOException ex) {
		           
		        } 
			}
		});
		btnNewButton_13.setIcon(new ImageIcon(Home.class.getResource("/images/index.jpg")));
		btnNewButton_13.setBounds(312, 0, 47, 28);
		panel_2.add(btnNewButton_13);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(60, 118, 182));
		panel_3.setBounds(0, 65, 126, 625);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnInput = new JButton("Input");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   
					 
					inputModuleAcid_Carbonate.setVisible(true);
					inputModuleAcid_Carbonate.resetFormData();
				
			}
		});
		btnInput.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnInput.setBounds(10, 11, 92, 37);
		panel_3.add(btnInput);
		
		JButton btnOutput = new JButton("Output");
		btnOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewOutput.setVisible(true);
			}
		});
		btnOutput.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnOutput.setBounds(10, 59, 92, 36);
		panel_3.add(btnOutput);
		
		JButton btndView = new JButton("3D View");
		btndView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view3d.setVisible(true);
			}
		});
		btndView.setFont(new Font("Tahoma", Font.BOLD, 12));
		btndView.setBounds(10, 106, 92, 37);
		panel_3.add(btndView);
		
		JLabel lblImport = new JLabel("Import");
		lblImport.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblImport.setBounds(34, 249, 68, 14);
		panel_3.add(lblImport);
		
		JButton btnNewButton = new JButton("LOG");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(0, 277, 112, 37);
		panel_3.add(btnNewButton);
		
		JButton btnWarmhole = new JButton("WARM HOLE");
		btnWarmhole.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnWarmhole.setBounds(0, 325, 112, 37);
		panel_3.add(btnWarmhole);
		
		JButton btnNewButton_1 = new JButton("WELL DESG");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(0, 374, 112, 37);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("PRESS RATE");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(0, 422, 112, 37);
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("DTS");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(0, 470, 112, 37);
		panel_3.add(btnNewButton_3);
	}
}
