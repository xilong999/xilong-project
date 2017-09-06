package com.ems.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entity.AllElec;
import com.ems.entity.NameOfElec;
import com.ems.entity.TreeNode;
import com.ems.service.TreeNodeService;

@RestController
@Path("/treeNode") // 此服务访问的路径
public class TreeNodeResourse {

	@Autowired
	TreeNodeService treeNodeService;

	@Path("/allEnergyLists")
	@GET // 表示此服务路径基于get请求模式
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8") // 表示响应的结果以文本方式返回
	public List<TreeNode> queryNodeAll() {
		return treeNodeService.queryNodeAll();
	}

	@Path("/allElecLists")
	@GET // 表示此服务路径基于get请求模式
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8") // 表示响应的结果以文本方式返回
	public List<TreeNode> queryNodeAllElec() {
		return treeNodeService.queryNodeAllElec();
	}

	@Path("/list")
	@GET // 表示此服务路径基于get请求模式
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8") // 表示响应的结果以文本方式返回
	public List<TreeNode> queryNode() {
		return treeNodeService.queryNode();
	}

	@Path("/valueOfEveryTypeElec")
	@GET // 表示此服务路径基于get请求模式
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8") // 表示响应的结果以文本方式返回
	public String queryEveryTypeElec(@QueryParam("id") String id,
			@QueryParam("name") String name) {
		return treeNodeService.queryEveryTypeElec(id,name);
	}

	@Path("/valueOfAllEnergyType")
	@GET // 表示此服务路径基于get请求模式
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8") // 表示响应的结果以文本方式返回
	public String queryAllEnergyType(@QueryParam("id") String id, @QueryParam("name") String name) {
		return treeNodeService.queryAllEnergyType(id,name);
	}

	@Path("/valueOfAllElec")
	@GET // 表示此服务路径基于get请求模式
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8") // 表示响应的结果以文本方式返回
	public List<AllElec> queryAllElec(@QueryParam("id") String id) {
		return treeNodeService.queryAllElec(id);
	}
	
	@Path("/nameOfAllElec")
	@GET // 表示此服务路径基于get请求模式
	@Produces(MediaType.APPLICATION_JSON+ ";charset=utf-8") // 表示响应的结果以文本方式返回
	public List<NameOfElec> queryNameOfAllElec(@QueryParam("id") String id) {
		return treeNodeService.queryNameOfAllElec(id);
	}
}
