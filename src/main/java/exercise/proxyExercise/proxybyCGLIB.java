package exercise.proxyExercise;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class proxybyCGLIB {

    public static Object generateProxy(Object obj){
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new InterceptorForCGLIB());
        enhancer.setSuperclass(obj.getClass());
        return enhancer.create();
    }
    public static void main(String[] args) {
        MakeBreadService service = new MakeBreadService();
        MakeCakeService service1 = new MakeCakeService();
        MakeFoodService proxy = (MakeFoodService) generateProxy(service1);
        proxy.makeFood();
    }
}
