package learn.coding;

import java.io.BufferedReader;
import java.io.FileReader;
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
 * Interface for Add
 *
 * @param <T> Type
 */
interface Add<T>{
    T add(Integer a, Integer b);
}

/**
 * Practice Java 9
 */
public class PracticeJava9 {
    private static final Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * Some new utility methods
     */
    public static void testUtilityMethods(){
        List.of(1,2,3).forEach(v -> LOG.log(Level.INFO,  String.valueOf(v)));
        Map.of(1, "One", 2, "Two").forEach((k,v) -> LOG.log(Level.INFO,  String.valueOf(v)));
    }

    /**
     * Process API Improvements
     */
    public static void processApiImprovements(){
        ProcessHandle currentProcess = ProcessHandle.current();
        LOG.log(Level.INFO, "{0}", String.valueOf(currentProcess));
    }

    /**
     * try-with-resources improvement in Java 9
     */
    public static void resourceManagementJava9(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("abc.txt"));
            try (bufferedReader){
                LOG.log(Level.INFO, "{0}", bufferedReader.readLine());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void diamondOperatorInAnonymousInnerClass(){
        Add<Integer> addition = new Add<Integer>() {
            @Override
            public Integer add(Integer a, Integer b) {
                return a + b;
            }
        };

        LOG.log(Level.INFO,  String.valueOf(addition.add(1,2)));
    }

    public static void main(String[] args) {
        testUtilityMethods();
        PrivateInterface.callPrivateInterface();
        processApiImprovements();
        resourceManagementJava9();
        diamondOperatorInAnonymousInnerClass();
    }
}


