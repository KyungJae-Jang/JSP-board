function validateForm() {
	const inputTitle = document.formWrite.title.value;
	const inputContents = document.formWrite.contents.value;
	const inputPwd = document.formWrite.pwd.value;

	if (inputTitle === "") {
		alert("Title must be filled out");
		return false;
	}
	if (inputTitle.length > 40) {
		alert("Title is too long");
		return false;
	}
	if (inputContents === "") {
		alert("Contents must be filled out");
		return false;
	}
	if (inputContents.length > 1000) {
		alert("Contents is too long");
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

	return true;
}
