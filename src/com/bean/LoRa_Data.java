package com.bean;


public class LoRa_Data {
	private int id;
	private double snr;
	private double rssi;
	private String msg;
	private int terminalId;
	private String time;
	// 解析串口数据用
	public LoRa_Data(double snr, double rssi) {
		super();
		this.snr = snr;
		this.rssi = rssi;
	}
	
	public LoRa_Data() {
	}

	// 查询用
	public LoRa_Data(int id, double snr, double rssi, String msg, String time, int terminalId) {
		super();
		this.id = id;
		this.snr = snr;
		this.rssi = rssi;
		this.msg = msg;
		this.time = time;
		this.terminalId = terminalId;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(int terminalId) {
		this.terminalId = terminalId;
	}
	

}
