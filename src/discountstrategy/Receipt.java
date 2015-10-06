package discountstrategy;

/**
 *
 * @author jwardell
 */
public class Receipt {

    private ICustomer customer;
    private LineItem[] lineItems = new LineItem[0];
    private OutputStrategy output;
    private ReceiptDataAccessStrategy db;

    public Receipt(String custId, ReceiptDataAccessStrategy db, OutputStrategy output) {
        this.customer = db.findCustomer(custId);
        this.output = output;
        this.db = db;
    }

    public void addToLineItemArray(LineItem purchase) {
        LineItem[] tempArray = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempArray, 0, lineItems.length);
        tempArray[lineItems.length] = purchase;
        lineItems = tempArray;
    }

    public void addLineItem(double qty, Product product) {
        LineItem li = new LineItem(qty, product);
        addToLineItemArray(li);
    }
    
    public void outputLineItems() {
         for (LineItem item : lineItems) {
             System.out.println(item);
        }
//       return customer.getCustId() + customer.getCustName();
    }
}
