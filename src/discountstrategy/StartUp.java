package discountstrategy;
/**
 *
 * @author JWardell
 */
public class StartUp {

    public static void main(String[] args) {
        
        CashRegister cr = new CashRegister();
        
        cr.startTransaction("100", new FakeDatabase(), new ConsoleReceiptPrint());
        cr.addItems("C222", 4);
        cr.addItems("A101", 1);
        cr.addItems("B205", 2);
        cr.endTransaction();
    }
}
