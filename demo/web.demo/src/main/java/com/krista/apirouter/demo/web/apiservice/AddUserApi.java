package com.krista.apirouter.demo.web.apiservice;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.krista.apirouter.annotation.Api;
import com.krista.apirouter.core.AbstractApiService;
import com.krista.apirouter.demo.web.apiservice.constraints.Global;
import com.krista.apirouter.demo.web.apiservice.request.AddUserRequest;
import com.krista.apirouter.demo.web.apiservice.response.AddUserResponse;
import com.krista.apirouter.exception.ApiException;

@Api(module = Global.MODULE_NAME, apiNo = "addUser", version = Global.API_VERSION, description = "新增用户")
public class AddUserApi extends AbstractApiService<AddUserRequest, AddUserResponse> {
	private static Logger logger = LoggerFactory.getLogger(AddUserApi.class);

	@Override
	protected AddUserResponse handle(AddUserRequest request) throws ApiException {
		logger.info(">>>>> 开始执行接口 AddUserApi");

		AddUserResponse addUserResponse = new AddUserResponse();
		addUserResponse.setUserId(UUID.randomUUID().toString());

		return addUserResponse;
	}
}