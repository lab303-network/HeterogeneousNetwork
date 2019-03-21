package com.bean;

public class Sensor_Data {
	private int id;
	private String sensor_id;
	private String data;
	private String time;
	public Sensor_Data(String sensor_id, String data, String time) {
		super();
		this.sensor_id = sensor_id;
		this.data = data;
		this.time = time;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
