package com.formation.emergency.domain.dao.repository;

import java.util.List;
import java.util.Map;

public interface IGenericRepository {
	
	public List<?> executeQuery(String namedQuery, Map<String, Object> parameters) throws Exception;
	
	public void create(Object object);
}
