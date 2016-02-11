package com.yog.mt.models;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.yog.fw.core.annotations.Validation;
import com.yog.fw.core.enums.UserType;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name = "YOG_USER")
@Cacheable(value = false)
public class User extends BaseModel {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "FIRST_NAME", nullable = false, length = 50)
	@Validation(required = true, min=5, max=30)
	private String firstName;
	
	@Column(name = "LAST_NAME", nullable = false, length = 50)
	@Validation(required = true, min=3, max=30)
	private String lastName;
	
	@Column(name = "ADDRESS", nullable = false)
	private String address;

	@Column(name = "MOBILE_NO", nullable = false)
	@Validation(required = true, min=5, max=30)
	private String mobileNo;
	
	@Column(name = "EMAIL_ID", nullable = true)
	@Validation(required = true, min=5, max=30)
	private String emailId;
    
	@Column(name = "TIME_ZONE", nullable = true)
	@Validation(required = true)
	private String timezone;
    
    @Column(name = "IS_ACTIVE", nullable = false)
    @Validation(required = true)
    private Boolean isActive;
    
    @Column(name = "USER_TYPE", nullable = false)
    @Enumerated
    @Validation(required = true)
    private UserType userType;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}
