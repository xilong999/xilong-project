package com.ems.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeviceStatistics implements Serializable {
	private static final long serialVersionUID = -3925900726110238256L;
	private String tagId;
	private String deviceId;
	private String devicePropertieName;
	private String devicePropertieID;
	private String energyConsumptionType;
	private String energyConsumptionChildType;
	private Map<String,String> devicePropertiesValue;
	private String devicePropertieUpdateTime;

	public DeviceStatistics() {
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDevicePropertieName() {
		return devicePropertieName;
	}

	public void setDevicePropertieName(String devicePropertieName) {
		this.devicePropertieName = devicePropertieName;
	}

	public String getDevicePropertieID() {
		return devicePropertieID;
	}

	public void setDevicePropertieID(String devicePropertieID) {
		this.devicePropertieID = devicePropertieID;
	}

	public String getEnergyConsumptionType() {
		return energyConsumptionType;
	}

	public void setEnergyConsumptionType(String energyConsumptionType) {
		this.energyConsumptionType = energyConsumptionType;
	}

	public String getEnergyConsumptionChildType() {
		return energyConsumptionChildType;
	}

	public void setEnergyConsumptionChildType(String energyConsumptionChildType) {
		this.energyConsumptionChildType = energyConsumptionChildType;
	}

	public DeviceStatistics(String tagId, String deviceId, String devicePropertieName, String devicePropertieID,
			String energyConsumptionType, String energyConsumptionChildType, Map<String,String> devicePropertiesValue,
			String devicePropertieUpdateTime) {
		super();
		this.tagId = tagId;
		this.deviceId = deviceId;
		this.devicePropertieName = devicePropertieName;
		this.devicePropertieID = devicePropertieID;
		this.energyConsumptionType = energyConsumptionType;
		this.energyConsumptionChildType = energyConsumptionChildType;
		this.devicePropertiesValue = devicePropertiesValue;
		this.devicePropertieUpdateTime = devicePropertieUpdateTime;
	}

	public Map<String,String> getDevicePropertiesValue() {
		return devicePropertiesValue;
	}

	public void setDevicePropertiesValue(Map<String,String> devicePropertiesValue) {
		this.devicePropertiesValue = devicePropertiesValue;
	}

	public String getDevicePropertieUpdateTime() {
		return devicePropertieUpdateTime;
	}

	public void setDevicePropertieUpdateTime(String devicePropertieUpdateTime) {
		this.devicePropertieUpdateTime = devicePropertieUpdateTime;
	}

	@Override
	public String toString() {
		return "DeviceStatistics [tagId=" + tagId + ", deviceId=" + deviceId + ", devicePropertieName="
				+ devicePropertieName + ", devicePropertieID=" + devicePropertieID + ", energyConsumptionType="
				+ energyConsumptionType + ", energyConsumptionChildType=" + energyConsumptionChildType
				+ ", devicePropertiesValue=" + devicePropertiesValue + ", devicePropertieUpdateTime="
				+ devicePropertieUpdateTime + "]";
	}

	
}