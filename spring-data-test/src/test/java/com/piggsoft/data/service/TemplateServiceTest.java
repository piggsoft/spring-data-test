package com.piggsoft.data.service;

import java.io.File;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.piggsoft.data.BaseTest;
import com.piggsoft.data.model.User;

public class TemplateServiceTest extends BaseTest{
	
	@Autowired private TemplateService templateService;
	
	@Test
	@Rollback(false)
	public void test() throws Exception {
		User operator = new User();
		operator.setId(1l);
		templateService.addTemplate(new File("src/test/resources/template/logback.xml"), operator);
	}
	
}
