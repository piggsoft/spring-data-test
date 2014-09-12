package com.piggsoft.data.service;

import com.piggsoft.data.model.User;

public interface UserService {
	void register(User user);
	String encryptPassword(String password);
	String decryptPassword(String password);
	boolean accountHadRegister(User user);
	User validateUser(User user);
}
