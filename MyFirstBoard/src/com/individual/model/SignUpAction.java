package com.individual.model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.individual.db.BoardDAO;
import com.individual.db.UserVO;

public class SignUpAction implements Action{
	
	private BoardDAO dao;
	private UserVO uVo;

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int result = 0;
		String url = "/signupUser.jsp";
		
		dao = BoardDAO.getInstance();
		uVo = new UserVO();
		
		uVo.setUserId(request.getParameter("userid"));
		uVo.setPwd(request.getParameter("pwd"));
		uVo.setUserName(request.getParameter("username"));
		uVo.setMobile(request.getParameter("mobile"));
		uVo.setEmail(request.getParameter("email"));
		
		result = dao.addMember(uVo);
		
		if(result == 1) {
			request.setAttribute("message", "Please log in");
			url = "/loginUser.jsp";
		} else {
			request.setAttribute("message", "ID already registered");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
