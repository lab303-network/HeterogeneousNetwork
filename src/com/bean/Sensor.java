package com.bean;

import java.util.List;

public class Sensor {
	private int id;
	private String type;
	private String name;
	private String sensor_id;
	private String father_id;
	private List<Sensor> list;
	public Sensor(String type, String name, String sensor_id, String father_id) {
		super();
		this.type = type;
		this.name = name;
		this.sensor_id = sensor_id;
		this.father_id = father_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSensor_id() {
		return sensor_id;
	}
	public void setSensor_id(String sensor_id) {
		this.sensor_id = sensor_id;
	}
	public String getFather_id() {
		return father_id;
	}
	public void setFather_id(String father_id) {
		this.father_id = father_id;
	}
	public List<Sensor> getList() {
		return list;
	}
	public void setList(List<Sensor> list) {
		this.list = list;
	}
	
}
