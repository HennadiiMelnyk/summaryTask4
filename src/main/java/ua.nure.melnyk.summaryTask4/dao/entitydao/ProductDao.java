package ua.nure.melnyk.summaryTask4.dao.entitydao;

import ua.nure.melnyk.summaryTask4.dao.CrudDao;
import ua.nure.melnyk.summaryTask4.model.Product;

import java.util.List;

/**
 * ProductDao
 */
public interface ProductDao extends CrudDao<Product> {
    /**
     * get product with specified name
     *
     * @param name
     * @return Product
     */
    Product getProductByName(String name);

    List<Product> filterByCategory(String category);

    /**
     * @return sorted list by specified field: Name
     */
    List<Product> getListOfProductsSortedByName();

    List<Product> filterByIsNew(String isNew);
}
