package com.ads.projetoIntegrador.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;

/**
 *
 * @author Yago Ferreira
 * @param <T>
 * @param <IdType>
 */
public interface IAbstractDAO<T, IdType> {

    public abstract T find(IdType id);

    public abstract List<T> find();

    public abstract int save(T t);

    public abstract int update(T t);

    public abstract int delete(T t);
}
