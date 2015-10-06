package discountstrategy;

/**
 *
 * @author jwardell
 */
public class CashRegister {

    private Receipt receipt;
    private Product product;

    public final void startTransaction(String custId, ReceiptDataAccessStrategy db, OutputStrategy output) {
        receipt = new Receipt(custId, db, output);   
    }

    public final void addItems(String prodId, int qty) {
        FakeDatabase db = new FakeDatabase();
        db.findProduct(prodId);
        if (prodId != null) {
          receipt.addLineItem(qty, product);
        }
    }

    public final void endTransaction() {
        receipt.outputLineItems();
    }
}
