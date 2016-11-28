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

 
public class SystemRequirement extends JFrame
{
  /*public static void main(String[] args)
  {
    new SystemRequirement();
  }*/
  
  public SystemRequirement()
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
                          + "<h3><center> System  Requirement</center></h3>"
                          + "<table>  <tr><td>No.</td><td>Software Or Resources</td><td>Version Requirement</td></tr>      <tr> <td> 1</td> <td>Eclipse</td> <td> Kepler</td></tr>       <tr> <td> 2</td> <td>Postgresql</td> <td> 9.3</td></tr>  <tr> <td> 3</td> <td>java</td> <td> 1.7</td></tr>  <tr> <td> 4</td> <td>MS Office</td> <td> 2003</td></tr>    </table>\n"
                        
                         + "</body>\n";
         Document doc = kit.createDefaultDocument();
        jEditorPane.setDocument(doc);
        jEditorPane.setText(htmlString);
        JFrame j = new JFrame("System  Requirement");
        j.getContentPane().add(scrollPane, BorderLayout.CENTER);
       // j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         j.setSize(new Dimension(600,600));
        j.setLocationRelativeTo(null);
        j.setVisible(true);
      }
    });
  }
}