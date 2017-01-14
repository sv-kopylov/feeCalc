
package calc;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.*;


public class Calc {
    JFrame calcFrame;
    JButton calcButton;
    Search search;
    Registeration regis;
    JTabbedPane tabbedPane;
    Classes classes;

    public Calc() {
       calcFrame = new JFrame("tmclc v0.0");
       calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       calcFrame.setSize(380, 380);
       calcFrame.setResizable(false);
     
        GridBagLayout c_gbl = new GridBagLayout();
        GridBagConstraints c_gbcon = new GridBagConstraints();
        calcFrame.setLayout(c_gbl);
                
        JLabel lForcl = new JLabel("Количество классов:");
        c_gbcon.gridx=0;
        c_gbcon.gridy=0;
        c_gbcon.weighty = 0.5;
        c_gbcon.weightx = 1;
        c_gbcon.fill = GridBagConstraints.NONE;
        c_gbcon.anchor = GridBagConstraints.FIRST_LINE_START;
        c_gbcon.insets = new Insets(10,4,4,0);

        calcFrame.add(lForcl, c_gbcon);
        
        classes = new Classes();
        c_gbcon.fill = GridBagConstraints.NONE;
        c_gbcon.gridx=GridBagConstraints.RELATIVE;
        c_gbcon.gridy=0;
        c_gbcon.weightx = 1;
        
        calcFrame.add(classes, c_gbcon);
        
        calcButton = new JButton("Посчитать");
        c_gbcon.weightx = 2;
        c_gbl.setConstraints(calcButton, c_gbcon);
        calcFrame.add(calcButton);
        

         
         tabbedPane = new JTabbedPane();
         search = new Search();
         regis = new Registeration();
         tabbedPane.addTab("Поиск", search);
         tabbedPane.addTab("Регистрация", regis);
         
       c_gbcon.insets = new Insets(0,0,0,0);
        c_gbcon.gridx=0;
        c_gbcon.gridy=GridBagConstraints.RELATIVE;
        c_gbcon.fill = GridBagConstraints.BOTH;
        c_gbcon.weighty = 10;
        c_gbcon.gridwidth = GridBagConstraints.REMAINDER;
        c_gbcon.gridheight =GridBagConstraints.REMAINDER;
//   
        calcFrame.add(tabbedPane, c_gbcon);
        
         Processor pr = new Processor(classes, search.terms, search, regis);
      
        calcButton.addActionListener(pr);
        classes.addActionListener(pr);
        search.terms.addActionListener(pr);
        search.translit.addActionListener(pr);
        
        
        
        
        
        
        calcFrame.setVisible(true);
    }
    
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            new Calc();
        });

    }
    
}
