package ua.nure.melnyk.summaryTask4;

import ua.nure.melnyk.summaryTask4.constants.CommandsConstants;
import ua.nure.melnyk.summaryTask4.controller.command.Command;
import ua.nure.melnyk.summaryTask4.controller.command.orderscommand.CreateOrderCommand;
import ua.nure.melnyk.summaryTask4.controller.command.orderscommand.RemoveElementFromCartByIdCommand;
import ua.nure.melnyk.summaryTask4.controller.command.orderscommand.ShowCartCommand;
import ua.nure.melnyk.summaryTask4.controller.command.productscommand.*;
import ua.nure.melnyk.summaryTask4.controller.command.usercommands.*;
import ua.nure.melnyk.summaryTask4.dao.entitydao.OrderDao;
import ua.nure.melnyk.summaryTask4.dao.entitydao.ProductDao;
import ua.nure.melnyk.summaryTask4.dao.entitydao.UserDao;
import ua.nure.melnyk.summaryTask4.dao.entitydao.impl.OrderDaoImpl;
import ua.nure.melnyk.summaryTask4.dao.entitydao.impl.ProductDaoImpl;
import ua.nure.melnyk.summaryTask4.dao.entitydao.impl.UserDaoImpl;
import ua.nure.melnyk.summaryTask4.model.Role;
import ua.nure.melnyk.summaryTask4.service.OrderService;
import ua.nure.melnyk.summaryTask4.service.ProductService;
import ua.nure.melnyk.summaryTask4.service.UserService;
import ua.nure.melnyk.summaryTask4.service.serviceImpl.OrderServiceImpl;
import ua.nure.melnyk.summaryTask4.service.serviceImpl.ProductServiceImpl;
import ua.nure.melnyk.summaryTask4.service.serviceImpl.UserServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Application Context
 */
@WebListener
public class ApplicationContext implements ServletContextListener {

    private Map<String, Command> commands;
    private UserDao userDao;
    private ProductDao productDao;
    private OrderDao orderDao;
    private UserService userService;
    private ProductService productService;
    private OrderService orderService;
    private Map<Role, String> accessMap;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("commands", getCommandContainer());
        servletContextEvent.getServletContext().setAttribute("productService", getProductService());
        servletContextEvent.getServletContext().setAttribute("accessMap", getAccessMap());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    /**
     * Map for Commands
     *
     * @return
     */
    public Map<String, Command> getCommandContainer() {
        if (commands == null) {
            commands = new HashMap<>();
            commands.put(CommandsConstants.REGISTER_USER, new RegisterNewUserCommand(getUserService()));
            commands.put(CommandsConstants.LOGIN, new LoginCommand(getUserService()));
            commands.put(CommandsConstants.LOGOUT, new LogOutCommand());
            commands.put(CommandsConstants.BLOCK_USER, new BlockUserCommand(getUserService()));
            commands.put(CommandsConstants.UNLOCK_USER, new UnlockUserCommand(getUserService()));
            commands.put(CommandsConstants.REDIRECT_TO_REGISTRATION_PAGE_USER, new RedirectToRegistrationPageCommand());
            commands.put(CommandsConstants.FIND_ALL_PRODUCTS, new ShowListProductCommand(getProductService()));
            commands.put(CommandsConstants.ADD_PRODUCT_TO_CART, new AddProductToCartCommand(getUserService()));
            commands.put(CommandsConstants.SHOW_CART, new ShowCartCommand());
            commands.put(CommandsConstants.REMOVE_ITEM_FROM_CART_BY_ID, new RemoveElementFromCartByIdCommand());
            commands.put(CommandsConstants.SORT_BY_PRICE, new SortProductsByPriceCommand(getProductService()));
            commands.put(CommandsConstants.SORT_BY_NAME, new SortListProductByNameCommand(getProductService()));
            commands.put(CommandsConstants.CREATE_ORDER, new CreateOrderCommand(getOrderService()));
            commands.put(CommandsConstants.FIND_ALL_USERS, new ViewAllUsersCommand(getUserService()));
            commands.put(CommandsConstants.FILTER_BY_CATEGORY, new FilterCategoryListCommand(productService));
            commands.put(CommandsConstants.FILTER_BY_IS_NEW, new FilterIsNewListCommand(productService));
        }
        return commands;
    }

    private Map<Role, String> getAccessMap() {
        if (accessMap == null) {
            accessMap = new HashMap<>();
            accessMap.put(Role.USER, "register login logout redirectToRegistration findAllProducts addToCart showCart removeById sortByPrice sortByName filter filterNovice createOrder");
            accessMap.put(Role.ADMIN, "block unlock viewAllUsers register login logout redirectToRegistration findAllProducts addToCart showCart removeById sortByPrice createOrder");
        }
        return accessMap;
    }

    public UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    public ProductDao getProductDao() {
        if (productDao == null) {
            productDao = new ProductDaoImpl();
        }
        return productDao;
    }

    public OrderDao getOrderDao() {
        if (orderDao == null) {
            orderDao = new OrderDaoImpl();
        }
        return orderDao;
    }

    public UserService getUserService() {
        if (userService == null) {
            userService = new UserServiceImpl(getUserDao(), getProductDao());
        }
        return userService;
    }

    public ProductService getProductService() {
        if (productService == null) {
            productService = new ProductServiceImpl(getProductDao());
        }
        return productService;
    }

    public OrderService getOrderService() {
        if (orderService == null) {
            orderService = new OrderServiceImpl(getOrderDao());
        }
        return orderService;
    }
}
