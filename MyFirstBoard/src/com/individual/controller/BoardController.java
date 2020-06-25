package com.individual.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.individual.model.Action;
import com.individual.model.ActionFactory;

@WebServlet("/mem.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public void init(ServletConfig config) throws ServletException {
	
	}

	public void destroy() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private  void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		System.out.println("받은 요청 : " + request.getParameter("command"));
		String command = request.getParameter("command");
		
		ActionFactory acf = ActionFactory.getInstance();
		Action ac = acf.getAction(command);
		
		if(ac != null) {
			ac.excute(request, response);
		}
	}
}
