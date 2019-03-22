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
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�������ڼ����̣߳�����Lora����
		new Thread(new Runnable() {			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new SerialListener();
			}
		}).start();
		
		//����TCP�����̣߳�����ZigBee����
		new Thread(new Runnable() {			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new SocketListener().readSocket();
			}
		}).start();
		request.getRequestDispatcher("/WEB-INF/main.html").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
