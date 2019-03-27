package ua.nure.melnyk.summaryTask4.dao.entitydao.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.melnyk.summaryTask4.dao.entitydao.UserDao;
import ua.nure.melnyk.summaryTask4.dao.factorydao.MySqlDaoFactory;
import ua.nure.melnyk.summaryTask4.exception.UserDaoException;
import ua.nure.melnyk.summaryTask4.model.User;
import ua.nure.melnyk.summaryTask4.util.DaoUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.nure.melnyk.summaryTask4.constants.SqlQuery.*;

/**
 * User Dao Implementation. Work with database;
 */
public class UserDaoImpl implements UserDao {

    private static final Logger logger
            = LoggerFactory.getLogger(UserDaoImpl.class);

    private PreparedStatement preparedStatement;

    private ResultSet resultSet;

    @Override
    public User select(int id) {
        User user = null;
        try {
            preparedStatement = MySqlDaoFactory.getInstance().getConnection()
                    .prepareStatement(SQL_SELECT_USER_BY_ID);
            int k = 1;
            preparedStatement.setInt(k++, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = DaoUtil.extractUser(resultSet);
            }
        } catch (SQLException e) {
            MySqlDaoFactory.getInstance().rollback();
            logger.info("Cannot get a user", e);
            throw new UserDaoException("Error  while getting a user");
        } finally {
            DaoUtil.closeResource(resultSet, preparedStatement);
            MySqlDaoFactory.getInstance().closeConnection();
        }
        return user;
    }

    @Override
    public boolean create(User user) {
        boolean result = true;
        MySqlDaoFactory mySqlDaoFactory = MySqlDaoFactory.getInstance();
        try {
            preparedStatement = mySqlDaoFactory.getConnection().prepareStatement(SQL_CREATE_USER);
            int k = 1;
            preparedStatement.setString(k++, user.getSurname());
            preparedStatement.setString(k++, user.getEmail());
            preparedStatement.setString(k++, user.getPassword());
            preparedStatement.setString(k++, String.valueOf(user.getIsBlock()));
            preparedStatement.execute();
            mySqlDaoFactory.commit();
        } catch (SQLException e) {
            result = false;
            MySqlDaoFactory.getInstance().rollback();
            logger.info("Cannot create a user", e);
            throw new UserDaoException("Error  while creating a user");
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
                    .prepareStatement(SQL_DELETE_USER);
            int k = 1;
            preparedStatement.setInt(k++, id);
            if (preparedStatement.executeUpdate() > 0) {
                logger.info("Log execute success");
            }
        } catch (SQLException e) {
            MySqlDaoFactory.getInstance().rollback();
            logger.info("Cannot delete user with id: " + id, e);
            throw new UserDaoException("Error  while delete a user");
        } finally {
            DaoUtil.closePreparedStatement(preparedStatement);
            MySqlDaoFactory.getInstance().closeConnection();
        }

    }

    @Override
    public User update(User user) {
        MySqlDaoFactory mySqlDaoFactory = MySqlDaoFactory.getInstance();
        try {
            preparedStatement = mySqlDaoFactory.getConnection()
                    .prepareStatement(SQL_UPDATE_USER);
            int k = 1;
            preparedStatement.setString(k++, user.getSurname());
            preparedStatement.setString(k++, user.getEmail());
            preparedStatement.setString(k++, user.getPassword());
            preparedStatement.setString(k++, String.valueOf(user.getIsBlock()));
            preparedStatement.setString(k++, String.valueOf(user.getRole().getValue()));
            preparedStatement.setInt(k++, user.getId());
            preparedStatement.executeUpdate();
            mySqlDaoFactory.commit();
        } catch (SQLException e) {
            MySqlDaoFactory.getInstance().rollback();
            logger.info("Cannot update a user", e);
            throw new UserDaoException("Error  while updating a user");
        } finally {
            DaoUtil.closePreparedStatement(preparedStatement);
            MySqlDaoFactory.getInstance().closeConnection();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();

        try {
            preparedStatement = MySqlDaoFactory.getInstance().getConnection()
                    .prepareStatement(SQL_GET_ALL_USERS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userList.add(DaoUtil.extractUser(resultSet));
            }
        } catch (SQLException e) {
            MySqlDaoFactory.getInstance().rollback();
            logger.info("Cannot get a list of users", e);
            throw new UserDaoException("Error  while getting a List of users");
        } finally {
            DaoUtil.closeResource(resultSet, preparedStatement);
            MySqlDaoFactory.getInstance().closeConnection();
        }
        return userList;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = null;
        try {
            preparedStatement = MySqlDaoFactory.getInstance().getConnection()
                    .prepareStatement(SQL_SELECT_USER_BY_EMAIL);
            int k = 1;
            preparedStatement.setString(k++, email);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = DaoUtil.extractUser(resultSet);
            }
        } catch (SQLException e) {
            MySqlDaoFactory.getInstance().rollback();
            logger.info("Cannot get user by email ", e);
            throw new UserDaoException("Error while getting user by email");
        } finally {
            DaoUtil.closeResource(resultSet, preparedStatement);
            MySqlDaoFactory.getInstance().closeConnection();
        }
        return user;
    }
}
