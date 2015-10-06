package discountstrategy;
/**
 *
 * @author jwardell
 */
public class LineItem {

    private double qty;
    private Product product;

    public LineItem(double qty, Product product) {
        this.qty = qty;
        this.product = product;
    }
    
    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public String getProductId() {
        return product.getProdId();
    }
    
    public String getProductName() {
        return product.getName();
    }
    
    public double getProductUnitPrice() {
        return product.getUnitPrice();
    }
    
    public double getProductDiscountAmt() {
        return product.getDiscountAmt(qty);
    }
   
}
