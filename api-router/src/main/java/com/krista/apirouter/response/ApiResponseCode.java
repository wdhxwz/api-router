package com.krista.apirouter.response;

/**
 * Api内置响应码
 * Created by Administrator on 2018/3/23.
 *
 * @author krista
 */
public enum ApiResponseCode implements ResponseCode<String> {
    /**
     * 空响应码
     */
    EmptyCode("Empty", "Empty Message"),

    /**
     * 重复的ApiKey
     */
    RepeatApiKey("5000", "apiKey is repeat"),
    /**
     * 请求参数为空
     */
    RequestDataIsEmpty("5001", "Request Data Is Empty"),
    /**
     * 请求参数格式错误
     */
    RequestDataFormatError("5002", "Request Data Format Error"),
    /**
     * 请求头为空
     */
    RequestHeadIsEmpty("5003", "Request Head Is Empty"),
    /**
     * 接口变化不存在
     */
    ApiNoNotExist("5004", "ApiNo Not Exist"),
    /**
     * 接口对应的版本无效
     */
    VersionIsNotAvailable("5005", "the version of apiNo is not available"),
    /**
     * 请求体为空
     */
    RequestBodyIsEmpty("5006", "RequestBody Is Empty"),
    /**
     * 参数异常
     */
    ParamError("5007", "Param Error");

    ApiResponseCode(String code, String message) {
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