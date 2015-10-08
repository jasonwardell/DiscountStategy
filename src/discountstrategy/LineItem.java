package discountstrategy;
/**
 *
 * @author jwardell
 */
public class LineItem {
    private ReceiptDataAccessStrategy db;
    private double qty;
    private Product product;

    public LineItem(ReceiptDataAccessStrategy db, double qty, Product product) {
        this.db = db;
        this.qty = qty;
        this.product = product;
    }
    
    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public String getProdId() {
        return product.getProdId();
    }
    
    public final Product getProduct() {
        return product;
    }
    
    public double getProductUnitPrice() {
        return product.getUnitPrice() * qty;
    }
    
    public double getProductDiscountAmt() {
        return product.getDiscount().getDiscountAmt(product.getUnitPrice(), qty);
    }
        private final Product findProduct(final String prodId) {
        return db.findProduct(prodId);
    }
   
}
