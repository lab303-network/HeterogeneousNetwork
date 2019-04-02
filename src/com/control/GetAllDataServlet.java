package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.LoRa_Data;
import com.bean.LoRa_Station;
import com.bean.Sensor_Data;
import com.dao.LoRa_Dao;
import com.dao.Rfid_Dao;
import com.dao.Sensor_Dao;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetAllDataServlet
 */
public class GetAllDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 收到前端传回的ajax请求，并返回所有数据的json数组
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");
		request.setCharacterEncoding("utf-8");
        //response.setContentType("text/html;charset=utf-8");
		
        System.out.println("=====getalldata请求======");
        String name = request.getParameter("name");
        System.out.println(name);
        
        // 获取lora相关数据 最新1条
        List<LoRa_Station> lora_list = new LoRa_Dao().getLoRaData();
        Map<String, List> map = new HashMap();
        map.put("lora", lora_list);
        
        // 获取zige相关数据，每个终端1最新数据        
        ArrayList<ArrayList<Sensor_Data>> sensor_data = new Sensor_Dao().getSensorData();
        ArrayList<ArrayList<String>> topo_data = new Sensor_Dao().getTopo();
        map.put("zigbee", sensor_data);
        map.put("zigbeeTopo", topo_data);
        
        // 获取Rfid数据，如果没有则返回空
        List<String> rfid_data = new Rfid_Dao().listRfid();
        map.put("rfid", rfid_data);
        
        JSONObject jsonO = JSONObject.fromObject(map);
		//JSONArray lora_json = JSONArray.fromObject(map);
		
		//System.out.println(jsonO);
		PrintWriter writer = response.getWriter(); 
		writer.write(jsonO.toString());
		writer.close(); 
		response.flushBuffer();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
