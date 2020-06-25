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
<link rel="stylesheet" href="Css/showBoard.css" />
<script type="text/javascript" src="Javascript/checkPwd.js"></script>
<title>Board Read</title>
</head>
<body>
	<div class="header">
		<a href="mem.do?command=main">Main</a> 
		<a href="mem.do?command=getBoardList">Board</a> 
		<a href="mem.do?command=getUser">UserInfo</a> 
		<a href="mem.do?command=logoutUser">Logout</a>
	</div>
	<div class="titles">
		<div class="title">Board Details</div>
	</div>
	<div class="main-board">
		<table class="board">
			<tr class="board-lists">
				<td class="board-header">Title</td>
				<td class="board-header">
					<%
						out.print(bVo.getTitle());
					%>
				</td>
			</tr>
			<tr class="board-lists">
				<td class="board-list">Writer</td>
				<td class="board-list">
					<%
						out.print(bVo.getUserId());
					%>
				</td>
			</tr>
			<tr class="board-lists">
				<td class="board-list">Time</td>
				<td class="board-list">
					<%
						out.print(bVo.getWritedate());
					%>
				</td>
			</tr>
			<tr class="board-lists">
				<td class="board-list">Contents</td>
				<td class="board-list">
					<%
						out.print(bVo.getContents());
					%>
				</td>
			</tr>
		</table>
	</div>
	<div class="footer">
		<div class="footer-menu"
			onclick="return validateForm(<%=bVo.getPwd()%>)">
			<a href="mem.do?command=getBoard&num=<%=bVo.getNum()%>">Update</a>
		</div>
		<div class="footer-menu"
			onclick="return validateForm(<%=bVo.getPwd()%>)">
			<a href="mem.do?command=deleteBoard&num=<%=bVo.getNum()%>">Delete</a>
		</div>
	</div>
</body>
</html>