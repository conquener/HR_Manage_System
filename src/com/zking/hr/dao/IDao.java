package com.zking.hr.dao;

import java.util.List;

public interface IDao<T> {
	
	public boolean insert(T t);
	public boolean update(T t);
	public boolean delete(Integer id);
	public List query(int indexPage);
}
