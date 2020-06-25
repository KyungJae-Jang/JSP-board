package com.individual.model;

public class ActionFactory {

	private static ActionFactory acf = new ActionFactory();

	private ActionFactory() {

	}

	public static ActionFactory getInstance() {
		return acf;
	}

	public Action getAction(String command) {
		Action action = null;

		if (command.equals("loginUser")) {
			action = new LoginAction();
		} else if (command.equals("signupUser")) {
			action = new SignUpAction();
		} else if (command.equals("logoutUser")) {
			action = new LogoutAction();
		} else if (command.equals("getUser")) {
			action = new GetUserAction();
		} else if (command.equals("updateUser")) {
			action = new UpdateUserAction();
		} else if (command.equals("main")) {
			action = new MainAction();
		} else if (command.equals("getBoardList")) {
			action = new GetBoardListAction();
		} else if (command.equals("writeBoard")) {
			action = new WriteBoardAction();
		} else if (command.equals("writeform")) {
			action = new WriteFormAction();
		} else if (command.equals("showBoard")) {
			action = new ShowBoardAction();
		} else if (command.equals("updateBoard")) {
			action = new UpdateBoardAction();
		} else if (command.equals("deleteBoard")) {
			action = new DeleteBoardAction();
		} else if (command.equals("getBoard")) {
			action = new GetBoardAction();
		}

		return action;
	}

}
