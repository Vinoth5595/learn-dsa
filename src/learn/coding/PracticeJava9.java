package learn.coding;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

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
        Add<Integer> addition = (a, b) -> a + b;

        LOG.log(Level.INFO, "{0}", addition.add(1,2));
    }

    public static void optionalApiAdditions(){
        Optional<String> optional1 = Optional.of("first");
        Optional<String> optional2 = Optional.of("second");


        // "or" utility method
        Optional<String> result = optional1.or(() -> optional2);
        LOG.log(Level.INFO, "{0}", result.orElse(""));

        optional1 = Optional.empty();

        result = optional1.or(() -> optional2);

        LOG.log(Level.INFO, "{0}", result.orElse(""));

        // "ifPresentOrElse" utility method
        AtomicInteger atomicInteger1 = new AtomicInteger(0);
        AtomicInteger atomicInteger2 = new AtomicInteger(0);
        optional2.ifPresentOrElse(t -> atomicInteger2.incrementAndGet(), atomicInteger1::incrementAndGet);

        LOG.log(Level.INFO,  () -> atomicInteger1 + " : " + atomicInteger2);

        // "stream" method in Optional Class
        List<String> list = optional2.stream().toList();
        LOG.log(Level.INFO, "{0}", String.valueOf(list));
    }

    @Deprecated(since = "11-12-2021", forRemoval = true)
    public static void streamApiImprovements(){
        // takeWhile
        Stream.of(1,2,3,4,5,6,7,8,9,10).takeWhile(i -> i < 5).forEach(System.out::println);
        // dropWhile
        Stream.of(1,2,3,4,5,6,7,8,9,10).dropWhile(i -> i < 5).forEach(System.out::println);
        // iterate
        Stream.iterate(0, i -> i < 10, i -> i + 1).forEach(System.out::println);
        // Stream.ofNullable
        Stream.ofNullable(null).forEach(System.out::println);
    }

    public static void main(String[] args) {
        testUtilityMethods();
        PrivateInterface.callPrivateInterface();
        processApiImprovements();
        resourceManagementJava9();
        diamondOperatorInAnonymousInnerClass();
        optionalApiAdditions();
        streamApiImprovements();
    }
}


