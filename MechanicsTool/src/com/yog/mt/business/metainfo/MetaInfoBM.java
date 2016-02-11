package com.yog.mt.business.metainfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.yog.mt.business.AbstractBusinessModel;

/**
 * @author Yougeshwar
 * 
 * Meta information of application
 * */

@Service
public class MetaInfoBM extends AbstractBusinessModel implements IMetaInfoBM {

	private static final long serialVersionUID = 1L;
	
	protected Logger log = LogManager.getLogger(MetaInfoBM.class);

	@Override
	public void getVersion() {
		log.info("Call getVersion()");
		getResponse().setVersion("1.0");
	}

}
