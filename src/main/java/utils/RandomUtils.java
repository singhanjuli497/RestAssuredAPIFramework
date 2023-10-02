package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtils {

    public static String getRandomStringValue(int charCount){
        return RandomStringUtils.random(charCount, true, false);
    }

    public static int getRandomIntValue(int charCount){
        return Integer.parseInt(RandomStringUtils.random(charCount, false, true));
    }

    public static String getRandomAlphaNumericValue(int charCount){
        return RandomStringUtils.random(charCount, true, true);
    }

    public static String getRandomLongValue(int charCount){
        return RandomStringUtils.random(charCount, false, true);
    }


}
