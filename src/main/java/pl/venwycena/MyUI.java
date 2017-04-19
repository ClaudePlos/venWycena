package pl.venwycena;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import javax.ejb.EJB;
import pl.venwycena.models.Users;
import pl.venwycena.service.UsersFacade;
import pl.venwycena.view.MainView;
import pl.venwycena.view.LoginView;
import pl.venwycena.view.WycenaView;

/**
 *
 * 2014-02-20
 * do bazy pass oracle na root !!!!
 * 
 * 
 * 
 */
@Theme("mytheme")
@Widgetset("pl.venwycena.MyAppWidgetset")
public class MyUI extends UI {
    
    @EJB
    UsersFacade uf = new UsersFacade();
    
    public static Users zalogowany;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
       /* final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking") );  
            }
        });
        layout.addComponent(button);*/
        
        new Navigator(this, this);

        //
        // The initial log view where the user can login to the application
        //
        getNavigator().addView(LoginView.NAME, LoginView.class);//

        //
        // Add the main view of the application
        //
        getNavigator().addView(MainView.NAME, MainView.class);
        
        getNavigator().addView(WycenaView.NAME, WycenaView.class);

        //
        // We use a view change handler to ensure the user is always redirected
        // to the login view if the user is not logged in.
        //
        getNavigator().addViewChangeListener(new ViewChangeListener() {

            @Override
            public boolean beforeViewChange(ViewChangeListener.ViewChangeEvent event) {

                // Check if a user has logged in
                boolean isLoggedIn = getSession().getAttribute("user") != null;
                boolean isLoginView = event.getNewView() instanceof LoginView;

                if (!isLoggedIn && !isLoginView) {
                    // Redirect to login view always if a user has not yet
                    // logged in
                    getNavigator().navigateTo(LoginView.NAME);
                    return false;

                } else if (isLoggedIn && isLoginView) {
                    // If someone tries to access to login view while logged in,
                    // then cancel
                    return false;
                }

                return true;
            }

            @Override
            public void afterViewChange(ViewChangeListener.ViewChangeEvent event) {

            }
        });

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
