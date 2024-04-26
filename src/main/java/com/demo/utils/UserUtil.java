package com.demo.utils;

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

}
