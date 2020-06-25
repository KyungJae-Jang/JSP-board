package com.individual.model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.individual.db.UserVO;

public class GetUserAction implements Action {

	private UserVO uVo;

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/updateUser.jsp";

		HttpSession session = request.getSession();
		uVo = (UserVO) session.getAttribute("loginUser");
		request.setAttribute("uVo", uVo);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
