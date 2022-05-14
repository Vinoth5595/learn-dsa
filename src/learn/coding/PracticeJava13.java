package learn.coding;

import java.util.logging.Logger;

public class PracticeJava13 {
    public static final Logger logger = Logger.getLogger(PracticeJava13.class.getName());

    /**
     * Text Block String
     */
    public static void textBlockString(){
        String normalString = "Hi\nHello\nYes";
        String textBlock = """
				Hi
				Hello
				Yes""";

        logger.info(() -> (normalString == textBlock) + "");
        logger.info(() -> (normalString.equals(textBlock)) + "");
    }

    public static void main(String[] args) {
        textBlockString();
    }
}
