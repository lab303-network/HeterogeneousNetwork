package com.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.LoRa_Data;
import com.dao.LoRa_Dao;

import net.sf.json.JSONArray;

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
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
		
        System.out.println("============");
        String name = request.getParameter("name");
        System.out.println(name);
        
        // 获取lora相关数据 最新五条
        List<LoRa_Data> lora_list = new LoRa_Dao().getLoRaData();
        Map<String, List> map = new HashMap();
        map.put("lora", lora_list);
		JSONArray lora_json = JSONArray.fromObject(map);
        System.out.println(lora_json);
        response.getWriter().write(lora_json.toString());
                
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
