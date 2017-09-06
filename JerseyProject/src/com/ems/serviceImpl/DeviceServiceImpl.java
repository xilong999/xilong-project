package com.ems.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.DeviceDao;

import com.ems.entity.Device;

import com.ems.service.DeviceService;


@Service("deviceService")
public class DeviceServiceImpl implements DeviceService {
    
	@Autowired
	private DeviceDao deviceDao;

	public Device get(String id) {
		return deviceDao.get(id);
	}
}
