package com.individual.model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.individual.db.BoardDAO;
import com.individual.db.BoardVO;
import com.individual.db.UserVO;

public class WriteBoardAction implements Action {

	private BoardDAO dao;
	private BoardVO bVo;
	private UserVO uVo;

	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/writeBoard.jsp";
		int result = 0;

		dao = BoardDAO.getInstance();
		bVo = new BoardVO();
		HttpSession session = request.getSession();
		uVo = (UserVO) session.getAttribute("loginUser");

		bVo.setUserId(uVo.getUserId());
		bVo.setPwd(request.getParameter("pwd"));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContents(request.getParameter("contents"));

		result = dao.setBoard(bVo);
		if (result != 1) {
			request.setAttribute("message", "Write fail");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
