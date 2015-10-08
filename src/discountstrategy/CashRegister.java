package discountstrategy;

/**
 *
 * @author jwardell
 */
public class CashRegister {

    private Receipt receipt;

    public final void startTransaction(String custId, ReceiptDataAccessStrategy db, OutputStrategy output) {
        receipt = new Receipt(custId, db, output);   
    }

    public final void addItems(String prodId, int qty) {
        FakeDatabase db = new FakeDatabase();
        db.findProduct(prodId);
        if (prodId != null) {
          receipt.addLineItem(qty, prodId);
        }
    }

    public final void endTransaction() {
        receipt.outputLineItems();
    }
}
