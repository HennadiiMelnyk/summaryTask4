package ua.nure.melnyk.summaryTask4.controller.command.productscommand;

import ua.nure.melnyk.summaryTask4.constants.Path;
import ua.nure.melnyk.summaryTask4.controller.command.Command;
import ua.nure.melnyk.summaryTask4.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command for sort list of product by Name
 */
public class SortListProductByNameCommand implements Command {

    private ProductService productService;

    public SortListProductByNameCommand(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("productList", productService.sortedListOfProductByName());
        return Path.INDEX_PAGE;
    }
}
