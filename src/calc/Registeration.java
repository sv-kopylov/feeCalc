
package calc;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Registeration extends JPanel{
    JLabel result;

    public Registeration() {
        
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx=0;
        c.gridy= 0;
        c.weightx = 1;
        c.weighty = 1;
        c.anchor =GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("Результат: "), c);
        
        c.gridx=0;
        c.gridy=GridBagConstraints.RELATIVE;
        c.gridwidth=GridBagConstraints.REMAINDER;
        c.gridheight =GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 10;
        c.anchor =GridBagConstraints.FIRST_LINE_START;
                
        result = new JLabel("");
        result.setVerticalAlignment(JLabel.TOP);
        add(result, c);
        
    }
    
    
    
}
