package discountstrategy;

/**
 *
 * @author jwardell
 */
public interface ReceiptDataAccessStrategy {
    
    public abstract ICustomer findCustomer(final String custId);
    
    public abstract Product findProduct(final String prodId);
}
