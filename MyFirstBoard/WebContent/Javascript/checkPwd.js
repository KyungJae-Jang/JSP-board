function validateForm(boardPwd) {

	const person = prompt("Please enter your password :");

	if (person == null || person != boardPwd) {
		alert("Password do not match");
		return false;
	} else {
		return true;
	}
}
