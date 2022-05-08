package learn.coding;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

interface Addition<T> {
    T add(T val1, T val2);
}

public class PracticeJava11 {
    public static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * Java 11 - String operations
     */
    public static void stringOperations(){
        // isBlank
        logger.log(Level.INFO, "{0}", " ".isBlank());

        // lines()
        "A \n A \n A ".lines().forEach(i -> logger.log(Level.INFO, "{0}", i));

        // strip(), stripLeading(), stripTrailing()
        String val = " A ";
        logger.log(Level.INFO, "{0}",
                val.length()
                        + " : " + val.strip().length()
                        + " : " + val.stripLeading().length()
                        + " : " + val.stripTrailing().length());

        // repeat()
        String val1 = "=";
        logger.log(Level.INFO, () -> val1.repeat(10));
    }

    /**
     * Local variable syntax for lambda expression
     */
    public static void localVariableVar(){
        Addition<Integer> addition = (var a, var b) -> a + b;
        logger.log(Level.INFO, () -> addition.add(1,2)+"");
    }

    public static void nestBasedAccessControl(){
        logger.log(Level.INFO, PracticeJava11.class.getNestHost().getName());
        logger.log(Level.INFO, PracticeJava11.Inner.class.getNestHost().getName());
        logger.log(Level.INFO, () -> PracticeJava11.Inner.class.isNestmateOf(PracticeJava11.class)+"");

        Arrays.stream(PracticeJava11.Inner.class.getNestMembers()).map(Class::getName)
                .forEach(i -> logger.log(Level.INFO, i));
    }

    public static void main(String[] args) {
        stringOperations();
        localVariableVar();
        nestBasedAccessControl();
    }

    class Inner {
        Inner(){}
    }
}
