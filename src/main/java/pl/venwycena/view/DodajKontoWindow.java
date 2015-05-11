/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.venwycena.view;

import com.vaadin.data.Validator;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import javax.ejb.EJB;
import pl.venwycena.elements.EmailField;
import pl.venwycena.service.UsersFacade;


/**
 *
 * @author k.skowronski
 */
public class DodajKontoWindow extends Window {
    
    
    final FormLayout content = new FormLayout();
    
    @EJB
    UsersFacade uf = new UsersFacade();
    
    TextField d01;
    TextField d02;
    EmailField d03;
    PasswordField d04;       
    
    boolean sprDane;
    String textError;
    
    public DodajKontoWindow()
    {
        super("Zarejestruj się");
        setWidth(400.0f, Unit.PIXELS);
        setContent(content); 
        center();
        
        
        d01 = new TextField(" Imię:");
        d01.setRequired(true);
        content.addComponent(d01);
        
        d02 = new TextField(" Nazwisko:");
        d02.setRequired(true);
        content.addComponent(d02);
        
        d03 = new EmailField(" Login(mail):");
        d03.setRequired(true);
        content.addComponent(d03);
        
        d03.addValidator( new Validator() {

            @Override
            public void validate(Object value) throws Validator.InvalidValueException {
                String login = (String) value;
                if ( !login.matches("(.*)@(.*)")) {
                 textError = textError + " Login musi posiadać znak @ !";
                 sprDane = false;
               }
            }
        });
        
        
        
        d04 = new PasswordField(" Hasło:");
        d04.setRequired(true);
        content.addComponent(d04);
        
        d04.addValidator( new Validator() {
            @Override
            public void validate(Object value) throws Validator.InvalidValueException {
                String password = (String) value;
                if (password != null && (password.length() < 8 || !password.matches(".*\\d.*"))) {
                    //throw new Validator.InvalidValueException(Notification.Type.ERROR_MESSAGE);
                 textError = textError + " Hasło musi posiadać min. 8 znaków i cyfrę !";
                 sprDane = false;
               }
            }
        });
        
        Button bAddUser = new Button("Dodaj konto", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                
                textError = "Wypełnij dane poprawnie !";
                
                
                try {
                    d03.validate();
                } catch (Exception e) {
                    Notification.show("Brak wpisanego loginu!",Notification.Type.ERROR_MESSAGE);
                    return;
                }
               
                try {
                    d04.validate();
                } catch (Exception e) {
                    Notification.show("Brak wpisanego hasła!",Notification.Type.ERROR_MESSAGE);
                    return;
                }
                 
                sprDane = sprWprowadzoneDane( d01.getValue(), " Imię " );
                sprDane = sprWprowadzoneDane( d02.getValue(), " Nazwisko " );
                sprDane = sprWprowadzoneDane( d03.getValue(), " Login " );
                sprDane = sprWprowadzoneDane( d04.getValue(), " Hasło " );
                
                if ( textError != "Wypełnij dane poprawnie !" )
                  Notification.show(textError, Notification.Type.ERROR_MESSAGE);
                else
                {
                    uf.addUser(d01.getValue(), d02.getValue(), d03.getValue(), d04.getValue());

                    // zamykam
                    close();
                    Notification.show("Zaloguj się na maila aby dokończyć rejestrację!",Notification.Type.ERROR_MESSAGE); 
                }
                    
            }
        });
        bAddUser.setIcon(FontAwesome.USER);
        content.addComponent(bAddUser);
        
        
    }
    
    
    public boolean sprWprowadzoneDane( String spr, String text ){
    
        if ( spr == "" )
        {
            textError = textError + text;
            return false;   
        }    
        else 
            return true;
        
    }
    
}
