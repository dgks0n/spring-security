package com.saltlux.translate.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {
	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public String getLoginPage(@RequestParam(value = "error", required = false) boolean error, ModelMap model, HttpSession session) {
		String err = "";
		if (error) {
			Throwable ex = (Throwable) session.getAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY);
			err = "Username or password incorrect";
			if (ex instanceof DisabledException) {
				err = "This account is not active. Please contact your administrator";
			} else if (ex instanceof LockedException) {
				err = "This account is locked. Please contact your administrator";
			} else if (ex instanceof AuthenticationException) {
				err = "You have entered an invalid username or password!";
			} else {
				err = "Unknown error";
			}
			model.put("error", err);
		} else {
			model.put("error", "");
		}
		
		return "login";
	}

	@RequestMapping("/logout.htm")
	public String loggedout(ModelMap model) {
		model.put("msg", "Logged out Successfully");
		model.put("error", "");
		return "login";
	}

	@RequestMapping("/denied.htm")
	public String accessDenied(ModelMap model) {
		return "denied";
	}
}
