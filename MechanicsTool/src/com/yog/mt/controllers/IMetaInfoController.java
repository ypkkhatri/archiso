package com.yog.mt.controllers;

import org.springframework.http.ResponseEntity;

import com.yog.mt.utils.ResponseBean;

public interface IMetaInfoController extends java.io.Serializable {
	public ResponseEntity<ResponseBean> getVersion();
}
