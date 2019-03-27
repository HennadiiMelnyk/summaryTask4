package ua.nure.melnyk.summaryTask4.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.melnyk.summaryTask4.model.Order;
import ua.nure.melnyk.summaryTask4.model.Product;
import ua.nure.melnyk.summaryTask4.model.Role;
import ua.nure.melnyk.summaryTask4.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Util class
 */
public final class DaoUtil {
    private static final Logger logger
            = LoggerFactory.getLogger(DaoUtil.class);

    private DaoUtil() {
    }

    /**
     * Close resources: resultSet, preparedStatement
     *
     * @param resultSet
     * @param preparedStatement
     */
    public static void closeResource(ResultSet resultSet, PreparedStatement preparedStatement) {
        try {
            resultSet.close();
        } catch (SQLException e) {
            logger.info("Cannot close resource: ResultSet ", e);
        }

        try {
            preparedStatement.close();
        } catch (SQLException e) {

            logger.info("Cannot close resource:  Prepared Statement", e);
        }
    }

    /**
     * Close preparedStatement
     *
     * @param preparedStatement
     */
    public static void closePreparedStatement(PreparedStatement preparedStatement) {
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("Cannot close");
        }
    }

    /**
     * Get a user
     *
     * @param resultSet
     * @return
     * @throws SQLException
     */
    public static User extractUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt(1));
        user.setEmail(resultSet.getString(2));
        user.setSurname(resultSet.getString(3));
        user.setPassword(resultSet.getString(4));
        user.setBlock(resultSet.getBoolean(5));
        user.setRole(Role.valueOf(resultSet.getString(6)));
        return user;
    }

    /**
     * Get a product
     *
     * @param resultSet
     * @return
     * @throws SQLException
     */
    public static Product extractProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getInt(1));
        product.setName(resultSet.getString(2));
        product.setCategory(resultSet.getString(3));
        product.setSize(resultSet.getString(4));
        product.setColor(resultSet.getString(5));
        product.setPrice(resultSet.getString(6));
        product.setNew(resultSet.getBoolean(7));
        return product;

    }

    /**
     * Get an Order
     *
     * @param resultSet
     * @return
     * @throws SQLException
     */
    public static Order extractOrder(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt(1));
        order.setStatus(resultSet.getString(2));
        order.setDetails(resultSet.getString(3));
        order.setUserId(resultSet.getInt(4));
        return order;
    }

}
