package ua.nure.melnyk.summaryTask4.dao;

import ua.nure.melnyk.summaryTask4.dao.entitydao.OrderDao;
import ua.nure.melnyk.summaryTask4.dao.entitydao.ProductDao;
import ua.nure.melnyk.summaryTask4.dao.entitydao.UserDao;
import ua.nure.melnyk.summaryTask4.dao.factorydao.MySqlDaoFactory;

import javax.naming.NamingException;
import java.util.HashMap;
import java.util.Map;

public abstract class DaoFactory {

    private static Map<String, DaoFactory> factories;

    public static DaoFactory getDAOFactory(String factory) throws NamingException {
        factories = new HashMap<>();
        factories.put("mysql", MySqlDaoFactory.getInstance());
        return factories.get(factory);
    }

    public abstract UserDao getUserDao();

    public abstract ProductDao getProductDao();

    public abstract OrderDao getOrderDao();
}
