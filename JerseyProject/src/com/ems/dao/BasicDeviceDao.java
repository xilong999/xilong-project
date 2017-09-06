package com.ems.dao;

import java.util.List;

import com.ems.entity.BasicDevice;

public interface BasicDeviceDao {
	
	public List<BasicDevice> getMutilTag(String deviceId);
}
