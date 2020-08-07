package com.cw.chat.api;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Cw
 * @date 2020/8/6
 */
public class ChatApi {
    private static Map<Class, Object> apiMap = new HashMap<>();

    public static <T> void register(Class<T> clazz, T contact) {
        apiMap.put(clazz, contact);
    }

    public static <T> void unregister(Class<T> clazz) {
        apiMap.remove(clazz);
    }

    public static <T> T get(Class<T> clazz) {
        if (apiMap.containsKey(clazz)) {
            return (T) apiMap.get(clazz);
        }
        return null;
    }
}
