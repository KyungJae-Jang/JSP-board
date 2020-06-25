package com.individual.model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.individual.db.BoardDAO;
import com.individual.db.UserVO;

public class LoginAction implements Action {

	private BoardDAO dao;
	private UserVO uVo;

	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String url = "/loginUser.jsp";
		int result;
		
		dao = BoardDAO.getInstance();

		result = dao.userCheck(userid, pwd);

		if (result == 1) {
			uVo = dao.getMember(request.getParameter("userid"));
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", uVo);
			url = "/main.jsp";

		} else if (result == 0) {
			request.setAttribute("message", "Password Incorrect");

		} else if (result == -1) {
			request.setAttribute("message", "User ID is not exist");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}
