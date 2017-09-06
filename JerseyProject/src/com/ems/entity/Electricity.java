package com.ems.entity;

public class Electricity {
    private String tagId;
    private String devicePropertieID;
    private String energyConsumptionType;


    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
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

    @Override
    public String toString() {
        return "Electricity{" +
                "tagId='" + tagId + '\'' +
                ", devicePropertieID='" + devicePropertieID + '\'' +
                ", energyConsumptionType='" + energyConsumptionType + '\'' +
                '}';
    }
}
