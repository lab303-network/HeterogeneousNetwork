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
	 * �յ�ǰ�˴��ص�ajax���󣬲������������ݵ�json����
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");
		request.setCharacterEncoding("utf-8");
        //response.setContentType("text/html;charset=utf-8");
		
        System.out.println("=====getalldata����======");
        String name = request.getParameter("name");
        System.out.println(name);
        
        // ��ȡlora������� ����1��
        List<LoRa_Station> lora_list = new LoRa_Dao().getLoRaData();
        Map<String, List> map = new HashMap();
        map.put("lora", lora_list);
        
        // ��ȡzige������ݣ�ÿ���ն�1��������        
        ArrayList<ArrayList<Sensor_Data>> sensor_data = new Sensor_Dao().getSensorData();
        ArrayList<ArrayList<String>> topo_data = new Sensor_Dao().getTopo();
        map.put("zigbee", sensor_data);
        map.put("zigbeeTopo", topo_data);
        
        // ��ȡRfid���ݣ����û���򷵻ؿ�
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
