package ua.nure.melnyk.summaryTask4.service;

import javax.servlet.http.HttpServletRequest;

/**
 *Order Service
 */
public interface OrderService {
    /**
     * Create order include the list of products in Cart
     * @param request
     * @return
     */
    boolean createOrder(HttpServletRequest request);

}
