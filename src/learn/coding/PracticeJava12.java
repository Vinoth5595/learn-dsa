package learn.coding;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Practice Java 12
 */
public class PracticeJava12 {
    public static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * Switch Expression Changes
     */
    public static void switchChanges(){
        String day = "M";
        String strDay = switch(day) {
            case "M", "W", "F" -> "MWF";
            case "T",  "TH","S" -> "TTHS";
            default -> "Looks like a Sunday";
        };

        logger.log(Level.INFO,  () -> strDay);
    }

    /**
     * Main method
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        switchChanges();
    }
}
