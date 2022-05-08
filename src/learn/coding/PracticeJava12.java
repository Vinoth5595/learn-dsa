package learn.coding;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Practice Java 12
 */
public class PracticeJava12 {
    public static final Logger logger = Logger.getLogger(PracticeJava12.class.getName());

    /**
     * Switch Expression Changes
     */
    public static void switchChanges(){
        String day = "M";
        String strDay = switch(day) {
            case "M", "W", "F" -> "MWF";
            case "T",  "TH","S" -> "TTHS";
            default -> "Looks like a Sunday";
        };

        logger.log(Level.INFO,  () -> strDay);
    }

    /**
     * Files mismatch method
     */
    public static void filesMismatch(){
        try {
            // Create files
            Path filePath1 = Files.createTempFile("file1", ".txt");
            Path filePath2 = Files.createTempFile("file2", ".txt");

            Files.writeString(filePath1, "I am Vinoth");
            Files.writeString(filePath2, "I am Vinoth");

            long mismatch = Files.mismatch(filePath1, filePath2);
            logger.log(Level.INFO, () -> "Mismatch position in file1 and file2 : " + mismatch);

            filePath1.toFile().deleteOnExit();
            filePath2.toFile().deleteOnExit();

            Path filePath3 = Files.createTempFile("file3",  ".txt");
            Path filePath4 = Files.createTempFile("file4",  ".txt");

            Files.writeString(filePath3, "I am Vinoth");
            Files.writeString(filePath4, "I am Nirmal");

            long misMatch = Files.mismatch(filePath3, filePath4);
            logger.info(() -> "mismatch position in file1 and file2 : " + misMatch);
        } catch (IOException e) {
            logger.info(e.toString());
        }
    }

    /**
     * Main method
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        switchChanges();
        filesMismatch();
    }
}
