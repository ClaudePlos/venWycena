/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.venwycena.view;


import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import pl.venwycena.MyUI;
import pl.venwycena.models.Wyceny;
import pl.venwycena.models.WycenyDane;
import pl.venwycena.service.UsersFacade;
import pl.venwycena.service.WycenaFacade;


/**
 *
 * @author k.skowronski
 */
public class MainView extends CustomComponent implements View {

    public static final String NAME = "";

    Label text = new Label();
    Table tab;
    
    @EJB
    WycenaFacade wf = new WycenaFacade();
    
    @EJB
    UsersFacade uf = new UsersFacade();
    
    WycenaRightView wrv;
    
    private FormLayout editorLayout = new FormLayout();
    
   
    Button logout = new Button("Wyloguj", new Button.ClickListener() {

        @Override
        public void buttonClick(Button.ClickEvent event) {

            // "Logout" the user
            getSession().setAttribute("user", null);
            
            // Navigate to main view
            
            // Refresh this view, should redirect to login view
            getUI().getNavigator().navigateTo(NAME);
        }
    });
    
    Button butWycena = new Button("Stwórz wycenę", new Button.ClickListener() {

        @Override
        public void buttonClick(Button.ClickEvent event) {

            // "Logout" the user
            //getSession().setAttribute("user", null);

            // Refresh this view, should redirect to login view
            getUI().getNavigator().navigateTo(WycenaView.NAME);
        }
    });
    
    Button butPobDiete = new Button("Pobierz dietę", new Button.ClickListener() {

        @Override
        public void buttonClick(Button.ClickEvent event) {

            // "Logout" the user
            //getSession().setAttribute("user", null);

            // Refresh this view, should redirect to login view
            getUI().getNavigator().navigateTo(DietaView.NAME);
        }
    });
    


    public MainView() {
        
        HorizontalSplitPanel splitPanel = new HorizontalSplitPanel();
        
        FormLayout form = new FormLayout();
        
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        int i = 1;
        
        tab = new Table("Twoje wyceny:");
        
        tab.addContainerProperty("Wycena", String.class, null);
        tab.addContainerProperty("Data Wyceny",  String.class, null);
        tab.addContainerProperty("Data Obowiązywania",  String.class, null);
        tab.addContainerProperty("Kto Zamawia",  String.class, null);
        tab.addContainerProperty("wycena",  Wyceny.class, null);
        tab.setColumnWidth("wycena", 0);
        tab.setSelectable(true);
        
        
        if ( MyUI.zalogowany != null )
        {
            List<Wyceny> wyceny = new ArrayList<Wyceny>();
            
            if ( MyUI.zalogowany.getULogin().equals("wycena@vendiservis.pl")){
                wyceny = wf.allWycenyAdmin();
            }else{
                wyceny = wf.allWycenyUsera(MyUI.zalogowany.getUId());
            }
               
            

            for ( Wyceny wyc : wyceny )
            {
                wyc.setMailKtoZamawia( uf.getUser(wyc.getWUserId()).getUMail() );
                tab.addItem( new Object[] { wyc.getWNazwa()
                        , formater.format( wyc.getWDataWyceny() ) 
                        , formater.format( wyc.getWDataObowiazywania() )
                        , wyc.getMailKtoZamawia()
                        , wyc                    
                },  i);
                i++;
            }
        }
        
        
        tab.setPageLength(10);
        
        wrv = new WycenaRightView();
        
        VerticalLayout leftLayout = new VerticalLayout();
        VerticalLayout rightLayout = new VerticalLayout();
        
        leftLayout.addComponent(tab);
        rightLayout.addComponent(wrv);
        
        splitPanel.addComponent(leftLayout);
        //splitPanel.addComponent(editorLayout);
        splitPanel.addComponent(rightLayout);  
        

        form.addComponent(splitPanel);
        
        tab.addItemClickListener( new ItemClickEvent.ItemClickListener() {

            @Override
            public void itemClick(ItemClickEvent event) {
                if (event.isDoubleClick())
                {
                    Wyceny wyc = (Wyceny) event.getItem().getItemProperty("wycena").getValue();
                    WycenaWindowTab wycInfo = new WycenaWindowTab();
                    wycInfo.odswiez(wyc);
                    UI.getCurrent().addWindow(wycInfo);
                }
            }
        });
        
   
        
        
        
        initContactList();
       
        
        
        setCompositionRoot(new CssLayout(text, logout, butWycena, butPobDiete, form ));
        
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // Get the user name from the session
        String username = String.valueOf(getSession().getAttribute("user"));

        // And show the username
        text.setValue("Witaj " + username);
    }
    
    
    
 
     
     private void initContactList() {
            //    tab.setVisibleColumns(new String[] { FNAME, LNAME, COMPANY });
                tab.setSelectable(true);
                tab.setImmediate(true);

                tab.addValueChangeListener(new Property.ValueChangeListener() {
                        public void valueChange(ValueChangeEvent event) {
                                Object contactId = tab.getValue();

                                    if (contactId != null)
                                    {
                                       Wyceny wyc = (Wyceny) tab.getItem(contactId).getItemProperty("wycena").getValue(); 
                                       WycenyDane wd = (WycenyDane) wf.pobierzWycenyDane( wyc.getWId() ); 
                                       
                                       wrv.odswiezDane(wd);

                                    }
                                      
                                    
                            

                                wrv.setVisible(contactId != null);
                        }
                });
        }

    
    
}
