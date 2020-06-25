<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.individual.db.BoardVO"%>
<%
	if (session.getAttribute("loginUser") == null) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/loginUser.jsp");
		dispatcher.forward(request, response);
	}
	BoardVO bVo = (BoardVO) request.getAttribute("bVo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Css/writeBoard.css" />
<script type="text/javascript" src="Javascript/writeBoard.js"></script>
<title>Board Write</title>
</head>
<body>
	<div class="header">
		<a href="mem.do?command=main">Main</a> 
		<a href="mem.do?command=getBoardList">Board</a> 
		<a href="mem.do?command=getUser">UserInfo</a> 
		<a href="mem.do?command=logoutUser">Logout</a>
	</div>
	<div class="titles">
		<div class="title">Board Update</div>
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
	<div class="form">
		<form class="formWrite" name="formWrite" method="post" action="mem.do">
			<div>
				<input type="text" id="title" class="input-title" name="title"
					placeholder="Title (Maximum Length 40)"
					value="<%=bVo.getTitle()%>" />
			</div>
			<div>
				<textarea id="contents" class="input-contents" name="contents"
					placeholder="Contents...(Maximum Length 1000)"><%=bVo.getContents()%></textarea>
			</div>
			<div>
				<input type="password" id="pwd" class="input-pwd" name="pwd"
					placeholder="Password (Maximum Length 15)" />
			</div>
			<div class="input-submit-div">
				<input class="input-submit" type="submit" value="Save"
					onclick="return validateForm()" /> 
				<input type="hidden"
					name="command" value="updateBoard">
				<input type="hidden"
					name="num" value="<%=bVo.getNum()%>">
			</div>
		</form>
	</div>
</body>
</html>
