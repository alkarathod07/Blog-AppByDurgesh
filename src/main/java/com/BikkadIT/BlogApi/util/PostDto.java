package com.BikkadIT.BlogApi.util;

import java.util.Date;

import com.BikkadIT.BlogApi.entites.Catagory;
import com.BikkadIT.BlogApi.entites.User;

public class PostDto {
 private int pId;
	private String title;
	private String content;

	private String imageName;
	private Date addedDate;

	private Catagory catagory;

	private User user;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
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

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Catagory getCatagory() {
		return catagory;
	}

	public void setCatagory(Catagory catagory) {
		this.catagory = catagory;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PostDto [pId=" + pId + ", title=" + title + ", content=" + content + ", imageName=" + imageName
				+ ", addedDate=" + addedDate + ", catagory=" + catagory + ", user=" + user + "]";
	}

	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	

}
