package ua.nure.melnyk.summaryTask4.controller.command.orderscommand;

import ua.nure.melnyk.summaryTask4.controller.command.Command;
import ua.nure.melnyk.summaryTask4.repository.Cart;
import ua.nure.melnyk.summaryTask4.util.CartUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class RemoveElementFromCartByIdCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            cart.removeFromCartById(id);
            request.getSession().setAttribute("cart", cart);
            request.getSession().setAttribute("totalPrice", CartUtils.extractTotalPrice(cart));
        }
        return null;
    }
}
