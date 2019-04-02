package com.bean;

public class Rfid_Station {
	private int id;
	private double x;
	private double y;
	
	public Rfid_Station() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rfid_Station(int id, double x, double y) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
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
	
}
