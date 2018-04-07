package com.krista.apirouter.demo.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.krista.apirouter.core.ApiRouter;
import com.krista.apirouter.exception.ApiException;
import com.krista.apirouter.utils.JsonUtil;

@Controller
public class ApiController {
	
	@Autowired
	private ApiRouter apiRouter;


	@RequestMapping(value = "/test")
	@ResponseBody
	public String test(){
		return "Hello ApiRouter";
	}
	
	@RequestMapping(value = "/api")
	@ResponseBody
	public String request(@RequestBody(required = false) String data) {
		try {
			return JsonUtil.toJson(apiRouter.executeApi(data));
		} catch (ApiException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getResponseCode().getCode());
			System.out.println(e.getResponseCode().getMessage());
			
			String message = e.getMessage();
			if(StringUtils.isEmpty(message)){
				message = e.getResponseCode().getMessage();
			}
			
			return e.getResponseCode().getCode() + " : " +  message ;
		}
	}
}
