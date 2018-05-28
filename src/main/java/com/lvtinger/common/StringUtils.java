package com.lvtinger.common;

public class StringUtils {
    public static boolean isEmpty(String string){
        return string == null || string.length() == 0;
    }

    public static boolean isNotEmpty(String string){
        return !isEmpty(string);
    }

    public static String firstToLower(String string){
        if(string == null){
            return null;
        }

        if(string.length() == 0){
            return string;
        }

        return string.substring(0, 1).toLowerCase() + string.substring(1);
    }
}
