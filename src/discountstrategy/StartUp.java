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
        Receipt r = new Receipt();
        System.out.println(r.getReceipt());
        System.out.println(db.findProduct("A101").toString());
        System.out.println(db.findCustomer("100").toString());
    }
}
