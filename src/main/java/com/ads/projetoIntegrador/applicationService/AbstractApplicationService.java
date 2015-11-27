package com.ads.projetoIntegrador.applicationService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.ads.projetoIntegrador.repository.IRepository;
import com.ads.projetoIntegrador.utils.HibernateUtils;

public class AbstractApplicationService<T extends Serializable, IdType extends Serializable> 
		implements IApplicationService<T, IdType> {

	private Session session;
	private IRepository<T, IdType> repository;
	
	public Session getSession() {
		if(!session.isConnected() || !session.isOpen()) {
			this.session = HibernateUtils.getSession();
		}
		return this.session;
	}
	
	protected void initialize() {
		repository.setSession(getSession());
	}
	
	protected void beginTransaction() {
		session.beginTransaction();
	}
	
	protected void commit() {
		session.getTransaction().commit();
	}
	
	protected void cleanUp() {
		session.flush();
		session.close();
	}
	
	@Override
	public T find(IdType id) {
		initialize();
		T t = repository.find(id);
		cleanUp();
		return t;
	}

	@Override
	public List<T> find() {
		initialize();
		List<T> list = repository.find();
		cleanUp();
		return list;
	}

	@Override
	public List<T> find(String namedQuery, Map<String, Object> params) {
		initialize();
		List<T> list = repository.find(namedQuery, params);
		cleanUp();
		return list;
	}

	@Override
	public void save(T t) {
		initialize();
		beginTransaction();
		repository.save(t);
		commit();
		cleanUp();
	}

	@Override
	public void save(List<T> tList) {
		initialize();
		beginTransaction();
		repository.save(tList);
		commit();
		cleanUp();
	}

	@Override
	public void update(T t) {
		initialize();
		beginTransaction();
		repository.update(t);
		commit();
		cleanUp();
	}

	@Override
	public void delete(T t) {
		initialize();
		beginTransaction();
		repository.delete(t);
		commit();
		cleanUp();
	}

	@Override
	public void delete(List<T> tList) {
		initialize();
		beginTransaction();
		repository.delete(tList);
		commit();
		cleanUp();
	}
}
