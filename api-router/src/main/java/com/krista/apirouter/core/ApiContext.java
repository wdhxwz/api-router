package com.krista.apirouter.core;

import com.krista.apirouter.bean.ApiEntity;
import com.krista.apirouter.utils.ApiUtil;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
     * Api集合,元素内容为module + "." + apiNo
     */
    private final Set<String> apiSet = new HashSet<String>();

    /**
     * 从Spring上下文中加载Api信息
     */
    public void loadApi(ApplicationContext applicationContext) {

    }

    /**
     * 获取指定的api信息
     * @param moduleName 模块名称
     * @param apiNo api编号
     * @param version 版本号
     * @return
     */
    public ApiEntity getApiEntity(String moduleName, String apiNo, String version) {
        String key = ApiUtil.apiWithVersion(moduleName,apiNo,version);

        return apiMap.get(key);
    }

    /**
     * 获取注册的api数量
     * @return
     */
    public int getApiCount() {
        return apiMap.size();
    }

    /**
     * 判断api是否有效
     * @param module 模块名称
     * @param apiNo api编号
     * @return
     */
    public boolean isValidApi(String module,String apiNo){
        String apiKey = ApiUtil.apiWithoutVersion(module,apiNo);

        return apiSet.contains(apiKey);
    }

    /**
     * 指定版本号是否有效（包括不存在和过期）
     * @param module 模块名称
     * @param apiNo  api编号
     * @param version 版本号
     * @return
     */
    public boolean isValidVersion(String module,String apiNo, String version) {
        String key = ApiUtil.apiWithVersion(module,apiNo,version);
        ApiEntity apiEntity = apiMap.get(key);

        return apiEntity != null && !apiEntity.isObsoleted();
    }
}