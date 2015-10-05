package discountstrategy;

/**
 *
 * @author jwardell
 */
public class Receipt {

    private double qty;
    private Product product;
    private double totalPrice;
    private String receipt;

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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getReceipt() {
        receipt = (product.getProdId() + " " + product.getName() + " " + product.getUnitPrice() + " "
                + qty + " " + product.getDiscountAmt(qty) + " " + totalPrice);
        return receipt;
    }
}
