package com.krista.apirouter.utils;

import com.krista.apirouter.exception.ApiException;
import com.krista.apirouter.request.Head;

/**
 * Api工具类
 */
public class ApiUtil {
    /**
     * 工具类，不允许实例化
     */
    private ApiUtil(){
    }

    /**
     * 分割标志
     */
    private static final String SPLIT_FLAG = ".";

    /**
     * 拼接字符串
     * @param module
     * @param apiNo
     * @param version
     * @return
     */
    public static String apiWithVersion(String module,String apiNo,String version){
        return  module + SPLIT_FLAG + apiNo + SPLIT_FLAG + version;
    }

    /**
     * 拼接字符串
     * @param module
     * @param apiNo
     * @return
     */
    public static String apiWithoutVersion(String module,String apiNo){
        return  module + SPLIT_FLAG + apiNo;
    }
}