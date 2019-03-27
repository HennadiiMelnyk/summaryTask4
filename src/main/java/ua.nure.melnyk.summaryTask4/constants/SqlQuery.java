package ua.nure.melnyk.summaryTask4.constants;

/**
 * Sql query const
 */
public final class SqlQuery {
    private SqlQuery() {
        //nop
    }

    /**
     * SQL queries for USERS table
     */
    public static final String SQL_CREATE_USER = "INSERT INTO users VALUES(DEFAULT, ?,?,?,?,2)";
    public static final String SQL_SELECT_USER_BY_ID = "select users.id, users.surname, users.email, users.password, users.isBlock,role.name from users join role on role.id=users.role_idrole WHERE users.id=?";
    public static final String SQL_GET_ALL_USERS = "select users.id, users.surname, users.email, users.password, users.isBlock, role.name from users join role on users.role_idrole=role.id";
    public static final String SQL_DELETE_USER = "DELETE FROM users WHERE id=?";
    public static final String SQL_UPDATE_USER = "UPDATE users SET surname=?,email=?, password=?, isBlock=?, role_idrole=? WHERE id=?";
    public static final String SQL_SELECT_USER_BY_EMAIL = "select users.id,users.email,users.surname, users.password, users.isBlock,role.name from users join role on users.role_idrole=role.id  WHERE users.email=?";
    /**
     * SQL queries for ORDER tale
     */
    public static final String SQL_SELECT_ORDER_BY_ID = "select orders.id, orders.status, users.email from orders join users on orders.users_idusers=users.id where orders.id=?";
    public static final String SQL_CREATE_ORDER = "INSERT INTO orders VALUES (DEFAULT,?,?,?)";
    public static final String SQL_DELETE_ORDER = "DELETE FROM orders WHERE id=?";
    public static final String SQL_UPDATE_ORDER = "UPDATE orders SET  status=?, users_idusers=? where id=?";
    public static final String SQL_GET_ALL_ORDERS = "select * from orders";
    /**
     * SQL queries for PRODUCT table
     */
    public static final String SQL_SELECT_PRODUCT_BY_ID = "select * from product where product.id=?";
    public static final String SQL_CREATE_PRODUCT = "insert into product values (DEFAULT,?,?,?,?,?)";
    public static final String SQL_DELETE_PRODUCT = "DELETE FROM product WHERE id=?";
    public static final String SQL_UPDATE_PRODUCT = "UPDATE product SET name=?,category=?, size=?,color=?, price=? WHERE id=?";
    public static final String SQL_GET_ALL_PRODUCTS = "select * from product";
   // public static final String SQL_GET_ALL_PRODUCT_ORDER_BY_PRICE = "select * from product order by product.price";
    public static final String SQL_GET_ALL_PRODUCT_ORDER_BY_NAME = "select * from product order by product.name";
    public static final String SQL_SELECT_PRODUCT_BY_NAME = "select * from product where product.name=?";
    public static final String SQL_GROUP_BY_CATEGORY = "select * from product where product.category=?";
    public static final String SQL_GROUP_BY_IS_NEW = "select * from product where product.isNew=?";
}
