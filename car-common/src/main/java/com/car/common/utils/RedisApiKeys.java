package com.car.common.utils;

/**
 * Redis所有Keys
 *
 * @author wind
 * @since 3.0.0 2017-07-18
 */
public class RedisApiKeys {

    public static String getExerciseContentKey(long sectionId){
        return "learn:exerciseContent:sectionId:" + sectionId;
    }

    public static String getProjectKey(String key){
        return "find:project:" + key;
    }
    
    public static String getTokenKey(long userId){
        return "login:token:" + userId;
    }
    
    public static String getParamSetKey(){
        return "login:paramSet";
    }
    
}
