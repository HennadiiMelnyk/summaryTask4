package ua.nure.melnyk.summaryTask4.util;

import ua.nure.melnyk.summaryTask4.model.Role;
import ua.nure.melnyk.summaryTask4.model.User;
import javax.servlet.http.HttpServletRequest;

/**
 * Utils Class for Command package
 */
public final class CommandUtil {

	private CommandUtil() {
		//nop
	}

	/**
	 * Extract user from registration post request
	 * @param request
	 * @return
	 */
	public static User extractUserFromRequest(HttpServletRequest request) {
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setSurname(request.getParameter("surname"));
		user.setBlock(false);
		user.setRole(Role.USER);
		return user;
	}
}
