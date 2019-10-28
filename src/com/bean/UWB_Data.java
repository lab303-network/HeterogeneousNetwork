package com.bean;

public class UWB_Data {
	private int id;
	private double x;
	private double y;
	private String time;
	public UWB_Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UWB_Data(double x, double y, String time) {
		super();
		this.x = x;
		this.y = y;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "UWB_Data [id=" + id + ", x=" + x + ", y=" + y + ", time=" + time + "]";
	}
	
}
