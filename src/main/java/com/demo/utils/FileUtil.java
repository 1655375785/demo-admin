package com.demo.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by lw on @date 2024/4/26.
 */
public class FileUtil {

    private static final String FILE_PATH = "data.txt";

    public static void writeToFile(String key, String value) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH,true))) {
            if(!StringUtils.isBlank(UserUtil.get(key))){
                throw new RuntimeException("user is already exists");
            }
            writer.println(key + "-" + value);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (RuntimeException e){
            throw e;
        }
    }

    public static Map<String, String> readFromFile() {
        Map<String, String> keyValueMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-", 2);
                if (parts.length == 2) {
                    String key = parts[0];
                    String value = parts[1];
                    keyValueMap.put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return keyValueMap;
    }

}
