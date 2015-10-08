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

    public void addLineItem(double qty, Product prodId) {
        LineItem li = new LineItem(db, qty, prodId);
        addToLineItemArray(li);
    }

    public final void outputLineItems() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        StringBuilder receiptInfo = new StringBuilder("Thank you for shopping at Kohls!\n\n");
        receiptInfo.append("Sold to: ").append(customer.getCustName()).append("\n");
       
        
        receiptInfo.append("ID\tItem\t\t\tPrice\tQty\tSubtotal\tDiscount").append("\n");
        receiptInfo.append("------------------------------------------------------------------------").append("\n");
        for(LineItem purchase : lineItems) {
            receiptInfo.append(purchase.getProduct().getProdId()).append("\t");
            receiptInfo.append(purchase.getProduct().getName()).append("\t");
            receiptInfo.append(nf.format(purchase.getProduct().getUnitPrice())).append("\t");
            receiptInfo.append(purchase.getQty()).append("\t");
            receiptInfo.append(nf.format(purchase.getProductUnitPrice())).append("\t\t");
            receiptInfo.append(nf.format(purchase.getProductDiscountAmt())).append("\n");
        }
  
        
         output.outputReceipt(receiptInfo.toString());
    }
}
