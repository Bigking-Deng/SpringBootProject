package exercise.proxyExercise;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class InterceptorForCGLIB implements MethodInterceptor {

//    Object target;
//
//    public InterceptorForCGLIB(Object target) {
//        this.target = target;
//    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("intercept start!");
        Thread.sleep(3000);
//        Object res = methodProxy.invoke(target, objects);
        Object res = methodProxy.invokeSuper(o, objects);
        Thread.sleep(3000);
        System.out.println("intercept stop!");
        return res;
    }
}
