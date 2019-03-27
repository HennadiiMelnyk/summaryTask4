package ua.nure.melnyk.summaryTask4;

import org.apache.log4j.BasicConfigurator;
import ua.nure.melnyk.summaryTask4.dao.CrudDao;
import ua.nure.melnyk.summaryTask4.dao.DaoFactory;
import ua.nure.melnyk.summaryTask4.dao.entitydao.OrderDao;
import ua.nure.melnyk.summaryTask4.dao.entitydao.ProductDao;
import ua.nure.melnyk.summaryTask4.dao.entitydao.UserDao;
import ua.nure.melnyk.summaryTask4.model.Order;
import ua.nure.melnyk.summaryTask4.model.Role;
import ua.nure.melnyk.summaryTask4.model.User;


import javax.naming.NamingException;
import java.sql.SQLException;

/**
 * Test class for checking sql queries
 */
public class TestDao {

    public static void main(String[] args) throws NamingException, SQLException {
        BasicConfigurator.configure();
        DaoFactory daoFactory = DaoFactory.getDAOFactory("mysql");
        UserDao userDao = daoFactory.getUserDao();
        ProductDao productDao = daoFactory.getProductDao();
        OrderDao orderDao = daoFactory.getOrderDao();

        /**
         * checking user dao methods
         */
        userDao.create(new User(3333, "vova", "vova@email.com", "3333", false, Role.USER));
         /*userDao.update( new User(4,"fffff","fff@","44444",true,Role.USER));
         System.out.println(userDao.select(1));
        userDao.delete(5);
        System.out.println(userDao.findAll());
        System.out.println(userDao.getUserByEmail("fff@"));*/

        /**
         * checking product dao methods
         */
        //System.out.println(productDao.select(2));
        // productDao.create(new Product(33333,"kartoshka","food","1x1","yellow-black","1.50"));
        //productDao.delete(10);
        //productDao.update(new Product(5,"m","m","m","m","200"));
        //System.out.println(productDao.findAll());
        //System.out.println(productDao.getProductByName("m"));

        /**
         * checking order dao methods
         */

        // System.out.println(orderDao.select(1));
        // orderDao.create(new Order(333,"PREPAYED","3"));
        //System.out.println(orderDao.findAll());
        //orderDao.update(new Order(1,"B","2"));
    }
}
