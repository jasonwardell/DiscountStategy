package discountstrategy;
/**
 *
 * @author jwardell
 */
public class PercentOffDiscount implements DiscountStategy {
    private double discountRate;
    
    public PercentOffDiscount(double discountRate) {
        this.discountRate = discountRate;
    }
            
    @Override
    public double getDiscountAmt(double unitPrice, double qty) {
        return unitPrice * qty * discountRate;
    }

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    
}
