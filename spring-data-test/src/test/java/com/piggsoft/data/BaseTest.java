package com.piggsoft.data;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.ServletWebRequest;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
// ?�M �A�i�H?���@?��?�޲z �C??��??��?���?�^? ??���\�O�_
@TransactionConfiguration(defaultRollback = true)
// ?�o�n�bXML���?����?�@~~~�ڬO���Ϊ`�Ѫ��覡
@Transactional
public abstract class BaseTest {

	@Autowired
	protected WebApplicationContext wac; // cached

	@Autowired
	protected MockServletContext servletContext; // cached

	@Autowired
	protected MockHttpSession session;

	@Autowired
	protected MockHttpServletRequest request;

	@Autowired
	protected MockHttpServletResponse response;

	@Autowired
	protected ServletWebRequest webRequest;

	protected MockMvc mockMvc;

	@Before
	public void setup() {
		// webAppContextSetup �`�N�W����static import
		// webAppContextSetup �۳y��WEB�e���i�H�K�[fileter ���O����K�[listenCLASS
		// WebApplicationContext context =
		// ContextLoader.getCurrentWebApplicationContext();
		// �p�G����]�t�p�W��k ???�ū�?
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
}
