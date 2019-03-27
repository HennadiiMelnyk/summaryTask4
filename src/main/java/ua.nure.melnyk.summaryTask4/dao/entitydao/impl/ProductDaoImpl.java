package ua.nure.melnyk.summaryTask4.dao.entitydao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.melnyk.summaryTask4.dao.entitydao.ProductDao;
import ua.nure.melnyk.summaryTask4.dao.factorydao.MySqlDaoFactory;
import ua.nure.melnyk.summaryTask4.exception.ProductDaoException;
import ua.nure.melnyk.summaryTask4.model.Product;
import ua.nure.melnyk.summaryTask4.util.DaoUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.nure.melnyk.summaryTask4.constants.SqlQuery.*;

/**
 * Product Dao Implementation. Work with database;
 */
public class ProductDaoImpl implements ProductDao {

    private static final Logger logger
            = LoggerFactory.getLogger(ProductDaoImpl.class);
    private PreparedStatement preparedStatement;

    private ResultSet resultSet;

    @Override
    public Product select(int id) {

        Product product = null;
        try {
            preparedStatement = MySqlDaoFactory.getInstance().getConnection()
                    .prepareStatement(SQL_SELECT_PRODUCT_BY_ID);
            int k = 1;
            preparedStatement.setInt(k++, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product = DaoUtil.extractProduct(resultSet);
            }
        } catch (SQLException e) {
            MySqlDaoFactory.getInstance().rollback();
            logger.info("Cannot get a product", e);
            throw new ProductDaoException("Error while getting a product by id");
        } finally {
            DaoUtil.closeResource(resultSet, preparedStatement);
            MySqlDaoFactory.getInstance().closeConnection();
        }
        return product;
    }

    @Override
    public boolean create(Product product) {
        boolean result = true;
        try {
            preparedStatement = MySqlDaoFactory.getInstance().getConnection()
                    .prepareStatement(SQL_CREATE_PRODUCT);
            int k = 1;
            preparedStatement.setString(k++, product.getName());
            preparedStatement.setString(k++, product.getCategory());
            preparedStatement.setString(k++, product.getColor());
            preparedStatement.setString(k++, product.getSize());
            preparedStatement.setString(k++, product.getPrice());
            if (preparedStatement.executeUpdate() > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
            }
        } catch (SQLException e) {
            result = false;
            MySqlDaoFactory.getInstance().rollback();
            logger.info("Cannot create a product", e);
            throw new ProductDaoException("Error while creating a product");
        } finally {
            DaoUtil.closeResource(resultSet, preparedStatement);
            MySqlDaoFactory.getInstance().closeConnection();
        }
        return result;
    }

    @Override
    public void delete(int id) {
        try {
            preparedStatement = MySqlDaoFactory.getInstance().getConnection()
                    .prepareStatement(SQL_DELETE_PRODUCT);
            int k = 1;
            preparedStatement.setInt(k++, id);
            if (preparedStatement.executeUpdate() > 0) {
                logger.info("delete success");
            }
        } catch (SQLException e) {
            MySqlDaoFactory.getInstance().rollback();
            logger.info("Cannot delete a product", e);
            throw new ProductDaoException("Error while deleting a product");
        } finally {
            DaoUtil.closePreparedStatement(preparedStatement);
            MySqlDaoFactory.getInstance().closeConnection();
        }

    }

    @Override
    public Product update(Product product) {
        try {
            preparedStatement = MySqlDaoFactory.getInstance().getConnection()
                    .prepareStatement(SQL_UPDATE_PRODUCT);
            int k = 1;
            preparedStatement.setString(k++, product.getName());
            preparedStatement.setString(k++, product.getCategory());
            preparedStatement.setString(k++, product.getSize());
            preparedStatement.setString(k++, product.getColor());
            preparedStatement.setString(k++, product.getPrice());
            preparedStatement.setInt(k++, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            MySqlDaoFactory.getInstance().rollback();
            logger.info("Cannot update a product", e);
            throw new ProductDaoException("Error while updating a product");
        } finally {
            DaoUtil.closePreparedStatement(preparedStatement);
            MySqlDaoFactory.getInstance().closeConnection();
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        try {
            preparedStatement = MySqlDaoFactory.getInstance().getConnection()
                    .prepareStatement(SQL_GET_ALL_PRODUCTS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productList.add(DaoUtil.extractProduct(resultSet));
            }
        } catch (SQLException e) {
            MySqlDaoFactory.getInstance().rollback();
            logger.info("Cannot get list of products", e);
            throw new ProductDaoException("Error while getting a List of products");
        } finally {
            DaoUtil.closeResource(resultSet, preparedStatement);
            MySqlDaoFactory.getInstance().closeConnection();
        }
        return productList;
    }

    @Override
    public Product getProductByName(String name) {
        Product product = null;
        try {
            preparedStatement = MySqlDaoFactory.getInstance().getConnection()
                    .prepareStatement(SQL_SELECT_PRODUCT_BY_NAME);
            int k = 1;
            preparedStatement.setString(k++, name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product = DaoUtil.extractProduct(resultSet);
            }
        } catch (SQLException e) {
            MySqlDaoFactory.getInstance().rollback();
            logger.info("Cannot get  product by name", e);
            throw new ProductDaoException("Error while getting  product by name");
        } finally {
            DaoUtil.closeResource(resultSet, preparedStatement);
            MySqlDaoFactory.getInstance().closeConnection();
        }
        return product;
    }

    @Override
    public List<Product> getListOfProductsSortedByName() {
        List<Product> productSortedListByName = new ArrayList<>();
        try {
            preparedStatement = MySqlDaoFactory.getInstance().getConnection()
                    .prepareStatement(SQL_GET_ALL_PRODUCT_ORDER_BY_NAME);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productSortedListByName.add(DaoUtil.extractProduct(resultSet));
            }
        } catch (SQLException e) {
            MySqlDaoFactory.getInstance().rollback();
            logger.info("Cannot get list of sorted products", e);
            throw new ProductDaoException("Error while getting a List of sorted  products");
        } finally {
            DaoUtil.closeResource(resultSet, preparedStatement);
            MySqlDaoFactory.getInstance().closeConnection();
        }
        return productSortedListByName;
    }

    @Override
    public List<Product> filterByIsNew(String isNew) {
        List<Product> productListGroupByCategory = new ArrayList<>();
        try {
            preparedStatement = MySqlDaoFactory.getInstance().getConnection()
                    .prepareStatement(SQL_GROUP_BY_IS_NEW);
            int k=1;
            preparedStatement.setString(k++, isNew);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productListGroupByCategory.add(DaoUtil.extractProduct(resultSet));
            }
        } catch (SQLException e) {
            MySqlDaoFactory.getInstance().rollback();
            logger.info("Cannot get list ", e);
            throw new ProductDaoException("Error while getting ");
        } finally {
            DaoUtil.closeResource(resultSet, preparedStatement);
            MySqlDaoFactory.getInstance().closeConnection();
        }
        return productListGroupByCategory;
    }

    @Override
    public List<Product> filterByCategory(String category) {
        List<Product> productListGroupByCategory = new ArrayList<>();
        try {
            preparedStatement = MySqlDaoFactory.getInstance().getConnection()
                    .prepareStatement(SQL_GROUP_BY_CATEGORY);
            int k=1;
            preparedStatement.setString(k++, category);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productListGroupByCategory.add(DaoUtil.extractProduct(resultSet));
            }
        } catch (SQLException e) {
            MySqlDaoFactory.getInstance().rollback();
            logger.info("Cannot get list of sorted products", e);
            throw new ProductDaoException("Error while getting a List of sorted  products");
        } finally {
            DaoUtil.closeResource(resultSet, preparedStatement);
            MySqlDaoFactory.getInstance().closeConnection();
        }
        return productListGroupByCategory;
    }
}

