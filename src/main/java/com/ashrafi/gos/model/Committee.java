package com.ashrafi.gos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Committee implements Serializable{

	private Long code;
	private String name;
	private List<Committee> children;
	private Long pcode;
	
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getPcode() {
		return pcode;
	}
	public void setPCode(Long pCode) {
		this.pcode = pCode;
	}
	public List<Committee> getChildren() {
		return children == null ? new ArrayList(0) : children;
	}
	public void setChildren(List<Committee> children) {
		this.children = children;
	}
	@Override
    public String toString() {
        return (getPcode() != null ? getPcode() : "0")+ " : " + getCode() + "," + getName();
    }
	
}
