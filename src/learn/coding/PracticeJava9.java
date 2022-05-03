package learn.coding;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Practice Java 9
 */
public class PracticeJava9 {
    private static final Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void testUtilityMethods(){
        LOG.log(Level.INFO, "Hello World");
    }

    public static void main(String[] args) {
        testUtilityMethods();
    }
}
