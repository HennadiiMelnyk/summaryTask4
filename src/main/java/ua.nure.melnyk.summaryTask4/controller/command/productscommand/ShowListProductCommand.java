package ua.nure.melnyk.summaryTask4.controller.command.productscommand;

import ua.nure.melnyk.summaryTask4.constants.Path;
import ua.nure.melnyk.summaryTask4.controller.command.Command;
import ua.nure.melnyk.summaryTask4.model.Product;
import ua.nure.melnyk.summaryTask4.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Show List of Products command
 */
public class ShowListProductCommand implements Command {

    private ProductService productService;

    public ShowListProductCommand(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.getAllProducts();
        Set<String> categoryList = productList.stream().map(Product::getCategory).collect(Collectors.toSet());
        Set<Boolean> noviceList = productList.stream().map(Product::isNew).collect(Collectors.toSet());
        request.setAttribute("productList", productList);
        request.getSession().setAttribute("categoryList", categoryList);
        request.getSession().setAttribute("noviceList", noviceList);
        return Path.INDEX_PAGE;
    }
}
