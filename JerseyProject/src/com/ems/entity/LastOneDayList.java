package com.ems.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class LastOneDayList {
    private List<LastOneDay> list;

    public LastOneDayList(List<LastOneDay> list) {
        this.list = list;
    }

    public List<LastOneDay> getList() {
        return list;
    }

    public void setList(List<LastOneDay> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "LastOneDayList{" +
                "list=" + list +
                '}';
    }

	public LastOneDayList() {
		super();
	}
}
