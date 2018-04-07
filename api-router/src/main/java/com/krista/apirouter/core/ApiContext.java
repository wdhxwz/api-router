package com.krista.apirouter.core;

import com.krista.apirouter.annotation.Api;
import com.krista.apirouter.bean.ApiEntity;
import com.krista.apirouter.enumerate.ObsoletedType;
import com.krista.apirouter.exception.ApiException;
import com.krista.apirouter.response.ApiResponseCode;
import com.krista.apirouter.utils.ApiUtil;
import com.krista.apirouter.utils.LocalCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * 缓存api接口信息
 * Created by Administrator on 2018/3/22.
 */
public class ApiContext {
    private static Logger logger = LoggerFactory.getLogger(ApiContext.class);

    /**
     * 缓存api信息<br/>
     * key:模块编号+"."+接口编号+"."+版本号
     */
    private Map<String, ApiEntity> apiMap = new HashMap<>(16);

    /**W
     * Api集合,元素内容为module + "." + apiNo
     */
    private final Set<String> apiSet = new HashSet<String>();

    /**
     * 从Spring上下文中加载Api信息
     */
    public void loadApi(ApplicationContext context) throws ApiException {
        if(logger.isDebugEnabled()){
            logger.debug("对Spring上下文中的Bean进行扫描，查找Api服务方法: " + context);
        }

        Map beanMap = context.getBeansWithAnnotation(Api.class);
        Iterator localIterator = beanMap.keySet().iterator();
        while (localIterator.hasNext()){
            String key = (String) localIterator.next();
            Object bean = beanMap.get(key);

            // 接口需要继承AbstractApiService并实现模板方法
            if(!(bean instanceof  AbstractApiService)) {
               logger.warn(">>>>>接口 {} 没有继承AbstractApiService类",key);
               continue;
            }

            // 必须打上Api注解并且继承相应接口
            Api api = bean.getClass().getAnnotation(Api.class);
            if(api == null){
                logger.info(">>>>>>接口:{} 未打上Api注解",key);
                continue;
            }else{
                ApiEntity apiEntity = new ApiEntity();
                String apiKey = ApiUtil.apiWithVersion(api.module(),api.apiNo(),api.version());

                Type type = ((ParameterizedType)bean.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
                LocalCache.addRequestParamType(apiKey,(Class)type);

                apiEntity.setApiInfo(bean);
                apiEntity.setDescription(api.description());
                apiEntity.setObsoleted(ObsoletedType.isObsoleted(api.obsoleted()));

                // 不能有重复键
                if(apiMap.containsKey(apiKey)){
                    throw new ApiException(ApiResponseCode.RepeatApiKey);
                }

                apiSet.add(ApiUtil.apiWithoutVersion(api.module(),api.apiNo()));
                apiMap.put(apiKey,apiEntity);

                logger.info(">>>>> 加载接口:{}({})",bean.getClass().getName(),api.description());
            }
        }
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