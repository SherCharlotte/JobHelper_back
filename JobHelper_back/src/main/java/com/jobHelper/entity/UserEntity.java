package com.jobHelper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "T_User")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class UserEntity extends IdEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column
	private String userName;
	
	@Column
	private String userPassword;
	
	@Column
	private String sex;
	
	@Column
	private String realName;
	
	@Column
	private String email;
	
	@Column
	private String hope;
	
	@Column
	private String admin;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHope() {
		return hope;
	}

	public void setHope(String hope) {
		this.hope = hope;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	
}
