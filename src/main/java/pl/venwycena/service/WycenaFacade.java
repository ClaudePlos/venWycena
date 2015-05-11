/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.venwycena.service;

import pl.venwycena.models.WycenyDane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pl.venwycena.models.Users;
import pl.venwycena.models.Wyceny;

/**
 *
 * @author k.skowronski
 */

@javax.ejb.Stateless
public class WycenaFacade {
    
     private static final EntityManagerFactory emfInstance =
		        Persistence.createEntityManagerFactory("PU");
    
    private EntityManager em;
    
    public WycenaFacade() {
        em = emfInstance.createEntityManager();
    }
    
    
    public List<Wyceny> allWycenyUsera( int user_id )
    {
        
        Query query =  em.createNativeQuery("select * from Wyceny where w_user_id = " + user_id );
        
        List<Object[]> ob = query.getResultList();
         
        List<Wyceny> wyceny =  new ArrayList<Wyceny>();
        
        for ( Object[] o : ob )
        {
           Wyceny w = new Wyceny();
           w.setWId( (Integer) o[0] );
           w.setWUserId( (Integer) o[1] );
           w.setWDataWyceny( (Date) o[2] );
           w.setWDataObowiazywania((Date) o[3] );
           w.setWNazwa( (String) o[4] );
           wyceny.add(w);
        }
                
        
        return wyceny;
    }
    

    public Wyceny zapiszWycene( Wyceny entry, WycenyDane wycDane )
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
                        EntityTransaction t = em.getTransaction();
                        
                        t.begin();
                        //check if the id is 0 which is same as null
                        //if (entry.getwId().intValue()==0){
                       //        entry.setWId(null);
                        //}
                       //save our entry
                       //entry = em.merge(entry);
                        //em.persist( entry );
                        //em.flush();
                        //em.flush();
                     
                        
                        em.createNativeQuery("INSERT INTO WYCENY (w_user_id,w_data_wyceny,w_data_obowiazywania,w_nazwa) "
                                + "VALUES ("+entry.getWUserId()+""
                                + ",'"+formatter.format(entry.getWDataWyceny())+"'"
                                + ",'"+formatter.format(entry.getWDataObowiazywania())+"'"
                                + ",'"+entry.getWNazwa()+"'"
                                + ")").executeUpdate();
                        t.commit();                        
     
                        
      
        
                Query query =  em.createNativeQuery("select max(w_id) from Wyceny where w_user_id = " + entry.getWUserId() );
        
                        int id_wyceny = (int) query.getSingleResult();
                        
                        em.getTransaction().begin();
                        
                        em.createNativeQuery("INSERT INTO WYCENY_DANE (d_w_id, d_01, d_02, d_03, d_04, d_05 ) "
                                + "VALUES ("+id_wyceny+""
                                + ",'"+wycDane.getD01()+"'"
                                + ",'"+wycDane.getD02()+"'"
                                + ",'"+wycDane.getD03()+"'"
                                + ",'"+wycDane.getD04()+"'"
                                + ",'"+wycDane.getD05()+"'"
                                + ")").executeUpdate();
                        em.getTransaction().commit();
        
                        
                } catch (Exception e) {
                        return null;
                }
                finally {
        	        em.close();
        	    }
         
         
                return entry;
    }
    
    
    
    
    public WycenyDane pobierzWycenyDane( int wycena_id )
    {
        
        Query query =  em.createNativeQuery("select * from wyceny_dane where d_w_id = " + wycena_id );
        
        List<Object[]> ob = query.getResultList();
        
        WycenyDane w = new WycenyDane();
              
        for ( Object[] o : ob )
        { 
           w.setDId( (Integer) o[0] );
           w.setDwId((Integer) o[1] );
           w.setD01( (String) o[2] );
           w.setD02( (String) o[3] );
           w.setD03( (String) o[4] );
           w.setD04( (String) o[5] );
           w.setD05( (String) o[6] );
        }
                
        
        return w;
    }
    
}
