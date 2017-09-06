package com.ems.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NowData {
    private String nowValue;

    public NowData(String nowValue) {
        this.nowValue = nowValue;
    }

    public String getNowValue() {
        return nowValue;
    }

    public void setNowValue(String nowValue) {
        this.nowValue = nowValue;
    }

    @Override
    public String toString() {
        return "NowData{" +
                "nowValue='" + nowValue + '\'' +
                '}';
    }

	public NowData() {
		super();
	}
}
