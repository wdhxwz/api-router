package com.krista.apirouter.request;

import java.io.Serializable;
import java.util.Map;

/**
 * 接口的参数实体
 * Created by Administrator on 2018/3/22.
 */
public class ApiParam implements Serializable{
    private static final long serialVersionUID = -1L;

    /**
     * 请求头
     */
    private Head head;

    /**
     * 请求体
     */
    private Map<String,String> body;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Map<String, String> getBody() {
        return body;
    }

    public void setBody(Map<String, String> body) {
        this.body = body;
    }
}