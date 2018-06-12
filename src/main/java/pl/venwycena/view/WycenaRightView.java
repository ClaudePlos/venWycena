/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.venwycena.view;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.json.JSONException;
import org.json.JSONObject;
import pl.venwycena.models.WycenyDane;

/**
 *
 * @author k.skowronski
 */
public class WycenaRightView extends FormLayout {
    
    private Label     d00;
    private TextField d01;
    private TextField d02;
    private TextField d03;
    private OptionGroup opWybDietSpec;
    private TextField d05;
    private OptionGroup d06;
            private TextField ilPos1;
            private TextField ilPos2;
            private TextField ilPos3;
            private TextField ilPos4;
            private TextField ilPos5;
    private OptionGroup d07;
            private TextField ilOsZy1;
            private TextField ilOsZy2;
            private TextField ilOsZy3;
            private TextField ilOsZy4;
            private TextField ilOsZy5;    
            private TextField ilOsZy6; 
    private TextField d08;
    private TextField d09;
    
    //10
    private OptionGroup opIleRazyDowPosilki;
    
    private TextField d11;
    
    //12,13,14,15
    private OptionGroup opSpDystrybucji;
    private OptionGroup opSpDostarczania;
    private OptionGroup opKalorycznoscPosilkow;
    private OptionGroup opPosilkiDlaDzieci;
    
    private TextField d16;
    
    private OptionGroup d17;
        private TextField ilDodSkla1;
        private TextField ilDodSkla2;
        private TextField ilDodSkla3;
        private TextField ilDodSkla4;
        private TextField ilDodSkla5;
        
    private OptionGroup opUtylizacjiaOdpa;
    private OptionGroup opUtylizacjiaOdpaKomun;
    private OptionGroup opWlasnwJadlospisy;
            
    
    public WycenaRightView(){

        wstawElementy();    
        
        setSizeUndefined();
        setMargin(true);
        setVisible(false);
        
    }
    
    private void wstawElementy(){
         //
        
        HorizontalLayout h01 = new HorizontalLayout();
        VerticalLayout h02 = new VerticalLayout();
        
        addComponent(h01);
        addComponent(h02);
        
        //0. Kwota wyceny
        d00 = new Label();
        h01.addComponent(d00);
        h01.addComponent(new Label("<br>",Label.CONTENT_XHTML));
        
        //1.
        d01 = new TextField("1. Ilość dni usługi:");
        d01.setEnabled(false);
        h02.addComponent(d01);
        h02.addComponent(new Label("<br>",Label.CONTENT_XHTML));
        
        //2.
        d02 = new TextField("2. Ilość osób żywionych:");
        d02.setEnabled(false);
        h02.addComponent(d02);
        h02.addComponent(new Label("<br>",Label.CONTENT_XHTML));
        
        //3.
        d03 = new TextField("3. Czy zamówienie ma zawierać więcej niż jedną dietę:");
        String odp03 = "TAK";
        d03.setValue( odp03 );
        d03.setEnabled(false);
        //addComponent(d03);
        h02.addComponent(d03);
        h02.addComponent(new Label("<br>",Label.CONTENT_XHTML));
        
        
        
        //4.
        opWybDietSpec = new OptionGroup("4. Ilość diet specjalistycznych z następujących rodzajów");
        opWybDietSpec.setMultiSelect(true);
        h02.addComponent(opWybDietSpec);
        h02.addComponent(new Label("<br>",Label.CONTENT_XHTML));
        
        
        //5.
        d05 = new TextField("5. Procentowa łączna ilość udziału diet bogatobiałkowej\n"
                + "oraz bogatoresztkowej oraz diet specjalnych w całościowej\n dziennej ilości diet:");
        d05.setEnabled(false);
        h02.addComponent(d05);
        h02.addComponent(new Label("<br><br>",Label.CONTENT_XHTML));
        
        //6.
        d06 = new OptionGroup("6. Ile posiłków w ciągu dnia ma obejmować catering w ramach diet. \n"
                + "Proszę wpisać  średnią dzienną liczbę dla przedstawionych opcji");
        d06.setEnabled(false);
        h02.addComponent(d06);     
            ilPos1 = new TextField("a. 1 posiłek dziennie (obiad)");
            ilPos1.setValue("0");
            ilPos1.setEnabled(false);
            h02.addComponent(ilPos1);
            ilPos2 = new TextField("b. 2 posiłki dziennie (śniadanie, obiad)");
            ilPos2.setValue("0");
            ilPos2.setEnabled(false);
            h02.addComponent(ilPos2);
            ilPos3 = new TextField("c. 3 posiłki dziennie (śniadanie, obiad, kolacja)");
            ilPos3.setValue("0");
            ilPos3.setEnabled(false);
            h02.addComponent(ilPos3);
            ilPos4 = new TextField("d. 4 posiłki dziennie (śniadanie, II śniadanie, obiad, kolacja) ");
            ilPos4.setValue("0");
            ilPos4.setEnabled(false);
            h02.addComponent(ilPos4);
            ilPos5 = new TextField("e. 5 posiłków dziennie (śniadanie, II śniadanie, obiad, podwieczorek, kolacja) ");
            ilPos5.setValue("0");
            ilPos5.setEnabled(false);
            h02.addComponent(ilPos5);
        h02.addComponent(new Label("<br><br>",Label.CONTENT_XHTML));
        
        //7.
        d07 = new OptionGroup("7. Ile osób ma być żywionych ? Proszę podać średnią ilość osób żywionych\n"
                + "w miesiącu dla każdego z posiłków ( w zależności od pytania nr. 3)");
        d07.setEnabled(false);
        h02.addComponent(d07);     
            ilOsZy1 = new TextField("a. Śniadania");
            ilOsZy1.setValue("0");
            ilOsZy1.setEnabled(false);
            h02.addComponent(ilOsZy1);
            ilOsZy2 = new TextField("b. II Śniadania");
            ilOsZy2.setValue("0");
            ilOsZy2.setEnabled(false);
            h02.addComponent(ilOsZy2);
            ilOsZy3 = new TextField("c. Zupy");
            ilOsZy3.setValue("0");
            ilOsZy3.setEnabled(false);
            h02.addComponent(ilOsZy3);
            ilOsZy4 = new TextField("d. Obiady");
            ilOsZy4.setValue("0");
            ilOsZy4.setEnabled(false);
            h02.addComponent(ilOsZy4);
            ilOsZy5 = new TextField("e. Podwieczorki");
            ilOsZy5.setValue("0");
            ilOsZy5.setEnabled(false);
            h02.addComponent(ilOsZy5);
            ilOsZy6 = new TextField("f. Kolacje");
            ilOsZy6.setValue("0");
            ilOsZy6.setEnabled(false);
            h02.addComponent(ilOsZy6);
        h02.addComponent(new Label("<br><br>",Label.CONTENT_XHTML));
        
        //8.
        d08 = new TextField("8. Gdzie odbywać się ma wykonanie usługi ? Proszę podać kod pocztowy:");
        d08.setEnabled(false);
        h02.addComponent(d08);
        h02.addComponent(new Label("<br>",Label.CONTENT_XHTML));
        
        //9.
        d09 = new TextField("9. Czy usługa ma być realizowana w jednym, czy w kilku oddzielnych miejscach?\n"
                + "Jeśli tak – proszę wpisać łączną ilość kilometrów dzielącą te miejsca od siebie.");
        d09.setEnabled(false);
        h02.addComponent(d09);
        h02.addComponent(new Label("<br>",Label.CONTENT_XHTML));
        
        
        //10
        opIleRazyDowPosilki = new OptionGroup("10. Ile razy dziennie mają być transportowane posiłki?");
        opIleRazyDowPosilki.setMultiSelect(true);
        h02.addComponent(opIleRazyDowPosilki);
        h02.addComponent(new Label("<br>",Label.CONTENT_XHTML));
        
        
        //11.
        d11 = new TextField("11. Ile niezależnych części budynku obejmuje zamówienie? (oddziały, sekcje, piętra itp. ).");
        d11.setEnabled(false);
        h02.addComponent(d11);
        h02.addComponent(new Label("<br>",Label.CONTENT_XHTML));
        
        
        //12
        opSpDystrybucji = new OptionGroup("12. Proszę wybrać sposób dystrybucji posiłków do osób żywionych ");
        opSpDystrybucji.setMultiSelect(true);
        h02.addComponent(opSpDystrybucji);
        h02.addComponent(new Label("<br>",Label.CONTENT_XHTML));
        
        //13
        opSpDostarczania = new OptionGroup("13. Czy podawanie posiłków żywionych dokonywane będzie przez osoby\n"
                + "zatrudnione przez zamawiającego usługę, lub będą odebrane indywidualnie przez żywionych ?");
        opSpDostarczania.setMultiSelect(true);
        h02.addComponent(opSpDostarczania);
        h02.addComponent(new Label("<br>",Label.CONTENT_XHTML));
        
        //14
        opKalorycznoscPosilkow = new OptionGroup("14. Proszę wybrać docelową kaloryczność całodziennego posiłku dla jednej osoby w diecie podstawowej.");
        opKalorycznoscPosilkow.setMultiSelect(true);
        h02.addComponent(opKalorycznoscPosilkow);
        h02.addComponent(new Label("<br>",Label.CONTENT_XHTML));
        
        //15
        opPosilkiDlaDzieci = new OptionGroup("15. Czy zamówienie obejmuje również posiłki dla niemowląt i dzieci do 1 roku życia ?");
        opPosilkiDlaDzieci.setMultiSelect(true);
        h02.addComponent(opPosilkiDlaDzieci);
        h02.addComponent(new Label("<br>",Label.CONTENT_XHTML));
        
        //16
        d16 = new TextField("16. Jeśli tak proszę o wpisanie średniej dziennej ilości mieszanek zamawianych dla dzieci?");
        d16.setEnabled(false);
        h02.addComponent(d16);
        h02.addComponent(new Label("<br>",Label.CONTENT_XHTML));
        
        //17
        d17 = new OptionGroup("17. Czy zamówienie oprócz wybranych diet przewiduje żywienie osób dodatkowymi składnikami.\n"
                + "Wybierz z listy jeśli dotyczy i wpisz ilość miesięcznego zapotrzebowania. ");
        d17.setEnabled(false);
        h02.addComponent(d17);     
            ilDodSkla1 = new TextField("a. Śniadania");
            ilDodSkla1.setValue("0");
            ilDodSkla1.setEnabled(false);
            h02.addComponent(ilDodSkla1);
            ilDodSkla2 = new TextField("b. II Śniadania");
            ilDodSkla2.setValue("0");
            ilDodSkla2.setEnabled(false);
            h02.addComponent(ilDodSkla2);
            ilDodSkla3 = new TextField("c. Zupy");
            ilDodSkla3.setValue("0");
            ilDodSkla3.setEnabled(false);
            h02.addComponent(ilDodSkla3);
            ilDodSkla4 = new TextField("d. Obiady");
            ilDodSkla4.setValue("0");
            ilDodSkla4.setEnabled(false);
            h02.addComponent(ilDodSkla4);
            ilDodSkla5 = new TextField("e. Podwieczorki");
            ilDodSkla5.setValue("0");
            ilDodSkla5.setEnabled(false);
            h02.addComponent(ilDodSkla5);
        h02.addComponent(new Label("<br><br>",Label.CONTENT_XHTML));
        
        //18
        opUtylizacjiaOdpa = new OptionGroup("18. Czy zamawiający usługę pokrywa koszt utylizacji odpadów pokonsumpcyjnych ?");
        opUtylizacjiaOdpa.setMultiSelect(true);
        h02.addComponent(opUtylizacjiaOdpa);
        h02.addComponent(new Label("<br>",Label.CONTENT_XHTML));
        
        //19
        opUtylizacjiaOdpaKomun = new OptionGroup("19. Czy zamawiający usługę pokrywa koszt utylizacji odpadów komunalnych\n powstałych w wyniku korzystania z usługi (opakowania jednorazowe, sztućce, serwetki, opakowania plastikowe)?");
        opUtylizacjiaOdpaKomun.setMultiSelect(true);
        h02.addComponent(opUtylizacjiaOdpaKomun);
        h02.addComponent(new Label("<br>",Label.CONTENT_XHTML));
        
        //20
        opWlasnwJadlospisy = new OptionGroup("20. Czy zamawiający będzie korzystał z jadłospisów wykonanych przez siebie, czy zamawia taką usługę ?");
        opWlasnwJadlospisy.setMultiSelect(true);
        h02.addComponent(opWlasnwJadlospisy);
        h02.addComponent(new Label("<br>",Label.CONTENT_XHTML));
        
        //21
        
         Button butWycena = new Button("Przekaż do działu produkcji", new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {

                    // "Logout" the user
                    //getSession().setAttribute("user", null);

                    // Refresh this view, should redirect to login view
                    //getUI().getNavigator().navigateTo(WycenaView.NAME);
                }
            });
         
         h02.addComponent(butWycena);
        
    }
    
    //***************************************************8
    
    public void odswiezDane( WycenyDane wd ){
        
        Long wycena =  (
                   Long.parseLong( wd.getD01().toString() ) * 1000 
                + (Long.parseLong( wd.getD02().toString() ) * 100) 
                );        
        //0.
        d00.setValue( "Sugerowana warotosc uslugi: " 
                + wycena.toString()
                + " PLN" );
        
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
           d05.setValue( wd.getD05() + "%" );
           
           //6.
           ilPos1.setValue( wd.getD06a() );
           ilPos2.setValue( wd.getD06b() );
           ilPos3.setValue( wd.getD06c() );
           ilPos4.setValue( wd.getD06d() );
           ilPos5.setValue( wd.getD06e() );
           
           //7.
           ilOsZy1.setValue( wd.getD07a() );
           ilOsZy2.setValue( wd.getD07b() );
           ilOsZy3.setValue( wd.getD07c() );
           ilOsZy4.setValue( wd.getD07d() );
           ilOsZy5.setValue( wd.getD07e() );
           ilOsZy6.setValue( wd.getD07f() );
           
           //8.
           d08.setValue( wd.getD08() );
           
           //9.
           d09.setValue( wd.getD09() );
           
           
           //10.
            String key_p10_1 = null;
            String key_p10_2 = null;
            String key_p10_3 = null;
          

            try {
                JSONObject jsonObject = new JSONObject(wd.getD10());

                key_p10_1 = (String )jsonObject.get("key1");
                key_p10_2 = (String )jsonObject.get("key2");
                key_p10_3 = (String )jsonObject.get("key3");

            } catch( JSONException e)
            {
              e.printStackTrace();
            }


            opIleRazyDowPosilki.addItem(0);
            opIleRazyDowPosilki.setItemCaption(0, "1 raz dziennie (tylko jeden posiłek)");
            opIleRazyDowPosilki.addItem(1);
            opIleRazyDowPosilki.setItemCaption(1, "2 razy dziennie (oddzielnie śniadanie i obiad z kolacją)");
            opIleRazyDowPosilki.addItem(2);
            opIleRazyDowPosilki.setItemCaption(2, "3 razy dziennie (oddzielnie śniadanie z ew. II śniadaniem – obiad z ew. podwieczorek – kolacja)");

            opIleRazyDowPosilki.setValue(null);

            if ( key_p10_1.equals("T") ) 
                opIleRazyDowPosilki.select(0);
            if ( key_p10_2.equals("T") ) 
                opIleRazyDowPosilki.select(1);
            if ( key_p10_3.equals("T") ) 
                opIleRazyDowPosilki.select(2);
            
            
            //11
            d11.setValue( wd.getD11() );
            
            //12
            String key_p12_1 = null;
            String key_p12_2 = null;
            
            try {
                JSONObject jsonObject = new JSONObject(wd.getD12());

                key_p12_1 = (String )jsonObject.get("key1");
                key_p12_2 = (String )jsonObject.get("key2");

            } catch( JSONException e)
            {
              e.printStackTrace();
            }
            opSpDystrybucji.addItem(0);
            opSpDystrybucji.setItemCaption(0, "Opakowania jednorazowe");
            opSpDystrybucji.addItem(1);
            opSpDystrybucji.setItemCaption(1, "Tace termoizolacyjne");
            
            opSpDystrybucji.setValue(null);

            if ( key_p12_1.equals("T") ) 
                opSpDystrybucji.select(0);
            if ( key_p12_2.equals("T") ) 
                opSpDystrybucji.select(1);
        
            //13
            String key_p13_1 = null;
            String key_p13_2 = null;
            
            try {
                JSONObject jsonObject = new JSONObject(wd.getD13());

                key_p13_1 = (String )jsonObject.get("key1");
                key_p13_2 = (String )jsonObject.get("key2");

            } catch( JSONException e)
            {
              e.printStackTrace();
            }
            opSpDostarczania.addItem(0);
            opSpDostarczania.setItemCaption(0, "Osoby zatrudnione przez zamawijącego");
            opSpDostarczania.addItem(1);
            opSpDostarczania.setItemCaption(1, "Indywidualnie");
            
            opSpDostarczania.setValue(null);

            if ( key_p13_1.equals("T") ) 
                opSpDostarczania.select(0);
            if ( key_p13_2.equals("T") ) 
                opSpDostarczania.select(1);
            
            //14
            String key_p14_1 = null;
            String key_p14_2 = null;
            String key_p14_3 = null;
          

            try {
                JSONObject jsonObject = new JSONObject(wd.getD14());

                key_p14_1 = (String )jsonObject.get("key1");
                key_p14_2 = (String )jsonObject.get("key2");
                key_p14_3 = (String )jsonObject.get("key3");

            } catch( JSONException e)
            {
              e.printStackTrace();
            }


            opKalorycznoscPosilkow.addItem(0);
            opKalorycznoscPosilkow.setItemCaption(0, "2400 kcal ");
            opKalorycznoscPosilkow.addItem(1);
            opKalorycznoscPosilkow.setItemCaption(1, "2200 kcal");
            opKalorycznoscPosilkow.addItem(2);
            opKalorycznoscPosilkow.setItemCaption(2, "2600 kcal");

            opKalorycznoscPosilkow.setValue(null);

            if ( key_p14_1.equals("T") ) 
                opKalorycznoscPosilkow.select(0);
            if ( key_p14_2.equals("T") ) 
                opKalorycznoscPosilkow.select(1);
            if ( key_p14_3.equals("T") ) 
                opKalorycznoscPosilkow.select(2);     
            
            //15
            String key_p15_1 = null;
            String key_p15_2 = null;
            
            try {
                JSONObject jsonObject = new JSONObject(wd.getD15());

                key_p15_1 = (String )jsonObject.get("key1");
                key_p15_2 = (String )jsonObject.get("key2");

            } catch( JSONException e)
            {
              e.printStackTrace();
            }
            opPosilkiDlaDzieci.addItem(0);
            opPosilkiDlaDzieci.setItemCaption(0, "Tak");
            opPosilkiDlaDzieci.addItem(1);
            opPosilkiDlaDzieci.setItemCaption(1, "Nie");
            
            opPosilkiDlaDzieci.setValue(null);

            if ( key_p15_1.equals("T") ) 
                opPosilkiDlaDzieci.select(0);
            if ( key_p15_2.equals("T") ) 
                opPosilkiDlaDzieci.select(1);
            
            
            //16
            d16.setValue( wd.getD16() );
            
            //17
            ilDodSkla1.setValue( wd.getD17a() );
            ilDodSkla2.setValue( wd.getD17b() );
            ilDodSkla3.setValue( wd.getD17c() );
            ilDodSkla4.setValue( wd.getD17d() );
            ilDodSkla5.setValue( wd.getD17e() );

            //18
            String key_p18_1 = null;
            String key_p18_2 = null;
            
            try {
                JSONObject jsonObject = new JSONObject(wd.getD18());

                key_p18_1 = (String )jsonObject.get("key1");
                key_p18_2 = (String )jsonObject.get("key2");

            } catch( JSONException e)
            {
              e.printStackTrace();
            }
            opUtylizacjiaOdpa.addItem(0);
            opUtylizacjiaOdpa.setItemCaption(0, "Tak");
            opUtylizacjiaOdpa.addItem(1);
            opUtylizacjiaOdpa.setItemCaption(1, "Nie");
            
            opUtylizacjiaOdpa.setValue(null);

            if ( key_p18_1.equals("T") ) 
                opUtylizacjiaOdpa.select(0);
            if ( key_p18_2.equals("T") ) 
                opUtylizacjiaOdpa.select(1);
            
            //19
            String key_p19_1 = null;
            String key_p19_2 = null;
            
            try {
                JSONObject jsonObject = new JSONObject(wd.getD19());

                key_p19_1 = (String )jsonObject.get("key1");
                key_p19_2 = (String )jsonObject.get("key2");

            } catch( JSONException e)
            {
              e.printStackTrace();
            }
            opUtylizacjiaOdpaKomun.addItem(0);
            opUtylizacjiaOdpaKomun.setItemCaption(0, "Tak");
            opUtylizacjiaOdpaKomun.addItem(1);
            opUtylizacjiaOdpaKomun.setItemCaption(1, "Nie");
            
            opUtylizacjiaOdpaKomun.setValue(null);

            if ( key_p19_1.equals("T") ) 
                opUtylizacjiaOdpaKomun.select(0);
            if ( key_p19_2.equals("T") ) 
                opUtylizacjiaOdpaKomun.select(1);
            
            //20
            String key_p20_1 = null;
            String key_p20_2 = null;
            
            try {
                JSONObject jsonObject = new JSONObject(wd.getD19());

                key_p20_1 = (String )jsonObject.get("key1");
                key_p20_2 = (String )jsonObject.get("key2");

            } catch( JSONException e)
            {
              e.printStackTrace();
            }
            opWlasnwJadlospisy.addItem(0);
            opWlasnwJadlospisy.setItemCaption(0, "Tak");
            opWlasnwJadlospisy.addItem(1);
            opWlasnwJadlospisy.setItemCaption(1, "Nie");
            
            opWlasnwJadlospisy.setValue(null);

            if ( key_p20_1.equals("T") ) 
                opWlasnwJadlospisy.select(0);
            if ( key_p20_2.equals("T") ) 
                opWlasnwJadlospisy.select(1);
        
        
    }
    
    
   
    
    
}
