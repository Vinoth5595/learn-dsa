package learn.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Functional Interface
 */

@FunctionalInterface
interface SampleInterface {
    void hello(String val);
}

/**
 * Operting System interface
 */
interface OperatingSystem {
    Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    default void iAmDefault(){
        LOG.log(Level.INFO, "Calling default method");
    }

    static void iAmStatic(){
        LOG.log(Level.INFO, "Calling Static Method");
    }
}

public class PracticeJava8 implements OperatingSystem {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * Main class
     *
     * @param args command line argument
     */
    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "Hello World");
        PracticeJava8 practiceJava8 = new PracticeJava8();
        forEachIterable();
        staticInterface();
        practiceJava8.defaultInterface();
        functionalInterface();
        streamAPIMethods();
    }

    /**
     * forEach() method in Iterable interface
     */
    public static void forEachIterable(){
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        integerList.forEach(i -> LOGGER.log(Level.INFO, String.valueOf(i)));
    }

    /**
     * Static method implementation in interface
     */
    public static void staticInterface(){
        OperatingSystem.iAmStatic();
    }

    /**
     * Default method implementation in interface
     */
    public void defaultInterface(){
        iAmDefault();
    }

    /**
     * Functional Interface
     */
    public static void functionalInterface(){
        SampleInterface sampleInterface = i -> LOGGER.log(Level.INFO, () -> i);
        sampleInterface.hello("Called by lambda expression");
    }

    /**
     * Sequential and parallel streams
     */
    public static void streamAPIMethods(){
        List<Integer> integerList = new ArrayList<>();
        for(int i = 0; i <= 100; i++) integerList.add(i);

        integerList.stream().filter(i  -> i > 90).forEach(i -> LOGGER.log(Level.INFO, () -> String.valueOf(i)));
        integerList.parallelStream().filter(i -> i > 90).forEach(i -> LOGGER.log(Level.INFO, () -> String.valueOf(i)));
    }
}
