/**
 * @author : Ranjith Suranga <suranga@ijse.lk>
 * @since : 12/8/20
 **/
public class AppInitializer {

    public static void main(String[] args) {
        Customer a = new Customer("A");
        a.yaluwa = new Customer("B");
        a.yaluwa.yaluwa = new Customer("C");
        Customer d = new Customer("D");
        d.yaluwa = new Customer("E");
        d = null;
        System.gc();
    }
}
