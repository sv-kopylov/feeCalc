
package calc;

import java.awt.*;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Search extends JPanel{
    JLabel searchResult;
    Terms terms;
    JCheckBox translit;

    public Search() {
        
        searchResult = new JLabel ("");
        searchResult.setVerticalAlignment(JLabel.TOP);
        terms = new Terms();
        translit = new JCheckBox();
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbcon = new GridBagConstraints();
        setLayout(gbl);
       
        gbcon.gridx=0;
        gbcon.gridy=0;
        gbcon.weighty = 1;
        gbcon.anchor =GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("Срок: "), gbcon);
        
        gbcon.gridx=GridBagConstraints.RELATIVE;
        gbcon.gridy=0;
        gbcon.weightx = 2;
        add(terms, gbcon);
        
        gbcon.gridx=GridBagConstraints.RELATIVE;
        gbcon.gridy=0;
        add(new JLabel("Транслит: "), gbcon);
        
        gbcon.gridx=GridBagConstraints.RELATIVE;
        gbcon.gridy=0;
        add(translit, gbcon);
        
        gbcon.gridx=0;
        gbcon.gridy=GridBagConstraints.RELATIVE;
        gbcon.weightx = 0;
        gbcon.weighty = 1;
        add(new JLabel("Результат: "), gbcon);
        
  
        
               
        gbcon.gridx=0;
        gbcon.gridy=GridBagConstraints.RELATIVE;
        gbcon.gridwidth=GridBagConstraints.REMAINDER;
        gbcon.gridheight =GridBagConstraints.REMAINDER;
        gbcon.fill = GridBagConstraints.BOTH;
        gbcon.weighty = 10;
        gbcon.anchor =GridBagConstraints.FIRST_LINE_START;
         
        add(searchResult, gbcon);
        
            
        
    }
    
    
}

class Terms extends JComboBox<String>{
    Terms(){
        
        super(new String[]{"месяц", "две недели", "одна неделя"});
        super.setSelectedIndex(0);
        
    }
}
