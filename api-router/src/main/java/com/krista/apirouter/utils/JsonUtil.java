package com.krista.apirouter.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * json工具类，使用阿里fastjson进行封装
 */
public class JsonUtil {
    /**
     * 工具类不允许实例化
     */
    private JsonUtil(){

    }

    /**
     * json转成对象
     * @param json
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T toObject(String json,Class<T> tClass){
        return JSONObject.parseObject(json,tClass);
    }

    /**
     * json转成对象
     * @param json
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> List<T> toObjectList(String json, Class<T> tClass){
        return JSONObject.parseArray(json,tClass);
    }

    /**
     * 对象转json
     * @param object
     * @return
     */
    public static String toJson(Object object){
        return  JSONObject.toJSONString(object);
    }
}
