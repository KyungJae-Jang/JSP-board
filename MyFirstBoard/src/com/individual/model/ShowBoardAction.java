package com.individual.model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.individual.db.BoardDAO;
import com.individual.db.BoardVO;


public class ShowBoardAction implements Action {
	
	private BoardDAO dao;
	private BoardVO bVo;

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/showBoard.jsp";
		dao = BoardDAO.getInstance();
			
		bVo = dao.getBoard(Integer.parseInt(request.getParameter("num")));
		request.setAttribute("bVo", bVo);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
