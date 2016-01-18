package com.formation.emergency.domain.dao.repository;

import java.util.List;
import java.util.Map;

public interface IGenericDao {

	void create(Object item) throws Exception;
	
	List<?> executeQuery(String nameQuery, Map<String,Object> params) throws Exception;
	
}
