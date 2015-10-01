package discountstrategy;

/**
 *
 * @author jwardell
 */
public class CashRegister  {
    private FakeDatabase db;
    private ICustomer custId;
    private ICustomer custName;

    public CashRegister(FakeDatabase db, ICustomer custId, ICustomer custName) {
        this.db = db;
        this.custId = custId;
        this.custName = custName;
    }

   public String getCustomer() {
       return db.findCustomer(custId);
   }
    public FakeDatabase getDb() {
        return db;
    }

    public void setDb(FakeDatabase db) {
        this.db = db;
    }

    public ICustomer getCustId() {
        return custId;
    }

    public void setCustId(ICustomer custId) {
        this.custId = custId;
    }

    public ICustomer getCustName() {
        return custName;
    }

    public void setCustName(ICustomer custName) {
        this.custName = custName;
    }
    
    public static void main(String[] args) {
        
        db.findCustomer(100);
    }
    
}
