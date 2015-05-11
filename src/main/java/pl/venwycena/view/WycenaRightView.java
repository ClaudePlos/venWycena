/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.venwycena.view;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextField;
import org.json.JSONException;
import org.json.JSONObject;
import pl.venwycena.models.WycenyDane;

/**
 *
 * @author k.skowronski
 */
public class WycenaRightView extends FormLayout {
    
    private TextField d01;
    private TextField d02;
    private TextField d03;
    private OptionGroup opWybDietSpec;
    
    public WycenaRightView(){

        wstawElementy();    
        
        setSizeUndefined();
        setMargin(true);
        setVisible(false);
        
    }
    
    private void wstawElementy(){
         //
        
        //1.
        d01 = new TextField("1. Ilość dni usługi:");
        d01.setEnabled(false);
        addComponent(d01);
        
        
        //2.
        d02 = new TextField("2. Ilość osób żywionych:");
        d02.setEnabled(false);
        addComponent(d02);
        
        //3.
        d03 = new TextField("3. Czy zamówienie ma zawierać więcej niż jedną dietę:");
        String odp03 = "TAK";
        d03.setValue( odp03 );
        d03.setEnabled(false);
        addComponent(d03);
        
        
        
        //4.
        opWybDietSpec = new OptionGroup("4. Ilość diet specjalistycznych z następujących rodzajów");
        opWybDietSpec.setMultiSelect(true);
        addComponent(opWybDietSpec);
        
        /*
        //5.
        TextField d05 = new TextField("5. Procentowa łączna ilość udziału diet bogatobiałkowej\n"
                + "oraz bogatoresztkowej oraz diet specjalnych w całościowej\n dziennej ilości diet:");
        //d05.setValue( wd.getD05() + "%" );
        d05.setEnabled(false);
        this.bind(d05,'5');*/
    }
    
    
    public void odswiezDane( WycenyDane wd ){
        
        
        //1.
         d01.setValue( wd.getD01() ); 
        //2. 
         d02.setValue( wd.getD02() );  
        
         
        // 3. 
         if  (wd.getD03().equals("N") )
              d03.setValue( "NIE" );  
        
        
        // 4. 
         String key1 = null;
         String key2 = null;
         String key3 = null;
         String key4 = null;
        
        try {
            JSONObject jsonObject = new JSONObject(wd.getD04());
            
            key1 = (String )jsonObject.get("key1");
            key2 = (String )jsonObject.get("key2");
            key3 = (String )jsonObject.get("key3");
            key4 = (String )jsonObject.get("key4");
    
        } catch( JSONException e)
        {
          e.printStackTrace();
        }
        
        

                if ( "TAK".equals( d03.getValue() ) )
                {
                    opWybDietSpec.addItem(0);
                    opWybDietSpec.setItemCaption(0, "podstawowa");
                    opWybDietSpec.addItem(1);
                    opWybDietSpec.setItemCaption(1, "bogatoresztkowa");
                    opWybDietSpec.addItem(2);
                    opWybDietSpec.setItemCaption(2, "łatwo strawna");
                    opWybDietSpec.addItem(3);
                    opWybDietSpec.setItemCaption(3, "łatwo strawna z ograniczeniem tłuszczu");
                    
                    opWybDietSpec.setValue(null);
                    
                    if ( key1.equals("T") ) 
                        opWybDietSpec.select(0);
                    if ( key2.equals("T") ) 
                        opWybDietSpec.select(1);
                    if ( key3.equals("T") ) 
                        opWybDietSpec.select(2);
                    if ( key4.equals("T") ) 
                        opWybDietSpec.select(3);
                    
                }                
                else
                {
                    opWybDietSpec.removeAllItems();
                }
                
                
           //5.     
        
    }
    
}
