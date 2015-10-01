package discountstrategy;

/**
 *
 * @author jwardell
 */
public class LineItem {

    private DiscountStategy discount;
    private Product prodId;
    private double qty;
    private Product name;
    private Product unitPrice;
    private double total;

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getTotal(double unitPrice, double qty) {
        total = (unitPrice * qty) - discount.getDiscountAmt(unitPrice, qty);
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

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

        Product p2 = new Product("A100", 20.00, "BaseBall Hat",
                new PercentOffDiscount(.10));
              LineItem li = new LineItem();
        double amt = p2.getDiscountAmt(1);
        double total = li.getTotal(20.00, 1);
        System.out.println("ProdID         unitPrice          Product        Discount    Total");
        System.out.println(p2.getProdId() + "           " + p2.getUnitPrice() + "                "
                + p2.getName() + "    " + amt + "         " + total);

    }
}
