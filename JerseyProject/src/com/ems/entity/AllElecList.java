package com.ems.entity;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AllElecList implements Serializable{

	private static final long serialVersionUID = 3346758274163373215L;
	private List<AllElec> allElecs;

	public List<AllElec> getAllElecs() {
		return allElecs;
	}

	public void setAllElecs(List<AllElec> allElecs) {
		this.allElecs = allElecs;
	}

	public AllElecList(List<AllElec> allElecs) {
		super();
		this.allElecs = allElecs;
	}

	public AllElecList() {
		super();
	}

	@Override
	public String toString() {
		return "AllElecList [allElecs=" + allElecs + "]";
	}
}
