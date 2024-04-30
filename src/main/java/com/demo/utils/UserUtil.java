package com.demo.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by lw on @date 2024/4/26.
 */
public class UserUtil {

    private static Map<String, String> userMap = new HashMap<>();

    public static void put(String key, String value){
        FileUtil.writeToFile(key, value);
        userMap.put(key,value);
    }

    public static String get(String key){
        String resource = userMap.get(key);
        if(StringUtils.isBlank(resource)){
            userMap = FileUtil.readFromFile();
            return userMap.get(key);
        }
        return resource;
    }

}
