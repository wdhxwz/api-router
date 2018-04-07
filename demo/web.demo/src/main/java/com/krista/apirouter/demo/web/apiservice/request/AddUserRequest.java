package com.krista.apirouter.demo.web.apiservice.request;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户新增请求类
 * @author wangdh
 *
 */
public class AddUserRequest implements Serializable{
	private static final long serialVersionUID = 6930896763783896072L;
	
	/**
	 * 用户名称
	 */
	private String userName;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 出生日期
	 */
	private Date birthday;
	
	/**
	 * 身份证号
	 */
	private String idCard;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
}