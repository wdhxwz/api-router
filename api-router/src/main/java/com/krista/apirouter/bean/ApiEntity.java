package com.krista.apirouter.bean;

/**
 * Api 的额外信息
 * Created by Administrator on 2018/3/22.
 */
public class ApiEntity {
    /**
     * Api的类实例
     */
    private Object apiInfo;

    /**
     * Api描述
     */
    private String description;

    public Object getApiInfo() {
        return apiInfo;
    }

    public void setApiInfo(Object apiInfo) {
        this.apiInfo = apiInfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}