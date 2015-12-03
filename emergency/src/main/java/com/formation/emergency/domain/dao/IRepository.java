package com.formation.emergency.domain.dao;

import java.util.List;

public interface IRepository<T>  {
	public void create(T object);

	public void update(T object);

	public void delete(Object object);

	public T find(Object key);

	public List<T> findall();
	
}
