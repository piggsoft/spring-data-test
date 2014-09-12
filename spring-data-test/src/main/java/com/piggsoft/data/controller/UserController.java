package com.piggsoft.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.piggsoft.data.model.User;
import com.piggsoft.data.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired private UserService userService;
	@RequestMapping("/register")
	@ResponseBody
	public User register(User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		return user;
	}
}
