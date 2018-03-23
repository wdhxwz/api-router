package com.krista.apirouter.core;

import com.krista.apirouter.bean.ApiEntity;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * 缓存api接口信息
 * Created by Administrator on 2018/3/22.
 */
public class ApiContext {
    /**
     * 缓存api信息<br/>
     * key:模块编号+"."+接口编号+"."+版本号
     */
    private Map<String, ApiEntity> apiMap = new HashMap<>(16);

    /**
     * 从Spring上下文中加载Api信息
     */
    public void loadApi(ApplicationContext applicationContext) {

    }

    public ApiEntity getApiEntity(String moduleName, String apiNo, String version) {
        String key = moduleName + "." + apiNo + "." + version;

        return apiMap.get(key);
    }

    public int getApiCount() {
        return apiMap.size();
    }
}