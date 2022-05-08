package learn.coding;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PracticeJava11 {
    public static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

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

    public static void main(String[] args) {
        stringOperations();
    }
}
