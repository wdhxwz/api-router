package com.krista.apirouter.response;

/**
 * 没有响应码
 * Created by Administrator on 2018/3/23.
 */
public enum NullResponseCode implements ResponseCode<String>{
    /**
     * 空响应码
     */
    EmptyCode("Empty","Empty Message")
    ;
    NullResponseCode(String code,String message){
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}