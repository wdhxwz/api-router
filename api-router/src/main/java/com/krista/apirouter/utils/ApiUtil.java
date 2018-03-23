package com.krista.apirouter.utils;

/**
 * Api工具类
 */
public class ApiUtil {
    public static String apiWithVersion(String module,String apiNo,String version){
        return  module + "." + apiNo + "." + version;
    }

    public static String apiWithoutVersion(String module,String apiNo){
        return  module + "." + apiNo;
    }
}