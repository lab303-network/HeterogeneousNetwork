package com.bean;

import java.util.List;

public class LoRa_Station {
	private int id;
	private double x;
	private double y; // »ùÕ¾µÄ×ø±ê
	private List<LoRa_Terminal> terminals;
	public LoRa_Station(double x, double y, List<LoRa_Terminal> terminals) {
		super();
		this.x = x;
		this.y = y;
		this.terminals = terminals;
	}
	public LoRa_Station(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}	
	public LoRa_Station() {
	}
	public LoRa_Station(int id, double x, double y, List<LoRa_Terminal> terminals) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		this.terminals = terminals;
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
	public List<LoRa_Terminal> getTerminals() {
		return terminals;
	}
	public void setTerminals(List<LoRa_Terminal> terminals) {
		this.terminals = terminals;
	}


	
	
}
