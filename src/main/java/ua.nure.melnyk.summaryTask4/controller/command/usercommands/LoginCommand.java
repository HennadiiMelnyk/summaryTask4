package ua.nure.melnyk.summaryTask4.controller.command.usercommands;

import ua.nure.melnyk.summaryTask4.constants.Path;
import ua.nure.melnyk.summaryTask4.controller.command.Command;
import ua.nure.melnyk.summaryTask4.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Login Command
 */
public class LoginCommand implements Command {

	private UserService userService;

	public LoginCommand(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		return userService.login(email, password, request) ? Path.INDEX_PAGE : Path.LOGIN_PAGE;
	}
}
