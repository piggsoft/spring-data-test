package com.piggsoft.data.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.piggsoft.data.model.User;

public interface UserDao extends CrudRepository<User, Long>{
	User findUserByUsername(String username);
	User findByUsername(String username);
	Page<User> findAll(Pageable pageable);
	User findByUsernameAndPassword(String username, String password);
}
