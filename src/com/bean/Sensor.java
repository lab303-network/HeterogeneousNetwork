package com.bean;

import java.util.List;

public class Sensor {
	private int id;
	private String sensor_id;
	private String sensor_addr;
	private String father_addr;
	private double x;
	private double y;
	private int isLeave;
	public Sensor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sensor(int id, String sensor_id, String sensor_addr, String father_addr) {
		super();
		this.id = id;
		this.sensor_id = sensor_id;
		this.sensor_addr = sensor_addr;
		this.father_addr = father_addr;
	}
	public Sensor(String sensor_id, String sensor_addr, String father_addr) {
		super();
		this.sensor_id = sensor_id;
		this.sensor_addr = sensor_addr;
		this.father_addr = father_addr;
	}
	public Sensor(String sensor_id, String sensor_addr, String father_addr, double x, double y, int isLeave) {
		super();
		this.sensor_id = sensor_id;
		this.sensor_addr = sensor_addr;
		this.father_addr = father_addr;
		this.x = x;
		this.y = y;
		this.isLeave = isLeave;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSensor_id() {
		return sensor_id;
	}
	public void setSensor_id(String sensor_id) {
		this.sensor_id = sensor_id;
	}
	public String getSensor_addr() {
		return sensor_addr;
	}
	public void setSensor_addr(String sensor_addr) {
		this.sensor_addr = sensor_addr;
	}
	public String getFather_addr() {
		return father_addr;
	}
	public void setFather_addr(String father_addr) {
		this.father_addr = father_addr;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public int getIsLeave() {
		return isLeave;
	}
	public void setIsLeave(int isLeave) {
		this.isLeave = isLeave;
	}
}
