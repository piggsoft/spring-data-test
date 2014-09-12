package com.piggsoft.data.controller;

import org.junit.Test;

import com.piggsoft.data.BaseTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserControllerTest extends BaseTest {

	@Test
	public void testRegister() throws Exception {
		mockMvc.perform(post("/user/register").param("username", "piggsoft")
				.param("password", "123456q"))
				.andDo(print())
				.andExpect(jsonPath("$.username").value("piggsoft"))
				.andExpect(jsonPath("$.password").value("123456q"));
	}
}
