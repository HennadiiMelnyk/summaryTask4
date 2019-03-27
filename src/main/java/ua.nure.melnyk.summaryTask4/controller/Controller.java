package ua.nure.melnyk.summaryTask4.controller;

import ua.nure.melnyk.summaryTask4.constants.CommandsConstants;
import ua.nure.melnyk.summaryTask4.constants.Path;
import ua.nure.melnyk.summaryTask4.controller.command.Command;
import ua.nure.melnyk.summaryTask4.controller.command.CommandContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

/**
 * Controller
 */
@WebServlet(value = "/controller")
public class Controller extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
            process(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
            process(request, response);
    }

    /**
     * Main method of this controller.
     */
    private void process(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {

        String forward;
        String commandName = request.getParameter("command");
        if (commandName != null) {
            Command command = CommandContainer.get(commandName, request.getServletContext());
            forward = "error";
            try {
                forward = command.execute(request, response);
            } catch (Exception ex) {
                request.setAttribute("errorMessage", ex.getMessage());
            }
        } else {
            forward = Path.INDEX_PAGE;
        }
        if (forward.equals(Path.INDEX_PAGE) && request.getAttribute("productList") == null) {
            CommandContainer.get(CommandsConstants.FIND_ALL_PRODUCTS, request.getServletContext()).execute(request, response);
        }
        request.getRequestDispatcher(forward).forward(request, response);
    }
}

