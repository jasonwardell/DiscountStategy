package discountstrategy;
/**
 *
 * @author jwardell
 */
public class NoDiscount implements DiscountStategy{
    private double discountRate;
    
    public NoDiscount(double discountRate) {
        this.discountRate = discountRate;
    }
            
    public double getDiscountAmt(double unitPrice, double qty) {
        return 0;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    
}