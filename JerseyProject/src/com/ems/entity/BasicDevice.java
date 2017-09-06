package com.ems.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BasicDevice {
	private String tagId;
	private String deviceId;
	private String deviceName;
	private String devicePropertie;
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
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDevicePropertie() {
		return devicePropertie;
	}
	public void setDevicePropertie(String devicePropertie) {
		this.devicePropertie = devicePropertie;
	}
	
	@Override
	public String toString() {
		return "BasicDevice [tagId=" + tagId + ", deviceId=" + deviceId + ", deviceName=" + deviceName
				+ ", devicePropertie=" + devicePropertie + "]";
	}
}
