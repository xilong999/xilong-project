package com.ems.service;

import java.util.List;

import com.ems.entity.AllElec;
import com.ems.entity.NameOfElec;
import com.ems.entity.TreeNode;

public interface TreeNodeService {

	public List<TreeNode> queryNode();
	public List<TreeNode> queryNodeAll();
	public List<TreeNode> queryNodeAllElec();
	public String queryEveryTypeElec(String id,String name);
	public String queryAllEnergyType(String id, String name);
	public List<AllElec> queryAllElec(String id);
	public List<NameOfElec> queryNameOfAllElec(String id);
}
