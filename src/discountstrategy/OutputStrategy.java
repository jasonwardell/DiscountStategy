package discountstrategy;

/**
 *
 * @author JWardell
 */
public interface OutputStrategy {

    public abstract void outputReceipt(String data);
    public abstract void outputMessage(String msg);
}
