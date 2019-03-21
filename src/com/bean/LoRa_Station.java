package com.bean;

import java.util.List;

public class LoRa_Station {
	private int id;
	private double x;
	private double y; // 基站的坐标
	private List<LoRa_Data> datas; //对应终端的数据
	public LoRa_Station(double x, double y, List<LoRa_Data> datas) {
		super();
		this.x = x;
		this.y = y;
		this.datas = datas;
	}
	public LoRa_Station(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	public LoRa_Station(int id, double x, double y) {
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
	public List<LoRa_Data> getDatas() {
		return datas;
	}
	public void setDatas(List<LoRa_Data> datas) {
		this.datas = datas;
	}

	
	
}
