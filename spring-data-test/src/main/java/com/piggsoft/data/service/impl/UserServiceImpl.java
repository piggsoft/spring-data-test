package com.piggsoft.data.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piggsoft.data.dao.UserDao;
import com.piggsoft.data.model.User;
import com.piggsoft.data.service.UserService;

@Service("userService")
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService {
	
	@Autowired private UserDao userDao;
	
	@Transactional
	@Override
	public void register(User user) {
		user.setPassword(encryptPassword(user.getPassword()));
		userDao.save(user);
	}

	@Override
	public String encryptPassword(String password) {
		return DigestUtils.md5Hex(password);
	}

	@Override
	public String decryptPassword(String password) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean accountHadRegister(User user) {
		return userDao.findByUsername(user.getUsername()) == null ? false : true;
	}

	@Override
	public User validateUser(User user) {
		return userDao.findByUsernameAndPassword(user.getUsername(), encryptPassword(user.getPassword()));
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
