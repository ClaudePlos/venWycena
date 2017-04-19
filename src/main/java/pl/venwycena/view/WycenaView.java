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
public class WycenaView extends CustomComponent implements View{
    
    
    @EJB
    WycenaFacade wf = new WycenaFacade();
     
    public static final String NAME = "wycena";
    
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
    
    
     public WycenaView() {
         
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
              v_ilDni.setValue("Ilośćć dni: " + ilDniInt);
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
        

     
        // 2.
        final TextField ilOsZy = new TextField("2. Proszę podać łączną dzienną ilość osób żywionych?");
        ilOsZy.setValue("0");
        form.addComponent(ilOsZy);

        form.addComponent(new Label("<br><br><br><br><br>",Label.CONTENT_XHTML));
        
        // 3.
        opCzyWiecNizJednaDieta = new OptionGroup("3. Czy zamówienie ma zawierać więcej niż jedną dietę?");
        opCzyWiecNizJednaDieta.addItem(0);
        opCzyWiecNizJednaDieta.setItemCaption(0, "Tak");
        opCzyWiecNizJednaDieta.addItem(1);
        opCzyWiecNizJednaDieta.setItemCaption(1, "Nie");
        
        form.addComponent(opCzyWiecNizJednaDieta);
        
        form.addComponent(new Label("<br><br><br><br><br>",Label.CONTENT_XHTML));
        
        // 4.
        opWybDietSpec = new OptionGroup("4. Proszę wybrać ilość diet specjalistycznych z następujących rodzajów");
        opWybDietSpec.setMultiSelect(true);
        
        
        opCzyWiecNizJednaDieta.addValueChangeListener( new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                final String valueString = String.valueOf(event.getProperty().getValue());
                if ( "0".equals(valueString) )
                {
                    opWybDietSpec.addItem(0);
                    opWybDietSpec.setItemCaption(0, "podstawowa");
                    opWybDietSpec.addItem(1);
                    opWybDietSpec.setItemCaption(1, "bogatoresztkowa");
                    opWybDietSpec.addItem(2);
                    opWybDietSpec.setItemCaption(2, "łatwo strawna");
                    opWybDietSpec.addItem(3);
                    opWybDietSpec.setItemCaption(3, "łatwo strawna z ograniczeniem tłuszczu");
                    procIlUdz5.setEnabled(true);
                }                
                else
                {
                    opWybDietSpec.removeAllItems();
                    procIlUdz5.setEnabled(false);
                }
                    
            }
        });
        
        
        
        opWybDietSpec.addValueChangeListener( new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
               final String valueString = String.valueOf(event.getProperty().getValue());
               if ( valueString.contains("0") )
                   p04key1 = "T";
               else
                   p04key1 = "N";
               if ( valueString.contains("1")  )
                   p04key2 = "T";
               else
                   p04key2 = "N";
               if ( valueString.contains("2")  )
                   p04key3 = "T";
               else
                   p04key3 = "N";
               if ( valueString.contains("3")  )
                   p04key4 = "T";
               else
                   p04key4 = "N";
            }
        });
        
  
        form.addComponent(opWybDietSpec);
        
        form.addComponent(new Label("<br><br><br><br><br>",Label.CONTENT_XHTML));
        
        
        // 5.
        procIlUdz5 = new TextField("5. Proszę podać procentową łączną ilość udziału diet bogatobiałkowej\n"
                + "oraz bogatoresztkowej oraz diet specjalnych w całościowej dziennej ilości diet");
        procIlUdz5.setValue("0");
        
        form.addComponent(procIlUdz5);
        
        form.addComponent(new Label("<br><br><br><br><br>",Label.CONTENT_XHTML));
        
        /// 6.
        ilPosDzien6 = new TextField("6. Ile posiłków w ciągu dnia ma obejmować catering w ramach diet. \n"
                + "Proszę wpisać  średnią dzienną liczbę dla przedstawionych opcji");
        ilPosDzien6.setEnabled(false);
        ilPosDzien6.setStyleName("dashing");
        form.addComponent(ilPosDzien6);
        
        ilPos1 = new TextField("a. 1 posiłek dziennie (obiad)");
        ilPos1.setValue("0");
        form.addComponent(ilPos1);
        ilPos2 = new TextField("b. 2 posiłki dziennie (śniadanie, obiad)");
        ilPos2.setValue("0");
        form.addComponent(ilPos2);
        ilPos3 = new TextField("c. 3 posiłki dziennie (śniadanie, obiad, kolacja)");
        ilPos3.setValue("0");
        form.addComponent(ilPos3);
        ilPos4 = new TextField("d. 4 posiłki dziennie (śniadanie, II śniadanie, obiad, kolacja) ");
        ilPos4.setValue("0");
        form.addComponent(ilPos4);
        ilPos5 = new TextField("e. 5 posiłków dziennie (śniadanie, II śniadanie, obiad, podwieczorek, kolacja) ");
        ilPos5.setValue("0");
        form.addComponent(ilPos5);
        
        form.addComponent(new Label("<br><br><br><br><br>",Label.CONTENT_XHTML));
        
        
        
        /// 7. 
        TextField ilOsZywionych7  = new TextField("7. Ile osób ma być żywionych ? Proszę podać średnią ilość osób żywionych\n"
                + "w miesiącu dla każdego z posiłków ( w zależności od pytania nr. 3)");
        ilOsZywionych7.setEnabled(false);

        ilOsZywionych7.setStyleName("dashing");
        
        form.addComponent(ilOsZywionych7);
     
        
        ilOsZy1 = new TextField("a. Śniadania");
        ilOsZy1.setValue("0");
        form.addComponent(ilOsZy1);
        ilOsZy2 = new TextField("b. II Śniadania");
        ilOsZy2.setValue("0");
        form.addComponent(ilOsZy2);
        ilOsZy3 = new TextField("c. Zupy");
        ilOsZy3.setValue("0");
        form.addComponent(ilOsZy3);
        ilOsZy4 = new TextField("d. Obiady");
        ilOsZy4.setValue("0");
        form.addComponent(ilOsZy4);
        ilOsZy5 = new TextField("e. Podwieczorki");
        ilOsZy5.setValue("0");
        form.addComponent(ilOsZy5);
        ilOsZy6 = new TextField("f. Kolacje");
        ilOsZy6.setValue("0");
        form.addComponent(ilOsZy6);
        
        form.addComponent(new Label("<br><br><br><br><br>",Label.CONTENT_XHTML));
        
        // 8.
        ////Gdzie odbywać się ma wykonanie usługi ? Proszę podać kod pocztowy
        gdzieUsluga8 = new TextField("8. Gdzie odbywać się ma wykonanie usługi ? Proszę podać kod pocztowy:");
        gdzieUsluga8.setValue("00-000");
        form.addComponent(gdzieUsluga8);   
        
        
        form.addComponent(new Label("<br><br><br><br><br>",Label.CONTENT_XHTML));
        
        // 9.
        //Czy usługa ma być realizowana w jednym, czy w kilku oddzielnych miejscach? Jeśli tak – proszę wpisać łączną ilość kilometrów dzielącą te miejsca od siebie.
        ilKmLaMie9 = new TextField("9. Czy usługa ma być realizowana w jednym, czy w kilku oddzielnych miejscach?\n"
                + "Jeśli tak – proszę wpisać łączną ilość kilometrów dzielącą te miejsca od siebie.");
        ilKmLaMie9.setValue("0");
        form.addComponent(ilKmLaMie9);  
        
        form.addComponent(new Label("<br><br><br><br><br>",Label.CONTENT_XHTML));
        
        //// 10.
        OptionGroup opIleRazyDowPosilki = new OptionGroup("10. Ile razy dziennie mają być transportowane posiłki?");
        opIleRazyDowPosilki.addItem(0);
        opIleRazyDowPosilki.setItemCaption(0, "1 raz dziennie (tylko jeden posiłek)");
        opIleRazyDowPosilki.addItem(1);
        opIleRazyDowPosilki.setItemCaption(1, "2 razy dziennie (oddzielnie śniadanie i obiad z kolacją)");
        opIleRazyDowPosilki.addItem(2);
        opIleRazyDowPosilki.setItemCaption(2, "3 razy dziennie (oddzielnie śniadanie z ew. II śniadaniem – obiad z ew. podwieczorek – kolacja)");
        form.addComponent(opIleRazyDowPosilki);
        
        opIleRazyDowPosilki.addValueChangeListener( new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
               final String valueString = String.valueOf(event.getProperty().getValue());
               
               if ( valueString.contains("0") )
                   p10key1 = "T";
               else
                   p10key1 = "N";
               
               if ( valueString.contains("1")  )
                   p10key2 = "T";
               else
                   p10key2 = "N";
               
               if ( valueString.contains("2")  )
                   p10key3 = "T";
               else
                   p10key3 = "N";
            }
        });
        
        
        form.addComponent(new Label("<br><br><br><br><br>",Label.CONTENT_XHTML));
        
        /// 11.
        ilCzesciBudynki= new TextField("11. Ile niezależnych części budynku obejmuje zamówienie? (oddziały, sekcje, piętra itp. ).");
        ilCzesciBudynki.setValue("0");
        form.addComponent(ilCzesciBudynki);  
        
        
        form.addComponent(new Label("<br><br><br><br><br>",Label.CONTENT_XHTML));
        
        /// 12.
        OptionGroup opSpDystrybucji = new OptionGroup("12. Proszę wybrać sposób dystrybucji posiłków do osób żywionych ");
        opSpDystrybucji.addItem(0);
        opSpDystrybucji.setItemCaption(0, "Opakowania jednorazowe");
        opSpDystrybucji.addItem(1);
        opSpDystrybucji.setItemCaption(1, "Tace termoizolacyjne");
        form.addComponent(opSpDystrybucji);
        
        opSpDystrybucji.addValueChangeListener( new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
               final String valueString = String.valueOf(event.getProperty().getValue());
               
               if ( valueString.contains("0") )
                   p12key1 = "T";
               else
                   p12key1 = "N";
               
               if ( valueString.contains("1")  )
                   p12key2 = "T";
               else
                   p12key2 = "N";

            }
        });
        
        form.addComponent(new Label("<br><br><br><br><br>",Label.CONTENT_XHTML));
        
        /// 13.
        OptionGroup opSpDostarczania = new OptionGroup("13. Czy podawanie posiłków żywionych dokonywane będzie przez osoby\n"
                + "zatrudnione przez zamawiającego usługę, lub będą odebrane indywidualnie przez żywionych ?");
        opSpDostarczania.addItem(0);
        opSpDostarczania.setItemCaption(0, "Osoby zatrudnione przez zamawijącego");
        opSpDostarczania.addItem(1);
        opSpDostarczania.setItemCaption(1, "Indywidualnie");
        form.addComponent(opSpDostarczania);
        
        opSpDostarczania.addValueChangeListener( new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
               final String valueString = String.valueOf(event.getProperty().getValue());
               
               if ( valueString.contains("0") )
                   p13key1 = "T";
               else
                   p13key1 = "N";
               
               if ( valueString.contains("1")  )
                   p13key2 = "T";
               else
                   p13key2 = "N";

            }
        });
        
        form.addComponent(new Label("<br><br><br><br><br>",Label.CONTENT_XHTML));
       
        /// 14.
        opKalorycznoscPosilkow = new OptionGroup("14. Proszę wybrać docelową kaloryczność całodziennego posiłku dla jednej osoby w diecie podstawowej.");
        opKalorycznoscPosilkow.addItem(0);
        opKalorycznoscPosilkow.setItemCaption(0, "2400 kcal ");
        opKalorycznoscPosilkow.addItem(1);
        opKalorycznoscPosilkow.setItemCaption(1, "2200 kcal");
        opKalorycznoscPosilkow.addItem(2);
        opKalorycznoscPosilkow.setItemCaption(2, "2600 kcal");
        opKalorycznoscPosilkow.setValidationVisible(true);
        form.addComponent(opKalorycznoscPosilkow);
        
        opKalorycznoscPosilkow.addValueChangeListener( new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
               final String valueString = String.valueOf(event.getProperty().getValue());
               
               if ( valueString.contains("0") )
                   p14key1 = "T";
               else
                   p14key1 = "N";
               
               if ( valueString.contains("1")  )
                   p14key2 = "T";
               else
                   p14key2 = "N";
               
               if ( valueString.contains("2")  )
                   p14key3 = "T";
               else
                   p14key3 = "N";

            }
        });
        
        form.addComponent(new Label("<br><br><br><br><br>",Label.CONTENT_XHTML));
        
        /// 15.
        OptionGroup opPosilkiDlaDzieci = new OptionGroup("15. Czy zamówienie obejmuje również posiłki dla niemowląt i dzieci do 1 roku życia ?");
        opPosilkiDlaDzieci.addItem(0);
        opPosilkiDlaDzieci.setItemCaption(0, "Tak");
        opPosilkiDlaDzieci.addItem(1);
        opPosilkiDlaDzieci.setItemCaption(1, "Nie");
        opPosilkiDlaDzieci.select(1);
        
        opPosilkiDlaDzieci.addValueChangeListener( new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
               final String valueString = String.valueOf(event.getProperty().getValue());
               
               if ( valueString.contains("0") )
                   p15key1 = "T";
               else
                   p15key1 = "N";
               
               if ( valueString.contains("1")  )
                   p15key2 = "T";
               else
                   p15key2 = "N";

            }
        });
        
        
        opPosilkiDlaDzieci.addValueChangeListener( new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                final String valueString = String.valueOf(event.getProperty().getValue());
                if ( "0".equals(valueString) )
               {
                   ilSrDziennaMieszDzieci16.setEnabled(true);
                }                
                else
                {
                   ilSrDziennaMieszDzieci16.setEnabled(false);
                }
                    
            }
        });
        
        form.addComponent(opPosilkiDlaDzieci);
        
        form.addComponent(new Label("<br><br><br><br><br>",Label.CONTENT_XHTML));
        
        /// 16.
        ilSrDziennaMieszDzieci16 = new TextField("16. Jeśli tak proszę o wpisanie średniej dziennej ilości mieszanek zamawianych dla dzieci? ");
        ilSrDziennaMieszDzieci16.setValue("0");
        ilSrDziennaMieszDzieci16.setEnabled(false);
        form.addComponent(ilSrDziennaMieszDzieci16);
        
        form.addComponent(new Label("<br><br><br><br><br>",Label.CONTENT_XHTML));
        
        
        // 17.
        TextField ilDodSkladniki17 = new TextField("17. Czy zamówienie oprócz wybranych diet przewiduje żywienie osób dodatkowymi składnikami.\n"
                + "Wybierz z listy jeśli dotyczy i wpisz ilość miesięcznego zapotrzebowania. ");
        ilDodSkladniki17.setEnabled(false);
        
        ilDodSkladniki17.setStyleName("dashing");
        
        form.addComponent(ilDodSkladniki17);
        
        ilDodSkla1 = new TextField("a. Dodatkowy jogurt naturalny )");
        ilDodSkla1.setValue("0");
        form.addComponent(ilDodSkla1);
        ilDodSkla2 = new TextField("b. Kleik ryżowy");
        ilDodSkla2.setValue("0");
        form.addComponent(ilDodSkla2);
        ilDodSkla3 = new TextField("c. Kisiel");
        ilDodSkla3.setValue("0");
        form.addComponent(ilDodSkla3);
        ilDodSkla4 = new TextField("d. Suchary");
        ilDodSkla4.setValue("0");
        form.addComponent(ilDodSkla4);
        ilDodSkla5 = new TextField("e. Kaszki mleczne dla dzieci");
        ilDodSkla5.setValue("0");
        form.addComponent(ilDodSkla5);
        
        form.addComponent(new Label("<br><br><br><br><br>",Label.CONTENT_XHTML));
        
        // 18.
        OptionGroup opUtylizacjiaOdpa = new OptionGroup("18. Czy zamawiający usługę pokrywa koszt utylizacji odpadów pokonsumpcyjnych ?");
        opUtylizacjiaOdpa.addItem(0);
        opUtylizacjiaOdpa.setItemCaption(0, "Tak");
        opUtylizacjiaOdpa.addItem(1);
        opUtylizacjiaOdpa.setItemCaption(1, "Nie");
        opUtylizacjiaOdpa.select(0);
        form.addComponent(opUtylizacjiaOdpa);
        
        opUtylizacjiaOdpa.addValueChangeListener( new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
               final String valueString = String.valueOf(event.getProperty().getValue());
               
               if ( valueString.contains("0") )
                   p18key1 = "T";
               else
                   p18key1 = "N";
               
               if ( valueString.contains("1")  )
                   p18key2 = "T";
               else
                   p18key2 = "N";

            }
        });
        
        form.addComponent(new Label("<br><br><br><br><br>",Label.CONTENT_XHTML));
        
        // 19.
        OptionGroup opUtylizacjiaOdpaKomun = new OptionGroup("19. Czy zamawiający usługę pokrywa koszt utylizacji odpadów komunalnych\n powstałych w wyniku korzystania z usługi (opakowania jednorazowe, sztućce, serwetki, opakowania plastikowe)?");
        opUtylizacjiaOdpaKomun.addItem(0);
        opUtylizacjiaOdpaKomun.setItemCaption(0, "Tak");
        opUtylizacjiaOdpaKomun.addItem(1);
        opUtylizacjiaOdpaKomun.setItemCaption(1, "Nie");
        opUtylizacjiaOdpaKomun.select(0);
        form.addComponent(opUtylizacjiaOdpaKomun);
        
        opUtylizacjiaOdpaKomun.addValueChangeListener( new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
               final String valueString = String.valueOf(event.getProperty().getValue());
               
               if ( valueString.contains("0") )
                   p19key1 = "T";
               else
                   p19key1 = "N";
               
               if ( valueString.contains("1")  )
                   p19key2 = "T";
               else
                   p19key2 = "N";

            }
        });
        
        form.addComponent(new Label("<br><br><br><br><br>",Label.CONTENT_XHTML));
        
        // 20.
        OptionGroup opWlasnwJadlospisy = new OptionGroup("20. Czy zamawiający będzie korzystał z jadłospisów wykonanych przez siebie, czy zamawia taką usługę ?");
        opWlasnwJadlospisy.addItem(0);
        opWlasnwJadlospisy.setItemCaption(0, "Tak");
        opWlasnwJadlospisy.addItem(1);
        opWlasnwJadlospisy.setItemCaption(1, "Nie");
        opWlasnwJadlospisy.select(0);
        form.addComponent(opWlasnwJadlospisy);
        
        opWlasnwJadlospisy.addValueChangeListener( new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
               final String valueString = String.valueOf(event.getProperty().getValue());
               
               if ( valueString.contains("0") )
                   p20key1 = "T";
               else
                   p20key1 = "N";
               
               if ( valueString.contains("1")  )
                   p20key2 = "T";
               else
                   p20key2 = "N";

            }
        });
         
        form.addComponent(new Label("<br><br><br><br><br>",Label.CONTENT_XHTML));
        
        /// END
        
         Button wyslijWycene;
        wyslijWycene = new Button("Wyślij", new Button.ClickListener() {
            
            @Override
            public void buttonClick(Button.ClickEvent event) {
                
                String vSpr = "OK";
                
                Object p03 = opCzyWiecNizJednaDieta.getValue();
                
                Object p14 = opKalorycznoscPosilkow.getValue();
                
                if ( p03 == null )
                {
                    vSpr = "Error";
                    Notification.show("Wypełnij pytanie numer 3 !");
                }
                
                if ( p14 == null )
                {
                    vSpr = "Error";
                    Notification.show("Wypełnij pytanie numer 14 !");
                }
                
       
                if ( vSpr.equals("OK"))
                {
                    SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
                
                    Date today = new Date();
                    Date dataOb = new Date();
                    dataOb.setTime(today.getTime() + 7 * 24 * 60 * 60 * 1000);

                    Wyceny wycena = new Wyceny();
                    wycena.setWDataWyceny( today );
                    wycena.setWDataObowiazywania( dataOb );
                    wycena.setWUserId( MyUI.zalogowany.getUId() );

                    wycena.setWNazwa("Wycena" + dateFormat.format(today) );
                    
                    
                    WycenyDane wycDane = new WycenyDane();
                    wycDane.setD01( Integer.toString(ilDniInt) );
                    wycDane.setD02( ilOsZy.getValue() );
                    wycDane.setD03( p03.toString() );
                    
    
                    String JSONp04 = "{\"key1\":\""+p04key1+"\",\"key2\":\""+p04key2+"\",\"key3\":\""+p04key3+"\",\"key4\":\""+p04key4+"\"}";
                    
                    wycDane.setD04( JSONp04 );
                    
                    wycDane.setD05( procIlUdz5.getValue() );
                    
                    //6.
                    wycDane.setD06a( ilPos1.getValue() );
                    wycDane.setD06b( ilPos2.getValue() );
                    wycDane.setD06c( ilPos3.getValue() );
                    wycDane.setD06d( ilPos4.getValue() );
                    wycDane.setD06e( ilPos5.getValue() );
                    
                    //7.
                    wycDane.setD07a( ilOsZy1.getValue() );
                    wycDane.setD07b( ilOsZy2.getValue() );
                    wycDane.setD07c( ilOsZy3.getValue() );
                    wycDane.setD07d( ilOsZy4.getValue() );
                    wycDane.setD07e( ilOsZy5.getValue() );
                    wycDane.setD07f( ilOsZy6.getValue() );
                    
                    //8
                    wycDane.setD08( gdzieUsluga8.getValue() );
                            
                    //9
                    wycDane.setD09( ilKmLaMie9.getValue());
                    
                    //10
                    String JSONp10 = "{\"key1\":\""+p10key1+"\",\"key2\":\""+p10key2+"\",\"key3\":\""+p10key3+"\"}";
                    wycDane.setD10( JSONp10 );
                    
                    //11
                    wycDane.setD11( ilCzesciBudynki.getValue());
                    
                    //12
                    String JSONp12 = "{\"key1\":\""+p12key1+"\",\"key2\":\""+p12key2+"\"}";
                    wycDane.setD12( JSONp12 );
                    
                    //13
                    String JSONp13 = "{\"key1\":\""+p13key1+"\",\"key2\":\""+p13key2+"\"}";
                    wycDane.setD13( JSONp13 );
                    
                    //14
                    String JSONp14 = "{\"key1\":\""+p14key1+"\",\"key2\":\""+p14key2+"\",\"key3\":\""+p14key3+"\"}";
                    wycDane.setD14( JSONp14 );
                    
                    //15
                    String JSONp15 = "{\"key1\":\""+p15key1+"\",\"key2\":\""+p15key2+"\"}";
                    wycDane.setD15( JSONp15 );
                    
                    //16
                    wycDane.setD16( ilSrDziennaMieszDzieci16.getValue());
                    
                    //17
                    wycDane.setD17a( ilDodSkla1.getValue() );
                    wycDane.setD17b( ilDodSkla2.getValue() );
                    wycDane.setD17c( ilDodSkla3.getValue() );
                    wycDane.setD17d( ilDodSkla4.getValue() );
                    wycDane.setD17e( ilDodSkla5.getValue() );
                    
                    //18
                    String JSONp18 = "{\"key1\":\""+p18key1+"\",\"key2\":\""+p18key2+"\"}";
                    wycDane.setD18( JSONp18 );
                    
                    //19
                    String JSONp19 = "{\"key1\":\""+p19key1+"\",\"key2\":\""+p19key2+"\"}";
                    wycDane.setD19( JSONp19 );
                    
                    //20
                    String JSONp20 = "{\"key1\":\""+p20key1+"\",\"key2\":\""+p20key2+"\"}";
                    wycDane.setD20( JSONp20 );
                    
                    Wyceny w = wf.zapiszWycene(wycena,wycDane );
                    
                    if ( w != null )
                    {
                        getUI().getNavigator().navigateTo(MainView.NAME);
                    }
                }
                
            }
        });
        
         
         
         
         setCompositionRoot(new CssLayout( labTytul, form, wyslijWycene ));
         
         
         
         
         
     }
     
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // Get the user name from the session
        String username = String.valueOf(getSession().getAttribute("user"));

        text.setValue("Witaj");
    }
    
}
