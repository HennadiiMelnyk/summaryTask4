package ua.nure.melnyk.SummaryTask4.Test.serviceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.nure.melnyk.summaryTask4.dao.entitydao.ProductDao;
import ua.nure.melnyk.summaryTask4.model.Product;
import ua.nure.melnyk.summaryTask4.service.OrderService;
import ua.nure.melnyk.summaryTask4.service.ProductService;
import ua.nure.melnyk.summaryTask4.service.serviceImpl.ProductServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    private ProductService productService;

    @Mock
    ProductDao productDao;

    @Mock
    HttpServletRequest request;

    @Before
    public void setUp() {
        productService = new ProductServiceImpl(productDao);
    }

    @Test
    public void getAllProductsFromListTest() {
        List<Product> testListProducts = new ArrayList<>();
        when(productDao.findAll()).thenReturn(testListProducts);
        productService.getAllProducts();
        verify(productDao).findAll();
    }

    @Test
    public void getAlLProductsFromListSortedByPriceTest() {
        List<Product> testSortedListOfProducts = new ArrayList<>();
        when(productService.sortedListOfProductByPrice()).thenReturn(testSortedListOfProducts);
        productService.sortedListOfProductByPrice();
        verify(productService).sortedListOfProductByPrice();

    }
}
