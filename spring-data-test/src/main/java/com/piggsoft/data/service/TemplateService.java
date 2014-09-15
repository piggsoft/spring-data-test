package com.piggsoft.data.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.piggsoft.data.model.User;
import com.piggsoft.data.model.template.Template;

public interface TemplateService {

	Template addTemplate(File templateFile, User operator)
			throws FileNotFoundException, IOException;

}
