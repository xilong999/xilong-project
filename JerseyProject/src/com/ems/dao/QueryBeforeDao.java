package com.ems.dao;

import java.util.List;

import com.ems.entity.AllElec;
import com.ems.entity.AllElecList;

public interface QueryBeforeDao {
	
	public List<AllElecList> queryBeforeAllElec(String id);
	public AllElecList queryBeforeOneElec(String id,String name);
	public List<AllElec> queryBeforeEnergyType(String id,String name);
	public List<AllElecList> queryBeforeAllElecs(String id) ;
}
