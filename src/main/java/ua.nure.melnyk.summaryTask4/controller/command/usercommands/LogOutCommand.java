package ua.nure.melnyk.summaryTask4.controller.command.usercommands;

import ua.nure.melnyk.summaryTask4.constants.Path;
import ua.nure.melnyk.summaryTask4.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Logout command
 */
public class LogOutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        return Path.INDEX_PAGE;
    }
}
