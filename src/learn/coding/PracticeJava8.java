package learn.coding;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PracticeJava8 {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * Main class
     *
     * @param args command line argument
     */
    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "Hello World");
        forEachIterable();
    }

    /**
     * forEach() method in Iterable interface
     */
    public static void forEachIterable(){
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        integerList.forEach(i -> LOGGER.log(Level.INFO, String.valueOf(i)));
    }
}
