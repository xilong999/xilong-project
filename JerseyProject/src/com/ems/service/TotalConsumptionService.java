package com.ems.service;

import com.ems.entity.LastOneDayList;
import com.ems.entity.NowData;

public interface TotalConsumptionService {
	public NowData getNowdata(String type);
	public LastOneDayList getElectricity(String type);
}
