package discountstrategy;
/**
 *
 * @author jwardell
 */
public class QtyDiscount implements DiscountStategy{
    private double discountRate;
    private double minQty;
    
    public QtyDiscount(double discountRate, double minQty) {
        this.discountRate = discountRate;
        this.minQty = minQty;
    }
            
    @Override
    public double getDiscountAmt(double unitPrice, double qty) {
        if (qty >= minQty) {
        return unitPrice * qty * discountRate;
    }else {
            return 0;
        }
    }

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getMinQty() {
        return minQty;
    }

    public void setMinQty(double minQty) {
        this.minQty = minQty;
    }
    
    
}