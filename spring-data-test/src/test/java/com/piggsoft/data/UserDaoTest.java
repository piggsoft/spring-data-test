package com.piggsoft.data;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

import com.piggsoft.data.dao.UserDao;
import com.piggsoft.data.model.User;

public class UserDaoTest extends BaseTest{
	
	@Autowired private UserDao userDao;
	
	@Test
	@Rollback(false)
	public void testSave() {
		if (userDao.count() > 1)
			return;
		for (int i=0; i<100; i++)
			userDao.save(createUser(i));
	}
	
	private User createUser(int no) {
		User user = new User();
		user.setUsername("username-"+no);
		user.setPassword("password-"+no);
		return user;
	}
	@Test
	public void testQuery() {
		User user = userDao.findUserByUsername("username-"+1);
		User user2 = userDao.findByUsername("username-"+1);
		Assert.assertEquals(user.getId(), user2.getId());
	}
	
	@Test
	public void testQueryPage() {
		Pageable page = new PageRequest(2, 10);
		Page<User> users = userDao.findAll(page);
		System.out.println(users.getSize() + "|" + users.getNumberOfElements());
	}
	
}
