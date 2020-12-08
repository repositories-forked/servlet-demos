/**
 * @author : Ranjith Suranga <suranga@ijse.lk>
 * @since : 12/8/20
 **/
public class Customer {

    public Customer yaluwa;
    private String id;

    public Customer(String id){
        this.id = id;
        System.out.println("Instantiate");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Beraganiyo...! Maawa(" + this.id + ") aran yanna hadannea!");
    }
}
