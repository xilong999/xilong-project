package com.ems.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ems.entity.User;
import com.mongodb.DBCollection;

public interface UserDao {

	/**
	 * 查询所有数据
	 * @param entity
	 * @return
	 */
	public List<?> findAll(Class<?> entity);
	
	/**
	 * 根据id查找第一条document
	 * @param id
	 * @param entity
	 * @return
	 */
	public User findOne(int id, Class<?> entity);
	/**
	 * 统计对应年龄的人数
	 * @param age
	 * @return
	 */
    public Long count(int age);
    
    /**
     * 查询所有userId相同的document
     * @param userId
     * @return
     */
    public List<User> query(int userId);
    
}
