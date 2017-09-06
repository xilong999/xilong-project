package com.ems.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AllElec implements Serializable{
	private static final long serialVersionUID = 6920976535667625157L;
	private String typeOfElec;
	private String value;
	public String getTypeOfElec() {
		return typeOfElec;
	}
	public void setTypeOfElec(String typeOfElec) {
		this.typeOfElec = typeOfElec;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public AllElec(String typeOfElec, String value) {
		super();
		this.typeOfElec = typeOfElec;
		this.value = value;
	}
	public AllElec() {
		super();
	}
	@Override
	public String toString() {
		return "AllElec [typeOfElec=" + typeOfElec + ", value=" + value + "]";
	}
}
