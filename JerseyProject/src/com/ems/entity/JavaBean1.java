package com.ems.entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
//@XmlType(propOrder = {"s"})
public class JavaBean1 {
    private String s;
    public JavaBean1(String s){
        this.s=s;
    }


    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
