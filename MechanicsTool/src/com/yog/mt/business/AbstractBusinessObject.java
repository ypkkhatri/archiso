package com.yog.mt.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.yog.fw.core.services.ICoreService;
import com.yog.fw.core.services.IModelService;
import com.yog.mt.utils.ResponseBean;

public abstract class AbstractBusinessObject implements IBusinessObject {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ICoreService coreService;
	
	@Autowired
	protected IModelService modelService;
	
	private ResponseBean responseBean;
	
	public AbstractBusinessObject() {
		responseBean = new ResponseBean();
	}
	
	@Override
	public ResponseBean getResponse() {
		return responseBean;
	}
	
	public ICoreService getCoreService() {
		return coreService;
	}
	
	public IModelService getModelService() {
		return modelService;
	}
}
