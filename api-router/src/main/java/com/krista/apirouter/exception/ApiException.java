package com.krista.apirouter.exception;

import com.krista.apirouter.response.ApiResponseCode;
import com.krista.apirouter.response.ResponseCode;

/**
 * 接口异常
 */
public class ApiException extends Exception{
    private static final long serialVersionUID = -1L;

    /**
     * 响应码
     */
    private ResponseCode responseCode;

    public ApiException(String message){
        super(message);
        this.responseCode = ApiResponseCode.EmptyCode;
    }

    public ApiException(ResponseCode responseCode){
        this.responseCode = responseCode;
    }

    public ApiException(String message,ResponseCode responseCode){
        super(message);
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