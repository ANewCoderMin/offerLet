package offer;

/**
 * @author Min
 * @create 2021-04-17 22:17
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacciRecursion(3));
        System.out.println(fibonacciRecursion(4));
        System.out.println(fibonacciRecursion(5));
        System.out.println(fibonacciRecursion(6));
        System.out.println(fibonacciRecursion(7));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));


    }

    public static int fibonacci(int num){
        int a = 0,b = 1,sum;
        for(int i = 0;i < num;i++){
            sum = (a+b)%1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static int fibonacciRecursion(int num){
        if(num == 1) return 1;
        if(num == 2) return 1;
        if(num == -1) return 0;

        return fibonacciRecursion(num - 1) + fibonacciRecursion(num - 2);
    }
}
