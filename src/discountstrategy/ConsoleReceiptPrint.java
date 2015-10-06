package discountstrategy;

/**
 *
 * @author JWardell
 */
public class ConsoleReceiptPrint implements OutputStrategy{

    @Override
    public void outputReceipt(String data) {
         System.out.println(data);
    }

    @Override
    public void outputMessage(String msg) {
        System.out.println(msg);
    }
    
}
