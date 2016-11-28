package com.chemplace.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

 
public class AboutChemPlace extends JFrame
{
  /*public static void main(String[] args)
  {
    new UserManual();
  }*/
  
  public AboutChemPlace()
  {
     
       
           JEditorPane jEditorPane = new JEditorPane();
            jEditorPane.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(jEditorPane);
        
        HTMLEditorKit kit = new HTMLEditorKit();
        jEditorPane.setEditorKit(kit);
        
        StyleSheet styleSheet = kit.getStyleSheet();
        styleSheet.addRule("body {color:#000; font-family:times; margin: 4px; }");
        styleSheet.addRule("h1 {color: blue;}");
        styleSheet.addRule("h2 {color: #ff0000;}");
        styleSheet.addRule("pre {font : 10px monaco; color : black; background-color : #fafafa; }");

        // create some simple html as a string
        String htmlString = "<html>\n"
                          + "<body>"
                          + "<h2><center>About ChemPlace</center></h2>"
                          + "<center><h3>Maximize Well Performance by Analysis and Optimization of Acid Treatments </h3></center>\n"
                         + "<ol>ChemPlace is a software system for analysis and optimization of matrix acid stimulation. It comes with user-friendly interface and robust numerical algorithm. ChemPlace uses advanced simulation techniques to model acid stimulation jobs at downhole conditions. ChemPlace provides better control on acid placement by prediction of acid placement, penetration length, reduction in skin, acid diversion strategy and stimulation optimization to maximize stimulation impact on well performance, while operating below fracturing pressure during placement.</ol>"
                         + "<h3><center>BENEFITS TO CUSTOMERS</center></h3>"                
                         + "<li>Better Control on Acid Placement and Optimization of Stimulation Process</li>"
                         + "<li>Improved Stimulation Impact on Well Performance</li>"
                         + "<li>No Need of DTS Technology for Acid Placement </li>"
                         + "<li>Calculation 3D Visualization to Understand Acid Placement </li>"
                         + "<li> User-Friendly System for Regular User </li>" 
                         + "<li>No Need of Large Amount of Input Data and Computational Time </li>" 
                         + "<h3><center>APPLICATION </center></h3>"
                         + "<li>Acid Placement Modeling </li>"
                         + "<li>Prediction of Penetration length </li>"
                         + "<li>Calculation of Productivity Index </li>"
                         + "<li>Prediction of Acid Placement </li>"
                         + "<li>Planning of Acid Diversion Strategy </li>"
                         + "<li>Analysis and Optimization of Stimulation </li>"
                         + "<li>Prediction of reduction in skin </li>"
                         + "<li>Design of Acid Stimulation </li>"
                         + "<li>Prediction of impact of viscosity, injection rate and sheer thinning </li>"
                         + "<li>Can be Used for Both Bullhead and Coil Tubing Based Stimulation </li>"
                         + "<li>Can be Used for Both Sandstone and Carbonate Reservoirs </li>"
                         + "<h3><center>Acid Placement Modelling</center></h3>"
                         + "<ol>Matrix acidizing is used to stimulate a well to remove near wellbore damage and improve flow performance. It is often possible that stimulation team does not have all data required to have a solid understanding on acid placement when planning acid stimulation. Poor understanding of acid placement may result in stimulating water-bearing intervals and leaving oil-bearing intervals nearly untreated.</ol>"
                         + "<ol>To plan an effective acid stimulation job, it’s important to know where and how injected acid is placed in the reservoir formations, and then plan the strategy to target oil-bearing intervals. Coil tubing has been relatively better to target a single perforation by separating it with packers and bridge plugs. However stimulation by coil tubing has shown poor results in many cases when treating long perforation of horizontal wells. The primary reason for poor results is geological contrast among different sub-segments (over depth) of a single perforation interval.</ol>"
                         + "<ol>ChemPlace provides stimulation team with better understanding of acid placement by prediction of acid placement into different perforations. It assists in planning the most efficient strategy for acid diversion to target oil-bearing intervals. It assists in design and optimization of stimulation job to maximize its impact on well performance. </ol>"
                         + "<ol>Acid placement modelling can be done in ChemPlace for both carbonate and sandstone reservoirs.ChemPlace will predict acid placement, penetration length and reduction in skin at downhole conditions. In case of coil tubing based treatment, ChemPlace predicts the acid placement profile over different segments (based on geological contrast) along completion depth. Figure No. 1 shows acid placement into three different perforations of a well targeted for acid stimulation. </ol>"
                         + "<h3><center>Acid Diversion Strategy</center></h3>"
                         + "<ol>Injected acid flows in high permeability regions, leaving behind low permeability regions nearly untreated. When acid stimulation team does not have the best understanding of how acid is distributed along different perforations, it’s difficult to plan suitable acid diversion techniques to improve acid placement to maximum impact of stimulation on well performance. The understanding of acid distribution among different perforations becomes even more challenging when acid is injected by bull heading rather than with coil tubing. </ol>"
                         + "<ol>During stimulation, it is not only important to apply an acid diversion technique for better treatment; but more important is to analyse the impacts of different acid diversion techniques (such as viscosity, acid diverters, pump rates etc.) on acid placement to find an optimum acid diversion strategy.  </ol>"
                         + "<ol>ChemPlace assists operators for even acid placement modeling. Easy-to-use interface of ChemPlace assists the stimulation team to target oil-bearing perforations/sub-segments by examining different diversion techniques to find the optimum diversion technique, which can be most suitable for acid diversion towards oil-bearing intervals. Acid diversion modelling can be utilized to compare and choose the best available acid diverting techniques available. </ol>"
                         + "<ol>Users can play around with different sets of values of these injection design variables to find optimum acid diversion strategy. Two cases of acid stimulation were modelled for a well having three perforations to demonstrate the impact of injected acid viscosity on acid placement. Figure No. 2 shows base case placement and acid diversion due to viscosity. </ol>"
                         + "<ol>Similar acid placement modelling can be done to find an optimum strategy for even distribution of acid based on pump pressure and fluid diversion technologies. Within the limitations of fracture pressure, it will be possible to plan strategy for effective acid stimulation job </ol>"
                         
                          + "<h3><center>Stimulation Design and Optimization </center></h3>"
                           + "<ol>Acid designs are generally based on operational constraints such as fracture pressure, pump capacity,acid handling capacity, and acid reaction analysis etc. These injection design parameters (pump rates,concentration, pump pressure, and acid volume, post flush volume etc.) impact the acid distribution and stimulation impact on well performance. To optimize the acid stimulation design, it is essential to model the sensitivity of these design parameters to observe their impact on well performance. </ol>"
                           + "<ol>The optimization of acid stimulation job is essential to maximize its impact on well performance. Optimized acid job within same operational and economical constraint can provide better treatment than when not optimized. Therefore optimization of acid stimulation design is key for success of stimulation. ChemPlace assists to examine the sensitivity of acid design parameters (such as pump rate, volume, viscosity, concentration, post flush volume etc.) on acid placement, penetration length, reduction in skin and productivity index of the well to find an optimum design for optimum treatment within given geological and economic constraints. For example figure No. 3 shows the impact of viscosity and injection rate on reduction in skin. In case of evaluation of impact of pump pressure, ChemPlace assists stimulation team to play around with different pump rates within fracture pressure limitation to find optimum pump pressure for efficient acid stimulation. </ol>"
                           + "<ol>ChemPlace assists to simulate acid treatments and analyse their impact on well productivity or injectivity. This allows stimulation team with finding optimum design, which can improve well performance by improving well productivity or injectivity. </ol>"
                           
                          + "<h3><center>Key Strength of ChemPlace</center></h3>"
                          + "<ol>ChemPlace is developed to provide users a tool, which is strong from inside as well as outside. Our meaning of inside strength stands for robust algorithms based on advanced fluid flow methodologies.However the outside strength stands for user-friendly interface. </ol>"
                          + "<ol>The tool has been developed such that it can reduce the modelling uncertainties by incorporating advanced mathematical modelling concepts, reservoir engineering and production engineering. The numerical algorithms incorporated are based on several years of industry experience in the area of analysis and optimization of chemical treatments; and expertise in developing simulation technology for oil and gas industry. </ol>"
                          + "<ol>The algorithm is designed such that it can work with even 70 numbers of layers and incorporate maximum geological complexities required in fluid flow modelling. The model will take input about reservoir geological contrast, well design and all injection stages (pump rate, viscosity, BHP,volume etc.) to model stimulation jobs at downhole condition. The limitation of 70 layers would satisfy most cases and some reprogramming may increase this limit, but with more computers processing time required. </ol>"
                          + "<ol>The interface of ChemPlace is designed such that it takes input and provides simulation results in user-friendly environment. Interface is designed such that a user does not require high level of training to use it. User will be able to use interface to input data, see plots and values from simulation results and also visualize their acid placement in 3D environment. The key strength of ChemPlace includes: </ol>" 
                          + "<li>User Friendly Interface </li>"
                          + "<li>Robust algorithm</li>"
                          + "<li>3D Visualization</li>"
                          + "<li> Fast Computation</li>"
                          + "<ol>Minimum Input Data Need </ol>"
                          + "<ol>Figure 3 & 4 is a typical 3D visualization of a well and near wellbore region in ChemPlace. ChemPlace can visualize chemical placement into different perforations or sub-segments of a single long perforation interval (in case of coil tubing based treatment). </ol>"  
                          + "<ol>3D visualization feature of ChemPlace assists stimulation team to better understand the near wellbore region and acid placement in 3D environment. The understanding of geology and acid placement in 3D environment makes stimulation team better understand and communicate for stimulation design and planning. </ol>"
                         
                         
                         + "</body>\n";
         Document doc = kit.createDefaultDocument();
        jEditorPane.setDocument(doc);
        jEditorPane.setText(htmlString);
        JFrame j = new JFrame("User Manual");
        j.getContentPane().add(scrollPane, BorderLayout.CENTER);
       // j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         j.setSize(new Dimension(878, 600));
        j.setLocationRelativeTo(null);
        j.setVisible(true);
      
     
  }
}