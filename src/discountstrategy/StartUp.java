package discountstrategy;

import java.util.Arrays;
import java.lang.Object;

/**
 *
 * @author JWardell
 */
public class StartUp {

    public static void main(String[] args) {
        ReceiptDataAccessStrategy db = new FakeDatabase();
        Product product = new Product("A100", 20.00, "BaseBall Hat", 
                new PercentOffDiscount(.10));
        ICustomer customer = new ICustomer("100", "John Smith");
        Receipt r = new Receipt("100");
        System.out.println(r.getReceipt());
//        System.out.println(db.findProduct("A101").toString());
//        System.out.println(db.findCustomer("100").toString());
    }
}
