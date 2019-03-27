package ua.nure.melnyk.summaryTask4.dao.entitydao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.melnyk.summaryTask4.dao.entitydao.OrderDao;
import ua.nure.melnyk.summaryTask4.dao.factorydao.MySqlDaoFactory;
import ua.nure.melnyk.summaryTask4.exception.OrderDaoException;
import ua.nure.melnyk.summaryTask4.model.Order;
import ua.nure.melnyk.summaryTask4.model.User;
import ua.nure.melnyk.summaryTask4.util.DaoUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.nure.melnyk.summaryTask4.constants.SqlQuery.*;

/**
 * Order Dao Implementation. Work with database;
 */
public class OrderDaoImpl implements OrderDao {

    private static final Logger logger
            = LoggerFactory.getLogger(OrderDaoImpl.class);
    private PreparedStatement preparedStatement;

    private ResultSet resultSet;

    @Override
    public Order select(int id) {

        Order order = null;
        try {
            preparedStatement = MySqlDaoFactory.getInstance().getConnection()
                    .prepareStatement(SQL_SELECT_ORDER_BY_ID);
            int k = 1;
            preparedStatement.setInt(k++, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                order = DaoUtil.extractOrder(resultSet);
            }
        } catch (SQLException e) {
            MySqlDaoFactory.getInstance().rollback();
            logger.info("Cannot get an order",e);
            throw  new OrderDaoException("Error while getting an order");
        } finally {
            DaoUtil.closeResource(resultSet, preparedStatement);
            MySqlDaoFactory.getInstance().closeConnection();
        }
        return order;
    }

    @Override
    public boolean create(Order order) {
        boolean result = true;
        MySqlDaoFactory mySqlDaoFactory = MySqlDaoFactory.getInstance();
        try {
            preparedStatement = mySqlDaoFactory.getConnection().prepareStatement(SQL_CREATE_ORDER);
            int k = 1;
            preparedStatement.setString(k++, order.getStatus());
            preparedStatement.setString(k++, order.getDetails());
            preparedStatement.setInt(k++, order.getUserId());
            preparedStatement.execute();
            mySqlDaoFactory.commit();
        } catch (SQLException e) {
            result = false;
            MySqlDaoFactory.getInstance().rollback();
            logger.info("Cannot create an order",e);
            throw  new OrderDaoException("Error while creating an order");
        } finally {
            DaoUtil.closePreparedStatement(preparedStatement);
            MySqlDaoFactory.getInstance().closeConnection();
        }
        return result;
    }

    @Override
    public void delete(int id) {
        try {
            preparedStatement = MySqlDaoFactory.getInstance().getConnection()
                    .prepareStatement(SQL_DELETE_ORDER);
            int k = 1;
            preparedStatement.setInt(k++, id);
            if (preparedStatement.executeUpdate() > 0) {
                logger.info("Log execute success");
            }
        } catch (SQLException e) {
            MySqlDaoFactory.getInstance().rollback();
            logger.info("Cannot delete an order",e);
            throw  new OrderDaoException("Error while deleting an order");
        } finally {
            DaoUtil.closePreparedStatement(preparedStatement);
            MySqlDaoFactory.getInstance().closeConnection();
        }
    }

    @Override
    public Order update(Order order) {
        try {
            preparedStatement = MySqlDaoFactory.getInstance().getConnection()
                    .prepareStatement(SQL_UPDATE_ORDER);
            int k = 1;
            preparedStatement.setString(k++, order.getStatus());
            preparedStatement.setString(k++, order.getDetails());
            preparedStatement.setInt(k++, order.getUserId());
            preparedStatement.setInt(k++, order.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            MySqlDaoFactory.getInstance().rollback();
            logger.info("Cannot update an order",e);
            throw  new OrderDaoException("Error while updating an order");
        } finally {
            DaoUtil.closePreparedStatement(preparedStatement);
            MySqlDaoFactory.getInstance().closeConnection();
        }
        return order;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orderList = new ArrayList<>();
        try {
            preparedStatement = MySqlDaoFactory.getInstance().getConnection()
                    .prepareStatement(SQL_GET_ALL_ORDERS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orderList.add(DaoUtil.extractOrder(resultSet));
            }
        } catch (SQLException e) {
            MySqlDaoFactory.getInstance().rollback();
            logger.info("Cannot get a list of orders",e);
            throw  new OrderDaoException("Error while getting a List of orders");
        } finally {
            DaoUtil.closeResource(resultSet, preparedStatement);
            MySqlDaoFactory.getInstance().closeConnection();
        }
        return orderList;
    }

    @Override
    public void selectAllOrdersByUser(User user) {

    }
}
