package com.ads.projetoIntegrador.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;

/**
 *
 * @author Yago Ferreira
 * @param <T>
 * @param <IdType>
 */
public interface IAbstractRepository<T extends Serializable, IdType> {

    T find(IdType id);
    
    void setSession(Session session);

    Session getSession();

    List<T> find();

    List<T> find(String namedQuery, Map<String, Object> params);

    int save(T t);

    void save(List<T> tList);

    void update(T t);

    void delete(T t);

    void delete(List<T> tList);
}
