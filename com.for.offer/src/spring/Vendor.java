package spring;

/**
 * @author Min
 * @create 2021-04-25 19:50
 */
public class Vendor implements Sell {

    @Override
    public void sell() {
        System.out.println("sell");
    }

    @Override
    public void ad() {
        System.out.println("ad");
    }
}
