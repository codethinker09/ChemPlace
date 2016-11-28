package com.chemplace.view.help;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import org.springframework.stereotype.Component;
 
public class HelpSensitivityAnalysis extends JFrame
{
  /*public static void main(String[] args)
  {
    new HelpSensitivityAnalysis();
  }*/
  
  public HelpSensitivityAnalysis()
  {
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
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
                          + "<h3><center>Sensitivity Analysis</center></h3>"
                          + "<ol>Data in this table are optional. If user interested to perform sensitivity of stimulation design then this table is used. This table assist user to perform sensitivity of injection design parameters (such as diverter’s viscosity, pump rate, acid volume, acid concentration and shear thinning diverters). Below is short description about inputs in sensitivity analysis table: </ol>\n"
                         + "<ul> <li>Diverter Viscosity (cP)</li> <li>Pump Rate (BPM)</li> <li>	Acid Concentration (%)</li> <li>Acid Volume (BBLs)</li><li>Diverter Shear Thinning Constant (K, n)</li>"
                         + "<ol><h3> If there is still question or assistance required, then please contact support team at Petroleumsoft   </h3></ol>"
                         + "</body>\n";
         Document doc = kit.createDefaultDocument();
        jEditorPane.setDocument(doc);
        jEditorPane.setText(htmlString);
        JFrame j = new JFrame("Help Sensitivity Analysis");
        j.getContentPane().add(scrollPane, BorderLayout.CENTER);
       // j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         j.setSize(new Dimension(600,600));
        j.setLocationRelativeTo(null);
        j.setVisible(true);
      }
    });
  }
}