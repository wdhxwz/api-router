package com.krista.apirouter.request;

import java.io.Serializable;

/**
 * 服务请求头部信息
 * Created by Administrator on 2018/3/22.
 */
public class Head implements Serializable{
    private static final long serialVersionUID = -1L;

    /**
     * 模块名称
     */
    private String module;
    /**
     * 接口编号
     */
    private String apiNo;
    /**
     * 版本号
     */
    private String version;
    /**
     * 请求id
     */
    private String requestId;
    /**
     * 请求时间,格式yyyyMMddHHmmss
     */
    private String reqeustTime;
    /**
     * 会话id
     */
    private String sessionId;
    /**
     * 请求方IP
     */
    private String reqeustIp;
    /**
     * 请求方id
     */
    private String callerId;

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getApiNo() {
        return apiNo;
    }

    public void setApiNo(String apiNo) {
        this.apiNo = apiNo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getReqeustTime() {
        return reqeustTime;
    }

    public void setReqeustTime(String reqeustTime) {
        this.reqeustTime = reqeustTime;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getReqeustIp() {
        return reqeustIp;
    }

    public void setReqeustIp(String reqeustIp) {
        this.reqeustIp = reqeustIp;
    }

    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }
}