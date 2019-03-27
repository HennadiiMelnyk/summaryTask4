package ua.nure.melnyk.summaryTask4.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.melnyk.summaryTask4.dao.entitydao.ProductDao;
import ua.nure.melnyk.summaryTask4.model.Product;
import ua.nure.melnyk.summaryTask4.service.ProductService;

import java.util.List;

/**
 * Product Service Implementation
 */
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    private static final Logger logger
            = LoggerFactory.getLogger(ProductServiceImpl.class);

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = productDao.findAll();
        return productList;
    }

    @Override
    public List<Product> sortedListOfProductByName() {
        return productDao.getListOfProductsSortedByName();
    }

    @Override
    public List<Product> sortedListOfProductByPrice() {
        List<Product> resultList = productDao.findAll();
        resultList.sort(((o1, o2) -> {
            Double o1Price = Double.parseDouble(o1.getPrice());
            Double o2Price = Double.parseDouble(o2.getPrice());
            return o1Price.compareTo(o2Price);
        }));
        return resultList;
    }

    @Override
    public List<Product> filterByCategory(String category) {

        return productDao.filterByCategory(category);
    }

    @Override
    public List<Product> filterByIsNew(String isNew) {
        return productDao.filterByIsNew(isNew);
    }


}
