package com.formation.emergency.domain.dao;

import java.util.List;
import java.util.Map;

public interface IGenericRepository {
		public List<?> ExecuteQuery(String namedQuery, Map<String,Object> parameters);
}
