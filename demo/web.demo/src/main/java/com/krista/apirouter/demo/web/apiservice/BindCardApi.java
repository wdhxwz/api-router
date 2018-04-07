package com.krista.apirouter.demo.web.apiservice;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.krista.apirouter.annotation.Api;
import com.krista.apirouter.core.AbstractApiService;
import com.krista.apirouter.demo.web.apiservice.constraints.Global;
import com.krista.apirouter.demo.web.apiservice.request.BindCardRequest;
import com.krista.apirouter.demo.web.apiservice.response.BindCardResponse;
import com.krista.apirouter.exception.ApiException;

@Api(module = Global.MODULE_NAME, apiNo = "bindCard", version = Global.API_VERSION, description = "绑定银行卡")
public class BindCardApi extends AbstractApiService<BindCardRequest, BindCardResponse> {
	private static Logger logger = LoggerFactory.getLogger(BindCardApi.class);

	@Override
	protected BindCardResponse handle(BindCardRequest request) throws ApiException {
		logger.info(">>>>> 开始执行接口 BindCardApi");

		BindCardResponse bindCardResponse = new BindCardResponse();
		bindCardResponse.setBankCardId(UUID.randomUUID().toString());

		return bindCardResponse;
	}
}