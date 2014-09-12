package com.piggsoft.data.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import javassist.tools.framedump;

import org.apache.commons.codec.digest.DigestUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.piggsoft.data.BaseTest;

public class UserControllerTest extends BaseTest {
	
	@Rule 
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	@Transactional
	public void testRegister() throws Exception {
		mockMvc.perform(
				post("/user/register").param("username", "piggsoft").param(
						"password", "123456q")).andDo(print())
				.andExpect(jsonPath("$.username").value("piggsoft"))
				.andExpect(jsonPath("$.password").value(DigestUtils.md5Hex("123456q")));
	}
	
	@Test
	@Transactional
	public void testRegister1() throws Exception {
		mockMvc.perform(
				post("/user/register").param("username", "piggsoft").param(
						"password", "123456q")).andDo(print())
				.andExpect(jsonPath("$.username").value("piggsoft"))
				.andExpect(jsonPath("$.password").value(DigestUtils.md5Hex("123456q")));
		thrown.expect(RuntimeException.class);
	}
	
	@Test
	@Rollback(false)
	public void testRegister2() throws Exception {
		for (int i=0; i<10; i++) {
		mockMvc.perform(
				post("/user/register").param("username", "piggsoft" + i).param(
						"password", "123456q")).andReturn();
		}
	}
	
	@Test
	public void testLogin() throws Exception{
		for (int i=0; i<10; i++) {
			mockMvc.perform(
					post("/user/login").param("username", "piggsoft" + i).param(
							"password", "123456q")).andExpect(content().string(CoreMatchers.containsString("UCCESS---ID:")));
					
		}
	}
	
	@Test
	@Rollback(false)
	public void testmodifyPassword() throws Exception{
		mockMvc.perform(
				post("/user/modifyPassword").param("id", "114").param("username", "piggsoft114").param(
						"password", "123456q")).andDo(print());
					
	}
	
	@Test
	public void testSearch() throws Exception{
		mockMvc.perform(
				post("/user/search").param("page.page", "2").param("page.size", "10").param(
						"sort", "id,desc")).andDo(print());
					
	}
}
