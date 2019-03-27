package ua.nure.melnyk.summaryTask4.dao.entitydao;

import ua.nure.melnyk.summaryTask4.dao.CrudDao;
import ua.nure.melnyk.summaryTask4.model.Order;
import ua.nure.melnyk.summaryTask4.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * OrderDao
 */
public interface OrderDao extends CrudDao<Order> {
    /**
     *
     * @param user
     */
    public void selectAllOrdersByUser(User user);


}
