package offer;

/**
 * @author Min
 * @create 2021-04-17 19:44
 */
public class MyPow {
    public static void main(String[] args) {
        System.out.println("start");
        System.out.println(myPow(2,3));
        System.out.println("end");
    }

    public static double myPow(int x,int y){
        long longY = y;
        if(y == 0)return 1l;
        if(y < 0){
            longY = -longY;
        }
        double response = 1.0;
        while (longY > 0 ){
            if((longY & 1l) == 1)response *= x;
            x *= x;
            longY >>= 1;
        }
        return response;
    }
}
