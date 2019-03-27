package ua.nure.melnyk.summaryTask4.dao.factorydao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.melnyk.summaryTask4.dao.DaoFactory;
import ua.nure.melnyk.summaryTask4.dao.entitydao.OrderDao;
import ua.nure.melnyk.summaryTask4.dao.entitydao.ProductDao;
import ua.nure.melnyk.summaryTask4.dao.entitydao.UserDao;
import ua.nure.melnyk.summaryTask4.dao.entitydao.impl.OrderDaoImpl;
import ua.nure.melnyk.summaryTask4.dao.entitydao.impl.ProductDaoImpl;
import ua.nure.melnyk.summaryTask4.dao.entitydao.impl.UserDaoImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Dao Factory
 */
public class MySqlDaoFactory extends DaoFactory {

    private static final Logger logger
            = LoggerFactory.getLogger(MySqlDaoFactory.class);

    private DataSource dataSource;

    private static MySqlDaoFactory instance;
    private Connection connection;

    public static synchronized MySqlDaoFactory getInstance() {
        if (instance == null) {
            instance = new MySqlDaoFactory();
        }
        return instance;
    }


    private MySqlDaoFactory() {
        try {
            Context initContext = new InitialContext();
            dataSource = (DataSource) initContext.lookup("java:/comp/env/jdbc/internetshop");
        } catch (NamingException e) {
            logger.info("Can not get a context ", e);
        }
    }

    /**
     * get Connection to database
     *
     * @return
     */
    public Connection getConnection() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            logger.info("Can not get a connection {}", MySqlDaoFactory.class.getSimpleName(), e);
        }
        return connection;
    }

    /**
     * close Connection
     */
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            logger.info("Can not close a connection {}", e);
        }
    }

    /**
     * commit changes
     */
    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            logger.info("Can not commit {}", e);

        }
    }

    /**
     * rollback changes
     */
    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            logger.info("Can not a rollback", e);
        }
    }

    @Override
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }

    @Override
    public ProductDao getProductDao() {
        return new ProductDaoImpl();
    }

    @Override
    public OrderDao getOrderDao() {
        return new OrderDaoImpl();
    }
}
