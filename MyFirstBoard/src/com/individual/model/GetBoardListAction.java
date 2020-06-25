package com.individual.model;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.individual.db.BoardDAO;
import com.individual.db.BoardVO;

public class GetBoardListAction implements Action {

	private BoardDAO dao;
	private ArrayList<BoardVO> list;

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/showBoardList.jsp";

		dao = BoardDAO.getInstance();
		list = dao.getBoardList();

		request.setAttribute("boardList", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
