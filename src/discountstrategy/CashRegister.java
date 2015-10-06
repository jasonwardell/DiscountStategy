package discountstrategy;

/**
 *
 * @author jwardell
 */
public class CashRegister {

    private Receipt receipt;
    private Product product;

    public void startTransaction() {
        receipt = new Receipt("100");
        
        addItems("A101", 2);
    }

    public void addItems(String prodId, int qty) {
        FakeDatabase db = new FakeDatabase();
        db.findProduct(prodId);
        if (prodId != null) {
          receipt.addLineItem(qty, product);
        }
    }

    public void endTransaction() {
        receipt.outputLineItems();
    }
}
