package com.ems.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LastOneDay{

    private String timeStart;
    private String value;

    public LastOneDay(String timeStart, String value) {
        this.timeStart = timeStart;
        this.value = value;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public String getValue() {
        return value;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public void setValue(String value) {
        this.value = value;
    }

    
    public LastOneDay() {
		super();
	}

	@Override
    public String toString() {
        return "LastOneDay{" +
                "timeStart='" + timeStart + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
