package ua.nure.melnyk.summaryTask4.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Main Command class
 */
public interface Command {
    /**
     * Main method for execute  request according to Pattern Command
     * @param request
     * @param response
     * @return
     */
    String execute(HttpServletRequest request, HttpServletResponse response);
}
