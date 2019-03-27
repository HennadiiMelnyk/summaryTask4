package ua.nure.melnyk.summaryTask4.util;

import ua.nure.melnyk.summaryTask4.repository.Cart;

import java.math.BigDecimal;

/**
 *Util class for Command package for ShowCartCommand
 */
public final class CartUtils {
    private CartUtils() {
        //nop
    }

    /**
     * multiply price of all product in cart.jsp
     * @param cart
     * @return
     */
    public static String extractTotalPrice(Cart cart) {
        final BigDecimal[] result = {BigDecimal.valueOf(0)};
        cart.getCart().forEach((key, value) -> {
            BigDecimal currentTotalPrice = BigDecimal.valueOf(Double.parseDouble(key.getPrice()))
                    .multiply(BigDecimal.valueOf(value));
            result[0] = result[0].add(currentTotalPrice);
        });
        return result[0].toString();
    }
}
