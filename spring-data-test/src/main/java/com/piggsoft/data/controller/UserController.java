package com.piggsoft.data.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping("/search")
	@ResponseBody
	public List<User> search(Pageable pageable) {
		Page<User> users = userService.search(pageable);
		return users.getContent();
	}
	
	@RequestMapping(value="/searchPage")
	@ResponseBody
	public Page<User> searchPage(HttpServletRequest request, @RequestBody Pageable pageable) {
		return userService.search(pageable);
	}
}
