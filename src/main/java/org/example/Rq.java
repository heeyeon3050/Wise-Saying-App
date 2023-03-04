package org.example;

import java.util.HashMap;

// Rq는 Request(요청)이라는 뜻
public class Rq {
    private HashMap<String, String> map = new HashMap<>();

    public Rq(String command){
        String[] commandBits = command.split("\\?", 2);

        if(commandBits.length == 1 ) return;

        String[] paramsBits = commandBits[1].split("&");

        for(String str : paramsBits){
            String[] paramStrBits = str.split("=", 2);
            String key = paramStrBits[0];
            String value = paramStrBits[1];

            map.put(key, value);
        }
    }

    public int getIntParam(String id, int defaultValue){
        try {
            return Integer.parseInt(map.get(id));
        } catch(NumberFormatException e){
            return defaultValue;
        }
    }
}