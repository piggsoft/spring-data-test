package com.piggsoft.data.model.template;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.piggsoft.data.model.User;

@Entity
public class Template {
	@Id
	@GeneratedValue
	private long id;
	private String title;
	@Lob
	private String content;
	private Date createTime;
	@ManyToOne
	private User creator;
	private Date updateTime;
	@ManyToOne
	private User updater;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public User getUpdater() {
		return updater;
	}
	public void setUpdater(User updater) {
		this.updater = updater;
	}
}
