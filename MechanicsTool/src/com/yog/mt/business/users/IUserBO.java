package com.yog.mt.business.users;

import com.yog.mt.business.IBusinessObject;

/**
 * @author Yougeshwar
 * 
 * */
public interface IUserBO extends IBusinessObject {
	public void doLogin(String username, String password);
	public void doLogout();
}
