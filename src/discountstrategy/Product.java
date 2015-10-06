
package discountstrategy;

/**
 *
 * @author jwardell
 */
public class Product {
    private String prodId;
    private String name;
    private double unitPrice;
    private DiscountStategy discount;

    public Product(String prodId, double unitPrice, String name, DiscountStategy discount) {
        this.prodId = prodId;
        this.name = name;
        this.discount = discount;
    }
    
    public double getDiscountAmt(double qty) {
        return discount.getDiscountAmt(unitPrice, qty);
    }
    
    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DiscountStategy getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountStategy discount) {
        this.discount = discount;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
     
}
