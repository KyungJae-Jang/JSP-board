package com.individual.model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.individual.db.BoardDAO;
import com.individual.db.BoardVO;

public class UpdateBoardAction implements Action {

	private BoardDAO dao;
	private BoardVO bVo;

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/main.jsp";
		int result = 0;

		dao = BoardDAO.getInstance();
		bVo = new BoardVO();

		bVo.setNum(Integer.parseInt(request.getParameter("num")));
		bVo.setPwd(request.getParameter("pwd"));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContents(request.getParameter("contents"));

		result = dao.updateBoard(bVo);
		if (result != 1) {
			request.setAttribute("message", "Update fail");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
