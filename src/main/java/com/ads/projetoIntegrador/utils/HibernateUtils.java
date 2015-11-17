/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Yago Ferreira
 */
public class HibernateUtils {

    private static SessionFactory sessionFactory;

    private static SessionFactory getInstance() {
        if(sessionFactory == null) {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

    public static Session getSession() throws HibernateException {
        return getInstance().openSession();
    }
}
