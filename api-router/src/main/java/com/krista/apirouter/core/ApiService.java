package com.krista.apirouter.core;

import com.krista.apirouter.exception.ApiException;
import com.krista.apirouter.request.ApiParam;

/**
 * Api服务接口
 * Created by Administrator on 2018/3/23.
 */
public interface ApiService {
    public abstract ApiParam execute(ApiParam param) throws ApiException;
}
