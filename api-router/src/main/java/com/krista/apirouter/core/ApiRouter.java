package com.krista.apirouter.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;

/**
 * Api路由，Web模式启动
 */
public class ApiRouter implements ApplicationContextAware {
    private static Logger logger = LoggerFactory.getLogger(ApiRouter.class);

    /**
     * Spring容器
     */
    private ApplicationContext applicationContext;

    /**
     * Api上下文
     */
    private ApiContext apiContext;

    /**
     * ApplicationContextAware接口实现
     * @param applicationContext
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 启动ApiRouter
     */
    public void startup() {
        if (logger.isInfoEnabled()) {
            logger.info(">>>>>>>>开始启动ApiRouter...");
        }
        Assert.notNull(this.applicationContext, "Spring上下文不能为空");
        apiContext =new ApiContext();
        apiContext.loadApi(applicationContext);
//        if (null == requestHeadValidator) {
//            requestHeadValidator = new DefaultRequestHeadValidator(apiRegister);
//        }

        if (logger.isInfoEnabled()) {
            logger.info(">>>>>>>>ApiRouter启动成功！api个数:{}",apiContext.getApiCount());
        }
    }
}