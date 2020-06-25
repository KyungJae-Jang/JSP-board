<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.individual.db.BoardVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="Css/showBoardList.css" />
<title>Board List</title>
</head>
<body>
	<div class="header">
		<a href="mem.do?command=main">Main</a> 
		<a href="mem.do?command=getBoardList">Board</a> 
		<a href="mem.do?command=getUser">UserInfo</a> 
		<a href="mem.do?command=logoutUser">Logout</a>
	</div>
	<div class="titles">
		<div class="title">Board List</div>
		<div class="write-btn">
			<a href="mem.do?command=writeform">Write</a>
		</div>
	</div>
	<div class="main-board">
		<table class="board">
			<tr class="board-headers">
				<th class="board-header">No.</th>
				<th class="board-header">Title</th>
				<th class="board-header">ID</th>
				<th class="board-header">Time</th>
			</tr>
			<%
				if (session.getAttribute("loginUser") == null) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/loginUser.jsp");
					dispatcher.forward(request, response);
				} else {
					ArrayList<BoardVO> list = (ArrayList) request.getAttribute("boardList");
					for (BoardVO bVo : list) {
			%>

			<tr class="board-lists">
				<td class="board-list">
					<%
						out.print(bVo.getNum());
					%>
				</td>
				<td class="board-list"><a
					href="mem.do?command=showBoard&num=<%= bVo.getNum() %>">
						<%
							out.print(bVo.getTitle());
						%>
				</a></td>
				<td class="board-list">
					<%
						out.print(bVo.getUserId());
					%>
				</td>
				<td class="board-list">
					<%
						out.print(bVo.getWritedate());
					%>
				</td>
			</tr>
			<%
				}
				}
			%>
		</table>
	</div>
</body>
</html>