package com.ems.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class NowDataList {
    private List<NowData> list;

    public NowDataList() {
        super();
    }

    public NowDataList(List<NowData> list) {
        this.list = list;
    }

    public List<NowData> getList() {
        return list;
    }

    public void setList(List<NowData> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "NowDataList{" +
                "list=" + list +
                '}';
    }
}
