package spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Min
 * @create 2021-04-25 18:20
 */
public class DynamicProxyPractice implements InvocationHandler {

    private Object sell;

    public DynamicProxyPractice(Object obj){
        this.sell = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(sell,args);
        System.out.println("after");
        return result;
    }

    public static void main(String[] args) {
        DynamicProxyPractice dynamicProxyPractice = new DynamicProxyPractice(new Vendor());

        Sell sell = (Sell) Proxy.newProxyInstance(Sell.class.getClassLoader(),new Class[]{Sell.class},dynamicProxyPractice );
        sell.sell();
        sell.ad();
    }
}




