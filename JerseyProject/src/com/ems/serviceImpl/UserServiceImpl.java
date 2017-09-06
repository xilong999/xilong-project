package com.ems.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.UserDao;
import com.ems.entity.User;
import com.ems.service.UserService;
import com.mongodb.DBCollection;
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired  
    private UserDao userDao;  
	
    @Override
    public User findOne(int id, Class<?> entity){
		return userDao.findOne(id, entity);
    }

    @Override
    public List<?> findAll(Class<?> entity){
    	return userDao.findAll(entity);
    }
    @Override
    public Long count(int age){
    	return userDao.count(age);
    }
    @Override
    public List<User> query(int userId){
    	return userDao.query(userId);
    }
}
