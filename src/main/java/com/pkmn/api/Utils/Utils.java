package com.pkmn.api.utils;

import com.pkmn.api.user.dto.UserIdDto;

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

    public static boolean isUserValid(UserIdDto user){
        if(user == null){
            return false;
        }
        else{
            if(user.getPassword().isBlank()){
                return false;
            }

            else if(user.getUserName().isBlank()){
                return false;
            }
        }

        return true;
    }

}
