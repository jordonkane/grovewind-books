package com.grovewindbooks.dao;

import java.util.List;

public interface GenericDAO<T> {

	public T create(T t);

	public T update(T t);

	public T get(Object id);

	public void delete(Object id);

	public List listAll();

	public long count();

}