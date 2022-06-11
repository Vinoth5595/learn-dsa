package learn.coding;

import java.util.logging.Logger;

public class LongestPalindrome {
    public static final Logger log = Logger.getLogger(LongestPalindrome.class.getName());

    public static void longestPalindromicSubstring(String str){
        int length = str.length();
        int maxLength = 1, start = 0;

        for(int i = 0; i < str.length(); i++){
            for(int j = i; j < str.length(); j++){
                int flag = 1;

                for(int k = 0; k < (j - i + 1) / 2; k++){
                    if(str.charAt(i + k) != str.charAt(j - k)){
                        flag = 0;
                    }
                }

                if(flag != 0 && (j - i + 1) > maxLength){
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }

        log.info(str.substring(start, (start + maxLength)));
    }

    public static void main(String[] args) {
        longestPalindromicSubstring("forgeeksskeegfor");
    }
}
