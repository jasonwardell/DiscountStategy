package discountstrategy;
/**
 *
 * @author jwardell
 */
public interface DiscountStategy {

    double getDiscountAmt(double unitPrice, double qty);

    double getDiscountRate();

    void setDiscountRate(double discountRate);
    
}
