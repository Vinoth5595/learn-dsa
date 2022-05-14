package learn.coding;

import java.util.logging.Logger;

record Author(Integer id, String name){
    public static final Logger logger = Logger.getLogger(Author.class.getName());

    public Author{
        if(id < 0){
            throw new IllegalArgumentException("Author id can't be negative");
        }
    }

    public void test(){
        logger.info(() -> "test() method called!!!");
    }
}

public class PracticeJava14 {
    public static final Logger logger = Logger.getLogger(PracticeJava14.class.getName());

    /**
     * Helpful NullPointerExceptions
     */
    public static void helpfulNPE(){
        Object a = null;
        //a.hashCode(); // Commented to avoid NPE
     }

    /**
     * Record in Java
     */
    public static void recordTesting(){
        Author author = new Author(1, "Vinoth");
        logger.info(() -> author.name());

        // calling method inside Java Record
        author.test();
    }

    public static void main(String[] args) {
        helpfulNPE();
        recordTesting();
    }
}
