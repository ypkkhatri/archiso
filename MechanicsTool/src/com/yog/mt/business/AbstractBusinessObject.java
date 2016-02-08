package com.yog.mt.business;

import com.yog.mt.utils.ResponseBean;

public abstract class AbstractBusinessObject implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private ResponseBean responseBean;
	
	public AbstractBusinessObject() {
		// TODO Auto-generated constructor stub
		responseBean = new ResponseBean();
	}
	
	public ResponseBean getResponse() {
		return responseBean;
	}
}
