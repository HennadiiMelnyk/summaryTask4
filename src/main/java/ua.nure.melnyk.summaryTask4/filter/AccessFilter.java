package ua.nure.melnyk.summaryTask4.filter;

import ua.nure.melnyk.summaryTask4.constants.Path;
import ua.nure.melnyk.summaryTask4.model.Role;
import ua.nure.melnyk.summaryTask4.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 *
 */
@WebFilter(value = "/*")
public class AccessFilter implements Filter {

    private Map<Role, String> accessMap;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        accessMap = (Map<Role, String>) filterConfig.getServletContext().getAttribute("accessMap");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String command = request.getParameter("command");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (command != null && !"logout".equals(command) && user != null) {
            if (accessMap.get(user.getRole()).contains(command) && !user.getIsBlock()) {
                chain.doFilter(request, response);
            } else {
                request.getRequestDispatcher(Path.ERROR_PAGE).forward(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
