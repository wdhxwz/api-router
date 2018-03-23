package com.krista.apirouter.exception;

import com.krista.apirouter.response.NullResponseCode;
import com.krista.apirouter.response.ResponseCode;

/**
 * 接口异常
 */
public class ApiException extends Exception{
    /**
     * 响应码
     */
    private ResponseCode responseCode;

    public ApiException(String message){
        super(message);
        this.responseCode = NullResponseCode.EmptyCode;
    }

    public ApiException(ResponseCode responseCode){
        this.responseCode = responseCode;
    }

    /**
     * 不收集异常堆栈信息
     * @return
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    /**
     * 获取响应码
     * @return
     */
    public ResponseCode getResponseCode() {
        return responseCode;
    }
}