package com.saltlux.translate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saltlux.common.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/home.htm", method = RequestMethod.GET)
	public String loadHome(ModelMap model) {
		return "home";
	}

	@RequestMapping(value = "/admin.htm", method = RequestMethod.GET)
	public String loadAdminHome(ModelMap model) {
		return "admin_home";
	}
}
