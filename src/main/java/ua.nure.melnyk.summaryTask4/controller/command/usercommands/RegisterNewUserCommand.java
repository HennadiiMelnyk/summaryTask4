package ua.nure.melnyk.summaryTask4.controller.command.usercommands;

import ua.nure.melnyk.summaryTask4.constants.Path;
import ua.nure.melnyk.summaryTask4.controller.command.Command;
import ua.nure.melnyk.summaryTask4.model.User;
import ua.nure.melnyk.summaryTask4.service.UserService;
import ua.nure.melnyk.summaryTask4.util.CommandUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Register New User Command
 */
public class RegisterNewUserCommand implements Command {

	private UserService userService;

	public RegisterNewUserCommand(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		User user = CommandUtil.extractUserFromRequest(request);
		return userService.registerUser(user, request) ? Path.INDEX_PAGE : Path.REGISTRATION_PAGE;
	}
}
