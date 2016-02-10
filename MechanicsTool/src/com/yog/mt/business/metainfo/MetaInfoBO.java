package com.yog.mt.business.metainfo;

import org.springframework.stereotype.Service;

import com.yog.mt.business.AbstractBusinessObject;

/**
 * @author Yougeshwar
 * 
 * Meta information of application
 * */

@Service
public class MetaInfoBO extends AbstractBusinessObject implements IMetaInfoBO {

	private static final long serialVersionUID = 1L;

	@Override
	public void getVersion() {
		getResponse().setVersion("1.0");
	}

}
