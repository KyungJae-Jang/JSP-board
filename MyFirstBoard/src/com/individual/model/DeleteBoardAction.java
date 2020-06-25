package com.individual.model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.individual.db.BoardDAO;

public class DeleteBoardAction implements Action {
	
	private BoardDAO dao;

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/main.jsp";
		dao = BoardDAO.getInstance();
			
		dao.deleteBoard(Integer.parseInt(request.getParameter("num")));
		System.out.println(request.getParameter("num"));

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
