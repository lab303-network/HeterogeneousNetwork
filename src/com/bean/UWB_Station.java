package com.bean;

public class UWB_Station {
	private String id;
	private double x;
	private double y;
	
	public UWB_Station() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UWB_Station(String id, double x, double y) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	
	
}
