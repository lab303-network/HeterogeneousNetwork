package com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tool.SerialListener;
import com.tool.SocketListener;

/**
 * Servlet implementation class main
 */
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public main() {
		super();
		//开启串口监听线程，监听Lora数据
		new Thread(new Runnable() {			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new SerialListener();
			}
		}).start();

		//开启TCP监听线程，监听ZigBee数据
		new Thread(new Runnable() {			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new SocketListener().readSocket();
			}
		}).start();
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/main.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
