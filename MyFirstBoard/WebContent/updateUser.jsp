<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.individual.db.UserVO"%>
<%
	if (session.getAttribute("loginUser") == null) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/loginUser.jsp");
		dispatcher.forward(request, response);
	}

	UserVO uVo = (UserVO) request.getAttribute("uVo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="Css/updateUser.css" />
<script type="text/javascript" src="Javascript/signupUser.js"></script>
<title>UserInfo</title>
</head>
<body>
	<div class="header">
		<a href="mem.do?command=main">Main</a> 
		<a href="mem.do?command=getBoardList">Board</a> 
		<a href="mem.do?command=getUser">UserInfo</a> 
		<a href="mem.do?command=logoutUser">Logout</a>
	</div>
	<div class="container">
		<div class="signup-box">
			<div class="signup-text">
				<span>Account Details</span>
			</div>
			<div>
				<%
					if (request.getAttribute("message") != null) {
						out.print("<div style='color:red; text-align:center;'>");
						out.print(request.getAttribute("message"));
						out.print("</div>");
					}
				%>
			</div>
			<div class="signup-form">
				<form class="formSignup" name="formSignup" method="post"
					action="mem.do">
					<div class="userid">
						<input class="input" name="userid" type="text"
							placeholder="Enter User ID (Maximum Length 15)"
							value="<%out.print(uVo.getUserId());%>" />
					</div>
					<div class="password">
						<input class="input" name="pwd" type="password"
							placeholder="Enter Password (Maximum Length 15)"
							value="<%out.print(uVo.getPwd());%>" />
					</div>
					<div class="username">
						<input class="input" name="username" type="text"
							placeholder="Enter User Name (Maximum Length 45"
							value="<%out.print(uVo.getUserName());%>" />
					</div>
					<div class="mobile">
						<input class="input" name="mobile" type="text"
							placeholder="Enter Mobile (Maximum Length 45"
							value="<%out.print(uVo.getMobile());%>" />
					</div>
					<div class="email">
						<input class="input" name="email" type="text"
							placeholder="Enter Email (Maximum Length 45)"
							value="<%out.print(uVo.getEmail());%>" />
					</div>
					<div class="signup-btn btn">
						<input class="input-signup" type="submit" value="Update"
							onclick="return validateForm()" /> <input name="command"
							type="hidden" value="updateUser" />
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>