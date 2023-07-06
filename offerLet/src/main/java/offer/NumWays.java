package offer;

import java.math.BigDecimal;

/**
 * @author Min
 * @create 2021-05-09 12:25
 */
public class NumWays {
    public static void main(String[] args) {
        NumWays numWays = new NumWays();
        numWays.numWays(92);
    }

    public int numWays(int n){
        BigDecimal first=new BigDecimal(1);
        BigDecimal second=new BigDecimal(1);
        BigDecimal third=new BigDecimal(0);
        BigDecimal tmp=new BigDecimal(0);
        BigDecimal divide=new BigDecimal(1000000007L);
        if(n == 1 || n == 0){
            return 1;
        }
        for(int i=2;i<=n;i++){
            third = first.add(second);
            tmp = second;
            second = third;
            first = tmp;
        }
        System.out.println(third.longValue());
        int result ;
        if(third.compareTo(divide) == 1){
            BigDecimal[] a =third.divideAndRemainder(divide);
            result = a[1].intValue();
            System.out.println(result);
        }else {
            result = third.intValue();
        }
        System.out.println(result);
        return result;
    }
}
