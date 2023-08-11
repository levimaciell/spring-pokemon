package com.pkmn.api.Utils;

public class Utils {
    
    /**
     * 
     * @param string String 
     * @return A Capitalized string, if not null. If null or empty, it will return the original string
     */
    public static String capitalizeString(String string){

        if(string != null && !string.isBlank()){

            return (string.substring(0, 1).toUpperCase()) + (string.substring(1).toLowerCase());

        }

        return string;
    }

}
