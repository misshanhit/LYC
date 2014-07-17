package com.lyc.dao;

import java.sql.Connection;
import java.util.ArrayList;

public interface DAOInterface {
	public Connection connect();
	public void close();
	public int count(String query);
	public ArrayList<Object> select(String query);
	public int insert(String query);
	public void update(String query);
	public int delete(String query);
	public int deleteList(String query);
}
