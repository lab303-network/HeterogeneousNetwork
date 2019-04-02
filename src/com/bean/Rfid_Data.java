package com.bean;

public class Rfid_Data {
	private int id;
	private String rfid_id;
	private int station_id;
	private int isLeft;
	private String time;
	private Rfid_Station station;
	public Rfid_Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rfid_Data(String rfid_id, int station_id, String time) {
		super();
		this.rfid_id = rfid_id;
		this.station_id = station_id;
		this.time = time;
	}
	public Rfid_Station getStation() {
		return station;
	}
	public void setStation(Rfid_Station station) {
		this.station = station;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRfid_id() {
		return rfid_id;
	}
	public void setRfid_id(String rfid_id) {
		this.rfid_id = rfid_id;
	}
	public int getStation_id() {
		return station_id;
	}
	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}
	public int getIsLeft() {
		return isLeft;
	}
	public void setIsLeft(int isLeft) {
		this.isLeft = isLeft;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
