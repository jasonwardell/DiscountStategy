package discountstrategy;

import java.text.NumberFormat;

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

    public final void outputLineItems() {
        StringBuilder receiptData = new StringBuilder("Thank you for shopping at Kohls!\n\n");
        receiptData.append("Sold to: ").append(customer.getCustName()).append("\n");
        output.outputReceipt(receiptData.toString());
    }
}
