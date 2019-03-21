package com.bean;

import java.util.List;

public class LoRa_Terminal {
	private int id;
	private int stationId;
	private List<LoRa_Data> datas;
	public LoRa_Terminal(int stationId, List<LoRa_Data> datas) {
		super();
		this.stationId = stationId;
		this.datas = datas;
	}
	public LoRa_Terminal(int id, int stationId, List<LoRa_Data> datas) {
		super();
		this.id = id;
		this.stationId = stationId;
		this.datas = datas;
	}
	
	public LoRa_Terminal() {
	}
	public LoRa_Terminal(int id, int stationId) {
		super();
		this.id = id;
		this.stationId = stationId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	public List<LoRa_Data> getDatas() {
		return datas;
	}
	public void setDatas(List<LoRa_Data> datas) {
		this.datas = datas;
	}
	

}
