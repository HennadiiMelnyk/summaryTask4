package ua.nure.melnyk.summaryTask4.constants;


/**
 * Command Constants for Application Context
 */
public final class CommandsConstants {
    private CommandsConstants() {
        //nop
    }

    public static final String FIND_ALL_USERS = "viewAllUsers";
    public static final String REGISTER_USER = "register";
    public static final String LOGIN = "login";
    public static final String LOGOUT = "logout";
    public static final String BLOCK_USER = "block";
    public static final String UNLOCK_USER = "unlock";
    public static final String REDIRECT_TO_REGISTRATION_PAGE_USER = "redirectToRegistration";
    public static final String FIND_ALL_PRODUCTS = "findAllProducts";
    public static final String ADD_PRODUCT_TO_CART = "addToCart";
    public static final String SHOW_CART = "showCart";
    public static final String REMOVE_ITEM_FROM_CART_BY_ID = "removeById";
    public static final String SORT_BY_PRICE = "sortByPrice";
    public static final String SORT_BY_NAME = "sortByName";
    public static final String CREATE_ORDER = "createOrder";
    public static final String FILTER_BY_CATEGORY = "filter";
    public static final String FILTER_BY_IS_NEW = "filterNovice";

}
