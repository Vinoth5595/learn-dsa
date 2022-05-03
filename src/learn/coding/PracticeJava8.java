package learn.coding;

import java.time.*;
import java.util.*;
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

    static void iAmStatic() {
        LOG.log(Level.INFO, "Calling Static Method");
    }

    default void iAmDefault() {
        LOG.log(Level.INFO, "Calling default method");
    }
}

public class PracticeJava8 implements OperatingSystem {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    /**
     * forEach() method in Iterable interface
     */
    public static void forEachIterable() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        integerList.forEach(i -> LOGGER.log(Level.INFO, String.valueOf(i)));
    }

    /**
     * Static method implementation in interface
     */
    public static void staticInterface() {
        OperatingSystem.iAmStatic();
    }

    /**
     * Functional Interface
     */
    public static void functionalInterface() {
        SampleInterface sampleInterface = i -> LOGGER.log(Level.INFO, () -> i);
        sampleInterface.hello("Called by lambda expression");
    }

    /**
     * Sequential and parallel streams
     */
    public static void streamAPIMethods() {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i <= 100; i++) integerList.add(i);

        integerList.stream().filter(i -> i > 90).forEach(i -> LOGGER.log(Level.INFO, () -> String.valueOf(i)));
        integerList.parallelStream().filter(i -> i > 90).forEach(i -> LOGGER.log(Level.INFO, () -> String.valueOf(i)));
    }

    /**
     * Java 8 Date Time API
     */
    public static void javaDateTimeAPI() {
        LocalDate localDate = LocalDate.now(); // Get Current Date
        LocalTime localTime = LocalTime.now(); // Get Current Time
        LOGGER.log(Level.INFO, () -> localDate + " " + localTime);

        LocalTime localTime1 = LocalTime.now(ZoneId.of("Asia/Kolkata"));
        LOGGER.log(Level.INFO, () -> localTime1 + "");

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTimeKolkata = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        LOGGER.log(Level.INFO, () -> localDateTime + " " + localDateTimeKolkata);

        Instant timestamp = Instant.now();
        Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
        LOGGER.log(Level.INFO, () -> timestamp + " " + specificTime);
    }

    /**
     * Collection API Improvements
     */
    public static void collectionApiImprovements() {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i <= 5; i++) integerList.add(i);

        Iterator<Integer> iterable = integerList.iterator();
        iterable.forEachRemaining(i -> LOGGER.log(Level.INFO, String.valueOf(i)));

        integerList.removeIf(i -> i > 2);
        LOGGER.log(Level.INFO, () -> String.valueOf(integerList.size()));
    }

    /**
     * HashTable vs HashMap difference
     */
    private static void hashTableVsHashMap() {
       try {
           Hashtable<Integer, Integer> hashtable = new Hashtable<>();
           hashtable.put(1, null); // throws Exception because value is null
           hashtable.put(null, 1); // throws Exception because key is null
       } catch (Exception e){
           LOGGER.log(Level.SEVERE, "Exception occurred", e);
       }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // HashMap accepts null in both key and value
        hashMap.put(null, 1);
        hashMap.put(1, null);

        LOGGER.log(Level.INFO, () -> String.valueOf(hashMap));
    }

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
        javaDateTimeAPI();
        collectionApiImprovements();
        hashTableVsHashMap();
    }

    /**
     * Default method implementation in interface
     */
    public void defaultInterface() {
        iAmDefault();
    }
}
