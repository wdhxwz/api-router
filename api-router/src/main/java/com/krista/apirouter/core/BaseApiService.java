package com.krista.apirouter.core;

import com.krista.apirouter.exception.ApiException;
import com.krista.apirouter.request.ApiParam;

/**
 * Created by Administrator on 2018/3/23.
 *
 * @author krista
 */
public class BaseApiService implements ApiService {

    @Override
    public ApiParam execute(ApiParam param) throws ApiException {
        return ApplicationContextEnvironment.executeApi(param);
    }
}
