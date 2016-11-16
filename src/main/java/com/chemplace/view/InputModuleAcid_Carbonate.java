package com.chemplace.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chemplace.view.model.beans.AcidInjectionTbl;
import com.chemplace.view.model.beans.AdditionalInpuDataTbl;
import com.chemplace.view.model.beans.FluidPropertiesTbl;
import com.chemplace.view.model.beans.ProjectTbl;
import com.chemplace.view.model.beans.ReservoirlethologyTbl;
import com.chemplace.view.model.beans.SensitivityAnalysisTbl;
import com.chemplace.view.model.beans.WelCompletionDataTbl;
import com.chemplace.view.model.beans.WellLayersStageTbl;
import com.chemplace.view.model.dao.AcidInjectionPlan;
import com.chemplace.view.model.dao.AcidInjectionPlanModel;
import com.chemplace.view.model.dao.AcidInjectionTblDao;
import com.chemplace.view.model.dao.AdditionalInpuDataTblDao;
import com.chemplace.view.model.dao.FluidPropertiesTblDao;
import com.chemplace.view.model.dao.ProjectDao;
import com.chemplace.view.model.dao.ReservoirlethologyTblDao;
import com.chemplace.view.model.dao.Reservoirlithology;
import com.chemplace.view.model.dao.ReservoirlithologyModel;
import com.chemplace.view.model.dao.SensitivityAnalysisTblDao;
import com.chemplace.view.model.dao.WelCompletionDataTblDao;
import com.chemplace.view.model.dao.WellLayersStageTblDao;
import com.chemplace.view.service.InputFile;
@Component
public class InputModuleAcid_Carbonate extends JFrame {
	final JScrollPane scrollPane_1;
	final JScrollPane scrollPane;
	   JButton btnSave;
	 
	
	ProjectTbl projectTblglobal;
	boolean isupadate=false;
	@Autowired
	private WellLayersStageTblDao wellLayersStageTblDao;
	
	@Autowired
	private SensitivityAnalysisTblDao sensitivityAnalysisTblDao;
	
	@Autowired
	private ReservoirlethologyTblDao reservoirlethologyTblDao;
	
	@Autowired
	private AcidInjectionTblDao acidInjectionTblDao;
	
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private AdditionalInpuDataTblDao additionalInpuDataTblDao;
	
	@Autowired
	private FluidPropertiesTblDao fluidPropertiesTblDao;
	
	@Autowired
	private WelCompletionDataTblDao welCompletionDataTblDao;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField textWellname;
	private JTextField textlayerNo;
	private JTextField textINJStages;
	private JTextField maxpress;
	private JTextField tubfc;
	private JTextField driverterconsk;
	private JTextField rockdensity;
	private JTextField nooftimesteps;
	private JTextField postprodbblsd;
	private JTextField fracApperture;
	private JTextField fracpress;
	private JTextField formvf;
	private JTextField driverterconn;
	private JTextField fraclength;
	private JTextField noofgrids;
	private JTextField postprodpress;
	private JTextField fraclengthft;
	private JTextField dcase1;
	private JTextField dcase2;
	private JTextField dcase3;
	private JTextField pcase1;
	private JTextField pcase2;
	private JTextField pacase3;
	private JTextField acidcase1;
	private JTextField acidvolcase1;
	private JTextField dscase1;
	private JTextField dsncae1;
	private JTextField acidcase2;
	private JTextField acidvolcase2;
	private JTextField dscase2;
	private JTextField dsncae2;
	private JTextField acidcase3;
	private JTextField acidvolcase3;
	private JTextField dscase3;
	private JTextField dsncae3;
	private JTextField resoildensity;
	private JTextField reswaterdensity;
	private JTextField resgasdencity;
	private JTextField resoil;
	private JTextField reswatervisc;
	private JTextField resgasvis;
	private JTextField perfdia;
	private JTextField lateraldepth;
	private JTextField wellmd;
	private JTextField welldia;
	private JTextField lateradepth;
	private JTextField welltvd;
	JLabel DiverterSherConsn;
	JComboBox simulationtype;
	JComboBox welltype;
	JComboBox completiontype;
	 
	JLabel lblDiverterShearCons; 
	JLabel lblAcidVolbbls;
	
	private JLabel lblPumpRatebmp;
	private JLabel lblAcidConc;
	private JLabel lblDiverterViscp; 
	private JTable table;
	private JTable table_1;
	AcidInjectionPlanModel model1;
	 AcidInjectionPlan row1;
	 List< AcidInjectionPlan>   AcidInjectionPlanList1 = new ArrayList< AcidInjectionPlan>();
	 ReservoirlithologyModel model2;
	 Reservoirlithology row2;
	List< Reservoirlithology>   ReservoirlithologyList = new ArrayList<Reservoirlithology>();
	private JTextField jetdia;
	private JTextField aciddencity;
	private JTextField aciddissolving;

	/**
	 * Launch the application.
	 */
	 

	/**
	 * Create the frame.
	 */
	public InputModuleAcid_Carbonate() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("InputModuleAcid_Carbonate");
		setBounds(130, 95, 1208, 622);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 118, 182));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//layers jpanel scrollbar
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(SystemColor.textHighlight));
		panel_4.setBounds(10, 65, 668, 140);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		  scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setPreferredSize(new Dimension(510, 130));
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(0, 0, 668, 140);
		panel_4.add(scrollPane);
		
		
		///stages jpanel scrollbar
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(51, 153, 255)));
		panel_6.setBounds(10, 235, 668, 130);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
	    scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_1.setPreferredSize(new Dimension(510, 130));
		scrollPane_1.setAutoscrolls(true);
		scrollPane_1.setBounds(0, 0, 668, 130);
		panel_6.add(scrollPane_1);
		 
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 87));
		panel_1.setBounds(11, 11, 195, 30);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblWellName = new JLabel("Well Name");
		lblWellName.setForeground(Color.BLACK);
		lblWellName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWellName.setBounds(10, 0, 94, 30);
		panel_1.add(lblWellName);
		
		textWellname = new JTextField();
		textWellname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				String textWellnameget=textWellname.getText().toString().trim();
				if(textWellnameget.equalsIgnoreCase(""))
				{
					
					textWellname.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Please enter well name");
				}
				else
				{
					textWellname.setBackground(Color.white);
				}
				
			}
			@Override
			public void focusGained(FocusEvent e) {
				
				textWellname.setBackground(Color.white);
			}
		});
		 
		textWellname.setFont(new Font("Tahoma", Font.BOLD, 12));
		textWellname.setBounds(107, 5, 74, 20);
		panel_1.add(textWellname);
		textWellname.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 87));
		panel_2.setBounds(229, 11, 182, 30);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNoOfLayers = new JLabel("No. of Layers");
		lblNoOfLayers.setForeground(Color.BLACK);
		lblNoOfLayers.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNoOfLayers.setBounds(10, 0, 97, 30);
		panel_2.add(lblNoOfLayers);
		
		textlayerNo = new JTextField();
		 
		textlayerNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
						
			}
			@Override
			public void keyReleased(KeyEvent e) {
				
				int rowno1=3;
				ReservoirlithologyList.clear();
				
				try
				{
					if(textlayerNo.getText().toString().trim().equalsIgnoreCase(""))
					{
						rowno1=3;
					}
					else
				{
						rowno1 = Integer.parseInt(textlayerNo.getText());
				}
				
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				/// layers 
				
			
				for(int j=1; j<=rowno1; j++)
				{
					ReservoirlithologyList.add(row2 = new  Reservoirlithology(j,0.0,0.0,0.0,0.0,0.0,0.0,0.0,"oil"));
			    }
				model2 = new  ReservoirlithologyModel(ReservoirlithologyList);
				
		 
				
				table_1 = new JTable(model2);
				  JTableHeader header = table_1.getTableHeader();
			      header.setBackground(new Color(91, 155, 213));
			      header.setForeground(Color.white);
				scrollPane.setViewportView(table_1);	
						
			}
		});
		textlayerNo.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
			
			
			}
		});
		
		textlayerNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		textlayerNo.setBounds(104, 5, 70, 20);
		panel_2.add(textlayerNo);
		textlayerNo.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 204, 87));
		panel_3.setBounds(421, 11, 224, 30);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNoOf = new JLabel("No of INJ Stages");
		lblNoOf.setForeground(Color.BLACK);
		lblNoOf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNoOf.setBounds(10, 0, 127, 30);
		panel_3.add(lblNoOf);
		
		textINJStages = new JTextField();
		textINJStages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
			}
		});
		textINJStages.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
			
				
				
				
			}
		});
		textINJStages.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				String getlayerno=textINJStages.getText();
				if(getlayerno.equalsIgnoreCase(""))
				{
					textINJStages.setBackground(Color.red);
				    JOptionPane.showMessageDialog(null, "Please enter no of layer.");
				}
				else if(!isInteger(getlayerno,10))
				{
					textINJStages.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Please enter only numeric no.");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				
				textINJStages.setBackground(Color.white);
			}
		});
		textINJStages.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
							}
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				int rowno1=3;
				AcidInjectionPlanList1.clear();
				
				try
				{
					if(textINJStages.getText().toString().trim().equalsIgnoreCase(""))
					{
						rowno1=3;
					}
					else
				{
						rowno1 = Integer.parseInt(textINJStages.getText());
				}
				
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
				 
								
				for(int i=1; i<=rowno1; i++)
				{
					   AcidInjectionPlanList1.add(row1 = new  AcidInjectionPlan(i,"oil",0.0,0.0,0.0,0.0,0.0,0.0,0.0));
			    }
			         model1 = new  AcidInjectionPlanModel( AcidInjectionPlanList1);
			 
			
			 table = new JTable(model1);
		     JTableHeader header1= table.getTableHeader();
		      header1.setBackground(new Color(91, 155, 213));
		      header1.setForeground(Color.white);
			 scrollPane_1.setViewportView(table);	
			}
		});
		textINJStages.setFont(new Font("Tahoma", Font.BOLD, 12));
		textINJStages.setBounds(131, 5, 82, 20);
		panel_3.add(textINJStages);
		textINJStages.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(SystemColor.textHighlight));
		panel_5.setBounds(688, 43, 504, 124);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_16 = new JLabel("2");
		label_16.setBounds(10, 49, 14, 14);
		panel_5.add(label_16);
		
		JLabel label_17 = new JLabel("3");
		label_17.setBounds(10, 74, 14, 14);
		panel_5.add(label_17);
		
		JLabel label_18 = new JLabel("4");
		label_18.setBounds(10, 99, 14, 14);
		panel_5.add(label_18);
		
		JLabel lblWellDiainch = new JLabel("Well Dia (Inch)");
		lblWellDiainch.setBounds(30, 52, 110, 14);
		panel_5.add(lblWellDiainch);
		
		JLabel lblWellMdft = new JLabel("Well TVD (FT)");
		lblWellMdft.setBounds(246, 74, 119, 20);
		panel_5.add(lblWellMdft);
		
		JLabel lblLateralslantedft = new JLabel("Lateral  Depth (FT)");
		lblLateralslantedft.setBounds(246, 99, 119, 14);
		panel_5.add(lblLateralslantedft);
		
		wellmd = new JTextField();
		wellmd.setBounds(130, 74, 106, 20);
		panel_5.add(wellmd);
		wellmd.setColumns(10);
		
		JLabel lblPerfDiainch = new JLabel("Perf Dia (Inch)");
		lblPerfDiainch.setBounds(247, 49, 118, 17);
		panel_5.add(lblPerfDiainch);
		
		JLabel lblWellTvdft = new JLabel("Well MD(FT)");
		lblWellTvdft.setBounds(30, 77, 110, 14);
		panel_5.add(lblWellTvdft);
		
		JLabel lblLateralAtDepthft = new JLabel("Latera Depth (FT)");
		lblLateralAtDepthft.setBounds(30, 99, 110, 17);
		panel_5.add(lblLateralAtDepthft);
		
		perfdia = new JTextField();
		perfdia.setBounds(377, 49, 117, 17);
		panel_5.add(perfdia);
		perfdia.setColumns(10);
		
		lateraldepth = new JTextField();
		lateraldepth.setBounds(377, 99, 117, 20);
		panel_5.add(lateraldepth);
		lateraldepth.setColumns(10);
		
		welldia = new JTextField();
		welldia.setBounds(130, 49, 106, 20);
		panel_5.add(welldia);
		welldia.setColumns(10);
		
		lateradepth = new JTextField();
		lateradepth.setBounds(130, 99, 106, 20);
		panel_5.add(lateradepth);
		lateradepth.setColumns(10);
		
		welltvd = new JTextField();
		welltvd.setBounds(377, 74, 117, 20);
		panel_5.add(welltvd);
		welltvd.setColumns(10);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.LIGHT_GRAY);
		panel_13.setBounds(0, 0, 504, 20);
		panel_5.add(panel_13);
		panel_13.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Well/Completion Design");
		lblNewLabel_3.setBounds(206, 0, 158, 16);
		panel_13.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton btnHelp_3 = new JButton("Help");
		btnHelp_3.setBounds(415, 0, 89, 21);
		panel_13.add(btnHelp_3);
		
		JLabel label_20 = new JLabel("1");
		label_20.setBounds(10, 31, 14, 14);
		panel_5.add(label_20);
		
		JLabel lblWellType = new JLabel("Well Type");
		lblWellType.setBounds(30, 27, 110, 14);
		panel_5.add(lblWellType);
		
		  welltype = new JComboBox();
		welltype.setModel(new DefaultComboBoxModel(new String[] {"Vertical", "Horizontal", "Slanted"}));
		welltype.setBounds(130, 24, 106, 21);
		panel_5.add(welltype);
		
		JLabel lblCompletionType = new JLabel("Completion Type");
		lblCompletionType.setBounds(246, 27, 119, 14);
		panel_5.add(lblCompletionType);
		
	    completiontype = new JComboBox();
		completiontype.setModel(new DefaultComboBoxModel(new String[] {"Openhole", "Cashed"}));
		completiontype.setBounds(377, 27, 117, 18);
		panel_5.add(completiontype);
		
	
			
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(SystemColor.textHighlight));
		panel_7.setBounds(688, 319, 504, 256);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.LIGHT_GRAY);
		panel_10.setBounds(0, 0, 504, 20);
		panel_7.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Additional Input Data");
		lblNewLabel_2.setBounds(207, 0, 183, 21);
		panel_10.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton btnHelp_5 = new JButton("Help");
		btnHelp_5.setBounds(415, 0, 89, 21);
		panel_10.add(btnHelp_5);
		
		JLabel label = new JLabel("2");
		label.setBounds(10, 76, 16, 14);
		panel_7.add(label);
		
		JLabel label_1 = new JLabel("3");
		label_1.setBounds(10, 101, 16, 14);
		panel_7.add(label_1);
		
		JLabel label_2 = new JLabel("4");
		label_2.setBounds(10, 127, 16, 14);
		panel_7.add(label_2);
		
		JLabel label_3 = new JLabel("5");
		label_3.setBounds(10, 152, 16, 14);
		panel_7.add(label_3);
		
		JLabel label_4 = new JLabel("6");
		label_4.setBounds(10, 177, 16, 14);
		panel_7.add(label_4);
		
		JLabel label_5 = new JLabel("7");
		label_5.setBounds(10, 202, 16, 14);
		panel_7.add(label_5);
		
		JLabel lblNewLabel_8 = new JLabel("Max Press(psi)");
		lblNewLabel_8.setBounds(20, 78, 132, 14);
		panel_7.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Tub Friction Coff");
		lblNewLabel_9.setBounds(20, 101, 132, 14);
		panel_7.add(lblNewLabel_9);
		
		JLabel lblDiverterConsK = new JLabel("Driverter Const. K");
		lblDiverterConsK.setBounds(20, 126, 132, 14);
		panel_7.add(lblDiverterConsK);
		
		JLabel lblRockDensitykg = new JLabel("Rock Density(KG/KG)");
		lblRockDensitykg.setBounds(20, 152, 132, 14);
		panel_7.add(lblRockDensitykg);
		
		JLabel lblNoOfTimesteps = new JLabel("No. of Timepsteps");
		lblNoOfTimesteps.setBounds(20, 177, 132, 14);
		panel_7.add(lblNoOfTimesteps);
		
		JLabel lblPostProdbblsd = new JLabel("Post Prod (bbls/D)");
		lblPostProdbblsd.setBounds(20, 202, 132, 14);
		panel_7.add(lblPostProdbblsd);
		
		maxpress = new JTextField();
		maxpress.setBounds(147, 73, 89, 20);
		panel_7.add(maxpress);
		maxpress.setColumns(10);
		
		tubfc = new JTextField();
		tubfc.setBounds(147, 98, 89, 20);
		panel_7.add(tubfc);
		tubfc.setColumns(10);
		
		driverterconsk = new JTextField();
		driverterconsk.setBounds(147, 124, 89, 20);
		panel_7.add(driverterconsk);
		driverterconsk.setColumns(10);
		
		rockdensity = new JTextField();
		rockdensity.setBounds(147, 149, 89, 20);
		panel_7.add(rockdensity);
		rockdensity.setColumns(10);
		
		nooftimesteps = new JTextField();
		nooftimesteps.setBounds(147, 174, 89, 20);
		panel_7.add(nooftimesteps);
		nooftimesteps.setColumns(10);
		
		postprodbblsd = new JTextField();
		postprodbblsd.setBounds(147, 199, 89, 20);
		panel_7.add(postprodbblsd);
		postprodbblsd.setColumns(10);
		
		JLabel lblFracPresspsi = new JLabel("Frac Press (psi)");
		lblFracPresspsi.setBounds(246, 76, 143, 14);
		panel_7.add(lblFracPresspsi);
		
		JLabel lblFormationVolFactor = new JLabel("Form. Vol. Factor");
		lblFormationVolFactor.setBounds(246, 101, 143, 14);
		panel_7.add(lblFormationVolFactor);
		
		JLabel lblDiverterConsN = new JLabel("Diverter Const. n");
		lblDiverterConsN.setBounds(246, 127, 143, 14);
		panel_7.add(lblDiverterConsN);
		
		JLabel label_6 = new JLabel("8");
		label_6.setBounds(10, 230, 16, 15);
		panel_7.add(label_6);
		
		JLabel lblFracApperTureft = new JLabel("Frac Apperture (FT)");
		lblFracApperTureft.setBounds(20, 230, 132, 15);
		panel_7.add(lblFracApperTureft);
		
		fracApperture = new JTextField();
		fracApperture.setBounds(147, 227, 89, 18);
		panel_7.add(fracApperture);
		fracApperture.setColumns(10);
		
		JLabel lblLeakOffCoeff = new JLabel("Frac Lenth (Inch)");
		lblLeakOffCoeff.setBounds(246, 152, 143, 14);
		panel_7.add(lblLeakOffCoeff);
		
		JLabel lblNoOfGrids = new JLabel("No. of Grids");
		lblNoOfGrids.setBounds(246, 177, 143, 14);
		panel_7.add(lblNoOfGrids);
		
		JLabel lblPostProdpresspsi = new JLabel("Post Prod at Press (Psi)");
		lblPostProdpresspsi.setBounds(246, 202, 143, 14);
		panel_7.add(lblPostProdpresspsi);
		
		JLabel lblFraclengthft = new JLabel("Frac Length(FT)");
		lblFraclengthft.setBounds(246, 230, 143, 15);
		panel_7.add(lblFraclengthft);
		
		fracpress = new JTextField();
		fracpress.setBounds(391, 73, 89, 20);
		panel_7.add(fracpress);
		fracpress.setColumns(10);
		
		formvf = new JTextField();
		formvf.setBounds(390, 98, 90, 20);
		panel_7.add(formvf);
		formvf.setColumns(10);
		
		driverterconn = new JTextField();
		driverterconn.setBounds(391, 124, 89, 20);
		panel_7.add(driverterconn);
		driverterconn.setColumns(10);
		
		fraclength = new JTextField();
		fraclength.setBounds(391, 149, 89, 20);
		panel_7.add(fraclength);
		fraclength.setColumns(10);
		
		noofgrids = new JTextField();
		noofgrids.setBounds(391, 174, 89, 20);
		panel_7.add(noofgrids);
		noofgrids.setColumns(10);
		
		postprodpress = new JTextField();
		postprodpress.setBounds(390, 199, 90, 20);
		panel_7.add(postprodpress);
		postprodpress.setColumns(10);
		
		fraclengthft = new JTextField();
		fraclengthft.setBounds(391, 225, 89, 20);
		panel_7.add(fraclengthft);
		fraclengthft.setColumns(10);
		
		JLabel label_19 = new JLabel("1");
		label_19.setBounds(10, 48, 16, 14);
		panel_7.add(label_19);
		
		JLabel lblNewLabel_12 = new JLabel("Stimulation Type");
		lblNewLabel_12.setBounds(20, 48, 132, 19);
		panel_7.add(lblNewLabel_12);
		
		JLabel lblJetDia = new JLabel("Jet  Dia (Inch)");
		lblJetDia.setBounds(246, 48, 143, 17);
		panel_7.add(lblJetDia);
		
		jetdia = new JTextField();
		jetdia.setBounds(391, 48, 89, 20);
		panel_7.add(jetdia);
		jetdia.setColumns(10);
		
		 simulationtype = new JComboBox();
		simulationtype.setModel(new DefaultComboBoxModel(new String[] {"Carbonate", "Sandstone"}));
		simulationtype.setBounds(144, 47, 92, 20);
		panel_7.add(simulationtype);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(SystemColor.textHighlight));
		panel_8.setBounds(688, 178, 504, 130);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.LIGHT_GRAY);
		panel_12.setBounds(0, 0, 504, 21);
		panel_8.add(panel_12);
		panel_12.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Fluid Properties");
		lblNewLabel_4.setBounds(219, 0, 134, 21);
		panel_12.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton btnHelp_4 = new JButton("Help");
		btnHelp_4.setBounds(415, 0, 89, 21);
		panel_12.add(btnHelp_4);
		
		JLabel label_13 = new JLabel("2");
		label_13.setBounds(10, 56, 14, 14);
		panel_8.add(label_13);
		
		JLabel label_14 = new JLabel("3");
		label_14.setBounds(10, 79, 14, 22);
		panel_8.add(label_14);
		
		JLabel label_15 = new JLabel("4");
		label_15.setBounds(10, 107, 14, 14);
		panel_8.add(label_15);
		
		JLabel lblResOliDensitykgm = new JLabel("Res Oil Density (Kg/m3)");
		lblResOliDensitykgm.setBounds(24, 56, 134, 14);
		panel_8.add(lblResOliDensitykgm);
		
		JLabel lblResWaterDensitykgm = new JLabel("Res. Water Density(Kg/m3)");
		lblResWaterDensitykgm.setBounds(24, 79, 146, 22);
		panel_8.add(lblResWaterDensitykgm);
		
		JLabel lblResGasDensitykgm = new JLabel("Res/Gas Density (Kg/m3)");
		lblResGasDensitykgm.setBounds(24, 107, 146, 14);
		panel_8.add(lblResGasDensitykgm);
		
		resoildensity = new JTextField();
		resoildensity.setBounds(172, 53, 77, 20);
		panel_8.add(resoildensity);
		resoildensity.setColumns(10);
		
		reswaterdensity = new JTextField();
		reswaterdensity.setBounds(172, 79, 77, 22);
		panel_8.add(reswaterdensity);
		reswaterdensity.setColumns(10);
		
		resgasdencity = new JTextField();
		resgasdencity.setBounds(172, 104, 77, 20);
		panel_8.add(resgasdencity);
		resgasdencity.setColumns(10);
		
		JLabel lblResOilViscp = new JLabel("Res Oil Vis(cP)");
		lblResOilViscp.setBounds(259, 56, 124, 14);
		panel_8.add(lblResOilViscp);
		
		JLabel lblResWaterViscp = new JLabel("Res Water Visc(cP)");
		lblResWaterViscp.setBounds(259, 81, 124, 14);
		panel_8.add(lblResWaterViscp);
		
		JLabel lblResGasViscp = new JLabel("Res Gas Vis (cP)");
		lblResGasViscp.setBounds(259, 107, 124, 14);
		panel_8.add(lblResGasViscp);
		
		resoil = new JTextField();
		resoil.setBounds(388, 53, 106, 20);
		panel_8.add(resoil);
		resoil.setColumns(10);
		
		reswatervisc = new JTextField();
		reswatervisc.setBounds(388, 78, 106, 20);
		panel_8.add(reswatervisc);
		reswatervisc.setColumns(10);
		
		resgasvis = new JTextField();
		resgasvis.setBounds(388, 104, 106, 20);
		panel_8.add(resgasvis);
		resgasvis.setColumns(10);
		
		JLabel label_21 = new JLabel("1");
		label_21.setBounds(10, 31, 14, 14);
		panel_8.add(label_21);
		
		JLabel lblAcidDensitykgm = new JLabel("Acid Density (Kg.m3)");
		lblAcidDensitykgm.setBounds(24, 31, 134, 14);
		panel_8.add(lblAcidDensitykgm);
		
		aciddencity = new JTextField();
		aciddencity.setBounds(172, 28, 77, 20);
		panel_8.add(aciddencity);
		aciddencity.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Acid Dissolving Power");
		lblNewLabel_6.setBounds(259, 32, 124, 14);
		panel_8.add(lblNewLabel_6);
		
		aciddissolving = new JTextField();
		aciddissolving.setBounds(388, 28, 106, 20);
		panel_8.add(aciddissolving);
		aciddissolving.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(SystemColor.textHighlight));
		panel_9.setBounds(11, 369, 668, 206);
		contentPane.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel label_7 = new JLabel("1");
		label_7.setBounds(10, 53, 24, 14);
		panel_9.add(label_7);
		
		JLabel label_8 = new JLabel("2");
		label_8.setBounds(10, 78, 24, 14);
		panel_9.add(label_8);
		
		JLabel label_9 = new JLabel("3");
		label_9.setBounds(10, 103, 24, 14);
		panel_9.add(label_9);
		
		JLabel label_10 = new JLabel("4");
		label_10.setBounds(10, 127, 24, 14);
		panel_9.add(label_10);
		
		JLabel label_11 = new JLabel("5");
		label_11.setBounds(10, 149, 24, 21);
		panel_9.add(label_11);
		
		lblDiverterViscp = new JLabel("DIVERTER VIS(cP)");
		lblDiverterViscp.setBounds(46, 53, 160, 14);
		panel_9.add(lblDiverterViscp);
		
		 lblPumpRatebmp = new JLabel("PUMP RATE(BMP)");
		lblPumpRatebmp.setBounds(46, 78, 160, 14);
		panel_9.add(lblPumpRatebmp);
		
		  lblAcidConc = new JLabel("ACID CONC(%)");
		lblAcidConc.setBounds(46, 103, 160, 14);
		panel_9.add(lblAcidConc);
		
		 lblAcidVolbbls = new JLabel("ACID VOL(BBLS)");
		lblAcidVolbbls.setBounds(46, 127, 160, 18);
		panel_9.add(lblAcidVolbbls);
		
		 lblDiverterShearCons = new JLabel("DIVERTER SHEAR CONS k");
		lblDiverterShearCons.setBounds(46, 156, 160, 14);
		panel_9.add(lblDiverterShearCons);
		
		JLabel label_12 = new JLabel("6");
		label_12.setBounds(10, 182, 12, 15);
		panel_9.add(label_12);
		
		  DiverterSherConsn = new JLabel("DIVERTER SHEAR CONS n");
		DiverterSherConsn.setBounds(46, 182, 160, 14);
		panel_9.add(DiverterSherConsn);
		
		dcase1 = new JTextField();
		dcase1.setBounds(227, 48, 124, 20);
		panel_9.add(dcase1);
		dcase1.setColumns(10);
		
		dcase2 = new JTextField();
		dcase2.setBounds(378, 48, 125, 20);
		panel_9.add(dcase2);
		dcase2.setColumns(10);
		
		dcase3 = new JTextField();
		dcase3.setBounds(536, 48, 124, 20);
		panel_9.add(dcase3);
		dcase3.setColumns(10);
		
		pcase1 = new JTextField();
		pcase1.setBounds(227, 73, 124, 20);
		panel_9.add(pcase1);
		pcase1.setColumns(10);
		
		pcase2 = new JTextField();
		pcase2.setBounds(378, 73, 125, 20);
		panel_9.add(pcase2);
		pcase2.setColumns(10);
		
		pacase3 = new JTextField();
		pacase3.setBounds(536, 73, 124, 20);
		panel_9.add(pacase3);
		pacase3.setColumns(10);
		
		acidcase1 = new JTextField();
		acidcase1.setBounds(227, 98, 124, 20);
		panel_9.add(acidcase1);
		acidcase1.setColumns(10);
		
		acidvolcase1 = new JTextField();
		acidvolcase1.setBounds(227, 122, 124, 20);
		panel_9.add(acidvolcase1);
		acidvolcase1.setColumns(10);
		
		dscase1 = new JTextField();
		dscase1.setBounds(227, 149, 124, 20);
		panel_9.add(dscase1);
		dscase1.setColumns(10);
		
		dsncae1 = new JTextField();
		dsncae1.setBounds(227, 177, 124, 20);
		panel_9.add(dsncae1);
		dsncae1.setColumns(10);
		
		acidcase2 = new JTextField();
		acidcase2.setBounds(378, 98, 125, 20);
		panel_9.add(acidcase2);
		acidcase2.setColumns(10);
		
		acidvolcase2 = new JTextField();
		acidvolcase2.setBounds(378, 122, 125, 20);
		panel_9.add(acidvolcase2);
		acidvolcase2.setColumns(10);
		
		dscase2 = new JTextField();
		dscase2.setBounds(378, 147, 125, 20);
		panel_9.add(dscase2);
		dscase2.setColumns(10);
		
		dsncae2 = new JTextField();
		dsncae2.setBounds(378, 177, 125, 20);
		panel_9.add(dsncae2);
		dsncae2.setColumns(10);
		
		acidcase3 = new JTextField();
		acidcase3.setBounds(536, 98, 124, 20);
		panel_9.add(acidcase3);
		acidcase3.setColumns(10);
		
		acidvolcase3 = new JTextField();
		acidvolcase3.setBounds(536, 122, 124, 20);
		panel_9.add(acidvolcase3);
		acidvolcase3.setColumns(10);
		
		dscase3 = new JTextField();
		dscase3.setBounds(536, 147, 124, 20);
		panel_9.add(dscase3);
		dscase3.setColumns(10);
		
		dsncae3 = new JTextField();
		dsncae3.setBounds(536, 177, 124, 20);
		panel_9.add(dsncae3);
		dsncae3.setColumns(10);
		
		JLabel lblCaseI = new JLabel("Case I");
		lblCaseI.setBounds(265, 23, 46, 14);
		panel_9.add(lblCaseI);
		lblCaseI.setForeground(Color.BLACK);
		lblCaseI.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCaseIii = new JLabel("Case III");
		lblCaseIii.setBounds(552, 23, 108, 14);
		panel_9.add(lblCaseIii);
		lblCaseIii.setForeground(Color.BLACK);
		lblCaseIii.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCaseIi = new JLabel("Case II");
		lblCaseIi.setBounds(392, 23, 111, 14);
		panel_9.add(lblCaseIi);
		lblCaseIi.setForeground(Color.BLACK);
		lblCaseIi.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(0, 0, 668, 21);
		panel_9.add(panel_11);
		panel_11.setBackground(Color.LIGHT_GRAY);
		panel_11.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Sensitivity Analysis");
		lblNewLabel_5.setBounds(264, 0, 185, 21);
		panel_11.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton btnHelp_2 = new JButton("Help");
		btnHelp_2.setBounds(579, 0, 89, 21);
		panel_11.add(btnHelp_2);
	 
		 JPanel panel_14 = new JPanel();
		 panel_14.setBackground(Color.LIGHT_GRAY);
		 panel_14.setBounds(11, 43, 667, 25);
		 contentPane.add(panel_14);
		 panel_14.setLayout(null);
		 
		 JLabel lblNewLabel = new JLabel("Reservoir Lithology");
		 lblNewLabel.setBounds(273, 0, 152, 20);
		 panel_14.add(lblNewLabel);
		 lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		 
		 JButton btnHelp = new JButton("Help");
		 btnHelp.setBounds(578, 0, 89, 20);
		 panel_14.add(btnHelp);
		 
		 JPanel panel_15 = new JPanel();
		 panel_15.setBounds(10, 216, 668, 19);
		 contentPane.add(panel_15);
		 panel_15.setBackground(Color.LIGHT_GRAY);
		 panel_15.setLayout(null);
		 
		 JLabel lblNewLabel_1 = new JLabel("Acid Injection Plan");
		 lblNewLabel_1.setBounds(275, 0, 179, 19);
		 panel_15.add(lblNewLabel_1);
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		 
		 JButton btnHelp_1 = new JButton("Help");
		 btnHelp_1.setBounds(579, -1, 89, 20);
		 panel_15.add(btnHelp_1);
		 
		 JButton btnImport = new JButton("IMPORT");
		 btnImport.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		JFileChooser fileChooser = new JFileChooser();
		 		int returnVal = fileChooser.showOpenDialog(fileChooser);
		 		if (returnVal == JFileChooser.APPROVE_OPTION) {
		 		     File  file = fileChooser.getSelectedFile();
		 		     importData(0, file);
		 		    // erfref
		 		     
		 		}
		 		
		 		
		 	}
		 });
		 btnImport.setBackground(new Color(255, 204, 87));
		 btnImport.setBounds(704, 10, 89, 31);
		 contentPane.add(btnImport);
		 btnImport.setFont(new Font("Tahoma", Font.BOLD, 12));
		 
		 JButton btnRun = new JButton("RUN");
		 btnRun.setBackground(new Color(255, 204, 87));
		 btnRun.setBounds(909, 10, 89, 31);
		 contentPane.add(btnRun);
		 btnRun.setFont(new Font("Tahoma", Font.BOLD, 12));
		 
		 JButton btnColse = new JButton("COLSE");
		 btnColse.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		
 		 		dispose();
		 	}
		 });
		 btnColse.setBackground(new Color(255, 204, 87));
		 btnColse.setBounds(1008, 10, 89, 31);
		 contentPane.add(btnColse);
		 btnColse.setFont(new Font("Tahoma", Font.BOLD, 12));
		 
		  btnSave = new JButton("SAVE");
		  btnSave.setBounds(803, 11, 96, 31);
		  contentPane.add(btnSave);
		  btnSave.setVisible(true);
		  btnSave.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		
		  		 try
				 {
				      
		  			
		  		  List<ProjectTbl> projectdetail=projectDao.getProjectDetail(Home.getCurrentProjectid());
				  
				  ProjectTbl projectTbl=new ProjectTbl();
				  projectTbl.setProjectName(projectdetail.get(0).getProjectName());
				  projectTbl.setCompanyName(projectdetail.get(0).getCompanyName());
				  projectTbl.setUserTbl(projectdetail.get(0).getUserTbl());
				  projectTbl.setProjectId(Home.getCurrentProjectid());	
				  
		  		  String usernamed=projectdetail.get(0).getUserName();
				  
				  WellLayersStageTbl wellLayersStageTbl=saveWellLayersStageTbl(projectTbl);
				  List<ReservoirlethologyTbl> listdatareservoirlethology=saveReservoirlethologyTbl(projectTbl);
				  List<AcidInjectionTbl> listacidinjectiontable=saveAcidInjectionTbl(projectTbl);
				  ArrayList<SensitivityAnalysisTbl> listsensitiveanalysistbl= saveSensitivityAnalysisTbl(projectTbl);
				  WelCompletionDataTbl welCompletionDataTbl=saveWelCompletionDataTbl(projectTbl);
				  FluidPropertiesTbl fluidPropertiesTbl= saveFluidPropertiesTbl(projectTbl);
				  AdditionalInpuDataTbl additionalInpuDataTbl=saveAdditionalInpuDataTbl(projectTbl);
				  
				  InputFile inputFile=new InputFile();
				  
				  try
				  {
				  inputFile.createTXTXLSFile(projectTbl, wellLayersStageTbl, listdatareservoirlethology, listacidinjectiontable, listsensitiveanalysistbl, 
						  welCompletionDataTbl, fluidPropertiesTbl, additionalInpuDataTbl);
				  
				  }
				  catch(Exception e)
				  {
					  e.printStackTrace();
				  }
				
          	  	 
          	  	 if(isupadate)
          	  	 {
          	  	 JOptionPane.showMessageDialog(null, "You have updated iput data successfully.");
          	  	 }
          	  	 else
          	  	 {
              	  	 JOptionPane.showMessageDialog(null, "Input data hase been saved successfully.");

          	  	 }
          	  	 }
				 catch(Exception e)
				 {
					 
					 if(isupadate)
					 {
						 JOptionPane.showMessageDialog(null, "There is some problem to update input data.");

					 }
					 else
					 {
						 JOptionPane.showMessageDialog(null, "There is some problem to save input data.");

					 }
					 e.printStackTrace();
					 
				 }
		  		
		  		
		  	}
		  });
		  btnSave.setBackground(new Color(255, 204, 87));
		  btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
	
		
}
	public static BigDecimal getBigDecimal( Object value ) {
        BigDecimal ret = null;
        if( value != null ) {
            if( value instanceof BigDecimal ) {
                ret = (BigDecimal) value;
            } else if( value instanceof String ) {
                ret = new BigDecimal( (String) value );
            } else if( value instanceof BigInteger ) {
                ret = new BigDecimal( (BigInteger) value );
            } else if( value instanceof Number ) {
                ret = new BigDecimal( ((Number)value).doubleValue() );
            } else {
                throw new ClassCastException("Not possible to coerce ["+value+"] from class "+value.getClass()+" into a BigDecimal.");
            }
        }
        return ret;
    }
	
//method for saving the data of welllayer stage table
	
public WellLayersStageTbl  saveWellLayersStageTbl(ProjectTbl projectTbl)
{
	 WellLayersStageTbl weLayersStageTbl = null;
	
	String Wellname="";
	 int NoOflayer=0,NoOfInjection=0;
	 Wellname=textWellname.getText().toString().trim();
	 
	 String layerno=textlayerNo.getText().toString().trim();
	 String injectionNo=textINJStages.getText().toString().trim();
	 
	 try
	 {
	 NoOflayer=Integer.parseInt(layerno);
	 NoOfInjection=Integer.parseInt(injectionNo);
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 		
	  if(Wellname.equalsIgnoreCase(""))
	  {
		  JOptionPane.showMessageDialog(null, "Please enter well name.");
	  }
	  
	  
	  else if(NoOflayer==0)
	  {
		  JOptionPane.showMessageDialog(null, "Please enter no of layer more than 0.");  
	  }
	  else if(NoOfInjection==0)
	  {
		  JOptionPane.showMessageDialog(null, "Please enter no of injection more than 0.");
	  }
	  else
	  {
      weLayersStageTbl=new WellLayersStageTbl();
	  weLayersStageTbl.setWellName(Wellname);
	  weLayersStageTbl.setNoOfLayers(NoOflayer);
	  weLayersStageTbl.setNoOfStages(NoOfInjection);
	  weLayersStageTbl.setProjectTbl(projectTbl);
	  if(isupadate)
	  {
		  wellLayersStageTblDao.update(weLayersStageTbl);
		  
	  }
	  else
	  {
		  wellLayersStageTblDao.save(weLayersStageTbl);
	  }
	  
	  
	  }
	return weLayersStageTbl;
}


ArrayList<SensitivityAnalysisTbl> saveSensitivityAnalysisTbl(ProjectTbl projectTbl)
{
	
	 ArrayList<SensitivityAnalysisTbl> listdatasensitvetable=new ArrayList<SensitivityAnalysisTbl>();
	 
	 
	 SensitivityAnalysisTbl sensitivityAnalysisTbl1=new SensitivityAnalysisTbl();
	 
	 sensitivityAnalysisTbl1.setSensitivityAnalysisName(lblDiverterViscp.getText().toString().trim());
	 sensitivityAnalysisTbl1.setProjectTbl(projectTbl);
	 
	 BigDecimal bcase1=new BigDecimal(dcase1.getText().toString().trim());
	 sensitivityAnalysisTbl1.setCase1(bcase1);
	 sensitivityAnalysisTbl1.setCase2(new BigDecimal(dcase2.getText().toString().trim()));
	 sensitivityAnalysisTbl1.setCase3(new BigDecimal(dcase3.getText().toString().trim()));
	 sensitivityAnalysisTbl1.setProjectTbl(projectTbl);
	 listdatasensitvetable.add(sensitivityAnalysisTbl1);
	 
     SensitivityAnalysisTbl sensitivityAnalysisTbl2=new SensitivityAnalysisTbl();
	 
	 sensitivityAnalysisTbl2.setSensitivityAnalysisName(lblPumpRatebmp.getText().toString().trim());
	 sensitivityAnalysisTbl2.setProjectTbl(projectTbl);
	 sensitivityAnalysisTbl2.setCase1(new BigDecimal(pcase1.getText().toString().trim()));
	 sensitivityAnalysisTbl2.setCase2(new BigDecimal(pcase2.getText().toString().trim()));
	 sensitivityAnalysisTbl2.setCase3(new BigDecimal(pacase3.getText().toString().trim()));
	 sensitivityAnalysisTbl2.setProjectTbl(projectTbl);
	 listdatasensitvetable.add(sensitivityAnalysisTbl2);
	 
     SensitivityAnalysisTbl sensitivityAnalysisTbl3=new SensitivityAnalysisTbl();
	 
	 sensitivityAnalysisTbl3.setSensitivityAnalysisName(lblAcidConc.getText().toString().trim());
	 sensitivityAnalysisTbl3.setProjectTbl(projectTbl);
	 sensitivityAnalysisTbl3.setCase1(new BigDecimal(acidcase1.getText().toString().trim()));
     sensitivityAnalysisTbl3.setCase2(new BigDecimal(acidcase2.getText().toString().trim()));
	 sensitivityAnalysisTbl3.setCase3(new BigDecimal(acidcase3.getText().toString().trim()));
	 sensitivityAnalysisTbl3.setProjectTbl(projectTbl);
	 listdatasensitvetable.add(sensitivityAnalysisTbl3);
	 
	 
	 
     SensitivityAnalysisTbl sensitivityAnalysisTbl4=new SensitivityAnalysisTbl();
	 
	 sensitivityAnalysisTbl4.setSensitivityAnalysisName(lblAcidVolbbls.getText().toString().trim());
	 sensitivityAnalysisTbl4.setProjectTbl(projectTbl);
	 sensitivityAnalysisTbl4.setCase1(new BigDecimal(acidvolcase1.getText().toString().trim()));
     sensitivityAnalysisTbl4.setCase2(new BigDecimal(acidvolcase2.getText().toString().trim()));
	 sensitivityAnalysisTbl4.setCase3(new BigDecimal(acidvolcase3.getText().toString().trim()));
	 sensitivityAnalysisTbl4.setProjectTbl(projectTbl);
	 listdatasensitvetable.add(sensitivityAnalysisTbl4);
	 
     SensitivityAnalysisTbl sensitivityAnalysisTbl5=new SensitivityAnalysisTbl();
	 
	 sensitivityAnalysisTbl5.setSensitivityAnalysisName(lblDiverterShearCons.getText().toString().trim());
	 sensitivityAnalysisTbl5.setProjectTbl(projectTbl);
	 sensitivityAnalysisTbl5.setCase1(new BigDecimal(dscase1.getText().toString().trim()));
     sensitivityAnalysisTbl5.setCase2(new BigDecimal(dscase2.getText().toString().trim()));
	 sensitivityAnalysisTbl5.setCase3(new BigDecimal(dscase3.getText().toString().trim()));
	 sensitivityAnalysisTbl5.setProjectTbl(projectTbl);
	 listdatasensitvetable.add(sensitivityAnalysisTbl5);
	 
      SensitivityAnalysisTbl sensitivityAnalysisTbl6=new SensitivityAnalysisTbl();
	 
	 sensitivityAnalysisTbl6.setSensitivityAnalysisName(DiverterSherConsn.getText().toString().trim());
	 sensitivityAnalysisTbl6.setProjectTbl(projectTbl);
	 sensitivityAnalysisTbl6.setCase1(new BigDecimal(dsncae1.getText().toString().trim()));
     sensitivityAnalysisTbl6.setCase2(new BigDecimal(dsncae2.getText().toString().trim()));
	 sensitivityAnalysisTbl6.setCase3(new BigDecimal(dsncae3.getText().toString().trim()));
	 sensitivityAnalysisTbl6.setProjectTbl(projectTbl);
	 listdatasensitvetable.add(sensitivityAnalysisTbl6);
	 
	 
	 if(isupadate)
	 {
		 sensitivityAnalysisTblDao.update(listdatasensitvetable);
	 }
	 else
	 {
		 sensitivityAnalysisTblDao.save(listdatasensitvetable);
	 }
	return listdatasensitvetable;
	 
	 
	
}

AdditionalInpuDataTbl saveAdditionalInpuDataTbl(ProjectTbl projectTbl)
{
	AdditionalInpuDataTbl additionalInpuDataTbl1=new AdditionalInpuDataTbl();
	 String hghg=(String) simulationtype.getSelectedItem();
	 
	 additionalInpuDataTbl1.setStimulationType(hghg);
	 additionalInpuDataTbl1.setJetDiaInch(new BigDecimal(jetdia.getText().toString().trim()));
	 additionalInpuDataTbl1.setMaxPressPsi(new BigDecimal(maxpress.getText().toString().trim()));
	 additionalInpuDataTbl1.setFracPressPsi(new BigDecimal(fracpress.getText().toString().trim()));
	 additionalInpuDataTbl1.setTubFrictionCoff(new BigDecimal(tubfc.getText().toString().trim()));
	 additionalInpuDataTbl1.setFormVolumeFactor(new BigDecimal(formvf.getText().toString().trim()));
	 additionalInpuDataTbl1.setDriverterConstK(new BigDecimal(driverterconsk.getText().toString().trim()));
	 additionalInpuDataTbl1.setDiverterCosntN(new BigDecimal(driverterconn.getText().toString().trim()));
	 additionalInpuDataTbl1.setRockDensityKg(new BigDecimal(rockdensity.getText().toString().trim()));
	 additionalInpuDataTbl1.setFracLenthInch(new BigDecimal(fraclength.getText().toString().trim()));
	 additionalInpuDataTbl1.setNoOfTimepsteps(new BigDecimal(nooftimesteps.getText().toString().trim()));
	 additionalInpuDataTbl1.setNoOfGrids(new BigDecimal(noofgrids.getText().toString().trim()));
	 additionalInpuDataTbl1.setPostProdBbls(new BigDecimal(postprodbblsd.getText().toString().trim()));
	 additionalInpuDataTbl1.setPostProdAtPressPsi(new BigDecimal(postprodpress.getText().toString().trim()));
	 additionalInpuDataTbl1.setFracAppertureFt(new BigDecimal(fracApperture.getText().toString().trim()));
	 additionalInpuDataTbl1.setFracLengthFt(new BigDecimal(fraclengthft.getText().toString().trim()));
	 additionalInpuDataTbl1.setProjectTbl(projectTbl);
	 
	 if(isupadate)
	 {
		 additionalInpuDataTblDao.update(additionalInpuDataTbl1);
	 }
	 else
	 {
		 additionalInpuDataTblDao.save(additionalInpuDataTbl1);
	 }
	return additionalInpuDataTbl1;
	
}

WelCompletionDataTbl saveWelCompletionDataTbl(ProjectTbl projectTbl)
{
	WelCompletionDataTbl welCompletionDataTbl=new WelCompletionDataTbl();
	String welltypee=(String) welltype.getSelectedItem();
	String welcompletion=(String) completiontype.getSelectedItem();
 	
	welCompletionDataTbl.setWellType(welltypee);
	welCompletionDataTbl.setCompletionType(welcompletion);
	welCompletionDataTbl.setWellDiaInch(new BigDecimal(welldia.getText().toString().trim()));
	welCompletionDataTbl.setPerfDiaInch(new BigDecimal(perfdia.getText().toString().trim()));
	welCompletionDataTbl.setWellMdFt(new BigDecimal(wellmd.getText().toString().trim()));
	welCompletionDataTbl.setWellTvdFt(new BigDecimal(welltvd.getText().toString().trim()));
    welCompletionDataTbl.setLateraDefthFt(new BigDecimal(lateradepth.getText().toString().trim()));
    welCompletionDataTbl.setLateralDefthFt(new BigDecimal(lateraldepth.getText().toString().trim()));
    welCompletionDataTbl.setProjectTbl(projectTbl);
    if(isupadate)
    {
    	welCompletionDataTblDao.update(welCompletionDataTbl);
    }
    else
    {
    	welCompletionDataTblDao.save(welCompletionDataTbl);
    }
	return welCompletionDataTbl;
    
}



List<ReservoirlethologyTbl> saveReservoirlethologyTbl(ProjectTbl projectTbl)
{
    List<ReservoirlethologyTbl>  reservoirDataList=new ArrayList<ReservoirlethologyTbl>();
    
    for(int i=0;i < table_1.getRowCount(); i++){
   	 
   	 ReservoirlethologyTbl reservoirlethologyTbl=new ReservoirlethologyTbl();
try
{
        
    
   	  BigDecimal formft=getBigDecimal(table_1.getValueAt(i,1));
 
   	 BigDecimal toft=getBigDecimal(table_1.getValueAt(i,2));
   	 BigDecimal tvdft=getBigDecimal(table_1.getValueAt(i,3));
   	 BigDecimal permmd=getBigDecimal(table_1.getValueAt(i,4));
   	 BigDecimal poro=getBigDecimal(table_1.getValueAt(i,5));
   	 BigDecimal zonepresspsi=getBigDecimal(table_1.getValueAt(i,6));
   	 BigDecimal prestimskin=getBigDecimal(table_1.getValueAt(i,7)); 
   	 String resfluidtype=table_1.getValueAt(i,8).toString();
   	  
   	 
   	 reservoirlethologyTbl.setFormDefthFt(new BigDecimal(table_1.getValueAt(i,1).toString().trim()));
   	 reservoirlethologyTbl.setToDefthFt(new BigDecimal(table_1.getValueAt(i,2).toString().trim()));
   	 reservoirlethologyTbl.setTvdFt(new BigDecimal(table_1.getValueAt(i,3).toString().trim()));
   	 reservoirlethologyTbl.setPermMd(new BigDecimal(table_1.getValueAt(i,4).toString().trim()));
   	 reservoirlethologyTbl.setPoro(new BigDecimal(table_1.getValueAt(i,5).toString().trim()));
   	 reservoirlethologyTbl.setZonePressPsi(new BigDecimal(table_1.getValueAt(i,6).toString().trim()));
   	 reservoirlethologyTbl.setPreStimSkin(new BigDecimal(table_1.getValueAt(i,7).toString().trim()));
   	 reservoirlethologyTbl.setFluidInPlace(resfluidtype);
   	 reservoirlethologyTbl.setProjectTbl(projectTbl);
   
   	 
      reservoirDataList.add(reservoirlethologyTbl);
}



catch(Exception e)
{
  e.printStackTrace();
}
   	 
    }
    
    if(isupadate)
    {
    	reservoirlethologyTblDao.update(reservoirDataList);
    }
    else
    {
    	reservoirlethologyTblDao.save(reservoirDataList);
    }
	return reservoirDataList;
    
}

List<AcidInjectionTbl> saveAcidInjectionTbl(ProjectTbl projectTbl)
{
	List<AcidInjectionTbl>  acidinjectionDataList=new ArrayList<AcidInjectionTbl>();
    
    for(int i=0;i < table.getRowCount(); i++){
   	 
  	  AcidInjectionTbl acidInjectionPlan=new AcidInjectionTbl();
      
  	  String stage=table.getValueAt(i, 1).toString();
  	  
  	  acidInjectionPlan.setStage(stage);
  	  
  	  acidInjectionPlan.setStavageVolBbls((new BigDecimal(table.getValueAt(i,2).toString().trim())));
  	  acidInjectionPlan.setConc((new BigDecimal(table.getValueAt(i,3).toString().trim())));
  	  acidInjectionPlan.setVise((new BigDecimal(table.getValueAt(i,4).toString().trim())));
  	  acidInjectionPlan.setPumpRateBmp((new BigDecimal(table.getValueAt(i,5).toString().trim())));
  	  acidInjectionPlan.setInjPressPsi((new BigDecimal(table.getValueAt(i,6).toString().trim())));
  	  acidInjectionPlan.setInjDefthFt((new BigDecimal(table.getValueAt(i,7).toString().trim())));
  	  acidInjectionPlan.setEntityFricLoss((new BigDecimal(table.getValueAt(i,8).toString().trim())));
  	  acidInjectionPlan.setProjectTbl(projectTbl);
  	  
  	  
  	  
  	  acidinjectionDataList.add(acidInjectionPlan);
       
   
       
    }
    
    if(isupadate)
    {
    	acidInjectionTblDao.update(acidinjectionDataList);
    }
    else
    {
    	 acidInjectionTblDao.save(acidinjectionDataList);
    }
	return acidinjectionDataList;
   
}

FluidPropertiesTbl saveFluidPropertiesTbl(ProjectTbl projectTbl)
{
	 FluidPropertiesTbl fluidPropertiesTbl=new FluidPropertiesTbl();
	 fluidPropertiesTbl.setAcidDensityKgM3(new BigDecimal(aciddencity.getText().toString().trim()));
	 fluidPropertiesTbl.setAcidDissolvingPower(new BigDecimal(aciddissolving.getText().toString().trim()));
	 fluidPropertiesTbl.setResOilDensityKgM3(new BigDecimal(resoildensity.getText().toString().trim()));
	 fluidPropertiesTbl.setResOilVisCp(new BigDecimal(resoil.getText().toString().trim()));
	 fluidPropertiesTbl.setResWaterDensityKgM3(new BigDecimal(reswaterdensity.getText().toString().trim()));
	 fluidPropertiesTbl.setResWaterViscCp(new BigDecimal(reswatervisc.getText().toString().trim()));
	 fluidPropertiesTbl.setResGasDensityKgM3(new BigDecimal(resgasdencity.getText().toString().trim()));
	 fluidPropertiesTbl.setResGasVisCp(new BigDecimal(resgasvis.getText().toString().trim()));
	 fluidPropertiesTbl.setProjectTbl(projectTbl);
	
	 if(isupadate)
	 {
		 fluidPropertiesTblDao.update(fluidPropertiesTbl);
	 }
	 else
	 {
		 fluidPropertiesTblDao.save(fluidPropertiesTbl); 
	 }
	return fluidPropertiesTbl;
	 
	
}

  ProjectTbl getProjecttbl(int projectid)
{
	List<ProjectTbl> projectdetail=projectDao.getProjectDetail(projectid);
	  
	  ProjectTbl projectTbl=new ProjectTbl();
	  projectTbl.setProjectName(projectdetail.get(0).getProjectName());
	  projectTbl.setCompanyName(projectdetail.get(0).getCompanyName());
	  projectTbl.setUserTbl(projectdetail.get(0).getUserTbl());
	  projectTbl.setProjectId(projectid);
	  
	  return projectTbl;
}

  void importData(int  projectid,File file)
  {

  	 
  	isupadate=false;
   //getWellLayersStageTbl(projectid,file);
 	getSensitivityAnalysisTbl(projectid,file);
  	getAdditionalInpuDataTbl(projectid,file);
  	getFluidPropertiesTbl(projectid,file);
  	getWelCompletionDataTbl(projectid,file);
  	getAcidInjectionTbl(projectid,file);
  	
  	
  	getReservoirlethologyTbl(projectid,file);
  }
  
  
  
void openproject(int  projectid)
{
   File file=null;
	btnSave.setText("UPDATE");
	isupadate=true;
    getWellLayersStageTbl(projectid);
	getSensitivityAnalysisTbl(projectid,file);
	getAdditionalInpuDataTbl(projectid,file);
	getFluidPropertiesTbl(projectid,file);
	getWelCompletionDataTbl(projectid,file);
	getAcidInjectionTbl(projectid,file);
	getReservoirlethologyTbl(projectid,file);
}
private void getReservoirlethologyTbl(int projectid,File file) {
	
	// TODO Auto-generated method stub
	List<ReservoirlethologyTbl> getlistdata=null;
	if(isupadate)
	{
		 getlistdata=reservoirlethologyTblDao.getListData(projectid);
	}
	else
	{
		TestApp testApp=new TestApp();
		getlistdata=testApp.getlistdatReservoirlethologyTbl(file);
		int nooflayer=getlistdata.size();
		
		textlayerNo.setText(""+nooflayer);
		
	}
	
	
	
   // public Reservoirlithology( int no,,, , , , ,double pre_stim_skin,String  fluid_in_place)

	int j=1;
	
	ReservoirlithologyList.clear();
	for(int i=0; i<getlistdata.size(); i++)
	{
		ReservoirlithologyList.add(row2 = new  Reservoirlithology(j,Double.parseDouble(getlistdata.get(i).getFormDefthFt().toString()),Double.parseDouble(getlistdata.get(i).getToDefthFt().toString()),
				Double.parseDouble(getlistdata.get(i).getTvdFt().toString()),Double.parseDouble(getlistdata.get(i).getPermMd().toString()),Double.parseDouble(getlistdata.get(i).getPoro().toString()),
				Double.parseDouble(getlistdata.get(i).getZonePressPsi().toString()),Double.parseDouble(getlistdata.get(i).getPreStimSkin().toString()),getlistdata.get(i).getFluidInPlace()));
    
		j++;
	}
	model2 = new  ReservoirlithologyModel(ReservoirlithologyList);
	
 
	  table_1 = new JTable(model2);
	  JTableHeader header = table_1.getTableHeader();
      header.setBackground(new Color(91, 155, 213));
      header.setForeground(Color.white);
	  scrollPane.setViewportView(table_1);
	
}
private void getAcidInjectionTbl(int projectid,File file) {
	// TODO Auto-generated method stub
	List<AcidInjectionTbl> getlistdata=null;
	if(isupadate)
	{
		  getlistdata=acidInjectionTblDao.getlistData(projectid);
	}
	else
	{
		TestApp testApp=new TestApp();
		getlistdata=testApp.getListdatAcidInjectionTbl(file);
		
		int noofacidinjection=getlistdata.size();
		textINJStages.setText(""+noofacidinjection);
		
	}
	 
	// int no,String stage,double stavage_vol_bbls,double conc,double vise,double pump_rate_bmp,double inj_press_psi,double inj_defth_ft,double  entity_fric_loss 
	
	AcidInjectionPlanList1.clear();
	int j=1;
	for(int i=0; i<getlistdata.size(); i++)
	{
		   
		           AcidInjectionPlanList1.add(row1 = new  AcidInjectionPlan(j,getlistdata.get(i).getStage().toString(),Double.parseDouble(getlistdata.get(i).getStavageVolBbls().toString()),
				   Double.parseDouble(getlistdata.get(i).getConc().toString()),Double.parseDouble(getlistdata.get(i).getVise().toString()),
				   Double.parseDouble(getlistdata.get(i).getPumpRateBmp().toString()),Double.parseDouble(getlistdata.get(i).getInjPressPsi().toString()),
				   Double.parseDouble(getlistdata.get(i).getInjDefthFt().toString()),Double.parseDouble(getlistdata.get(i).getEntityFricLoss().toString())));
    j++;
	}
	
	model1 = new  AcidInjectionPlanModel( AcidInjectionPlanList1);
	table = new JTable(model1);
	 JTableHeader header1= table.getTableHeader();
     header1.setBackground(new Color(91, 155, 213));
     header1.setForeground(Color.white);
	 scrollPane_1.setViewportView(table);
}
private void getWelCompletionDataTbl(int projectid,File file) {
	// TODO Auto-generated method stub
	List<WelCompletionDataTbl> getlistdata=null;
	 if(isupadate)
	 {
	   getlistdata=welCompletionDataTblDao.getListData(projectid);
	 }
	 else
	 {
		 TestApp testApp=new TestApp();
		 
		 getlistdata=testApp.getwelCompletionDataTbl(file);
	 }
	// welltype.set
	 welldia.setText(getlistdata.get(0).getWellDiaInch().toString()); 
	 perfdia.setText(getlistdata.get(0).getPerfDiaInch().toString());
	 wellmd.setText(getlistdata.get(0).getWellMdFt().toString());
	 welltvd.setText(getlistdata.get(0).getWellTvdFt().toString());
	 lateradepth.setText(getlistdata.get(0).getLateraDefthFt().toString());
	 lateraldepth.setText(getlistdata.get(0).getLateralDefthFt().toString());
}
private void getFluidPropertiesTbl(int projectid,File file) {
	// TODO Auto-generated method stub
	List<FluidPropertiesTbl> getlistdata=null;
	if(isupadate)
	 {
		   getlistdata=fluidPropertiesTblDao.getListData(projectid); 
	 }
	 else
	 {
		TestApp testApp =new TestApp();
		 getlistdata=testApp.getFluidPropertiesTbl(file);
	 }
 	aciddencity.setText(getlistdata.get(0).getAcidDensityKgM3().toString());
	aciddissolving.setText(getlistdata.get(0).getAcidDissolvingPower().toString());
	resoildensity.setText(getlistdata.get(0).getResOilDensityKgM3().toString());
	resoil.setText(getlistdata.get(0).getResOilDensityKgM3().toString());
	reswaterdensity.setText(getlistdata.get(0).getResWaterDensityKgM3().toString());
	reswatervisc.setText(getlistdata.get(0).getResWaterViscCp().toString());
	resgasdencity.setText(getlistdata.get(0).getResGasDensityKgM3().toString());
	resgasvis.setText(getlistdata.get(0).getResGasVisCp().toString());
}
private void getAdditionalInpuDataTbl(int projectid ,File file) {
	// TODO Auto-generated method stub
	List<AdditionalInpuDataTbl> getlistdata=null;
	if(isupadate)
	{
	  getlistdata=additionalInpuDataTblDao.getListData(projectid);
	}
	else
	{
		TestApp testApp=new TestApp();
		 
		getlistdata=testApp.getAdditionalInpuDataTbl(file);
	}
	 
	 jetdia.setText(getlistdata.get(0).getJetDiaInch().toString());
	 maxpress.setText(getlistdata.get(0).getMaxPressPsi().toString()); 
	 fracpress.setText(getlistdata.get(0).getFracPressPsi().toString());
	 tubfc.setText(getlistdata.get(0).getTubFrictionCoff().toString());
	 formvf.setText(getlistdata.get(0).getFormVolumeFactor().toString());
	 driverterconsk.setText(getlistdata.get(0).getDriverterConstK().toString());
	 driverterconn.setText(getlistdata.get(0).getDiverterCosntN().toString());
	 rockdensity.setText(getlistdata.get(0).getRockDensityKg().toString());
	 fraclength.setText(getlistdata.get(0).getFracLenthInch().toString());
	 nooftimesteps.setText(getlistdata.get(0).getNoOfTimepsteps().toString());
	 noofgrids.setText(getlistdata.get(0).getNoOfGrids().toString());
	 postprodbblsd.setText(getlistdata.get(0).getPostProdBbls().toString());
	 postprodpress.setText(getlistdata.get(0).getPostProdAtPressPsi().toString());
	 fracApperture.setText(getlistdata.get(0).getFracAppertureFt().toString());
	 fraclengthft.setText(getlistdata.get(0).getFracAppertureFt().toString());
	 
}
private void getSensitivityAnalysisTbl(int projectid,File file) {
	// TODO Auto-generated method stub
	List<SensitivityAnalysisTbl> getlistdata=null;
	if(isupadate)
	{
	  getlistdata=sensitivityAnalysisTblDao.getListdata(projectid);
	}
	else
	{
		TestApp testApp=new TestApp();
		getlistdata=testApp.getSensitivityAnalysisTbl(file);
		
		
	}
	  
	 
	 lblDiverterViscp.setText(getlistdata.get(0).getSensitivityAnalysisName().toString());
	 dcase1.setText(getlistdata.get(0).getCase1().toString());
	 dcase2.setText(getlistdata.get(0).getCase2().toString());
	 dcase3.setText(getlistdata.get(0).getCase3().toString());
	 lblPumpRatebmp.setText(getlistdata.get(1).getSensitivityAnalysisName().toString());
	 pcase1.setText(getlistdata.get(1).getCase1().toString());
	 pcase2.setText(getlistdata.get(1).getCase2().toString());
	 pacase3.setText(getlistdata.get(1).getCase3().toString());
	 lblAcidConc.setText(getlistdata.get(2).getSensitivityAnalysisName().toString());
	 acidcase1.setText(getlistdata.get(2).getCase1().toString());
	 acidcase2.setText(getlistdata.get(2).getCase2().toString());
     acidcase3.setText(getlistdata.get(2).getCase3().toString());
    
      
     
	 lblAcidVolbbls.setText(getlistdata.get(3).getSensitivityAnalysisName().toString());
	 acidvolcase1.setText(getlistdata.get(3).getCase1().toString());
	 acidvolcase2.setText(getlistdata.get(3).getCase2().toString());
	 acidvolcase3.setText(getlistdata.get(3).getCase3().toString());
     
     lblDiverterShearCons.setText(getlistdata.get(4).getSensitivityAnalysisName().toString());
     dscase1.setText(getlistdata.get(4).getCase1().toString());
     dscase2.setText(getlistdata.get(4).getCase2().toString());
     dscase3.setText(getlistdata.get(4).getCase3().toString());
     DiverterSherConsn.setText(getlistdata.get(5).getSensitivityAnalysisName().toString());
     dsncae1.setText(getlistdata.get(5).getCase1().toString());
     dsncae2.setText(getlistdata.get(5).getCase2().toString());
     dsncae3.setText(getlistdata.get(5).getCase3().toString());


}
     private void getWellLayersStageTbl(int projectid) {
	// TODO Auto-generated method stub
	List<WellLayersStageTbl> getrowdata=wellLayersStageTblDao.getRowdata(projectid);
	textWellname.setText(getrowdata.get(0).getWellName());
	String noOflayer= getrowdata.get(0).getNoOfLayers().toString();
	String noOfinjection=getrowdata.get(0).getNoOfStages().toString();
	
	textlayerNo.setText(noOflayer);
	textINJStages.setText(noOfinjection);
	
}
     
public  void resetFormData()
  {
	  
	
	btnSave.setText("SAVE");
	
	ReservoirlithologyList.clear();
	AcidInjectionPlanList1.clear();
	jetdia.setText("");
	 maxpress.setText(""); 
	 fracpress.setText("");
	 tubfc.setText("");
	 formvf.setText("");
	 driverterconsk.setText("");
	 driverterconn.setText("");
	 rockdensity.setText("");
	 fraclength.setText("");
	 nooftimesteps.setText("");
	 noofgrids.setText("");
	 postprodbblsd.setText("");
	 postprodpress.setText("");
	 fracApperture.setText("");
	 fraclengthft.setText("");
	
	 
	 dcase1.setText("");
	 dcase2.setText("");
	 dcase3.setText("");
	  
	 pcase1.setText("");
	 pcase2.setText("");
	 pacase3.setText("");
	  
	 acidcase1.setText("");
	 acidcase2.setText("");
     acidcase3.setText("");
    
      
     
	  
	 acidvolcase1.setText("");
	 acidvolcase2.setText("");
	 acidvolcase3.setText("");
     
    
     dscase1.setText("");
     dscase2.setText("");
     dscase3.setText("");
     
     dsncae1.setText("");
     dsncae2.setText("");
     dsncae3.setText("");
     
     aciddencity.setText("");
 	aciddissolving.setText("");
 	resoildensity.setText("");
 	resoil.setText("");
 	reswaterdensity.setText("");
 	reswatervisc.setText("");
 	resgasdencity.setText("");
 	resgasvis.setText("");
 	
 	 welldia.setText(""); 
	 perfdia.setText("");
	 wellmd.setText("");
	 welltvd.setText("");
	 lateradepth.setText("");
	 lateraldepth.setText("");
	 
	 textWellname.setText("");
		 
		
		textlayerNo.setText("");
		textINJStages.setText("");
  
  }
public static boolean isInteger(String s, int radix) {
    if(s.isEmpty()) return false;
    for(int i = 0; i < s.length(); i++) {
        if(i == 0 && s.charAt(i) == '-') {
            if(s.length() == 1) return false;
            else continue;
        }
        if(Character.digit(s.charAt(i),radix) < 0) return false;
    }
    return true;
}


}