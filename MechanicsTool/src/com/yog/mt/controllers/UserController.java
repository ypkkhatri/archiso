package com.yog.mt.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yog.mt.utils.ResponseBean;

/**
 * @author Yougeshwar
 * 
 * User controller
 * */
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {
	
	@RequestMapping(value = "/user/{username}/{password}")
	public ResponseEntity<ResponseBean> doLogin(@PathVariable String username, @PathVariable String password) {
		return null;
	}
}
