package com.bean;

public class Sensor_Data {
	private int id;
	private String sensor_id;
	private String data;
	private String time;
	private String rssi;
	private Sensor sensor;
	public Sensor_Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sensor_Data(int id, String sensor_id, String data, String time, String rssi, Sensor sensor) {
		super();
		this.id = id;
		this.sensor_id = sensor_id;
		this.data = data;
		this.time = time;
		this.rssi = rssi;
		this.sensor = sensor;
	}
	public Sensor_Data(String sensor_id, String data, String time, String rssi, Sensor sensor) {
		super();
		this.sensor_id = sensor_id;
		this.data = data;
		this.time = time;
		this.rssi = rssi;
		this.sensor = sensor;
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Sensor getSensor() {
		return sensor;
	}
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	public String getRssi() {
		return rssi;
	}
	public void setRssi(String rssi) {
		this.rssi = rssi;
	}
	
	
}
