package ua.nure.melnyk.summaryTask4.controller.command.productscommand;

import ua.nure.melnyk.summaryTask4.constants.Path;
import ua.nure.melnyk.summaryTask4.controller.command.Command;
import ua.nure.melnyk.summaryTask4.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Filter Category Command
 */
public class FilterCategoryListCommand implements Command {

    private ProductService productService;

    public FilterCategoryListCommand(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String category = request.getParameter("category");
        request.setAttribute("productList",productService.filterByCategory(category));
        return Path.INDEX_PAGE;
    }
}
