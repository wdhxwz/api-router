package com.krista.apirouter.core;

import com.krista.apirouter.request.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 应用上下文环境
 * Created by Administrator on 2018/3/23.
 */
public class ApplicationContextEnvironment {
    private static Logger logger = LoggerFactory.getLogger(ApplicationContextEnvironment.class);

    private static ApiContext apiContext = new ApiContext();

    private static ApplicationContext applicationContext;

    public  static ApiContext getApiContext(){
        return apiContext;
    }

    public static void startSpringContext(String springConfigClassPath) throws Exception{
        if(StringUtils.isEmpty(springConfigClassPath)){
            throw new IllegalArgumentException("配置文件路径为空");
        }
        logger.info(">>>>>>启动Spring容器:{}",springConfigClassPath);
        applicationContext = new ClassPathXmlApplicationContext(springConfigClassPath);
        logger.info(">>>>>>启动Spring容器完成:{}",springConfigClassPath);
    }

    public static void loadApi(){
        apiContext.loadApi(applicationContext);
        logger.info(">>>>>>加载api数量{}个",apiContext.getApiCount());
    }

    public static void excuteApi(ApiParam param){

    }
}
