package org.doando.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.doando.entity.CityEntity;
import org.hibernate.Query;

public class CityRepository extends AbstractRepository<CityEntity, Integer> {

	public CityRepository() {
		super(CityEntity.class);
	}
	
	public List<CityEntity> findByState(Integer id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		Query q = getSession().createQuery("select c from CityEntity c where c.id_state = :id");
		q.setProperties(params);
		return q.list();
	}
	
}
