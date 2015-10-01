package discountstrategy;

/**
 *
 * @author jwardell
 */
public class LineItem {
 private DiscountStategy discount;
 private Product prodId;
 private Product name;
 private Product unitPrice;


    public DiscountStategy getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountStategy discount) {
        this.discount = discount;
    }

    public Product getProdId() {
        return prodId;
    }

    public void setProdId(Product prodId) {
        this.prodId = prodId;
    }

    public Product getName() {
        return name;
    }

    public void setName(Product name) {
        this.name = name;
    }

    public Product getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Product unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    public static void main(String[] args) {
        Product product = new Product("A100", 20.00, "BaseBall Hat", 
                new PercentOffDiscount(.10));
        System.out.println(product.getName());
    }
}