package ua.nure.melnyk.summaryTask4.exception;

/**
 * OrderDao Exception
 */
public class OrderDaoException extends RuntimeException{
    /**
     * Specified message for every operation with database in OrderDaoImpl
     * @param message
     */
    public OrderDaoException(String message) {
        super(message);
    }
}
