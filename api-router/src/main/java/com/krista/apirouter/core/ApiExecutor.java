package com.krista.apirouter.core;

import com.krista.apirouter.exception.ApiException;
import com.krista.apirouter.request.ApiParam;

/**
 * Api执行器<br/>
 * 不进行异常处理,由最外层进行处理
 * Created by Administrator on 2018/3/23.
 */
public class ApiExecutor implements ApiService{
    /**
     * 执行Api
     * @param apiParam
     */
    public ApiParam execute(ApiParam apiParam) throws ApiException{

        return  null;
    }
}