package com.ems.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entity.User;
import com.ems.service.UserService;

@RestController
@Path("/user") // 此服务访问的路径
public class UserResource {
	@Autowired
	UserService userService;
	
	
	//Person qp = mongoTemplate.findOne(query(where("age").is(33)), Person.class); 
	@Path("/{userId}")
	@GET // 表示此服务路径基于get请求模式
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8") // 表示响应的结果以文本方式返回
	public User findOne(@PathParam("userId") int userId) {
		return userService.findOne(userId,User.class);
	}
	
	@Path("count/{age}")
	@GET // 表示此服务路径基于get请求模式
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8") // 表示响应的结果以文本方式返回
	public String count(@PathParam("age") int age) {
		return userService.count(age).toString();
	}
	
	
	@SuppressWarnings("unchecked")
	@GET // 表示此服务路径基于get请求模式
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8") // 表示响应的结果以文本方式返回
	public List<User> findAll() {
		return (List<User>) userService.findAll(User.class);
	}
	
	@Path("userList/{userId}")
	@GET // 表示此服务路径基于get请求模式
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8") // 表示响应的结果以文本方式返回
	public List<User> query(@PathParam("userId") int userId) {
		return userService.query(userId);
	}
}
