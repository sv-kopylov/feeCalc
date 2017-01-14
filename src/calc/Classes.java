
package calc;

import javax.swing.JComboBox;
import javax.swing.JLabel;


public class Classes extends JComboBox<Integer> {
    JLabel result;
    
    Classes(){

        for (int i=0; i<45; i++){
            addItem(i+1);
        }
        super.setSelectedIndex(0);
        
    }
}
