function validateForm() {
	const inputUserId = document.formSignup.userid.value;
	const inputPwd = document.formSignup.pwd.value;
	const inputUserName = document.formSignup.username.value;
	const inputMobile = document.formSignup.mobile.value;
	const inputEmail = document.formSignup.email.value;

	if (inputUserId === "") {
		alert("User ID must be filled out");
		return false;
	}
	if (inputUserId.length > 15) {
		alert("User ID is too long");
		return false;
	}
	if (inputPwd === "") {
		alert("Password must be filled out");
		return false;
	}
	if (inputPwd.length > 15) {
		alert("Password is too long");
		return false;
	}
	if (inputUserName === "") {
		alert("User Name must be filled out");
		return false;
	}
	if (inputUserName.length > 45) {
		alert("User Name is too long");
		return false;
	}
	if (inputMobile === "") {
		alert("Mobile must be filled out");
		return false;
	}
	if (inputMobile.length > 45) {
		alert("Mobile is too long");
		return false;
	}
	if (inputEmail === "") {
		alert("Email must be filled out");
		return false;
	}
	if (inputEmail.length > 45) {
		alert("Email is too long");
		return false;
	}

	return true;
}
