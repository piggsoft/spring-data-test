package com.piggsoft.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.piggsoft.data.exception.UserException;
import com.piggsoft.data.model.User;
import com.piggsoft.data.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired private UserService userService;
	@RequestMapping("/register")
	@ResponseBody
	public User register(User user) {
		try {
		user = userService.register(user);
		} catch (UserException e) {
			return null;
		}
		return user;
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(User user) {
		User result = userService.login(user);
		return result != null ? "SUCCESS---ID:" + result.getId() : "FAIL";
	}
	@RequestMapping("/modifyPassword")
	@ResponseBody
	public User modifyPassword(User user) {
		return userService.modifyPassword(user);
	}
}
