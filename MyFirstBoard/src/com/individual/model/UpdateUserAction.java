package com.individual.model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.individual.db.BoardDAO;
import com.individual.db.UserVO;

public class UpdateUserAction implements Action {

	private BoardDAO dao;
	private UserVO uVo;

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int result = 0;
		String url = "/updateUser.jsp";

		dao = BoardDAO.getInstance();
		uVo = new UserVO();

		uVo.setUserId(request.getParameter("userid"));
		uVo.setPwd(request.getParameter("pwd"));
		uVo.setUserName(request.getParameter("username"));
		uVo.setMobile(request.getParameter("mobile"));
		uVo.setEmail(request.getParameter("email"));

		result = dao.updateMember(uVo);

		if (result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", uVo);
			url = "/main.jsp";
		} else {
			request.setAttribute("message", "Update fail");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}
