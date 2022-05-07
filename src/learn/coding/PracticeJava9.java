package learn.coding;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

interface PrivateInterface {
    Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static void privateMethodImplementation(){
        LOG.log(Level.INFO, "Calling private method inside interface");
    }

    static void callPrivateInterface(){
        privateMethodImplementation();
    }
}

/**
 * Practice Java 9
 */
public class PracticeJava9 {
    private static final Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void testUtilityMethods(){
        List.of(1,2,3).forEach(v -> LOG.log(Level.INFO,  String.valueOf(v)));
        Map.of(1, "One", 2, "Two").forEach((k,v) -> LOG.log(Level.INFO,  String.valueOf(v)));
    }

    public static void processApiImprovements(){
        ProcessHandle currentProcess = ProcessHandle.current();
        LOG.log(Level.INFO, "{0}", String.valueOf(currentProcess));
    }

    public static void main(String[] args) {
        testUtilityMethods();
        PrivateInterface.callPrivateInterface();
        processApiImprovements();
    }
}


