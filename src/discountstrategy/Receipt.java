package discountstrategy;

/**
 *
 * @author jwardell
 */
public class Receipt {
    private double qty;
    private Product product;
    private LineItem totalPrice;
    private String custId;
    private Product prodId;

    public Receipt(String custId) {
        this.custId = custId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }


    public Product getProdId() {
        return prodId;
    }

    public void setProdId(Product prodId) {
        this.prodId = prodId;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public LineItem getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(LineItem totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public String getReceipt() {
        return (product.getProdId() + " " + product.getName() + " " + product.getUnitPrice() + " "
                + qty + " " + product.getDiscountAmt(qty) + " " + totalPrice);
    }
}