package exercise.proxyExercise;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class OtherProceduresSet implements InvocationHandler {

    Object proxyIns;

    public OtherProceduresSet(Object proxy) {
        this.proxyIns = proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("prepare the materials to make food in advanced");
        Thread.sleep(3000);
        Object res = method.invoke(proxyIns, args);
        System.out.println("finish the whole procedure and write logs");
        return res;
    }
}
