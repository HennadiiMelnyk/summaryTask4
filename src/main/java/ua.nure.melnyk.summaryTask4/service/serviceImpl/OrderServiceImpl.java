package ua.nure.melnyk.summaryTask4.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.melnyk.summaryTask4.dao.entitydao.OrderDao;
import ua.nure.melnyk.summaryTask4.model.Order;
import ua.nure.melnyk.summaryTask4.model.User;
import ua.nure.melnyk.summaryTask4.repository.Cart;
import ua.nure.melnyk.summaryTask4.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.BigInteger;

public class OrderServiceImpl implements OrderService {

    private static final Logger logger
            = LoggerFactory.getLogger(OrderServiceImpl.class);

    private OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public boolean createOrder(HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        String totalPrice = (String) request.getSession().getAttribute("totalPrice");
        User user = (User) request.getSession().getAttribute("user");
        Order order = new Order();
        StringBuilder sb = new StringBuilder();
        cart.getCart().forEach((key, value) -> {
            sb.append(key.getName() + " " + key.getPrice() + " " + value);
            sb.append(System.lineSeparator());
        });
        sb.append("totalPrice : " + totalPrice);
        order.setDetails(sb.toString());
        order.setId(1);
        order.setStatus("registered");
        order.setUserId(user.getId());
        return orderDao.create(order);
    }
}
