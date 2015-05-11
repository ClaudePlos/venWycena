/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.venwycena.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pl.venwycena.models.Users;

/**
 *
 * @author k.skowronski
 */
@javax.ejb.Stateless
public class UsersFacade  {
    //@PersistenceContext(unitName = "com.mycompany_venWycena-ui_war_1.0-SNAPSHOTPU") extends AbstractFacade<Users>
    
    
    private static final EntityManagerFactory emfInstance =
		        Persistence.createEntityManagerFactory("PU");
    
    private EntityManager em;
    
  /*  @Override
    protected EntityManager getEntityManager() {
        return em;
    }*/

    public UsersFacade() {
        em = emfInstance.createEntityManager();
        //super(Users.class);
    }
    
    public List<Users> allUsers()
    {
        List<Users> allUsers = em.createQuery("from Users u").getResultList();
        
        return allUsers;
    }
    
    public Users sprawdzenieLogowania( Users user )
    {
        Users us = new Users();
                
       try{
          Query query = em.createNativeQuery("SELECT * FROM Users WHERE u_Login = '" + user.getULogin() + "' and u_Password = '" + user.getUPassword() + "'");
          
          Object[] us1 = (Object[]) query.getSingleResult();
           
          us.setUId( (Integer) us1[0] ); 
          us.setULogin( (String) us1[1]); 
          us.setUPassword((String) us1[2]); 
          us.setUMail((String) us1[3]);
          
                  
       } catch(Exception e){
          us.setULogin("ErrErrErr");
       }
        
        return us;
    }
    
    public void addUser ( String imie, String nazwisko, String login, String password )
    {
      
            em.getTransaction().begin();

            em.createNativeQuery("INSERT INTO USERS (u_imie, u_nazwisko, u_login, u_password, u_mail, u_aktywny ) "
                    + "VALUES ('"+imie+"'"
                    + ",'"+nazwisko+"'"
                    + ",'"+login+"'"
                    + ",'"+password+"'"
                    + ",'"+login+"'"
                    + ",'T'"
                    + ")").executeUpdate();
            em.getTransaction().commit();
    }
    
}
    
  
    
