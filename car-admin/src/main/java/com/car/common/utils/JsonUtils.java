package com.car.common.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JsonUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    static
    {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <T> T readValue(String json, Class<T> valueType)
    {
        T type = null;
        try
        {
            type = mapper.readValue(json, valueType);
        }
        catch (JsonParseException e)
        {
            System.out.println(e);
        }
        catch (JsonMappingException e)
        {
            System.out.println(e);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        return type;
    }

    public static <T> T readValue(String json, JavaType valueType)
    {
        T type = null;
        try
        {
            type = mapper.readValue(json, valueType);
        }
        catch (JsonParseException e)
        {
            System.out.println(e);
        }
        catch (JsonMappingException e)
        {
            System.out.println(e);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        return type;
    }

    public static <T> List<T> readValueByList(String json, Class<T> valueType)
    {
        JavaType javaType = getCollectionType(List.class, valueType);
        return readValue(json, javaType);
    }

    public static String writeValueAsString(Object value)
    {
        String json = null;
        try
        {
            json = mapper.writeValueAsString(value);
        }
        catch (JsonProcessingException e)
        {
            System.out.println(e);
        }
        return json;
    }

    public static <T> T readValue(String json, Class<?> collectionClass, Class<?>... elementClasses)
    {
        return readValue(json, getCollectionType(collectionClass, elementClasses));
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses)
    {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
