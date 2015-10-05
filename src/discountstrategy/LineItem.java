package discountstrategy;

/**
 *
 * @author jwardell
 */
public class LineItem {
    private double qty;
    private Product product;
    private double totalPrice;

    public double getTotalPrice() {
        totalPrice = (product.getUnitPrice() * qty) - product.getDiscountAmt(qty);
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

