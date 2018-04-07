package com.krista.apirouter.demo.web.apiservice.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * 银行卡绑定请求类
 * @author wangdh
 *
 */
public class BindCardRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1925704301684147939L;

	/**
	 * 卡号
	 */
	@NotNull(message = "银行卡号不能为空")
	private String cardNo;
	/**
	 * 持卡人姓名
	 */
	private String userName;
	/**
	 * 预留手机号
	 */
	private String mobile;
	/**
	 * 银行名称
	 */
	private String bankName;
	/**
	 * 银行编号
	 */
	private String bankNo;
	/**
	 * 支行名称
	 */
	private String branchBankName;
	/**
	 * 支行编号
	 */
	private String branchBankNo;
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	public String getBranchBankName() {
		return branchBankName;
	}
	public void setBranchBankName(String branchBankName) {
		this.branchBankName = branchBankName;
	}
	public String getBranchBankNo() {
		return branchBankNo;
	}
	public void setBranchBankNo(String branchBankNo) {
		this.branchBankNo = branchBankNo;
	}
}