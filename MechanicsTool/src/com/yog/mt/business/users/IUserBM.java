package com.yog.mt.business.users;

import com.yog.mt.business.IBusinessModel;

/**
 * @author Yougeshwar
 * 
 * */
public interface IUserBM extends IBusinessModel {
	public void doLogin(String username, String password);
	public void doLogout();
}
