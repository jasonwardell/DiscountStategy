package discountstrategy;

/**
 *
 * @author jwardell
 */
public class ICustomer {

    private String custId;
    private String custName;

    public ICustomer(String custId, String custName) {
        this.custId = custId;
        this.custName = custName;
    }

    public String getCustId() {
        return custId;
    }

    public String getCustName() {
        return custName;
    }
}
