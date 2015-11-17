package com.ads.projetoIntegrador.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.ads.projetoIntegrador.dto.AbstractDTO;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Yago Ferreira
 * @param <T>
 * @param <IdType>
 */
public interface IAbstractDAO<T extends AbstractDTO, IdType> {

    public abstract T find(IdType id);

    public abstract Session getSession();

    public abstract List<T> find();

    public abstract void save(T t);

    public abstract void update(T t);

    public abstract void delete(T t);
}
