<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.individual.db.UserVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Css/main.css" />
<title>Main</title>
</head>
<body>
	<div class="header">
		<a href="mem.do?command=main">Main</a> 
		<a href="mem.do?command=getBoardList">Board</a> 
		<a href="mem.do?command=getUser">UserInfo</a> 
		<a href="mem.do?command=logoutUser">Logout</a>
	</div>
	<div class="main">
		<%
			if (session.getAttribute("loginUser") != null) {
				UserVO uVo = (UserVO) session.getAttribute("loginUser");
				out.print("<div style='color: #289cef; text-align:center; font-size:50px; margin-top: 30px'>");
				out.print("Hi " + uVo.getUserId() + "<br><br>");
				out.print("Welcome to Board List !");
				out.print("</div>");
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/loginUser.jsp");
				dispatcher.forward(request, response);
			}
		%>
	</div>
</body>
</html>