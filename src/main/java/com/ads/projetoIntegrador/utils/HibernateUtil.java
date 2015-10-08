/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ads.projetoIntegrador.utils;

import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Yago Ferreira
 */
@SuppressWarnings("deprecation")
public class HibernateUtil {

/*    private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
        try {
            AnnotationConfiguration conf = new AnnotationConfiguration();
            SessionFactory obj = conf.configure("hibernate.cfg.xml").buildSessionFactory();
            return obj;
        } catch (Throwable ex) {

            System.err.println("Falha ao Iniciar Sessão." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }*/
	
	
	private static SessionFactory sessionFactory;    
    
    public static SessionFactory getSessionFactory()  throws MappingException    
    {    
        if(sessionFactory == null) {  
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();  
        }    
        return sessionFactory;    
    }    
    
    public static Session getSession()    
    {    
        return getSessionFactory().openSession();    
    }  
}
