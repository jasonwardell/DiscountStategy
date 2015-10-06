package discountstrategy;

/**
 *
 * @author jwardell
 */
public class Receipt {

    private ICustomer customer;
    private LineItem[] lineItems = new LineItem[0];

    public Receipt(String custId) {
        FakeDatabase db = new FakeDatabase();
        customer = db.findCustomer(custId);
    }

    public void addToLineItemArray(LineItem purchase) {
        LineItem[] tempArray = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempArray, 0, lineItems.length);
        tempArray[lineItems.length] = purchase;
        tempArray =  lineItems;
    }

    public void addLineItem(double qty, Product product) {
        LineItem li = new LineItem(qty, product);
        addToLineItemArray(li);
    }
    
    public String outputLineItems() {
       return customer.getCustId() + customer.getCustName();
    }
}
