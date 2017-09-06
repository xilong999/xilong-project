package com.ems.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.BasicDeviceDao;
import com.ems.entity.BasicDevice;
import com.ems.service.BasicDeviceService;


@Service("basicDeviceService")
public class BasicDeviceServiceImpl implements BasicDeviceService {
	
	@Autowired
	BasicDeviceDao basicDeviceDao;
	
	@Override
	public List<BasicDevice> getMutilTag(String deviceId) {
		return basicDeviceDao.getMutilTag(deviceId);
	}
}
