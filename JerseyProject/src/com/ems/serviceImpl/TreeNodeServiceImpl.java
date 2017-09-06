package com.ems.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.TreeNodeDao;
import com.ems.entity.AllElec;
import com.ems.entity.NameOfElec;
import com.ems.entity.TreeNode;
import com.ems.service.TreeNodeService;

@Service("treeNodeService")
public class TreeNodeServiceImpl implements TreeNodeService {

	@Autowired
	TreeNodeDao treeNodeDao;
	
	@Override
	public List<TreeNode> queryNode() {
		return treeNodeDao.queryNode();
	}
	
	public List<TreeNode> queryNodeAll(){
		return treeNodeDao.queryNodeAll();
	}

	public List<TreeNode> queryNodeAllElec(){
		return treeNodeDao.queryNodeAllElec();
	}
	@Override
	public String queryEveryTypeElec(String id,String name) {
		// TODO Auto-generated method stub
		return treeNodeDao.queryEveryTypeElec(id,name);
	}

	@Override
	public String queryAllEnergyType(String id,String name) {
		// TODO Auto-generated method stub
		return treeNodeDao.queryAllEnergyType(id,name);
	}

	@Override
	public List<AllElec> queryAllElec(String id) {
		// TODO Auto-generated method stub
		return treeNodeDao.queryAllElec(id);
	}

	@Override
	public List<NameOfElec> queryNameOfAllElec(String id) {
		// TODO Auto-generated method stub
		return treeNodeDao.queryNameOfAllElec(id);
	}
}
