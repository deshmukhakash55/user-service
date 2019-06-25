package com.xperphile.userservice.utility;

import com.xperphile.userservice.constants.UserConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringListConvertor {

    public static List<String> convertStringToList(String listString){
        List<String> list = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(listString, UserConstants.DELIMITER);
        while (tokenizer.hasMoreElements()){
            String item = tokenizer.nextElement().toString();
            list.add(item);
        }
        return list;
    }

    public static String convertListToString(List<String> list){
        String string = "";
        for (String item : list)
            string = string.concat(item);
        return string;
    }

}