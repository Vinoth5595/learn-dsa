package learn.coding;

import java.util.logging.Logger;

abstract sealed class Person permits IAmFinal, IAmNonSealed {
    int a = 10;
}

final class IAmFinal extends Person {
}

non-sealed class IAmNonSealed extends Person {
}


/**
 * Practice Java 15 Features
 */
public class PracticeJava15 {
    public static final Logger logger = Logger.getLogger(PracticeJava15.class.getName());

    /**
     * Working with sealed feature
     */
    public static void sealedFeature(){
        IAmFinal iAmFinal = new IAmFinal();
        int a = iAmFinal.a;
        
        IAmNonSealed iAmNonSealed = new IAmNonSealed();
        int a1 = iAmNonSealed.a;

        logger.info(() -> a + " : " + a1);
    }

    /**
     * Main Method
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        sealedFeature();
    }
}
