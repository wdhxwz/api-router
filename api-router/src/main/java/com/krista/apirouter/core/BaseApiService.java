package com.krista.apirouter.core;

import com.krista.apirouter.exception.ApiException;
import com.krista.apirouter.request.ApiParam;

/**
 * Created by Administrator on 2018/3/23.
 */
public class BaseApiService implements ApiService{

    @Override
    public ApiParam execute(ApiParam param) throws ApiException{
        ApplicationContextEnvironment.excuteApi(param);

        return  null;
    }
}
