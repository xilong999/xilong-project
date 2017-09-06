package com.ems.service;

import java.util.List;

import com.ems.entity.BasicDevice;

public interface BasicDeviceService {
	
	public List<BasicDevice> getMutilTag(String deviceId);
}
