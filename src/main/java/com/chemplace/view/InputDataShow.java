package com.chemplace.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.springframework.stereotype.Component;

import java.awt.Color;

@Component
public class InputDataShow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputDataShow frame = new InputDataShow();
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
	public InputDataShow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(130, 95, 1208, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1192, 584);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblInputData = new JLabel("Input Data");
		lblInputData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInputData.setBounds(601, 0, 72, 25);
		panel.add(lblInputData);
		
		JLabel lblProjectDetails = new JLabel("Project Details ");
		lblProjectDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProjectDetails.setBounds(10, 11, 169, 14);
		panel.add(lblProjectDetails);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 26, 1182, 27);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblProjectName = new JLabel("Project Name");
		lblProjectName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProjectName.setBounds(10, 0, 108, 24);
		panel_1.add(lblProjectName);
		
		JLabel lblUserName = new JLabel("Company Name");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUserName.setBounds(445, 3, 140, 21);
		panel_1.add(lblUserName);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(821, 3, 129, 21);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(106, 3, 129, 21);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(578, 3, 46, 21);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(1015, 3, 86, 21);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Reservoir Lithology");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 49, 139, 25);
		panel.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 75, 651, 150);
		panel.add(panel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Acid Injection Plan");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 236, 159, 14);
		panel.add(lblNewLabel_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(10, 261, 651, 150);
		panel.add(panel_3);
		
		JLabel lblSensitivityAnalysis = new JLabel("Sensitivity Analysis");
		lblSensitivityAnalysis.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSensitivityAnalysis.setBounds(10, 422, 129, 14);
		panel.add(lblSensitivityAnalysis);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(10, 439, 651, 134);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label = new JLabel("DIVERTER VIS(cP)");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(59, 0, 160, 25);
		panel_4.add(label);
		
		JLabel label_1 = new JLabel("PUMP RATE(BMP)");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(59, 23, 160, 24);
		panel_4.add(label_1);
		
		JLabel label_2 = new JLabel("ACID CONC(%)");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(59, 45, 160, 22);
		panel_4.add(label_2);
		
		JLabel label_3 = new JLabel("ACID VOL(BBLS)");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(59, 63, 160, 25);
		panel_4.add(label_3);
		
		JLabel label_4 = new JLabel("DIVERTER SHEAR CONS k");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(59, 85, 160, 26);
		panel_4.add(label_4);
		
		JLabel label_5 = new JLabel("DIVERTER SHEAR CONS n");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(59, 104, 160, 30);
		panel_4.add(label_5);
		
		JLabel label_6 = new JLabel("6");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(23, 104, 12, 30);
		panel_4.add(label_6);
		
		JLabel label_7 = new JLabel("4");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setBounds(23, 63, 24, 25);
		panel_4.add(label_7);
		
		JLabel label_8 = new JLabel("5");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_8.setBounds(23, 82, 24, 29);
		panel_4.add(label_8);
		
		JLabel label_9 = new JLabel("3");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_9.setBounds(23, 45, 24, 22);
		panel_4.add(label_9);
		
		JLabel label_10 = new JLabel("2");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_10.setBounds(23, 23, 24, 24);
		panel_4.add(label_10);
		
		JLabel label_11 = new JLabel("1");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_11.setBounds(23, 0, 24, 25);
		panel_4.add(label_11);
		
		JLabel lblFulidProperties = new JLabel("Fluid Properties");
		lblFulidProperties.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFulidProperties.setBounds(671, 187, 117, 25);
		panel.add(lblFulidProperties);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(671, 213, 511, 120);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_12 = new JLabel("Acid Density (Kg.m3)");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_12.setBounds(35, 11, 160, 24);
		panel_5.add(label_12);
		
		JLabel label_13 = new JLabel("Res Oil Density (Kg/m3)");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_13.setBounds(35, 37, 160, 18);
		panel_5.add(label_13);
		
		JLabel label_14 = new JLabel("Res. Water Density(Kg/m3)");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_14.setBounds(35, 57, 160, 29);
		panel_5.add(label_14);
		
		JLabel label_15 = new JLabel("Res/Gas Density (Kg/m3)");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_15.setBounds(35, 92, 160, 17);
		panel_5.add(label_15);
		
		JLabel label_16 = new JLabel("4");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_16.setBounds(10, 92, 15, 17);
		panel_5.add(label_16);
		
		JLabel label_17 = new JLabel("3");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_17.setBounds(10, 57, 15, 29);
		panel_5.add(label_17);
		
		JLabel label_18 = new JLabel("2");
		label_18.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_18.setBounds(10, 37, 15, 18);
		panel_5.add(label_18);
		
		JLabel label_19 = new JLabel("1");
		label_19.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_19.setBounds(10, 11, 15, 24);
		panel_5.add(label_19);
		
		JLabel label_20 = new JLabel("Acid Dissolving Power");
		label_20.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_20.setBounds(310, 12, 133, 23);
		panel_5.add(label_20);
		
		JLabel label_21 = new JLabel("Res Oil Vis(cP)");
		label_21.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_21.setBounds(310, 37, 133, 18);
		panel_5.add(label_21);
		
		JLabel label_22 = new JLabel("Res Water Visc(cP)");
		label_22.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_22.setBounds(310, 59, 133, 27);
		panel_5.add(label_22);
		
		JLabel label_23 = new JLabel("Res Gas Vis (cP)");
		label_23.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_23.setBounds(310, 92, 133, 17);
		panel_5.add(label_23);
		
		JLabel lblWellCompletionDesign = new JLabel("Well Completion Design");
		lblWellCompletionDesign.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWellCompletionDesign.setBounds(672, 54, 176, 14);
		panel.add(lblWellCompletionDesign);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(671, 75, 511, 112);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel label_24 = new JLabel("3");
		label_24.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_24.setBounds(10, 58, 14, 14);
		panel_6.add(label_24);
		
		JLabel label_25 = new JLabel("4");
		label_25.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_25.setBounds(10, 83, 14, 14);
		panel_6.add(label_25);
		
		JLabel label_26 = new JLabel("2");
		label_26.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_26.setBounds(10, 33, 14, 14);
		panel_6.add(label_26);
		
		JLabel label_27 = new JLabel("1");
		label_27.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_27.setBounds(10, 11, 14, 18);
		panel_6.add(label_27);
		
		JLabel label_28 = new JLabel("Well Type");
		label_28.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_28.setBounds(37, 11, 121, 14);
		panel_6.add(label_28);
		
		JLabel label_29 = new JLabel("Well Dia (Inch)");
		label_29.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_29.setBounds(37, 36, 121, 14);
		panel_6.add(label_29);
		
		JLabel label_30 = new JLabel("Well MD(FT)");
		label_30.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_30.setBounds(37, 58, 121, 17);
		panel_6.add(label_30);
		
		JLabel label_31 = new JLabel("Latera Depth (FT)");
		label_31.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_31.setBounds(37, 83, 121, 17);
		panel_6.add(label_31);
		
		JLabel label_32 = new JLabel("Lateral  Depth (FT)");
		label_32.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_32.setBounds(302, 83, 140, 14);
		panel_6.add(label_32);
		
		JLabel label_33 = new JLabel("Well TVD (FT)");
		label_33.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_33.setBounds(302, 58, 140, 20);
		panel_6.add(label_33);
		
		JLabel label_34 = new JLabel("Perf Dia (Inch)");
		label_34.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_34.setBounds(303, 33, 139, 17);
		panel_6.add(label_34);
		
		JLabel label_35 = new JLabel("Completion Type");
		label_35.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_35.setBounds(302, 11, 140, 14);
		panel_6.add(label_35);
		
		JLabel lblNewLabel_6 = new JLabel("Additional Input Data");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(671, 338, 188, 27);
		panel.add(lblNewLabel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBounds(671, 365, 511, 208);
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel label_36 = new JLabel("Stimulation Type");
		label_36.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_36.setBounds(36, 11, 140, 13);
		panel_7.add(label_36);
		
		JLabel label_37 = new JLabel("Max Press(psi)");
		label_37.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_37.setBounds(36, 30, 140, 14);
		panel_7.add(label_37);
		
		JLabel label_38 = new JLabel("1");
		label_38.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_38.setBounds(10, 11, 16, 13);
		panel_7.add(label_38);
		
		JLabel label_39 = new JLabel("2");
		label_39.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_39.setBounds(10, 28, 16, 14);
		panel_7.add(label_39);
		
		JLabel label_40 = new JLabel("3");
		label_40.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_40.setBounds(10, 53, 16, 14);
		panel_7.add(label_40);
		
		JLabel label_41 = new JLabel("Tub Friction Coff");
		label_41.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_41.setBounds(36, 53, 140, 14);
		panel_7.add(label_41);
		
		JLabel label_42 = new JLabel("Driverter Const. K");
		label_42.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_42.setBounds(36, 78, 140, 14);
		panel_7.add(label_42);
		
		JLabel label_43 = new JLabel("4");
		label_43.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_43.setBounds(10, 79, 16, 14);
		panel_7.add(label_43);
		
		JLabel label_44 = new JLabel("5");
		label_44.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_44.setBounds(10, 104, 16, 14);
		panel_7.add(label_44);
		
		JLabel label_45 = new JLabel("6");
		label_45.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_45.setBounds(10, 129, 16, 14);
		panel_7.add(label_45);
		
		JLabel label_46 = new JLabel("7");
		label_46.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_46.setBounds(10, 154, 16, 14);
		panel_7.add(label_46);
		
		JLabel label_47 = new JLabel("8");
		label_47.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_47.setBounds(10, 179, 16, 18);
		panel_7.add(label_47);
		
		JLabel label_48 = new JLabel("Post Prod (bbls/D)");
		label_48.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_48.setBounds(36, 154, 140, 14);
		panel_7.add(label_48);
		
		JLabel label_49 = new JLabel("No. of Timepsteps");
		label_49.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_49.setBounds(36, 129, 140, 14);
		panel_7.add(label_49);
		
		JLabel label_50 = new JLabel("Rock Density(KG/KG)");
		label_50.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_50.setBounds(36, 104, 140, 14);
		panel_7.add(label_50);
		
		JLabel label_51 = new JLabel("Jet  Dia (Inch)");
		label_51.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_51.setBounds(306, 11, 142, 13);
		panel_7.add(label_51);
		
		JLabel label_52 = new JLabel("Frac Press (psi)");
		label_52.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_52.setBounds(306, 28, 142, 14);
		panel_7.add(label_52);
		
		JLabel label_53 = new JLabel("Form. Vol. Factor");
		label_53.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_53.setBounds(306, 53, 142, 14);
		panel_7.add(label_53);
		
		JLabel label_54 = new JLabel("Diverter Const. n");
		label_54.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_54.setBounds(306, 79, 142, 14);
		panel_7.add(label_54);
		
		JLabel label_55 = new JLabel("Frac Lenth (Inch)");
		label_55.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_55.setBounds(306, 104, 142, 14);
		panel_7.add(label_55);
		
		JLabel label_56 = new JLabel("No. of Grids");
		label_56.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_56.setBounds(306, 129, 142, 14);
		panel_7.add(label_56);
		
		JLabel label_57 = new JLabel("Post Prod at Press (Psi)");
		label_57.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_57.setBounds(306, 154, 142, 14);
		panel_7.add(label_57);
		
		JLabel label_58 = new JLabel("Frac Length(FT)");
		label_58.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_58.setBounds(306, 182, 142, 15);
		panel_7.add(label_58);
		
		JLabel label_59 = new JLabel("Frac Apperture (FT)");
		label_59.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_59.setBounds(36, 179, 140, 15);
		panel_7.add(label_59);
	}
}
