package com.bean;


public class LoRa_Data {
	private int id;
	private double snr;
	private double rssi;
	private String msg;
	private int stationid;
	private String time;
	// ��������������
	public LoRa_Data(double snr, double rssi) {
		super();
		this.snr = snr;
		this.rssi = rssi;
	}
	// ��ѯ��
	public LoRa_Data(int id, double snr, double rssi, String msg, String time, int stationid) {
		super();
		this.id = id;
		this.snr = snr;
		this.rssi = rssi;
		this.msg = msg;
		this.time = time;
		this.stationid = stationid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSnr() {
		return snr;
	}
	public void setSnr(double snr) {
		this.snr = snr;
	}
	public double getRssi() {
		return rssi;
	}
	public void setRssi(double rssi) {
		this.rssi = rssi;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getStationid() {
		return stationid;
	}
	public void setStationid(int stationid) {
		this.stationid = stationid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	

}
