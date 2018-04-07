package com.krista.apirouter.demo.web.apiservice.response;

import java.io.Serializable;

/**
 * 银行卡响应请求类
 * @author wangdh
 *
 */
public class BindCardResponse implements Serializable{
	private static final long serialVersionUID = 1305383985958586222L;
	
	/**
	 * 银行卡ID
	 */
	private String bankCardId;

	public String getBankCardId() {
		return bankCardId;
	}

	public void setBankCardId(String bankCardId) {
		this.bankCardId = bankCardId;
	}
}