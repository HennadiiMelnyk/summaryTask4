package ua.nure.melnyk.summaryTask4.controller.command.orderscommand;

import ua.nure.melnyk.summaryTask4.constants.Path;
import ua.nure.melnyk.summaryTask4.controller.command.Command;
import ua.nure.melnyk.summaryTask4.repository.Cart;
import ua.nure.melnyk.summaryTask4.util.CartUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

/**
 * ShowCart Command
 */
public class ShowCartCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            request.getSession().setAttribute("totalPrice", CartUtils.extractTotalPrice(cart));
        }
        return Path.CART_PAGE;
    }
}
