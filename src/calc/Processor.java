
package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JLabel;


public class Processor implements ActionListener {
    double baseVerbSearchCost = 4720.0;
    double additVerbalSearchCost = 1180.0;
    double baseFigurSearchCost = 8260.0;
    double additFigureSearchCost = 1770.0;
    
    double formalExamFee = 2700.0;
    double baseRegisterFee = 11500.0;
    double additRegisterFee = 2050.0;
    double feeForGetting = 16200.0;
    
    double totalVerbalSearchCost;
    double totalFigSearchCost;
    double totalFeeForAppl;
    double translitIndicator;
    
    
    private int clNum;
    private int term;
   
    Classes cls;
    Terms trms;
    JCheckBox trans;
    Search search;
    Registeration registeration;

    public Processor(Classes cls, Terms trms, Search search,
            Registeration registeration) {
        this.cls = cls;
        this.trms = trms;
        this.search = search;
        this.registeration = registeration;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        totalVerbalSearchCost=0;
        totalFigSearchCost=0;
        totalFeeForAppl=0;
        
        clNum = (Integer)cls.getSelectedItem();
        if ((String)trms.getSelectedItem() == "месяц")
            term = 1; else
            if ((String)trms.getSelectedItem() == "две недели")
                term=2; else
                if ((String)trms.getSelectedItem() == "одна неделя")
                    term=3; else term=0;
        
        if (search.translit.isSelected())
            translitIndicator =1.1;
        else translitIndicator =1.0;
        
        
        totalVerbalSearchCost = translitIndicator*term*(baseVerbSearchCost +additVerbalSearchCost*(clNum-1));

        
        totalFigSearchCost = term*(baseFigurSearchCost + additFigureSearchCost*(clNum-1));
        
        totalFeeForAppl = formalExamFee+ baseRegisterFee+additRegisterFee*(clNum-1);
        
        String forSearch = "<html>Поиск по словесному знаку: "+
        "<br><br> тариф за один класс: " + (int)(term* baseVerbSearchCost)+
        "<br> тариф за дополнительные классы: "+ 
        (clNum-1) + " x "+ (int)(additVerbalSearchCost*term) +" = "+
        (int)((clNum-1)*additVerbalSearchCost*term)+
         "<br> тариф за транслитерацию: " + (int)((translitIndicator-1)*term*(baseVerbSearchCost +additVerbalSearchCost*(clNum-1)))+
        "<br> всего: " +(int)totalVerbalSearchCost +
                 "<br><br> Поиск по изобразительному  знаку: " +
                "<br><br> тариф за один класс: " + (int)(term* baseFigurSearchCost)+
                "<br> тариф за дополнительные классы: "+ 
                (clNum-1) + " x "+ (int)(additFigureSearchCost*term) +" = "+
        (int)((clNum-1)*additFigureSearchCost*term)+
                "<br> всего: " + (int)totalFigSearchCost
                +"</html>";
        search.searchResult.setText(forSearch);
        String forRegistration = "<html>Пошлина за подачу заявки:"
                + " <br>Формальная экспертиза: "+(int)formalExamFee 
                + " <br>Экспертиза заявленного обозначения, база: "+(int)baseRegisterFee
                + " <br> За дополнительные классы: " + (clNum-1)+" x "+(int)additRegisterFee+" = "
                +(int)((clNum-1)*additRegisterFee)
                + "<br>Всего за экспертизу заявленного обозначения: " +(int)((clNum-1)*additRegisterFee + baseRegisterFee)
                + "<br> Всего за подачу: "+ (int)totalFeeForAppl+"</html>";
        registeration.result.setText(forRegistration);
        
        
         
        
 
    }
    
    
    
}
