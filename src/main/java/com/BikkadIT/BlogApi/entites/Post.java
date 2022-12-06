package com.BikkadIT.BlogApi.entites;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity

public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pId;
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	@ManyToOne
	private Catagory catagory;
	@ManyToOne
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
		title = title;
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
		return "Post [pId=" + pId + ", Title=" + title + ", content=" + content + ", imageName=" + imageName
				+ ", addedDate=" + addedDate + ", catagory=" + catagory + ", user=" + user + "]";
	}

	public Post(int pId, String title, String content, String imageName, Date addedDate, Catagory catagory, User user) {
		super();
		this.pId = pId;
		title = title;
		this.content = content;
		this.imageName = imageName;
		this.addedDate = addedDate;
		this.catagory = catagory;
		this.user = user;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

}
