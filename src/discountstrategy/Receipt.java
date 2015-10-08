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

    public void addLineItem(double qty, String prodId) {
        LineItem purchase = new LineItem(db, qty, prodId);
        addToLineItemArray(purchase);
    }
     public double getSubTotal() {
        double total = 0.0;
        for(LineItem purchase : lineItems) {
            total += purchase.getProductUnitPrice();
        }
        return total;
    }
     
              public final double getTotalDiscount() {
        double total = 0.0;
        for(LineItem purchase : lineItems) {
            total += purchase.getProductDiscountAmt();
        }
        return total;
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
  
        double subTotal = getSubTotal();
        double totalDiscount = getTotalDiscount();
        double totalPrice = subTotal - totalDiscount;
        receiptInfo.append("\n");
//        receiptInfo.append("\t\t\t\t\t\t\t").append("-------------");
        receiptInfo.append("\t\t\t\t    Total before discounts:     ").append(nf.format(subTotal)).append("\n");        
        receiptInfo.append("\t\t\t\t\t   Total discounts:     ").append(nf.format(totalDiscount)).append("\n");
        receiptInfo.append("\t\t\t\t\t\t Total due:     ").append(nf.format(totalPrice)).append("\n");
        
         output.outputReceipt(receiptInfo.toString());
    }
}
