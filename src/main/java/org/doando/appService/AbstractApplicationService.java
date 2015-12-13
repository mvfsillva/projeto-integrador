package org.doando.appService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.doando.business.IBusinessManager;
import org.doando.utils.HibernateUtils;
import org.hibernate.Session;

public class AbstractApplicationService<T extends Serializable, IdType extends Serializable>
		implements IApplicationService<T, IdType> {

	private Session session;
	protected IBusinessManager<T, IdType> business;

	public AbstractApplicationService() {
		session = HibernateUtils.getSession();
	}

	public Session getSession() {
		if (!session.isConnected() || !session.isOpen()) {
			this.session = HibernateUtils.getSession();
		}
		return this.session;
	}

	protected void initialize() {
		business.setSession(getSession());
	}

	protected void beginTransaction() {
		session.beginTransaction();
	}

	protected void commit() {
		session.getTransaction().commit();
	}

	protected void rollback() {
		session.getTransaction().rollback();
	}

	protected void cleanUp() {
		session.flush();
		session.close();
	}

	@Override
	public T find(IdType id) {
		initialize();
		T t = business.find(id);
		cleanUp();
		return t;
	}

	@Override
	public List<T> find() {
		initialize();
		List<T> list = business.find();
		cleanUp();
		return list;
	}

	@Override
	public List<T> find(String namedQuery, Map<String, Object> params) {
		initialize();
		List<T> list = business.find(namedQuery, params);
		cleanUp();
		return list;
	}

	@Override
	public void save(T t) {
		initialize();
		try {
			beginTransaction();
			try {
				business.save(t);
				commit();
			} catch (Exception ex) {
				// Log the exception here
				rollback();
				throw ex;
			}
		} finally {
			cleanUp();
		}
	}

	@Override
	public void save(List<T> tList) {
		initialize();
		try {
			beginTransaction();
			try {
				business.save(tList);
				commit();
			} catch (Exception ex) {
				// Log the exception here
				rollback();
				throw ex;
			}
		} finally {
			cleanUp();
		}
	}

	@Override
	public void update(T t) {
		initialize();
		try {
			beginTransaction();
			try {
				business.update(t);
				commit();
			} catch (Exception ex) {
				// Log the exception here
				rollback();
				throw ex;
			}
		} finally {
			cleanUp();
		}
	}

	@Override
	public void delete(T t) {
		initialize();
		try {
			beginTransaction();
			try {
				business.delete(t);
				commit();
			} catch (Exception ex) {
				// Log the exception here
				rollback();
				throw ex;
			}
		} finally {
			cleanUp();
		}
	}

	@Override
	public void delete(List<T> tList) {
		initialize();
		try {
			beginTransaction();
			try {
				business.delete(tList);
				commit();
			} catch (Exception ex) {
				// Log the exception here
				rollback();
				throw ex;
			}
		} finally {
			cleanUp();
		}
	}
}
