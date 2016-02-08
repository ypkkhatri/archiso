package com.yog.mt.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yog.mt.business.IMetaInfoBO;
import com.yog.mt.business.MetaInfoBO;
import com.yog.mt.utils.ResponseBean;

@RestController
@RequestMapping(value = "/metainfo")
public class MetaInfoController extends BaseRestController {
	
	@RequestMapping(value = "/appversion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseBean> getVersion() {
		IMetaInfoBO bo = new MetaInfoBO();
		bo.getVersion();
		return new ResponseEntity<ResponseBean>(bo.getResponse(), HttpStatus.OK);
	}
}
