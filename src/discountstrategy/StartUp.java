package discountstrategy;

/**
 *
 * @author JWardell
 */
public class StartUp {

    public static void main(String[] args) {
        ReceiptDataAccessStrategy db = new FakeDatabase();
        System.out.println(db.findCustomer("100"));
        System.out.println(db.findProduct("A101"));
        
                for (ICustomer customer : fb.customers) {
            System.out.print(customer + ", ");
        }
    }
}
