package com.ems.dao;

import com.ems.entity.LastOneDayList;
import com.ems.entity.NowData;

public interface TotalConsumptionDao {
	
	public LastOneDayList getElectricity(String type);
	public NowData getNowdata(String type);
}
