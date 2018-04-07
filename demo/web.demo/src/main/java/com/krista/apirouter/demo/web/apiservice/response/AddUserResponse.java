package com.krista.apirouter.demo.web.apiservice.response;

import java.io.Serializable;

/**
 * 用户新增响应类
 * @author wangdh
 *
 */
public class AddUserResponse implements Serializable{
	private static final long serialVersionUID = 5139890319432758413L;

	/**
	 * 用户ID
	 */
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}	
}