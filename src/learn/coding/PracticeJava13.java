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

    /**
     * Enhancement in Switch Expression
     */
    public static void switchEnhancements(){
        int choice = 2;

        // multi-label case statements
        // yield to returns
        int x = switch (choice) {
            case 1,2,3:
                yield choice;
            default:
                yield -1;
        };

        logger.info(() -> x + "");
    }

    public static void main(String[] args) {
        textBlockString();
        stringNewMethods();
        switchEnhancements();
    }
}
