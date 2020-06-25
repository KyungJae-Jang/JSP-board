<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Css/loginUser.css">
<script type="text/javascript" src="Javascript/loginUser.js"></script>
<title>Login</title>
</head>
<body>
	<div class="container">
		<div class="login-overlay"></div>
		<div class="login-box">
			<div class="login-text">
				<span>Login</span>
			</div>
			<div class="login-form">
				<form class="formLogin" name="formLogin" method="post"
					action="mem.do">
					<div class="userid">
						<input class="input-user" name="userid" type="text"
							placeholder="Enter Username" />
					</div>
					<div class="password">
						<input class="input-pwd" name="pwd" type="password"
							placeholder="Enter Password" />
					</div>
					<div class="login-btn btn">
						<input class="input-login" type="submit" value="Login"
							onclick="return validateForm()" /> <input name="command"
							type="hidden" value="loginUser" />
					</div>
				</form>
				<div class="signup-btn btn">
					<a href="signupUser.jsp">
					<button class="input-signup" type="button">Sign Up</button> 
					</a>
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
			</div>
		</div>
	</div>
</body>
</html>