package learn.coding;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PracticeJava10 {
    public static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void checkVersion(){
        logger.log(Level.INFO,"Version : " + Runtime.version());
    }

    public static void main(String[] args) {
        checkVersion();
    }
}
