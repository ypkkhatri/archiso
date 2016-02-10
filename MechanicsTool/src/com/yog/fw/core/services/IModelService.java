package com.yog.fw.core.services;

import com.yog.mt.models.BaseModel;

public interface IModelService extends java.io.Serializable {
	public void validate(BaseModel model) throws Exception;
}
