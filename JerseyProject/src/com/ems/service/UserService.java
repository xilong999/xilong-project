package com.ems.service;

import java.util.List;

import com.ems.entity.User;
import com.mongodb.DBCollection;

public interface UserService {	
	
	public User findOne(int id, Class<?> entity);
	
	public List<?> findAll(Class<?> entity);
	
	public Long count(int age);
	
	public List<User> query(int userId);
}
