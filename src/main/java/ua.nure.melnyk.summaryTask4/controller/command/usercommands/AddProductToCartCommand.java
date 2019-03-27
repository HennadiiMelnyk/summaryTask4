package ua.nure.melnyk.summaryTask4.controller.command.usercommands;

import ua.nure.melnyk.summaryTask4.controller.command.Command;
import ua.nure.melnyk.summaryTask4.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Add Product to Cart Command
 */
public class AddProductToCartCommand implements Command {

    private UserService userService;

    public AddProductToCartCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int productId = Integer.valueOf(request.getParameter("id"));
        if (userService.addProductToCart(productId, request)) {
            return "success";
        }
        return "failure";
    }
}
