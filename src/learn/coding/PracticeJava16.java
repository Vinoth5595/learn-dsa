package learn.coding;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Logger;

interface HelloWorld{
    default String hello(){
        return "Hello World!!!";
    }
}

/**
 * Practice Java 16
 */
public class PracticeJava16 {
    public static final Logger logger = Logger.getLogger(PracticeJava16.class.getName());

    /**
     * Invoke default method from proxy instance
     */
    public static void invokeDefaultMethodFromProxyInstance(){
        Object proxy = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {HelloWorld.class},
                (prox, method, args) -> {
                    if(method.isDefault()){
                        return InvocationHandler.invokeDefault(prox, method, args);
                    }

                    return null;
                });

        try {
            Method method = proxy.getClass().getMethod("hello");
            logger.info(() -> {
                try {
                    return method.invoke(proxy) + "";
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                return null;
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Main Method
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        invokeDefaultMethodFromProxyInstance();
    }
}
