package com.piggsoft.data.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import com.piggsoft.data.dao.TemplateDao;
import com.piggsoft.data.model.User;
import com.piggsoft.data.model.template.Template;
import com.piggsoft.data.service.TemplateService;

@Service("templateService")
public class TemplateServiceImpl implements TemplateService{
	@Autowired private TemplateDao templateDao;
	
	@Override
	public Template addTemplate(File templateFile, User operator) throws FileNotFoundException, IOException {
		Template result = new Template();
		result.setContent(StreamUtils.copyToString(new FileInputStream(templateFile), Charset.forName("UTF-8")));
		result.setCreateTime(new Date());
		result.setCreator(operator);
		templateDao.save(result);
		return result;
	}
	
	
	
	public void setTemplateDao(TemplateDao templateDao) {
		this.templateDao = templateDao;
	}
	
	
}
