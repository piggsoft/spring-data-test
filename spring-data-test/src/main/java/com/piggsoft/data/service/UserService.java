package com.piggsoft.data.service;

import com.piggsoft.data.model.User;

public interface UserService {
	User register(User user);
	String encryptPassword(String password);
	String decryptPassword(String password);
	boolean accountHadRegister(User user);
	User login(User user);
	User modifyPassword(User user);
}
