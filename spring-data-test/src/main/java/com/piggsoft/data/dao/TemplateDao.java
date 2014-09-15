package com.piggsoft.data.dao;

import org.springframework.data.repository.CrudRepository;

import com.piggsoft.data.model.template.Template;

public interface TemplateDao extends CrudRepository<Template, Long> {
	
}
