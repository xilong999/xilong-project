package com.ems.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entity.AllElec;
import com.ems.entity.AllElecList;
import com.ems.service.QueryBeforeService;

@RestController
@Path("/queryBefore") // 此服务访问的路径
public class QueryBeforeResourse {

	@Autowired
	QueryBeforeService queryBeforeService;

	@Path("/beforeEnergyType/{id}/{name}")
	@GET // 表示此服务路径基于get请求模式
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8") // 表示响应的结果以文本方式返回
	public List<AllElec> queryBeforeEnergyType(@PathParam("id") String id, 
			@PathParam("name") String name) {
		return queryBeforeService.queryBeforeEnergyType(id,name);
	}
	
	
	@Path("/beforeAllElec/{id}")
	@GET // 表示此服务路径基于get请求模式
	@Produces(MediaType.APPLICATION_JSON  + ";charset=utf-8") // 表示响应的结果以文本方式返回
	public List<AllElecList> queryBeforeAllElec(@PathParam("id") String id) {
		return queryBeforeService.queryBeforeAllElec(id);
	}
	
	@Path("/beforeAllElecs/{id}")
	@GET // 表示此服务路径基于get请求模式
	@Produces(MediaType.APPLICATION_JSON  + ";charset=utf-8") // 表示响应的结果以文本方式返回
	public List<AllElecList> queryBeforeAllElecs(@PathParam("id") String id) {
		return queryBeforeService.queryBeforeAllElecs(id);
	}

	@Path("/beforeOneElec/{id}/{name}")
	@GET // 表示此服务路径基于get请求模式
	@Produces(MediaType.APPLICATION_JSON  + ";charset=utf-8") // 表示响应的结果以文本方式返回
	public AllElecList queryBeforeOneElec(@PathParam("id") String id, @PathParam("name") String name){
		return queryBeforeService.queryBeforeOneElec(id, name);
	}
}
