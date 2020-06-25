<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Css/signupUser.css">
<script type="text/javascript" src="Javascript/signupUser.js"></script>
<title>Sign Up</title>
</head>
<body>
	<div class="container">
		<div class="signup-box">
			<div class="signup-text">
				<span>Create an account</span>
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
							placeholder="Enter User ID (Maximum Length 15)" />
					</div>
					<div class="password">
						<input class="input" name="pwd" type="password"
							placeholder="Enter Password (Maximum Length 15)" />
					</div>
					<div class="username">
						<input class="input" name="username" type="text"
							placeholder="Enter User Name (Maximum Length 45)" />
					</div>
					<div class="mobile">
						<input class="input" name="mobile" type="text"
							placeholder="Enter Mobile (Maximum Length 45)" />
					</div>
					<div class="email">
						<input class="input" name="email" type="text"
							placeholder="Enter Email (Maximum Length 45)" />
					</div>
					<div class="signup-btn btn">
						<input class="input-signup" type="submit" value="Sign Up"
							onclick="return validateForm()" /> <input name="command"
							type="hidden" value="signupUser" />
					</div>
					<div class="already-signup">
						<span>Already have an account?</span> 
						<a href="loginUser.jsp"><span>Log in</span></a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>