package com.yog.mt.business;

import com.yog.fw.core.services.ICoreService;
import com.yog.fw.core.services.IModelService;
import com.yog.mt.utils.ResponseBean;

/**
 * @author Yougeshwar
 * 
 * Main Interface of business object
 * */
public interface IBusinessModel extends java.io.Serializable {

	public ICoreService getCoreService();
	public IModelService getModelService();
	public ResponseBean getResponse();
}
