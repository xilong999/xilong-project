package com.ems.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.QueryBeforeDao;
import com.ems.entity.AllElec;
import com.ems.entity.AllElecList;
import com.ems.service.QueryBeforeService;
@Service("queryBeforeService")
public class QueryBeforeServiceImpl implements QueryBeforeService {
	@Autowired
	QueryBeforeDao queryBeforeDao;
	@Override
	public List<AllElec> queryBeforeEnergyType(String id, String name) {
		// TODO Auto-generated method stub
		return queryBeforeDao.queryBeforeEnergyType(id, name);
	}
	@Override
	public List<AllElecList> queryBeforeAllElec(String id) {
		// TODO Auto-generated method stub
		return queryBeforeDao.queryBeforeAllElec(id);
	}
	@Override
	public AllElecList queryBeforeOneElec(String id, String name) {
		// TODO Auto-generated method stub
		return queryBeforeDao.queryBeforeOneElec(id, name);
	}
	@Override
	public List<AllElecList> queryBeforeAllElecs(String id) {
		// TODO Auto-generated method stub
		return queryBeforeDao.queryBeforeAllElecs(id);
	}
}
