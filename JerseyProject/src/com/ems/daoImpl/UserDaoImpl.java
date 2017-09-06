package com.ems.daoImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ems.dao.UserDao;
import com.ems.entity.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

@Repository("userDao") 
public class UserDaoImpl implements UserDao{

	@Override
	public List<?> findAll(Class<?> entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findOne(int id, Class<?> entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count(int age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> query(int userId) {
		// TODO Auto-generated method stub
		return null;
	}  
  
       /* *//** 
         * 操作mongodb的类,可以参考api 
         *//*  
        @Autowired  
        private MongoTemplate mongoTemplate;  

		// 查询所有数据
	    public List<?> findAll(Class<?> entity) {
	        return mongoTemplate.findAll(entity);
	    }

	    // 根据id查找
	    public User findOne(int id, Class<?> entity) {
	        return (User) mongoTemplate.findOne(new Query(Criteria.where("userId")
	                .is(id)), entity);
	    }

	    *//** 
	     * 统计这个年龄的人数 
	     * @param age 
	     * @return 
	     *//*  
	    public Long count(int age) {  
	        DBCollection userColl = mongoTemplate.getCollection(mongoTemplate  
	                .getCollectionName(User.class));  
	        BasicDBObject parameter = new BasicDBObject();  
	        parameter.put("age", age);  
	        return userColl.count(parameter);  
	    }  
	    *//**
	     * 根据userId 查询
	     * @param userId
	     *//*
	    public List<User> query(int userId) {  
	        // 根据age查询  
	        List<User> users = mongoTemplate.find(new Query(new Criteria(  
	                "userId").is(userId)), User.class);  
	        for (User u : users) {  
	            System.out.println(u.toString());  
	        }  
	        return users;
	    }  */
}  
