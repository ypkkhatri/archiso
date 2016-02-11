package com.yog.mt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yog.fw.core.annotations.Allow;
import com.yog.mt.business.metainfo.IMetaInfoBM;
import com.yog.mt.utils.ResponseBean;

/**
 * @author Yougeshwar
 * 
 * Meta information controller
 * */

@RestController
@RequestMapping(value = "/metainfo")
public class MetaInfoController extends BaseController implements IMetaInfoController {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IMetaInfoBM metaInfoBM;
	
	@Override
	@Allow
	@RequestMapping(value = "/appversion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBean> getVersion() {
		metaInfoBM.getVersion();
		return new ResponseEntity<ResponseBean>(metaInfoBM.getResponse(), HttpStatus.OK);
	}
}
