package ua.nure.melnyk.summaryTask4.exception;

/**
 * ProductDaoException
 */
public class ProductDaoException extends RuntimeException {
    /**
     * Specified message for every operation with database in ProductDaoImpl
     *
     * @param message
     */
    public ProductDaoException(String message) {
        super(message);
    }
}
