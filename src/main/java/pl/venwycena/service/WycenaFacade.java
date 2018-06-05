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
import javax.ejb.EJB;
import javax.inject.Inject;
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
    
    @Inject
    UsersFacade uf = new UsersFacade();
    
    public WycenaFacade() {
        em = emfInstance.createEntityManager();
    }
    
    
    public List<Wyceny> allWycenyUsera( int user_id )
    {
        
        Query query =  em.createNativeQuery("select * from wyceny where w_user_id = " + user_id + "  order by w_data_wyceny desc" );
        
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
    
    public List<Wyceny> allWycenyAdmin()
    {
        
        Query query =  em.createNativeQuery("select * from wyceny order by w_data_wyceny desc");
        
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
           Users user = uf.getUser( w.getWUserId() );
           w.setMailKtoZamawia( user.getUMail() );
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
                     
                        
                        em.createNativeQuery("INSERT INTO wyceny (w_user_id,w_data_wyceny,w_data_obowiazywania,w_nazwa) "
                                + "VALUES ("+entry.getWUserId()+""
                                + ",'"+formatter.format(entry.getWDataWyceny())+"'"
                                + ",'"+formatter.format(entry.getWDataObowiazywania())+"'"
                                + ",'"+entry.getWNazwa()+"'"
                                + ")").executeUpdate();
                        t.commit();                        
     
                        
      
        
                Query query =  em.createNativeQuery("select max(w_id) from wyceny where w_user_id = " + entry.getWUserId() );
        
                        int id_wyceny = (int) query.getSingleResult();
                        
                        em.getTransaction().begin();
                        
                        em.createNativeQuery("INSERT INTO wyceny_dane (d_w_id, d_01, d_02, d_03, d_04, d_05, d_06a, d_06b, d_06c, d_06d, d_06e"
                                + " , d_07a, d_07b, d_07c, d_07d, d_07e, d_07f"
                                + " , d_08, d_09, d_10, d_11, d_12, d_13, d_14, d_15, d_16"
                                + " , d_17a, d_17b, d_17c, d_17d, d_17e"
                                + " , d_18, d_19, d_20"
                                + " ) "
                                + "VALUES ("+id_wyceny+""
                                + ",'"+wycDane.getD01()+"'"
                                + ",'"+wycDane.getD02()+"'"
                                + ",'"+wycDane.getD03()+"'"
                                + ",'"+wycDane.getD04()+"'"
                                + ",'"+wycDane.getD05()+"'"
                                + ",'"+wycDane.getD06a()+"'"
                                + ",'"+wycDane.getD06b()+"'"
                                + ",'"+wycDane.getD06c()+"'"
                                + ",'"+wycDane.getD06d()+"'"
                                + ",'"+wycDane.getD06e()+"'"
                                + ",'"+wycDane.getD07a()+"'"
                                + ",'"+wycDane.getD07b()+"'"
                                + ",'"+wycDane.getD07c()+"'"
                                + ",'"+wycDane.getD07d()+"'"
                                + ",'"+wycDane.getD07e()+"'"
                                + ",'"+wycDane.getD07f()+"'"
                                + ",'"+wycDane.getD08()+"'"
                                + ",'"+wycDane.getD09()+"'"
                                + ",'"+wycDane.getD10()+"'"
                                + ",'"+wycDane.getD11()+"'"
                                + ",'"+wycDane.getD12()+"'"
                                + ",'"+wycDane.getD13()+"'"
                                + ",'"+wycDane.getD14()+"'"
                                + ",'"+wycDane.getD15()+"'"
                                + ",'"+wycDane.getD16()+"'"
                                + ",'"+wycDane.getD17a()+"'"
                                + ",'"+wycDane.getD17b()+"'"
                                + ",'"+wycDane.getD17c()+"'"
                                + ",'"+wycDane.getD17d()+"'"
                                + ",'"+wycDane.getD17e()+"'"
                                + ",'"+wycDane.getD18()+"'"
                                + ",'"+wycDane.getD19()+"'"
                                + ",'"+wycDane.getD20()+"'"
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
           w.setD06a( (String) o[7] );
           w.setD06b( (String) o[8] );
           w.setD06c( (String) o[9] );
           w.setD06d( (String) o[10] );
           w.setD06e( (String) o[11] );
           
           w.setD07a( (String) o[12] );
           w.setD07b( (String) o[13] );
           w.setD07c( (String) o[14] );
           w.setD07d( (String) o[15] );
           w.setD07e( (String) o[16] );
           w.setD07f( (String) o[17] );
           
           w.setD08( (String) o[18] );
           w.setD09( (String) o[19] );

           w.setD10( (String) o[20] );
           
           w.setD11( (String) o[21] );
           
           w.setD12( (String) o[22] );
           w.setD13( (String) o[23] );
           w.setD14( (String) o[24] );
           
           w.setD15( (String) o[25] );
           w.setD16( (String) o[26] );
           
           w.setD17a( (String) o[27] );
           w.setD17b( (String) o[28] );
           w.setD17c( (String) o[29] );
           w.setD17d( (String) o[30] );
           w.setD17e( (String) o[31] );
           
           w.setD18( (String) o[32] );
           w.setD19( (String) o[33] );
           w.setD20( (String) o[34] );

           
        }
                
        
        return w;
    }
    
}
