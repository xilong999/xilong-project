package com.ems.daoImpl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import com.ems.dao.DeviceDao;
import com.ems.entity.Device;

@Repository("deviceDao")
public class DeviceDaoImpl implements DeviceDao {

	@Autowired
	private RedisTemplate<Serializable, Object> redisTemplate;

	@Resource
	public void setRedisTemplate(RedisTemplate<Serializable, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	/**
	 * 根据key读取一个value
	 * 
	 * @param key
	 * @return
	 */

	public Device get(final String tagId) {  
	    return redisTemplate.execute(new RedisCallback<Device>() {  
	        @Override  
	        public Device doInRedis(RedisConnection connection)  
	                throws DataAccessException {  
	            byte[] key = redisTemplate.getStringSerializer().serialize(  
	            		"nowData:"+tagId);  
	            if (connection.exists(key)) {  
	                List<byte[]> value = connection.hMGet(  
	                        key,  
	                        redisTemplate.getStringSerializer().serialize("deviceId"),  
	                        redisTemplate.getStringSerializer().serialize("devicePropertieName"), 
	                        redisTemplate.getStringSerializer().serialize("devicePropertieID"),
	                        redisTemplate.getStringSerializer().serialize("energyConsumptionType"),
	                        redisTemplate.getStringSerializer().serialize("energyConsumptionChildType"),  
	                        redisTemplate.getStringSerializer().serialize("devicePropertieValue"), 
	                        redisTemplate.getStringSerializer().serialize("devicePropertieUpdateTime")
	                        );  
	                Device device = new Device();  
	                String deviceId = redisTemplate.getStringSerializer()  
	                        .deserialize(value.get(0));  
	                device.setDeviceId(deviceId);  
	                String devicePropertieName = redisTemplate.getStringSerializer()  
	                        .deserialize(value.get(1));  
	                device.setDevicePropertieName(devicePropertieName); 
	                String propertieId = redisTemplate.getStringSerializer()  
	                        .deserialize(value.get(2));  
	                device.setDevicePropertieName(propertieId);
	                String energyConsumptionType = redisTemplate.getStringSerializer()  
	                        .deserialize(value.get(3));  
	                device.setEnergyConsumptionType(energyConsumptionType); 
	                String energyConsumptionChildType = redisTemplate.getStringSerializer()  
	                        .deserialize(value.get(4));  
	                device.setEnergyConsumptionChildType(energyConsumptionChildType);
	                String devicePropertieValue = redisTemplate.getStringSerializer()  
	                        .deserialize(value.get(5));  
	                device.setDevicePropertieValue(devicePropertieValue); 
	                String devicePropertieUpdateTime = redisTemplate.getStringSerializer()  
	                        .deserialize(value.get(6));  
	                device.setDevicePropertieUpdateTime(devicePropertieUpdateTime);
	                
	                device.setTagId(tagId);  
	  
	                return device;  
	            }  
	            return null;  
	        }  
	    });  
	} 
	
}