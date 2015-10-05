package discountstrategy;

import java.util.Arrays;

/**
 *
 * @author jwardell
 */
public class FakeDatabase implements ReceiptDataAccessStrategy {

    private final ICustomer[] customers = {
        new ICustomer("100", "John Smith"),
        new ICustomer("200", "Sally Jones"),
        new ICustomer("300", "Bob Clementi")
    };

    private final Product[] products = {
        new Product("A101", 19.95, "MLB Brewer's Hat ", new PercentOffDiscount(0.15)),
        new Product("B205", 35.50, "Men's Dress Shirt", new QtyDiscount(.10, 5)),
        new Product("C222", 9.50, "Women's Socks    ", new NoDiscount(0))
    };

    /**
     * Tries to find a Customer by customer id.
     *
     * @param custId - must not be null or empty
     * @return found Customer or null if not found or bad argument
     */
    @Override
    public ICustomer findCustomer(final String custId) {
        // validation is needed for method parameter       
        if (custId == null || custId.length() == 0) {
            System.out.println("Sorry, FakeDatabase.findCustomer method has "
                    + "illegal argument");
            return null;  // end method prematurely after log to console
        }

        ICustomer customer = null;

        for (ICustomer c : customers) {
            if (custId.equals(c.getCustId())) {
                customer = c;
                break;
            }
        }

        return customer;
    }

    /**
     * Tries to find a Product by product id.
     *
     * @param prodId - must not be null or empty
     * @return found Product or null if not found or bad argument
     */
    @Override
    public Product findProduct(final String prodId) {
        // validation is needed for method parameter
        if (prodId == null || prodId.length() == 0) {
            System.out.println("Sorry, FakeDatabase.findProduct method has "
                    + "illegal argument");
            return null;  // end method prematurely after log to console
        }

        Product product = null;

        for (Product p : products) {
            if (prodId.equals(p.getProdId())) {
                product = p;
                break;
            }
        }

        return product;
    }
}
