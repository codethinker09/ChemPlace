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

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
 
public class HelpAcidInjectionPlan extends JFrame
{
  /*public static void main(String[] args)
  {
    new HelpAcidInjectionPlan();
  }*/
  
	public HelpAcidInjectionPlan()
	{
	   initialize();
	}
	
  public void  initialize()
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
                          + "<h3><center>Acid Injection Plan</center></h3>"
                          + "<ol>Inputs in this table is used for wellbore model building. Users can select number of injection stages on the top of input page and corresponding numbers of rows will be generated in this table to provide injection parameters (such as injection volume, acid concentration, pump rate and injection pressure etc.) of each stage.  </ol>\n"
                          + "<ol>The input in table can be done manually. However manual input for large number of layers is time consuming and therefore its possible to import all the inputs in this table directly from an excel file. To import input data in this table from an excel file, you can use “Inj. Plan” button under import tab on the left most column on interface.   </ol>\n"
                          + "<ol>Here is the short description of list of inputs which will be input through this table: </ol>\n"
                          + "<li><b>Stage Name :</b>In this input cell, user require to provide injected acid density in Kg/m3 unit. There is default value of this parameter is already available in this input cell; and if user does not have any known value for it then they can use this default value otherwise update it with known value of injection acid density for your own stimulation.      </li>"
 
                        + "<ul> <li><b>Value Type:    </b>Numerical     </li> <li><b>Input Type:   </b>Default      </li> <li><b> Value Range:    </b> 0 to 3000 Kg/m3    </li> <li><b>Example:      </b>   1000, 870, etc. </li>         </ul>\n" 
                          +"<li><b> Stage Volume (Bbls): </b>In this input cell, user require to provide injected acid density in Kg/m3 unit. There is default value of this parameter is already available in this input cell; and if user does not have any known value for it then they can use this default value otherwise update it with known value of injection acid density for your own stimulation.     </li>"
                          +"<ul><li><b>Value Type:    </b>  Numerical   </li> <li><b>Input Type:    </b> Default    </li> <li><b>Value Range: 3     </b>0 to 3000 Kg/m    </li> <li><b> Example:    </b>1000, 870, etc.     </li>       </ul>"
                          +"<li> <b>Main Acid Concentration (%):</b>In this input cell, user require to provide injected acid density in Kg/m3 unit. There is default value of this parameter is already available in this input cell; and if user does not have any known value for it then they can use this default value otherwise update it with known value of injection acid density for your own stimulation.    </li>"
                          +"<ul><li><b>Value Type:   </b>Numerical      </li> <li><b>Input Type:   </b>Default      </li> <li><b> Value Range:  </b>0 to 3000 Kg/m3      </li> <li><b>Example:    </b>  1000, 870, etc.    </li>    </ul>"
                          
                          +"<li> <b>Viscosity (cP): </b>In this input cell, user require to provide injected acid density in Kg/m3 unit. There is default value of this parameter is already available in this input cell; and if user does not have any known value for it then they can use this default value otherwise update it with known value of injection acid density for your own stimulation.        </li>"
                          +" <ul><li><b>Value Type: Numerical    </b>Numerical    </li><li><b> Input Type:  </b> Default    </li><li><b>Value Range:     </b>0 to 3000 Kg/m3     </li><li><b>Example:    </b> 1000, 870, etc.     </li>     </ul>"
                          
                         +"<li> <b>Pump Rate (BPM):   </b>  In this input cell, user require to provide injected acid density in Kg/m3 unit. There is default value of this parameter is already available in this input cell; and if user does not have any known value for it then they can use this default value otherwise update it with known value of injection acid density for your own stimulation.       </li>"
                         +" <ul><li><b>Value Type:   </b> Numerical     </li><li><b>Input Type:   </b>Default      </li><li><b>Value Range:    </b> 0 to 3000 Kg/m3     </li><li><b>Example:    </b>1000, 870, etc.    </li>     </ul>"
  
                           +"<li> <b>	Inj. Pressure (Psi) BHP/SURF:    </b> In this input cell, user require to provide injected acid density in Kg/m3 unit. There is default value of this parameter is already available in this input cell; and if user does not have any known value for it then they can use this default value otherwise update it with known value of injection acid density for your own stimulation.       </li>"
                           +" <ul><li><b>Value Type:    </b>Numerical     </li><li><b>Input Type:   </b> Default     </li><li><b> Value Range:    </b> 0 to 3000 Kg/m3    </li><li><b>Example:   </b>1000, 870, etc.       </li>     </ul>"
  
                             +"<li> <b>Injection Depth (FT):</b>	 In this input cell, user require to provide injected acid density in Kg/m3 unit. There is default value of this parameter is already available in this input cell; and if user does not have any known value for it then they can use this default value otherwise update it with known value of injection acid density for your own stimulation.        </li>"
                              +" <ul><li><b>Value Type:   </b> Numerical   </li><li><b> Input Type:    </b> Default   </li><li><b>Value Range:     </b> 0 to 3000 Kg/m3    </li><li><b>Example:     </b> 1000, 870, etc.    </li>     </ul>"
  
                            +"<li> <b>  Friction Entry Pressure (Psi):</b> In this input cell, user require to provide injected acid density in Kg/m3 unit. There is default value of this parameter is already available in this input cell; and if user does not have any known value for it then they can use this default value otherwise update it with known value of injection acid density for your own stimulation.        </li>"
                             +" <ul><li><b>Value Type:   </b>Numerical      </li><li><b> Input Type:  </b>Default      </li><li><b>Value Range:     </b>0 to 3000 Kg/m3     </li><li><b> Example:   </b> 1000, 870, etc    </li>     </ul>"
  
                            + "<ol><h3> If there is still question or assistance required, then please contact support team at Petroleumsoft   </h3></ol>"
    
                          
                          + "</body>\n";
         Document doc = kit.createDefaultDocument();
        jEditorPane.setDocument(doc);
        jEditorPane.setText(htmlString);
        JFrame j = new JFrame("Help Acid Injection Plan");
        j.getContentPane().add(scrollPane, BorderLayout.CENTER);
        //j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         j.setSize(new Dimension(600,600));
        j.setLocationRelativeTo(null);
        j.setVisible(true);
      }
    });
  }
}