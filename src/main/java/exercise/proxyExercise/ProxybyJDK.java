package exercise.proxyExercise;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxybyJDK {


    public static Object generateProxy(Object service){
        Class clazz = service.getClass();
        InvocationHandler usingHandler = new OtherProceduresSet(service);
        Object proxyInstance = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), usingHandler);
        return proxyInstance;
    }

    public static void main(String[] args) {
        MakeBreadService service = new MakeBreadService();
        MakeCakeService service1 = new MakeCakeService();

//        System.out.println(service.getClass());
//        System.out.println(service.getClass().getClassLoader());
//        System.out.println(Arrays.asList(service.getClass().getInterfaces()).get(0));
        MakeFoodService proxyIns = (MakeFoodService) generateProxy(service1);
        proxyIns.makeFood();

    }
}
