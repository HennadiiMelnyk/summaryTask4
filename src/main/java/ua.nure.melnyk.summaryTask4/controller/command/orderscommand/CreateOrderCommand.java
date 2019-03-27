package ua.nure.melnyk.summaryTask4.controller.command.orderscommand;

import ua.nure.melnyk.summaryTask4.constants.Path;
import ua.nure.melnyk.summaryTask4.controller.command.Command;
import ua.nure.melnyk.summaryTask4.model.User;
import ua.nure.melnyk.summaryTask4.repository.Cart;
import ua.nure.melnyk.summaryTask4.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CreateOrder command
 */
public class CreateOrderCommand implements Command {
    private OrderService orderService;

    public CreateOrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        if (orderService.createOrder(request)) {
            return Path.SUCCESS_PAGE;
        }
        return Path.ERROR_PAGE;
    }
}
