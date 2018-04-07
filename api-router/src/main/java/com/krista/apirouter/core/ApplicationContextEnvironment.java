package com.krista.apirouter.core;

import com.krista.apirouter.exception.ApiException;
import com.krista.apirouter.request.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 应用上下文环境,Java Application模式启动
 * Created by Administrator on 2018/3/23.
 */
public class ApplicationContextEnvironment {
    private static Logger logger = LoggerFactory.getLogger(ApplicationContextEnvironment.class);

    private static ApplicationContext applicationContext;

    public static void startSpringContext(String springConfigClassPath) throws Exception{
        if(StringUtils.isEmpty(springConfigClassPath)){
            throw new IllegalArgumentException("配置文件路径为空");
        }
        logger.info(">>>>>>启动Spring容器:{}",springConfigClassPath);
        applicationContext = new ClassPathXmlApplicationContext(springConfigClassPath);

        ApiRouter apiRouter = applicationContext.getBean(ApiRouter.class);
        if(apiRouter == null){
            throw new ApiException(">>>>> 没有配置ApiRouter");
        }

        logger.info(">>>>>>启动Spring容器完成:{}",springConfigClassPath);
    }

    public static ApiParam executeApi(ApiParam param) throws ApiException{
        ApiRouter apiRouter = applicationContext.getBean(ApiRouter.class);

        return apiRouter.executeApi(param);
    }
}