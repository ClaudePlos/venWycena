/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.venwycena.view;



import com.vaadin.data.validator.AbstractValidator;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Image;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;
import javax.ejb.EJB;
import pl.venwycena.MyUI;
import pl.venwycena.models.Users;
import pl.venwycena.service.UsersFacade;

/**
 *
 * @author k.skowronski
 */
public class LoginView extends CustomComponent implements View,
        Button.ClickListener {
    
    @EJB
    UsersFacade uf = new UsersFacade();

    public static final String NAME = "login";

    private final TextField user;

    private final PasswordField password;

    private final Button loginButton;
    
    private final Button zarejestrujButton;

    public LoginView() {
        setSizeFull();

        // create logo
        Image imgLogoVendi = new Image();
        imgLogoVendi.setSource(new ThemeResource("vendi_logo2.png"));

        // Create the user input field
        user = new TextField("Login:");
        user.setWidth("300px");
        user.setRequired(true);
        user.setInputPrompt("Your username (eg. joe@email.com)");
        user.addValidator(new EmailValidator(
                "Username must be an email address"));
        user.setInvalidAllowed(false);
        user.setValue("test@t.pl");

        // Create the password input field
        password = new PasswordField("Hasło:");
        password.setWidth("300px");
        password.addValidator(new PasswordValidator());
        password.setRequired(true);
        password.setNullRepresentation("");
        password.setValue("passw0rd");

        // Create login button
        loginButton = new Button("Login", this);
        loginButton.setIcon(FontAwesome.CHECK);
        zarejestrujButton = new Button("Zarejestruj się", this);

        // Add both to a 
        
        VerticalLayout fields = new VerticalLayout( user, password, loginButton, zarejestrujButton);
        fields.setCaption("Podaj login i hasło. (test@t.pl/passw0rd)");
        fields.setSpacing(true);
    //   fields.setMargin(new MarginInfo(true, true, true, false));
        fields.setSizeUndefined();

        
        VerticalLayout logo = new VerticalLayout( imgLogoVendi, fields );
        logo.setComponentAlignment(imgLogoVendi, Alignment.MIDDLE_CENTER);
        logo.setComponentAlignment(fields, Alignment.MIDDLE_CENTER);
        logo.setSpacing(true);
        logo.setSizeUndefined();
        // The view root layout
        VerticalLayout viewLayout = new VerticalLayout(logo);
        viewLayout.setSizeFull();
        viewLayout.setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
        viewLayout.setStyleName(Reindeer.LAYOUT_BLUE);
        setCompositionRoot(viewLayout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // focus the username field when user arrives to the login view
        user.focus();
    }

    // Validator for validating the passwords
    private static final class PasswordValidator extends
            AbstractValidator<String> {

        public PasswordValidator() {
            super("The password provided is not valid");
        }

        @Override
        protected boolean isValidValue(String value) {
            //
            // Password must be at least 8 characters long and contain at least
            // one number
            //
            if (value != null
                    && (value.length() < 8 || !value.matches(".*\\d.*"))) {
                return false;
            }
            return true;
        }

        @Override
        public Class<String> getType() {
            return String.class;
        }
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {

        //
        // Validate the fields using the navigator. By using validors for the
        // fields we reduce the amount of queries we have to use to the database
        // for wrongly entered passwords
        //
        
   
        String nazwaButtona =  event.getComponent().getCaption();
        
        if ( nazwaButtona.equals("Zarejestruj się") )
        {
            DodajKontoWindow dodKontoW = new DodajKontoWindow();
            UI.getCurrent().addWindow(dodKontoW);
            return;
        }
        
        if (!user.isValid() || !password.isValid()) {
            return;
        }


        String username = user.getValue().toString();
        String password = this.password.getValue().toString();
        
        Users login = new Users();
        login.setULogin(username);
        login.setUPassword(password);
        
        Users us = uf.sprawdzenieLogowania(login);

        //
        // Validate username and password with database here. For examples sake
        // I use a dummy username and password.
        //
        boolean isValid = username.equals(us.getULogin())
                && password.equals(us.getUPassword());

        if (isValid) {

            // Store the current user in the service session
            getSession().setAttribute("user", username);
            
            MyUI.zalogowany = us;
            MyUI.zalogowany.setUId(us.getUId());
            // Navigate to main view
            getUI().getNavigator().navigateTo(MainView.NAME);//

        } else {

            // Wrong password clear the password field and refocuses it
            this.password.setValue(null);
            this.password.focus();

        }
    }
}