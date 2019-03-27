package ua.nure.melnyk.summaryTask4.controller.command.productscommand;

import ua.nure.melnyk.summaryTask4.constants.Path;
import ua.nure.melnyk.summaryTask4.controller.command.Command;
import ua.nure.melnyk.summaryTask4.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Filter isNew Command
 */
public class FilterIsNewListCommand implements Command{

    private ProductService productService;

    public FilterIsNewListCommand(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String isNew = request.getParameter("novice");
        request.setAttribute("productList",productService.filterByIsNew(isNew));
        return Path.INDEX_PAGE;
    }
}
