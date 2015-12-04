package com.formation.emergency.domain.dao;

import java.util.List;
import java.util.Map;

public interface IGenericRepository {
	List<?> executeQuery(String namedQuery, Map<String, Object> parameters) throws Exception;
	
	void create(Object object) throws Exception;
}
