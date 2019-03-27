package ua.nure.melnyk.summaryTask4.service;

import ua.nure.melnyk.summaryTask4.model.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Product Service
 */
public interface ProductService {
    /**
     * Get a list of all products
     *
     * @return
     */
    List<Product> getAllProducts();

    /**
     * sort list of products by Name
     *
     *
     * @return
     */
    List<Product> sortedListOfProductByName();

    /**
     * sort List of product by Price
     *
     *
     * @return
     */
    List<Product> sortedListOfProductByPrice();

    /**
     * get
     * @param category
     * @return
     */
    List<Product> filterByCategory(String category);

    List<Product> filterByIsNew(String isNew);




}
