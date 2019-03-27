package ua.nure.melnyk.summaryTask4.dao.entitydao;

import ua.nure.melnyk.summaryTask4.dao.CrudDao;
import ua.nure.melnyk.summaryTask4.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * UserDao.
 */
public interface UserDao extends CrudDao<User> {

    /**
     * get User with specified email
     *
     * @param email
     * @return User
     */
    User getUserByEmail(String email);
}
