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

    /**
     * New Methods in Strings
     */
    public static void stringNewMethods(){
        String data = "data is %s";
        logger.info(() -> data.formatted("1"));

        String textBlock = """
                Hi 
                      This is Vinoth
                             ***************
                """;

        logger.info(() -> textBlock.stripIndent());

        String str1 = "Hi\n\tHello' \" /u0022 Vinoth\r";
        logger.info(() -> str1.translateEscapes());
    }

    public static void main(String[] args) {
        textBlockString();
        stringNewMethods();
    }
}
