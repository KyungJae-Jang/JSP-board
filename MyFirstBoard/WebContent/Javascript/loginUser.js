function validateForm() {
	const inputUser = document.formLogin.userid.value;
	const inputPwd = document.formLogin.pwd.value;

	if (inputUser === "") {
		alert("User ID must be filled out");
		return false;
	}
	if (inputPwd === "") {
		alert("Password must be filled out");
		return false;
	}

	return true;
}
