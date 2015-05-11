/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.venwycena.view;

import com.vaadin.data.Property;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import javax.ejb.EJB;
import static javax.ws.rs.client.Entity.json;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pl.venwycena.models.Wyceny;
import pl.venwycena.service.WycenaFacade;
import pl.venwycena.models.WycenyDane;

/**
 *
 * @author k.skowronski
 */
public class WycenaWindowTab extends Window {
    
    
    @EJB
    WycenaFacade uf = new WycenaFacade();
    
    public Wyceny _wycena; 
    
    final FormLayout content = new FormLayout();
    
    public WycenaWindowTab()
    {
        super("Dane wyceny");
        setWidth(800.0f, Unit.PIXELS);
        setContent(content); 
        center();
    }
    
    
    public void odswiez( Wyceny wyc )
    {
        _wycena = wyc;
        Label idWyc = new Label(_wycena.getWNazwa());         
        content.addComponent(idWyc);
        
        WycenyDane wd = (WycenyDane) uf.pobierzWycenyDane( _wycena.getWId() );
        
        //1.
        TextField d01 = new TextField("1. Ilość dni usługi:");
        d01.setValue( wd.getD01() );
        d01.setEnabled(false);
        content.addComponent(d01);
        
        
        //2.
        TextField d02 = new TextField("2. Ilość osób żywionych:");
        d02.setValue( wd.getD02() );
        d02.setEnabled(false);
        content.addComponent(d02);
        
        //3.
        TextField d03 = new TextField("3. Czy zamówienie ma zawierać więcej niż jedną dietę:");
        String odp03 = "TAK";
        
        if (wd.getD02().equals("N") )
            odp03 = "NIE";
        
        d03.setValue( odp03 );
        d03.setEnabled(false);
        content.addComponent(d03);
        
        
         // 4.
        OptionGroup opWybDietSpec = new OptionGroup("4. Ilość diet specjalistycznych z następujących rodzajów");
        opWybDietSpec.setMultiSelect(true);
        
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
        
        

                if ( "TAK".equals(odp03) )
                {
                    opWybDietSpec.addItem(0);
                    opWybDietSpec.setItemCaption(0, "podstawowa");
                    opWybDietSpec.addItem(1);
                    opWybDietSpec.setItemCaption(1, "bogatoresztkowa");
                    opWybDietSpec.addItem(2);
                    opWybDietSpec.setItemCaption(2, "łatwo strawna");
                    opWybDietSpec.addItem(3);
                    opWybDietSpec.setItemCaption(3, "łatwo strawna z ograniczeniem tłuszczu");
                    
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
                    
            
        content.addComponent(opWybDietSpec);
        
        
        //2.
        TextField d05 = new TextField("5. Procentowa łączna ilość udziału diet bogatobiałkowej\n"
                + "oraz bogatoresztkowej oraz diet specjalnych w całościowej\n dziennej ilości diet:");
        d05.setValue( wd.getD05() + "%" );
        d05.setEnabled(false);
        content.addComponent(d05);
        
        
        

        
    }
   
    
    
        
}