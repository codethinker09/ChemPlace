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

 
public class HelpFluidProperties extends JFrame
{
  /*public static void main(String[] args)
  {
    new HelpFluidProperties();
  }*/
  
  public HelpFluidProperties()
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
                          + "<h3><center>Fluid Properties</center></h3>"
                          + "<ol>In this table, user inputs related injection fluid as well as reservoir fluid properties (such as density and viscosity). Below is short description about inputs in fluid properties table: </ol>\n"
                         
                          + "<li><b>Inj. Acid Density (Kg/m3):</b> In this input cell, user require to provide injected acid density in Kg/m3 unit. There is default value of this parameter is already available in this input cell; and if user does not have any known value for it then they can use this default value otherwise update it with known value of injection acid density for your own stimulation.  </li>"
                          + "<ul> <li><b>Value Type:    </b>Numerical     </li> <li><b>Input Type:   </b>Default      </li> <li><b> Value Range:    </b> 0 to 3000 Kg/m3    </li> <li><b>Example:      </b>   1000, 870, etc. </li>         </ul>\n" 
                  
    + "<li><b>Acid Dissolving Power: </b>In this input cell, user require to provide injected acid density in Kg/m3 unit. There is default value of this parameter is already available in this input cell; and if user does not have any known value for it then they can use this default value otherwise update it with known value of injection acid density for your own stimulation.  </li>"
    + "<ul> <li><b>Value Type:    </b>Numerical     </li> <li><b>Input Type:   </b>Default      </li> <li><b> Value Range:    </b> 0 to 3000 Kg/m3    </li> <li><b>Example:      </b>   1000, 870, etc. </li>         </ul>\n" 

    + "<li><b>Reservoir Oil Density and Viscosity: </b>In this input cell, user require to provide injected acid density in Kg/m3 unit. There is default value of this parameter is already available in this input cell; and if user does not have any known value for it then they can use this default value otherwise update it with known value of injection acid density for your own stimulation.  </li>"
    + "<ul> <li><b>Value Type:    </b>Numerical     </li> <li><b>Input Type:   </b>Default      </li> <li><b> Value Range:    </b> 0 to 3000 Kg/m3    </li> <li><b>Example:      </b>   1000, 870, etc. </li>         </ul>\n" 

    + "<li><b>Reservoir Water Density and Viscosity:</b>  In this input cell, user require to provide injected acid density in Kg/m3 unit. There is default value of this parameter is already available in this input cell; and if user does not have any known value for it then they can use this default value otherwise update it with known value of injection acid density for your own stimulation. </li>"
    + "<ul> <li><b>Value Type:    </b>Numerical     </li> <li><b>Input Type:   </b>Default      </li> <li><b> Value Range:    </b> 0 to 3000 Kg/m3    </li> <li><b>Example:      </b>   1000, 870, etc. </li>         </ul>\n" 

    + "<li><b>Reservoir Gas Density and Viscosity:</b> In this input cell, user require to provide injected acid density in Kg/m3 unit. There is default value of this parameter is already available in this input cell; and if user does not have any known value for it then they can use this default value otherwise update it with known value of injection acid density for your own stimulation.  </li>"
    + "<ul> <li><b>Value Type:    </b>Numerical     </li> <li><b>Input Type:   </b>Default      </li> <li><b> Value Range:    </b> 0 to 3000 Kg/m3    </li> <li><b>Example:      </b>   1000, 870, etc. </li>         </ul>\n" 
                         
                 + "<ol><h3> If there is still question or assistance required, then please contact support team at Petroleumsoft   </h3></ol>"
                             
                          + "</body>\n";
         Document doc = kit.createDefaultDocument();
        jEditorPane.setDocument(doc);
        jEditorPane.setText(htmlString);
        JFrame j = new JFrame("Help Fluid Properties");
        j.getContentPane().add(scrollPane, BorderLayout.CENTER);
        //j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         j.setSize(new Dimension(600,600));
        j.setLocationRelativeTo(null);
        j.setVisible(true);
      }
    });
  }
}