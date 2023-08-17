package com.pkmn.api.utils;

import com.pkmn.api.exceptions.UtilsException;
import com.pkmn.api.user.dto.UserIdDto;
import com.pkmn.api.user.entities.User;

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


    public static User userDtoToUser(UserIdDto user) throws UtilsException{

        if(user == null){
            throw new UtilsException("User Informed is null !");
        }
        else{
            if(user.getPassword().isBlank()){
                throw new UtilsException("User Informed has a blank password!");
            }

            else if(user.getUserName().isBlank()){
                throw new UtilsException("User Informed has a blank userName!\nUsername = " + user.getUserName());
            }
        }

        User userReturn = new User();
        //userReturn.setId(user.getId());
        userReturn.setPassword(user.getPassword());
        userReturn.setUserName(user.getUserName());

        return userReturn;
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
