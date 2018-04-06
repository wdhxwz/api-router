package com.krista.apirouter.core;

import com.krista.apirouter.exception.ApiException;
import com.krista.apirouter.request.ApiParam;
import com.krista.apirouter.response.ApiResponseCode;
import com.krista.apirouter.utils.BeanMapper;
import com.krista.apirouter.utils.JsonUtil;

import java.util.Map;

/**
 * 抽象Api服务，使用模板模式设计
 */
public abstract class AbstractApiService<TRequest,TResponse> implements ApiService {

    private TRequest data;

    /**
     * 模板方法
     * @param request
     * @return
     */
    protected abstract TResponse handle(TRequest request) throws ApiException;

    @Override
    public ApiParam execute(ApiParam param) throws ApiException {
        Map body = param.getBody();
        if(body == null || body.isEmpty()){
            throw new ApiException(ApiResponseCode.RequestBodyIsEmpty);
        }
       TRequest request = (TRequest)BeanMapper.map(body,data.getClass());
       TResponse responseBody =handle(request);

       ApiParam response = new ApiParam();
       BeanMapper.copy(param,response);
       if(!(responseBody instanceof Void)){
           response.setBody(BeanMapper.map(responseBody,Map.class));
       }else {
           response.setBody(null);
       }
        return response;
    }
}