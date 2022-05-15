package learn.coding;

import java.util.logging.Logger;

record GrandParent(){}
record Parent(){}
record Child(){}

/**
 * Practice Java 17
 */
public class PracticeJava17 {
    public static final Logger logger = Logger.getLogger(PracticeJava17.class.getName());

    public static String checkType(Object obj){
        return switch(obj) {
            case GrandParent g -> "I am gandparent " + g;
            case Parent p -> "I am parent " + p;
            case Child c -> "I am child " + c;
            default -> "default";
        };
    }

    /**
     * Main method
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        logger.info(() -> checkType(new GrandParent()));
        logger.info(() -> checkType(new Parent()));
        logger.info(() -> checkType(new Child()));
    }
}
