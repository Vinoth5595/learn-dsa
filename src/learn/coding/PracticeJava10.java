package learn.coding;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PracticeJava10 {
    public static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void checkVersion(){
        logger.log(Level.INFO,"Version : {0}", Runtime.version());
    }

    public static void localVariableTypeInference(){
        var numbers = Arrays.asList(1,2,3);

        for(var num: numbers){
            logger.log(Level.INFO,  "{0}",  num);
        }

        for(var i = 0; i < numbers.size(); i++){
            logger.log(Level.INFO,  "{0}", numbers.get(i));
        }
    }

    public static void main(String[] args) {
        checkVersion();
        localVariableTypeInference();
    }
}
