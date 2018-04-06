package com.krista.apirouter.core;

import com.krista.apirouter.bean.ApiEntity;
import com.krista.apirouter.exception.ApiException;
import com.krista.apirouter.request.ApiParam;
import com.krista.apirouter.request.Head;
import com.krista.apirouter.response.ApiResponseCode;
import com.krista.apirouter.utils.ApiUtil;
import com.krista.apirouter.utils.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

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
     *
     * @param applicationContext
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 启动ApiRouter
     */
    public void startup() throws ApiException {
        if (logger.isInfoEnabled()) {
            logger.info(">>>>>>>>开始启动ApiRouter...");
        }
        Assert.notNull(this.applicationContext, "Spring上下文不能为空");
        apiContext = new ApiContext();
        apiContext.loadApi(applicationContext);
        if (logger.isInfoEnabled()) {
            logger.info(">>>>>>>>ApiRouter启动成功！api个数:{}", apiContext.getApiCount());
        }
    }

    /**
     * 执行api服务
     * @param requestData
     * @throws ApiException
     */
    public ApiParam executeApi(String requestData) throws ApiException {
        // 请求的时候,参数为"",这里接收到的数据为"\"\"",因此不为空
        logger.info("请求的数据：{}" , requestData);

        // 参数为空
        if(StringUtils.isEmpty(requestData)){
            throw  new ApiException(ApiResponseCode.RequestDataIsEmpty);
        }

        // Url decode
        if (requestData.indexOf("%") > -1) {
            try {
                requestData = URLDecoder.decode(requestData, "utf-8");
            } catch (UnsupportedEncodingException e) {
                logger.info("url解码时遇到未知编码方式");
            }
        }

        // 解析出ApiParam
        ApiParam apiParam = null;
        try {
            apiParam = JsonUtil.toObject(requestData, ApiParam.class);
        } catch (Exception e) {
            logger.error("对象序列化失败", e);
        }

        return  this.executeApi(apiParam);
    }

    /**
     * 执行api服务
     * @param apiParam
     * @throws ApiException
     */
    public ApiParam executeApi(ApiParam apiParam) throws ApiException {
        // 参数格式错误
        if (apiParam == null) {
            logger.info("请求数据为空");
            throw new ApiException(ApiResponseCode.RequestDataFormatError);
        }

        // 验证参数头
        Head head = apiParam.getHead();
        if(head == null){
            logger.info("请求头为空");
            throw new ApiException(ApiResponseCode.RequestHeadIsEmpty);
        }

        String module = head.getModule();
        String apiNo = head.getApiNo();
        if(!apiContext.isValidApi(module,apiNo)){
            throw new ApiException(ApiResponseCode.ApiNoNotExist);
        }
        String version = head.getVersion();
        if(!apiContext.isValidVersion(module,apiNo,version)){
            throw new ApiException(ApiResponseCode.VersionIsNotAvailable);
        }

        // 获取Api信息,并执行Api
        ApiEntity apiEntity = apiContext.getApiEntity(module,apiNo,version);
        if(apiEntity == null){
            throw new ApiException(ApiResponseCode.ApiNoNotExist);
        }

        ApiService apiService = (ApiService)apiEntity.getApiInfo();

        return apiService.execute(apiParam);
    }
}