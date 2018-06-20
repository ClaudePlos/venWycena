/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.venwycena.view;

import com.vaadin.data.Property;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import pl.venwycena.MyUI;
import pl.venwycena.models.Wyceny;
import pl.venwycena.service.WycenaFacade;
import pl.venwycena.models.WycenyDane;

/**
 *
 * @author k.skowronski
 */
public class OfertyView extends CustomComponent implements View{
    
    
    @EJB
    WycenaFacade wf = new WycenaFacade();
     
    public static final String NAME = "oferta";
    
    Label text = new Label();
    
    
    int ilDniInt;
    
    Label v_ilDni = new Label();
    
    PopupDateField dataOd;
    PopupDateField dataDo;
    
    OptionGroup opCzyWiecNizJednaDieta;
    
    OptionGroup opWybDietSpec;

    TextField procIlUdz5;
    
    OptionGroup opWybIlPosDzien6;
    
    TextField ilPosDzien6;
    
    TextField ilPos1;
    TextField ilPos2;
    TextField ilPos3;
    TextField ilPos4;
    TextField ilPos5;
    
    TextField ilOsZy1;
    TextField ilOsZy2;
    TextField ilOsZy3;
    TextField ilOsZy4;
    TextField ilOsZy5;
    TextField ilOsZy6;
    
    TextField gdzieUsluga8;
    TextField ilKmLaMie9;
   
    
    OptionGroup opKalorycznoscPosilkow;
    
    TextField ilCzesciBudynki;
    
    TextField ilSrDziennaMieszDzieci16;
    
    TextField ilDodSkla1;
    TextField ilDodSkla2;
    TextField ilDodSkla3;
    TextField ilDodSkla4;
    TextField ilDodSkla5;
    
    
    
    String p04key1 = "N";
    String p04key2 = "N";
    String p04key3 = "N";
    String p04key4 = "N";
    
    String p10key1 = "N";
    String p10key2 = "N";
    String p10key3 = "N";
    
    String p12key1 = "N";
    String p12key2 = "N";
    
    String p13key1 = "N";
    String p13key2 = "N";
    
    String p14key1 = "N";
    String p14key2 = "N";
    String p14key3 = "N";
    
    String p15key1 = "N";
    String p15key2 = "N";
    
    String p18key1 = "N";
    String p18key2 = "N";
    
    String p19key1 = "N";
    String p19key2 = "N";
    
    String p20key1 = "N";
    String p20key2 = "N";
    
    
     public OfertyView() {
         
        Label labTytul = new Label("<br>ALGORYTM WYCENY ZAMÓWIEŃ CATERINGOWYCH POPRZEZ STRONĘ WWW DLA VENDI SERVIS SP. Z O.O.");
        labTytul.setContentMode(ContentMode.HTML);
         
        FormLayout form = new FormLayout();
  
 
        
        // 1.
        OptionGroup opJakaUsluga = new OptionGroup("1. Czy usluga pojedyncza?\n"
                + "Czy zamówienie dotyczy pojedynczej usługi cateringowej, czy usługi trwającej w czasie.\n"
                + "Jeśli jest to usługa pojedyncza proszę wpisać ilość dni usługi.");
        opJakaUsluga.addItem(0);
        opJakaUsluga.setItemCaption(0, "Tak");
        opJakaUsluga.addItem(1);
        opJakaUsluga.setItemCaption(1, "Nie");
        opJakaUsluga.select(0);
        
           
        dataOd = new PopupDateField();
        dataOd.setDateFormat("yyyy-MM-dd");
        dataOd.setValue(new Date());
        
        
        
        dataDo = new PopupDateField();
        dataDo.setDateFormat("yyyy-MM-dd");
        dataDo.setValue(new Date());
        dataDo.setVisible(false);
        
        dataDo.addValueChangeListener( new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                
              Date dataOdD = (Date) dataOd.getValue();
              Date dataDoD = (Date) dataDo.getValue();
              ilDniInt  = (int)( (dataDoD.getTime() - dataOdD.getTime()) / (1000 * 60 * 60 * 24)) + 1;
              v_ilDni.setValue("Ilość dni: " + ilDniInt);
            }
        } );
        
        
        opJakaUsluga.addValueChangeListener( new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                final String valueString = String.valueOf(event.getProperty().getValue());
                if ( "0".equals(valueString) )
                {
                  dataDo.setVisible(false);  
                  ilDniInt = 1;
                  v_ilDni.setValue("Ilośćć dni: " + ilDniInt);
                }                
                else
                {
                    dataDo.setVisible(true);
                    Date dataOdD = (Date) dataOd.getValue();
                    Date dataDoD = (Date) dataDo.getValue();
                    ilDniInt = (int)( (dataDoD.getTime() - dataOdD.getTime()) / (1000 * 60 * 60 * 24)) + 1;
                    v_ilDni.setValue("Ilośćć dni: " + ilDniInt);
                }
                    
            }
        });
        
        form.addComponent(opJakaUsluga);
        form.addComponent(dataOd);
        form.addComponent(dataDo);
        form.addComponent(v_ilDni);
        
        form.addComponent(new Label("<br><br><br><br><br>",Label.CONTENT_XHTML));
      
      
         
         
         setCompositionRoot(new CssLayout( labTytul, form ));
         
         
         
         
         
     }
     
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // Get the user name from the session
        String username = String.valueOf(getSession().getAttribute("user"));

        text.setValue("Witaj");
    }
    
}
